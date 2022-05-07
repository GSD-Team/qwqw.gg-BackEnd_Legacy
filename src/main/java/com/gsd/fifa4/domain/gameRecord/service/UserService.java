package com.gsd.fifa4.domain.gameRecord.service;

import com.gsd.fifa4.dataCenter.service.DataCenterService;
import com.gsd.fifa4.api.MatchApi;
import com.gsd.fifa4.api.UserApi;
import com.gsd.fifa4.domain.gameRecord.constant.MatchType;
import com.gsd.fifa4.domain.gameRecord.dto.SquadDTO;
import com.gsd.fifa4.domain.gameRecord.dto.UserInfoDTO;
import com.gsd.fifa4.domain.gameRecord.factory.MatchFactory;
import com.gsd.fifa4.domain.gameRecord.model.api.match.Match;
import com.gsd.fifa4.domain.gameRecord.model.api.match.MatchInfo;
import com.gsd.fifa4.domain.gameRecord.model.api.User;
import com.gsd.fifa4.domain.gameRecord.model.api.UserMaxDivision;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Yohan lee
 * Created on 2021-01-29.
 **/

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {

    private final UserApi userApi;
    private final MatchApi matchApi;
    private final MetaService metaService;
    private final DataCenterService dataCenterService;

    /**
     * 유저의 매치 간단정보를 가져온다.
     * @param accessId 유저의 고유 id
     * @return 유저 간단정보 DTO
     */
    public UserInfoDTO getUserInfo(String accessId) {

        //공식경기 등급 가져오기.
        UserMaxDivision userMaxDivision = userApi.getUserMaxDivisions(accessId)
                .stream()
                .filter(maxDivision -> maxDivision.getMatchType() == MatchType.RANK)
                .findFirst()
                .orElseThrow(NullPointerException::new)
                ;

        userMaxDivision.setDivisionName(metaService.findDivisionName(userMaxDivision.getDivision()));

        List<Match> matches = getMatches(accessId, 0, 10);

        return UserInfoDTO.builder()
                .userMaxDivision(userMaxDivision)
                .midRangeShootRatio(MatchFactory.midRangeShootAverage(matches))
                .headerShootRatio(MatchFactory.headingSootAverage(matches))
                .possessionRatio(MatchFactory.possessionAverage(matches))
                .build();
    }


    public SquadDTO getUserSquad(String accessId) {
        MatchInfo myMatchInfo = getRecentMatch(accessId).getMyMatchInfo();

        metaService.load(myMatchInfo);
        dataCenterService.buildDataCenter(myMatchInfo);

        return new SquadDTO(dataCenterService.getClubPrice(myMatchInfo), myMatchInfo);
    }


    /**
     * 특정 유저의 매치 리스트를 가져온다.
     * @param accessId 유저 고유 id
     * @param offset 시작지점
     * @param limit 가져올 데이터 개수
     * @return 매치 리스트
     */
    public List<Match> getMatches(String accessId, int offset, int limit) {
        return userApi.getMatchIds(accessId, offset, limit)
                .stream()
                .map(matchId -> matchApi.getMatchByAccessId(matchId, accessId))
                .collect(Collectors.toList());
    }


    /**
     * 특정 유저의 가장 최근 매치를 가져온다.
     * @param accessId 유저 고유 id
     * @return 가장 최근의 매치 정보
     */
    public Match getRecentMatch(String accessId) {
        List<String> matchIds = userApi.getMatchIds(accessId, 0, 1);
        if(matchIds.isEmpty()) {
            log.error("[{}]의 매치기록이 존재하지 않음.", accessId);
            throw new IllegalArgumentException("플레이한 전적이 없어서 조회가 불가능합니다.");
        }

        return  matchApi.getMatchByAccessId(matchIds.get(0), accessId);
    }


    /**
     * 특정 닉네임에 해당하는 유저정보를 가져온다.
     * @param nickName 유저 닉네임
     * @return 유저 정보
     */
    public User getUser(String nickName) {
        if(!StringUtils.hasText(nickName)) {
           throw new IllegalArgumentException("nickName은 필수 값입니다.");
        }

        return userApi.getUser(nickName.trim());
    }



}

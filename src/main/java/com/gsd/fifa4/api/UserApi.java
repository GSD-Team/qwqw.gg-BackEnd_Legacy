package com.gsd.fifa4.api;

import com.gsd.fifa4.domain.gameRecord.constant.MatchType;
import com.gsd.fifa4.domain.gameRecord.model.api.User;
import com.gsd.fifa4.domain.gameRecord.model.api.UserMaxDivision;
import com.gsd.fifa4.global.adapter.HttpAdapter;
import com.gsd.fifa4.global.properties.DomainProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Component
@RequiredArgsConstructor
public class UserApi {

    private final static String MAX_DIVISION_PATH = "maxdivision";
    private final static String MATCHES_PATH = "matches";

    private final HttpAdapter httpAdapter;

    private final DomainProperties domainProperties;

    /**
     * 유저 닉네임으로 유저 정보 조회
     * @param nickName 유저 닉네임
     * @return User 유저정보
     */
    public User getUser(String nickName){
        MultiValueMap<String, String> queryParamMap = new LinkedMultiValueMap<>();
        queryParamMap.put("nickname", Collections.singletonList(nickName));

        return httpAdapter.getQueryStringApi(domainProperties.getUser(), queryParamMap, User.class);
    }

    public List<UserMaxDivision> getUserMaxDivisions(String accessId) {
        UserMaxDivision[] userMaxDivisions = httpAdapter.getPathAndQueryStringApi(
                domainProperties.getUser(),
                null,
                UserMaxDivision[].class,
                accessId,
                MAX_DIVISION_PATH
        );

        return Arrays.asList(userMaxDivisions);
    }


    /**
     * 유저 고유 식별자로 유저의 매치 기록 조회
     * @param accessId 유저 고유 식별자
     * @param offset 기준점
     * @param limit 가져올 데이터 Count
     * @return MatchId 리스트
     */
    public List<String> getMatchIds(String accessId, int offset, int limit){
        MultiValueMap<String, String> queryParamMap = new LinkedMultiValueMap<>();

        queryParamMap.put("matchtype", Collections.singletonList(MatchType.RANK.toString()));
        queryParamMap.put("offset", Collections.singletonList(String.valueOf(offset)));
        queryParamMap.put("limit", Collections.singletonList(String.valueOf(limit)));

        String[] matchIds = httpAdapter.getPathAndQueryStringApi(
                domainProperties.getUser(),
                queryParamMap,
                String[].class,
                accessId,
                MATCHES_PATH);

        return Arrays.asList(matchIds);
    }
}

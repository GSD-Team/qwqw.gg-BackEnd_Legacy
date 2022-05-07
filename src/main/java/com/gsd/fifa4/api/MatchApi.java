package com.gsd.fifa4.api;


import com.gsd.fifa4.domain.gameRecord.model.api.match.Match;
import com.gsd.fifa4.domain.gameRecord.model.api.match.MatchInfo;
import com.gsd.fifa4.global.properties.DomainProperties;
import com.gsd.fifa4.global.adapter.HttpAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

@Component
@RequiredArgsConstructor
public class MatchApi {

    private final HttpAdapter httpAdapter;
    private final DomainProperties domainProperties;


    /**
     * 매치 상세 기록 조회
     * @param matchId 매치 고유 식별자
     * @param searchNickName 검색한 닉네임(MatchInfo 인덱스가 뒤바뀌는 경우가 있어 호출하여 검사.)
     * @return MATCH 데이터
     */
    public Match getMatch(String matchId, String searchNickName){
        Match match = getMatch(matchId);

        //MatchInfo의 첫번째 인덱스가 검색한 닉네임이 아닐경우, 인덱스 역정렬.
        if(!match.getMyMatchInfo().getNickName().equals(searchNickName)){
            List<MatchInfo> matchInfo = match.getMatchInfo();
            Collections.reverse(matchInfo);
            match.setMatchInfo(matchInfo);
        }

        return match;
    }

    /**
     * 매치 상세 기록 조회
     * @param matchId 매치 고유 식별자
     * @param accessId 유저 고유 식별자(MatchInfo 인덱스가 뒤바뀌는 경우가 있어 호출하여 검사.)
     * @return MATCH 데이터
     */
    public Match getMatchByAccessId(String matchId, String accessId){
        Match match = getMatch(matchId);

        //MatchInfo의 첫번째 인덱스가 검색한 닉네임이 아닐경우, 인덱스 역정렬.
        if(!match.getMyMatchInfo().getAccessId().equals(accessId)){
            List<MatchInfo> matchInfo = match.getMatchInfo();
            Collections.reverse(matchInfo);
            match.setMatchInfo(matchInfo);
        }

        return match;
    }

    private Match getMatch(String matchId) {
        return httpAdapter.getRestApi(domainProperties.getMatch(), matchId, Match.class);
    }



}

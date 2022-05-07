package com.gsd.fifa4.api;

import com.gsd.fifa4.domain.gameRecord.model.api.match.Match;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
public class MatchApiTest {

    @Autowired
    private MatchApi matchApi;

    private static final String NICK_NAME = "굴리트러브";
    private static final String MATCH_ID = "5e996552ef99d44dc764eec8";


    @Test
    @DisplayName("매치정보 가져오기")
    void getMatch() {
        Match match = matchApi.getMatch(MATCH_ID, NICK_NAME);

        assertEquals(NICK_NAME, match.getMyMatchInfo().getNickName());
    }

}

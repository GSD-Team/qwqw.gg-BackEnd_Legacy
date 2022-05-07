package com.gsd.fifa4.global;

import com.gsd.fifa4.domain.gameRecord.model.api.match.Match;
import com.gsd.fifa4.domain.gameRecord.model.api.User;
import com.gsd.fifa4.global.properties.DomainProperties;
import com.gsd.fifa4.global.adapter.HttpAdapter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
public class HttpAdapterTest {

    @Autowired
    private HttpAdapter httpAdapter;

    @Autowired
    private DomainProperties domainProperties;

    private static final String NICK_NAME = "굴리트러브";
    private static final String MATCH_ID = "5e6b925524c6de5223badb00";

    @Test
    @DisplayName("HTTP 통신을 한다.")
    public void getRestApi(){
        Match match = httpAdapter.getRestApi(domainProperties.getMatch(), MATCH_ID, Match.class);
        assertEquals(MATCH_ID ,match.getMatchId());
    }

    @Test
    @DisplayName("QueryString을 포함한 HTTP 통신을 한다.")
    public void httpQueryStringApi(){
        MultiValueMap<String, String> queryParamMap = new LinkedMultiValueMap<>();
        queryParamMap.put("nickname", Collections.singletonList(NICK_NAME));

        User user = httpAdapter.getQueryStringApi(domainProperties.getUser(), queryParamMap, User.class);

        assertEquals(NICK_NAME, user.getNickName());

    }


}


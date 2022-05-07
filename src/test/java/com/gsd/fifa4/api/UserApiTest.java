package com.gsd.fifa4.api;

import com.gsd.fifa4.domain.gameRecord.model.api.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


@SpringBootTest
public class UserApiTest {

    @Autowired
    private UserApi userApi;

    private static final String NICK_NAME = "굴리트러브";
    private static final String ACCESS_ID = "09957c305a4b744584fd9ef2";

    @Test
    @DisplayName("유저 닉네임으로 유저 정보 조회")
    void getUser(){
        User user = userApi.getUser(NICK_NAME);
        assertEquals(NICK_NAME, user.getNickName());
    }

    @Test
    @DisplayName("유저 고유 식별자로 유저의 매치 기록 조회")
    void getMatchIds(){

        List<String> matchIds = userApi.getMatchIds(ACCESS_ID, 0, 10);

        assertNotNull(matchIds);

    }
}

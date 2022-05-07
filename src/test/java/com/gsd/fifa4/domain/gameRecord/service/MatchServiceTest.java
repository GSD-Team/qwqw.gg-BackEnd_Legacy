package com.gsd.fifa4.domain.gameRecord.service;

import com.gsd.fifa4.domain.gameRecord.dto.gameRecord.GameRecordDetailDTO;
import com.gsd.fifa4.domain.gameRecord.dto.gameRecord.GameRecordListDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class MatchServiceTest {

    @Autowired
    private MatchService matchService;

    private static final String NICKNAME = "굴리트러브";
    private static final String MATCH_ID = "5e996552ef99d44dc764eec8";


    @Test
    @DisplayName("매치 리스트 서비스")
    void getList(){
       GameRecordListDTO gameRecordList = matchService.getRecordList(NICKNAME, 0, 10);

    }


    @Test
    @DisplayName("매치 상세정보 서비스")
    void getInfo() {
        GameRecordDetailDTO gameRecordDetail = matchService.getRecordInfo(MATCH_ID, NICKNAME);

//         log.info("내팀 선수 고유 식별자 {}", gameRecordDetail.getMyPlayer().stream()
//                 .map(Player::getId)
//                 .collect(Collectors.toList()));
//
//         log.info("상대팀 선수 고유 식별자 {}", gameRecordDetail.getEnemyPlayer().stream()
//                 .map(Player::getId)
//                 .collect(Collectors.toList()));


    }
}

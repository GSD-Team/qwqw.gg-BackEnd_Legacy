package com.gsd.fifa4.domain.gameRecord.dto.gameRecord;


import com.gsd.fifa4.domain.gameRecord.model.api.match.Match;
import com.gsd.fifa4.domain.gameRecord.model.api.match.MatchInfo;
import com.gsd.fifa4.domain.gameRecord.model.api.match.detail.Player;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class GameRecordDetailDTO {

    private String myNickName;

    private String enemyNickName;

    private String gameResult;

    private Integer myScore;

    private Integer enemyScore;

    private GameInfo gameInfo;

    private List<Player> myPlayer;

    private List<Player> enemyPlayer;


    public GameRecordDetailDTO(Match match) {
        MatchInfo myMatchInfo = match.getMyMatchInfo();
        MatchInfo enemyMatchInfo = match.getEnemyMatchInfo();

        this.gameResult = myMatchInfo.getMatchDetail().getMatchResult();

        this.myNickName = myMatchInfo.getNickName();
        this.myPlayer = myMatchInfo.getPlayers();
        this.myScore =  myMatchInfo.getShoot().getGoalTotal();

        this.enemyNickName = enemyMatchInfo.getNickName();
        this.enemyPlayer = enemyMatchInfo.getPlayers();
        this.enemyScore = enemyMatchInfo.getShoot().getGoalTotal();


        //경기 정보
        this.gameInfo = GameInfo.builder()
                .myPossession(myMatchInfo.getMatchDetail().getPossession())
                .enemyPossession(enemyMatchInfo.getMatchDetail().getPossession())
                .myTotalShoot(myMatchInfo.getShoot().getShootTotal())
                .enemyTotalShoot(enemyMatchInfo.getShoot().getShootTotal())
                .myTotalEffectiveShoot(myMatchInfo.getShoot().getEffectiveShootTotal())
                .enemyTotalEffectiveShoot(enemyMatchInfo.getShoot().getEffectiveShootTotal())
                .myTotalCards(myMatchInfo.getMatchDetail().getTotalCards())
                .enemyTotalCards(enemyMatchInfo.getMatchDetail().getTotalCards())
                .myTryPass(myMatchInfo.getPass().getPassTry())
                .enemyTryPass(enemyMatchInfo.getPass().getPassTry())
                .mySuccessPass(myMatchInfo.getPass().getPassSuccess())
                .enemySuccessPass(enemyMatchInfo.getPass().getPassSuccess())
                .build();
    }

    @Getter
    @NoArgsConstructor
    public static class GameInfo {

        //점유율
        private int myPossession;

        private int enemyPossession;

        //총 슛수
        private int myTotalShoot;

        private int enemyTotalShoot;

        //총 유효슛
        private int myTotalEffectiveShoot;

        private int enemyTotalEffectiveShoot;

        //카드
        private int myTotalCards;

        private int enemyTotalCards;

        //패스 시도
        private int myTryPass;

        private int enemyTryPass;

        //패스 성공
        private int mySuccessPass;

        private int enemySuccessPass;

        @Builder
        public GameInfo(int myPossession, int enemyPossession, int myTotalShoot, int enemyTotalShoot,
                        int myTotalEffectiveShoot, int enemyTotalEffectiveShoot,
                        int myTotalCards, int enemyTotalCards,
                        int myTryPass, int enemyTryPass,
                        int mySuccessPass, int enemySuccessPass) {
            this.myPossession = myPossession;
            this.enemyPossession = enemyPossession;
            this.myTotalShoot = myTotalShoot;
            this.enemyTotalShoot = enemyTotalShoot;
            this.myTotalEffectiveShoot = myTotalEffectiveShoot;
            this.enemyTotalEffectiveShoot = enemyTotalEffectiveShoot;
            this.myTotalCards = myTotalCards;
            this.enemyTotalCards = enemyTotalCards;
            this.myTryPass = myTryPass;
            this.enemyTryPass = enemyTryPass;
            this.mySuccessPass = mySuccessPass;
            this.enemySuccessPass = enemySuccessPass;
        }
    }
}

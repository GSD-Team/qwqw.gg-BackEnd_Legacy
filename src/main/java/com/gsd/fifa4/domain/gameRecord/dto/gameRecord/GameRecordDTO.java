package com.gsd.fifa4.domain.gameRecord.dto.gameRecord;

import com.gsd.fifa4.domain.gameRecord.model.api.match.Match;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class GameRecordDTO {

   private String matchId;

   private String matchDate;

   private String myNickName;

   private String myAccessId;

   private String enemyNickName;

   private String enemyAccessId;

   private int myScore;

   private int enemyScore;

   private String gameResult;

   public GameRecordDTO(Match match){
        this.matchId = match.getMatchId();
        this.matchDate = match.getMatchDate();
        this.myNickName = match.getMyNickName();
        this.myAccessId = match.getMyAccessId();
        this.myScore = match.getMyScore();
        this.enemyNickName = match.getEnemyNickName();
        this.enemyAccessId = match.getEnemyAccessId();
        this.enemyScore = match.getEnemyScore();
        this.gameResult = match.getMyMatchInfo().getMatchDetail().getMatchResult();
    }


}

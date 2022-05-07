package com.gsd.fifa4.domain.gameRecord.model.api.match;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
public class Match {
    private String matchId;

    private String matchDate;

    private int matchType;

    @JsonProperty("matchInfo")
    private List<MatchInfo> matchInfo;

    public String getMyNickName() {
        return getMyMatchInfo().getNickName();
    }

    public String getEnemyNickName() {
        return getEnemyMatchInfo().getNickName();
    }

    public String getMyAccessId() {
        return getMyMatchInfo().getAccessId();
    }

    public String getEnemyAccessId() {
        return getEnemyMatchInfo().getAccessId();
    }

    public int getMyScore() {
        return getMyMatchInfo().getShoot().getGoalTotal();
    }

    public int getEnemyScore() {
        return getEnemyMatchInfo().getShoot().getGoalTotal();
    }

    public MatchInfo getMyMatchInfo() {
        return this.getMatchInfo().get(0);
    }

    public MatchInfo getEnemyMatchInfo() {
        return this.getMatchInfo().get(1);
    }





}

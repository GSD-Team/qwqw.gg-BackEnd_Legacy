package com.gsd.fifa4.domain.gameRecord.model.api.match.detail;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MatchDetail {

    private int seasonId;

    private String matchResult;

    /** @apiNote  0: 정상종료, 1: 몰수승, 2: 몰수패 **/
    private int systemPause;

    private int foul;

    private int injury;

    private int redCards;

    private int yellowCards;

    private int dribble;

    private int cornerKick;

    private int possession;


    public int getTotalCards() {
        return this.yellowCards + this.redCards;
    }

}

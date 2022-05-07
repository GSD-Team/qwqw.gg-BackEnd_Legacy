package com.gsd.fifa4.domain.gameRecord.model.api.match.detail;

import com.gsd.fifa4.global.util.NumberUtil;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Shoot {
    
    private int shootTotal;

    private int effectiveShootTotal;

    private int shootOutScore;

    private int goalTotal;

    private int goalTotalDisplay;

    private int ownGoal;

    private int shootHeading;

    private int goalHeading;

    private int shootFreekick;

    private int goalFreekick;

    private int shootInPenalty;

    private int goalInPenalty;

    private int shootOutPenalty;

    private int goalOutPenalty;

    private int shootPenaltyKick;

    private int goalPenaltyKick;

    public int headingShootRatio() {
        return NumberUtil.calculatePersent(this.shootTotal, this.shootHeading);
    }

    public int outPenaltyShootratio() {
        return NumberUtil.calculatePersent(this.shootTotal, this.shootOutPenalty);
    }
}

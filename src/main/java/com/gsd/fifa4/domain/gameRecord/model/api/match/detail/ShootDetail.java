package com.gsd.fifa4.domain.gameRecord.model.api.match.detail;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ShootDetail {

    private int goalTime;

    private double x;

    private double y;

    private int type;

    private int result;

    private boolean assist;

    private boolean hitPost;

    private boolean inPenalty;

}

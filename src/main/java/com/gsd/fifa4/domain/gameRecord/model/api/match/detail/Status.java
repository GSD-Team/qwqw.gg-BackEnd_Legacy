package com.gsd.fifa4.domain.gameRecord.model.api.match.detail;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Status {

    public double spRating;

    public int tackle;

    public int block;

    public int passSuccess;

    public int passTry;

    public int dribble;

    public int goal;

    public int assist;

    public int effectiveShoot;

    public int shoot;
}

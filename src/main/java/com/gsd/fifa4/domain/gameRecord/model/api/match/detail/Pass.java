package com.gsd.fifa4.domain.gameRecord.model.api.match.detail;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Pass {
    private int passTry;

    private int passSuccess;

    private int shortPassTry;

    private int shortPassSuccess;

    private int longPassTry;

    private int longPassSuccess;

    private int bouncingLobPassTry;

    private int bouncingLobPassSuccess;

    private int drivenGroundPassTry;

    private int drivenGroundPassSuccess;

    private int throughPassTry;

    private int throughPassSuccess;

    private int lobbedThroughPassTry;

    private int lobbedThroughPassSuccess;
}

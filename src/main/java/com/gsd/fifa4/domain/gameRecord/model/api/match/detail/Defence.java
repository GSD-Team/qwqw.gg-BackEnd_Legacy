package com.gsd.fifa4.domain.gameRecord.model.api.match.detail;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Defence {

    private int blockTry;

    private int blockSuccess;

    private int tackleTry;

    private int tackleSuccess;
}

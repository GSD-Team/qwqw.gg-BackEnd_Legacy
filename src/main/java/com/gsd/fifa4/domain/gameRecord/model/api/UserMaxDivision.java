package com.gsd.fifa4.domain.gameRecord.model.api;


import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class UserMaxDivision {

    private int matchType;

    private int division;

    private String divisionName;

    private LocalDateTime achievementDate;
}

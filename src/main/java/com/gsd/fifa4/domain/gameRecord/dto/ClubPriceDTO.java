package com.gsd.fifa4.domain.gameRecord.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Created by Yohan lee
 * Created on 2021-03-04.
 **/

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ClubPriceDTO {

    private Long myClub;

    private Long enemyClub;
}

package com.gsd.fifa4.domain.gameRecord.dto;

import com.gsd.fifa4.domain.gameRecord.model.api.UserMaxDivision;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * Created by Yohan lee
 * Created on 2021-01-29.
 **/

@Getter
@NoArgsConstructor
public class UserInfoDTO {

    private String maxDivision;

    private LocalDateTime achieveMaxDivisionDate;

    private int midRangeShootRatio;

    private int headerShootRatio;

    private int possessionRatio;

    @Builder
    public UserInfoDTO(UserMaxDivision userMaxDivision, int midRangeShootRatio, int headerShootRatio, int possessionRatio) {
            this.maxDivision = userMaxDivision.getDivisionName();
            this.achieveMaxDivisionDate = userMaxDivision.getAchievementDate();
            this.midRangeShootRatio = midRangeShootRatio;
            this.headerShootRatio = headerShootRatio;
            this.possessionRatio = possessionRatio;
    }

}

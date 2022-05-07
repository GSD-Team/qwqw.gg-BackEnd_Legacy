package com.gsd.fifa4.domain.gameRecord.factory;

import com.gsd.fifa4.domain.gameRecord.model.api.match.Match;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Yohan lee
 * Created on 2021-01-29.
 **/


public class MatchFactory {

    public static int possessionAverage(List<Match> matches) {
        return matches.stream()
                .collect(Collectors.averagingDouble(match -> match.getMyMatchInfo().getMatchDetail().getPossession()))
                .intValue();
    }

    public static int midRangeShootAverage(List<Match> matches) {
        return matches.stream()
                .collect(Collectors.averagingDouble(match -> match.getMyMatchInfo().getShoot().outPenaltyShootratio()))
                .intValue();
    }

    public static int headingSootAverage(List<Match> matches) {
        return matches.stream()
                .collect(Collectors.averagingDouble(match -> match.getMyMatchInfo().getShoot().headingShootRatio()))
                .intValue();
    }
}

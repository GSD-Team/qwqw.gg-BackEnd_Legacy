package com.gsd.fifa4.domain.gameRecord.service;

import com.gsd.fifa4.api.MetaDataApi;
import com.gsd.fifa4.domain.gameRecord.model.api.match.MatchInfo;
import com.gsd.fifa4.domain.gameRecord.model.api.match.detail.Player;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * Created by Yohan lee
 * Created on 2021-01-29.
 **/

@Service
@RequiredArgsConstructor
public class MetaService {

    private final MetaDataApi metaDataApi;

    public void load(MatchInfo matchInfo) {
        loadPlayersPostion(matchInfo);
        loadPlayersSeason(matchInfo);
    }

    public void loadPlayersPostion(MatchInfo matchInfo) {
        for (Player player : matchInfo.getPlayers()) {
            player.setPositionDescription(findPositionName(player.getPosition()));
        }
    }

    public void loadPlayersSeason(MatchInfo matchInfo) {
        for (Player player : matchInfo.getPlayers()) {
            player.setSeasonImgUrl(findSeasonImgUrl(player.getSeasonId()));
        }
    }

    public String findDivisionName(int divisionId) {
        return  metaDataApi.getDivisions()
                .stream()
                .filter(div -> div.getDivisionId() == divisionId)
                .findFirst()
                .orElseThrow(NullPointerException::new)
                .getDivisionName();
    }

    public String findPositionName(int spposition) {
       return metaDataApi.getPositions()
                .stream()
                .filter(position -> position.getSpposition().equals(spposition))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new)
                .getDesc();
    }

    public String findSeasonImgUrl(int seasonId) {
        return metaDataApi.getSeasons().stream()
                .filter(sea -> sea.getSeasonId() == seasonId)
                .findFirst()
                .orElseThrow(IllegalArgumentException::new)
                .getSeasonImg();
    }

}

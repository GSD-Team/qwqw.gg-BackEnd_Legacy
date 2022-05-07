package com.gsd.fifa4.dataCenter.service;

import com.gsd.fifa4.dataCenter.DataCenterAdapter;
import com.gsd.fifa4.domain.gameRecord.model.api.match.MatchInfo;
import com.gsd.fifa4.domain.gameRecord.model.api.match.detail.Player;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DataCenterService {
    private final DataCenterAdapter dataCenterAdapter;

    public void buildDataCenter(MatchInfo matchInfo) {
        for (Player player : matchInfo.getPlayers()) {
            player.initDataCenter(dataCenterAdapter.getPlayer(player.getId(), player.getGrade()));
        }
    }

    public Long getClubPrice(MatchInfo matchInfo) {
        return matchInfo.getPlayers()
                .stream()
                .mapToLong(player -> dataCenterAdapter.getPlayerPrice(player.getId(), player.getGrade()))
                .sum();
    }


}

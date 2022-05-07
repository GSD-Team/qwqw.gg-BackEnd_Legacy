package com.gsd.fifa4.domain.gameRecord.factory;

import com.gsd.fifa4.domain.gameRecord.model.api.match.detail.Player;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Yohan lee
 * Created on 2021-02-23.
 **/

public class PlayerFactory {

    /**
     * 주전 플레이어목록의 포워드(FW) 평균 능력치를 계산한다.
     * @param players 플레이어 목록
     * @return 포워드(FW) 평균 능력치
     */
    public static int averageForwardAbility(List<Player> players) {
        return players.stream()
                .filter(player -> player.isForward() && player.isKeyPlayer())
                .collect(Collectors.averagingDouble(Player::getAblilty))
                .intValue();
    }
    /**
     * 주전 플레이어목록의 미드필더(MF) 평균 능력치를 계산한다.
     * @param players 플레이어 목록
     * @return 미드필더(MF) 평균 능력치
     */
    public static int averageMidAbility(List<Player> players) {
        return players.stream()
                .filter(player -> player.isMid() && player.isKeyPlayer())
                .collect(Collectors.averagingDouble(Player::getAblilty))
                .intValue();
    }

    /**
     * 주전 플레이어목록의 수비수(DF) 평균 능력치를 계산한다.
     * @param players 플레이어 목록
     * @return 수비수(DF) 평균 능력치
     */
    public static int averageDefenderAbility(List<Player> players) {
        return players.stream()
                .filter(player -> player.isDefender() && player.isKeyPlayer())
                .collect(Collectors.averagingDouble(Player::getAblilty))
                .intValue();
    }
}

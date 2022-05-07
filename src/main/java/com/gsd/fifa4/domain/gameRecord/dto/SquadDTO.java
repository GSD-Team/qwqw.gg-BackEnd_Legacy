package com.gsd.fifa4.domain.gameRecord.dto;

import com.gsd.fifa4.domain.gameRecord.factory.PlayerFactory;
import com.gsd.fifa4.domain.gameRecord.model.api.match.MatchInfo;
import com.gsd.fifa4.domain.gameRecord.model.api.match.detail.Player;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Created by [Yohan lee]
 * Created on 2021-01-31.
 **/

@Getter
@NoArgsConstructor
public class SquadDTO {

    private String nickName;

    private String accessId;

    private Long clubPrice;

    private int totalClubPay;

    private int averageFwAblilty;

    private int averageMidAblilty;

    private int averageDfAblilty;

    private List<Player> players;

    public SquadDTO(Long clubPrice, MatchInfo matchInfo) {
        this.nickName = matchInfo.getNickName();
        this.accessId = matchInfo.getAccessId();
        this.clubPrice = clubPrice;
        this.players = matchInfo.getPlayers();
        this.totalClubPay = calculateTotalPay(matchInfo.getPlayers());
        this.averageFwAblilty = PlayerFactory.averageForwardAbility(matchInfo.getPlayers());
        this.averageMidAblilty = PlayerFactory.averageMidAbility(matchInfo.getPlayers());
        this.averageDfAblilty = PlayerFactory.averageDefenderAbility(matchInfo.getPlayers());
    }

    //주전만 급여계산.
    private int calculateTotalPay(List<Player> players) {
        return players.stream()
                .filter(Player::isKeyPlayer)
                .mapToInt(Player::getPay)
                .sum();
    }
}

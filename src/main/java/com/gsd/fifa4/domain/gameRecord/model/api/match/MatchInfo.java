package com.gsd.fifa4.domain.gameRecord.model.api.match;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.gsd.fifa4.domain.gameRecord.model.api.match.detail.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class MatchInfo {

    private String accessId;

    @JsonProperty("nickname")
    private String nickName;

    private MatchDetail matchDetail;

    private Shoot shoot;

    private List<ShootDetail> shootDetail;

    private Pass pass;

    private Defence defence;

    @JsonProperty("player")
    private List<Player> players;

}

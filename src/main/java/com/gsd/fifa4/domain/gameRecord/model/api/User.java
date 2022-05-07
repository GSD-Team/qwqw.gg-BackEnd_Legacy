package com.gsd.fifa4.domain.gameRecord.model.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {

    @JsonProperty("accessId")
    private String accessId;

    @JsonProperty("nickname")
    private String nickName;

    @JsonProperty("level")
    private int level;
}

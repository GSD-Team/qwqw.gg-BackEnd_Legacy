package com.gsd.fifa4.domain.gameRecord.model.api.match.detail;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.gsd.fifa4.dataCenter.dto.DataCenter;
import com.gsd.fifa4.global.util.PlayerUtil;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Player {


    @JsonProperty("spId")
    private int id;

    @JsonProperty("spPosition")
    private int position;

    private String positionDescription;

    @JsonProperty("spGrade")
    private int grade;

    private Status status;

    private String name;

    private Long price;

    private String seasonImgUrl;

    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    private int ablilty;

    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    private int pay;

    @JsonGetter("ablilty")
    public int getAblilty() {
        return ablilty + PlayerUtil.addAbility(grade) + 4;
    }

    public boolean isKeyPlayer() {
        return position != 28;
    }

    @JsonGetter("originalName")
    public String getName() {
        return name;
    }

    @JsonGetter("name")
    public String getLastName() {
        return PlayerUtil.getLastName(name);
    }

    @JsonGetter("imageId")
    public int getImageId() {
        return PlayerUtil.getImageId(id);
    }

    @JsonGetter("cardImageUrl")
    public String getCardImageURL() {
        return PlayerUtil.getCardImageURL(seasonImgUrl);
    }

    @JsonGetter("seasonId")
    public int getSeasonId() {
        return PlayerUtil.getSeasonId(id);
    }

    public boolean isForward() {
        return 20 <= position && position <= 27 ;
    }

    public boolean isMid() {
        return 9 <= position && position <= 19;
    }

    public boolean isDefender() {
        return 0 < position && position <= 8;
    }

    public void initDataCenter(DataCenter dataCenter) {
        this.price = dataCenter.getPrice();
        this.name = dataCenter.getName();
        this.pay = dataCenter.getPay();
        this.ablilty = dataCenter.getAblilty();
    }

}

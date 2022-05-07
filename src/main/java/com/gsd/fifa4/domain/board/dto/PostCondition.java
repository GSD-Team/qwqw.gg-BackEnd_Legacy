package com.gsd.fifa4.domain.board.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Created by Yohan lee
 * Created on 2021-03-22.
 **/

@Getter
@NoArgsConstructor
@ApiModel("게시판 검색 조건")
public class PostCondition {
    enum Division {
        ALL,
        TITLE,
        CREATOR
    }

    @ApiModelProperty("검색 키워드")
    private String keyword;

    @ApiModelProperty(value = "검색 구분", example = "ALL : 전체 검색, TITLE : 제목검색, CREATOR : 작성자 검색")
    private Division division;


    @ApiModelProperty(hidden = true)
    public boolean isAll() {
        return division == Division.ALL || division == null;
    }

    @ApiModelProperty(hidden = true)
    public boolean isTitle() {
        return division != null && division == Division.TITLE;
    }

    @ApiModelProperty(hidden = true)
    public boolean isCreator() {
        return division != null && division == Division.CREATOR;
    }

}

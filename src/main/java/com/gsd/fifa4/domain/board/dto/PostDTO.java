package com.gsd.fifa4.domain.board.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.gsd.fifa4.domain.board.model.Post;
import com.querydsl.core.annotations.QueryProjection;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

/**
 * Created by Yohan lee
 * Created on 2021-03-22.
 **/

@Getter
@NoArgsConstructor
@ApiModel("게시글 반환 JSON")
public class PostDTO {

    @ApiModelProperty("게시글 고유 식별자")
    private Long id;

    @ApiModelProperty("게시글 제목")
    private String title;

    @ApiModelProperty("게시글 컨텐츠")
    private String text;

    @ApiModelProperty("공지사항 유무")
    private boolean notice;

    @ApiModelProperty("작성자")
    private String creator;

    @ApiModelProperty("게시글 비밀번호")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String postPassword;

    @ApiModelProperty("생성일")
    private LocalDateTime createdDate;

    @ApiModelProperty("수정일")
    private LocalDateTime updatedDate;

    @QueryProjection
    public PostDTO(Long id, String title, String creator, boolean notice, LocalDateTime createdDate, LocalDateTime updatedDate) {
        this.id = id;
        this.title = title;
        this.creator = creator;
        this.notice = notice;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
    }

    @Getter
    @NoArgsConstructor
    @ApiModel("게시글 요청 JSON")
    public static class Request {

        @ApiModelProperty("게시글 제목")
        @NotBlank(message = "제목은 공백일 수 없습니다.")
        private String title;

        @ApiModelProperty("게시글 컨텐츠")
        @NotBlank(message = "내용은 공백일 수 없습니다.")
        private String text;

        @ApiModelProperty("작성자")
        private String creator;

        @ApiModelProperty("게시글 비밀번호")
        @NotBlank(message = "게시물 패스워드는 공백일 수 없습니다.")
        private String postPassword;
    }
}

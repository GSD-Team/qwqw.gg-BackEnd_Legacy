package com.gsd.fifa4.global.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by Yohan lee
 * Created on 2021-03-22.
 **/


@Getter
@Setter
public class Response {

    private String message;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Object data;


    /**
     * Success 후, 반환할 데이터가 없을 경우 사용.
     */
    public Response() {
        this.message = "success";
        this.data = null;
    }

    /**
     * Success 후, 반환할 데이터가 있을 경우 사용.
     * @param data Response Data
     */
    public Response(Object data) {
        this.message = "success";
        this.data = data;
    }

    /**
     * 오류 반환 시, 사용.
     * @param errorMessage 에러메시지
     */
    public Response(String errorMessage) {
        this.message= errorMessage;
        this.data = null;
    }
}

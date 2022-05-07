package com.gsd.fifa4.dataCenter.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Created by Yohan lee
 * Created on 2021-02-09.
 **/

@Getter
@NoArgsConstructor
public class DataCenter {


    private Long price;

    private String name;

    private int pay;

    private int ablilty;

    @Builder
    public DataCenter(Long price, String name, int pay, int ablilty) {
        this.price = price;
        this.name = name;
        this.pay = pay;
        this.ablilty = ablilty;
    }

    public void setPrice(Long price) {
        this.price = price;
    }
}

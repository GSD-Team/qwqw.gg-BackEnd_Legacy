package com.gsd.fifa4.global;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.TimeZone;

/**
 * Created by Yohan lee
 * Created on 2021-03-04.
 **/
public class UtilMethodTest {

    @DisplayName("TimeZone Convert Test")
    @Test
    void timezone() {
        LocalDateTime localDateTime =
                LocalDateTime.ofInstant(Instant.ofEpochSecond(1614319004), TimeZone.getTimeZone("Asia/Seoul").toZoneId());
        System.out.println(localDateTime);
    }
}

package com.gsd.fifa4.domain.gameRecord.util;

import org.jsoup.Jsoup;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.io.IOException;

public class CrawlingTuningTest {

    private static final String PRICE_URL = "http://fifaonline4.nexon.com/datacenter/PlayerPriceGraph?spid=201001109&n1strong=1";
    private static final String NAME_URL = "http://fifaonline4.nexon.com/DataCenter/PlayerInfo?spid=201001109";
    private static final String PRICE_CSS =  ".header .add_info .txt strong";
    private static final String NAME_CSS =  ".datacenter .data_detail .wrap .content_header .info_wrap .info_line .name";



    @Test
    @Timeout(8000)
    void t1() throws IOException {
        for(int i=0; i<11; i++) {
            Jsoup.connect(PRICE_URL).execute();
        }
    }

    @Test
    void t2() throws IOException {
        for(int i=0; i<11; i++) {
            Jsoup.connect(PRICE_URL).post().select(PRICE_CSS).text();
        }
    }

    @Test
    void t3() {

    }

    @Test
    void t4() {

    }

    @Test
    void t5() {

    }

    @Test
    void t6() {

    }

}

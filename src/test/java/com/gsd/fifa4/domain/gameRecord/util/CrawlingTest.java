package com.gsd.fifa4.domain.gameRecord.util;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;




public class CrawlingTest {

    private static final String PRICE_URL = "http://fifaonline4.nexon.com/datacenter/PlayerPriceGraph?spid=216020801&n1strong=1";
    private static final String DATA_CENTER_URL = "http://fifaonline4.nexon.com/DataCenter/PlayerInfo?spid=216020801&n1Strong=1";
    private static final String SP_ID = "216020801";
    private static final String PRICE_CSS =
            ".header .add_info .txt strong";
    private static final String NAME_CSS =
            ".datacenter .data_detail .wrap .content_header .info_wrap .info_line .name";
    private static final String PAY_CSS =
            ".datacenter .data_detail .wrap .content_header .info_wrap .info_line .side_utils .pay_side";
    private static final String ABLILTY_CSS =
            ".datacenter .data_detail .wrap .content_header .thumb .ovr";


    @Test
    @DisplayName("한번에 단가,이름,급여 능력치 모두 뽑기")
    void allCrawl() throws IOException {
        String price = Jsoup.connect(PRICE_URL).post().select(PRICE_CSS).text();
        Document document = Jsoup.connect(DATA_CENTER_URL).post();
        String name = document.select(NAME_CSS).text();
        String pay =  document.select(PAY_CSS).text();
        String ablilty = document.select(ABLILTY_CSS).text();
        System.out.println(price + name + pay + ablilty);

    }


    @Test
    @DisplayName("말디니 단가 뽑아내기.")
    void price() throws IOException {
        String price = Jsoup.connect(PRICE_URL).post().select(PRICE_CSS).text();
        System.out.println(price);
    }

    @Test
    @DisplayName("말디니 이름 뽑아내기")
    void name() throws IOException {
        String name = Jsoup.connect(DATA_CENTER_URL).get().select(NAME_CSS).text();
        System.out.println(name);
        assertEquals("파올로 말디니", name);
    }

    @Test
    @DisplayName("말디니 급여 뽑아내기")
    void pay() throws IOException {
        String pay = Jsoup.connect(DATA_CENTER_URL).get().select(PAY_CSS).text();
        System.out.println(pay);
    }

    @Test
    @DisplayName("말디니 능력치 뽑아내기")
    void ablilty() throws IOException {
        String ablilty = Jsoup.connect(DATA_CENTER_URL).get().select(ABLILTY_CSS).text();
        System.out.println(ablilty);
    }



}

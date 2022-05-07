package com.gsd.fifa4.dataCenter;

import com.gsd.fifa4.dataCenter.dto.DataCenter;
import com.gsd.fifa4.global.properties.ExternalProperties;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.io.IOException;


@Slf4j
@Service
@RequiredArgsConstructor
public class DataCenterAdapter {

    private final ExternalProperties properties;


    public DataCenter getPlayer(int spId) {
        Document playerDocument = getPlayerDocument(spId);
        return DataCenter.builder()
                .name(scrapingPlayerName(playerDocument))
                .pay(scrapingPlayerPay(playerDocument))
                .ablilty(scrapingPlayerAblilty(playerDocument))
                .build();
    }

    public DataCenter getPlayer(int spId, int strong) {
        DataCenter dataCenter = getPlayer(spId);
        dataCenter.setPrice(scrapingPlayerPrice(getPriceDocument(spId, strong)));
        return dataCenter;
    }

    public Long getPlayerPrice(int spId, int strong) {
        return scrapingPlayerPrice(getPriceDocument(spId, strong));
    }



    private Long scrapingPlayerPrice(Document document) {
        String price = document//getPriceDocument(spId, strong)
                .select(properties.getPlayerPriceCssQuery())
                .text();

        return priceToLong(price);
    }

    private String scrapingPlayerName(Document document) {
        return document
                .select(properties.getPlayerNameCssQuery())
                .text();
    }

    private int scrapingPlayerPay(Document document) {
        String pay = document
                .select(properties.getPlayerPayCssQuery())
                .text();

        return Integer.parseInt(pay);
    }

    private int scrapingPlayerAblilty(Document document) {
        String ablilty = document
                .select(properties.getPlayerAbliltyCssQuery())
                .text();

        return Integer.parseInt(ablilty);
    }

    private Document getPriceDocument(int spId, int strong) {
        try {
            return Jsoup.connect(properties.createPlayerPriceUrl(spId, strong))
                    .post();
        } catch (IOException e) {
            log.error("데이터센터 연결 실패 [{}]", e.getMessage());
        }

        throw new IllegalArgumentException("데이터 센터 연결 실패");
    }

    private Document getPlayerDocument(int spId) {
        try {
            return Jsoup.connect(properties.createPlayerUrl(spId))
                    .get();
        } catch (IOException e) {
            log.error("데이터센터 연결 실패 [{}]", e.getMessage());
        }

        throw new IllegalArgumentException("데이터 센터 연결 실패");
    }

    private Long priceToLong(String playerPrice) {
        if(StringUtils.isEmpty(playerPrice)) {
            return 0L;
        }

        return Long.valueOf(playerPrice
                .replace("BP", "")
                .replaceAll(",", "")
                .trim());
    }
}

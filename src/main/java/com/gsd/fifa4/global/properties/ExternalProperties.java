package com.gsd.fifa4.global.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
@ConfigurationProperties("gamerecord.external")
public class ExternalProperties {
    private String playerPriceUrl;
    private String playerPriceCssQuery;

    private String playerUrl;
    private String playerNameCssQuery;
    private String playerPayCssQuery;
    private String playerAbliltyCssQuery;


    public String createPlayerPriceUrl(int spId, int strong) {
        return String.format("%s?spid=%d&n1strong=%d", playerPriceUrl, spId, strong);
    }

    public String createPlayerUrl(int spId) {
        return String.format("%s?spid=%d",playerUrl, spId);
    }
}

package com.gsd.fifa4.global.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
@ConfigurationProperties(prefix = "gamerecord.domain")
public class DomainProperties {
    private String match;

    private String user;

    private MetaData metaData;


    @Getter
    @Setter
    public static class MetaData {
        private String position;

        private String season;

        private String division;
    }
}

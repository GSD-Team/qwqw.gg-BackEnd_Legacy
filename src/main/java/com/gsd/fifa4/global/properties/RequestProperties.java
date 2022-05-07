package com.gsd.fifa4.global.properties;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;


@Component
@Getter
@Setter
@ConfigurationProperties(prefix = "gamerecord.http")
@ToString
public class RequestProperties {
    private String authorization;
    private String protocol;
}

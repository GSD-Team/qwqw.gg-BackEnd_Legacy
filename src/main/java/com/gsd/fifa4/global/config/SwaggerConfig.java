package com.gsd.fifa4.global.config;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Pageable;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.List;

/**
 * Created by Yohan lee
 * Created on 2021-03-22.
 **/

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.OAS_30)
                .apiInfo(apiInfo())
                .directModelSubstitute(Pageable.class, SwaggerPage.class)
                .select()
                // 현재 RequestMapping으로 할당된 모든 URL 리스트를 추출
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.ant("/api/board/**"))
                .build();
    }

    private ApiInfo apiInfo() {
        StringBuilder builder = new StringBuilder()
            .append("페이징리스트 pageable 정의 ->")
            .append("pageSize : 페이지당 표출되는 데이터 개수 ")
            .append("totalElements : 총 데이터 개수");
        return new ApiInfoBuilder()
                .title("FIFA Record API")
                .description(builder.toString())
                .version("1.0")
                .build();
    }

    @Getter
    @Setter
    @ApiModel
    static class SwaggerPage {
        @ApiModelProperty(value = "페이지 번호(1~N)")
        private Integer page;

//        @ApiModelProperty(value = "페이지 크기(ex.4)")
//        private Integer size;

//        @ApiModelProperty(value = "정렬조건['컬럼명', ASC(내림차순) or DESC(오름차순)]\n" +
//                "example) sort=createdDate,DESC")
//        private List<String> sort;
    }
}

package com.gsd.fifa4.api;


import com.gsd.fifa4.domain.gameRecord.model.meta.Division;
import com.gsd.fifa4.domain.gameRecord.model.meta.Position;
import com.gsd.fifa4.domain.gameRecord.model.meta.Season;
import com.gsd.fifa4.global.adapter.HttpAdapter;
import com.gsd.fifa4.global.properties.DomainProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
@RequiredArgsConstructor
public class MetaDataApi {

    private final HttpAdapter httpAdapter;
    private final DomainProperties domainProperties;


    /**
     * 선수 포지션에 대한 메타데이터를 가져온다.
     * @return 포지션 메타데이터 리스트
     */
    public List<Position> getPositions() {
        Position[] positions =
                httpAdapter.getRestApi(domainProperties.getMetaData().getPosition(), null, Position[].class);

        return Arrays.asList(positions);
    }

    /**
     * 시즌 정보에 대한 메타데이터를 가져온다.
     * @return 시즌 메타데이터 리스트
     */
    public List<Season> getSeasons() {
        Season[] seasons =
                httpAdapter.getRestApi(domainProperties.getMetaData().getSeason(), null, Season[].class);

        return Arrays.asList(seasons);
    }

    /**
     * 등급 식별자 메타 데이터를 가져온다.
     * @return 등급 식별자 리스트
     */
    public List<Division> getDivisions() {
        Division[] divisions =
                httpAdapter.getRestApi(domainProperties.getMetaData().getDivision(), null, Division[].class);

        return Arrays.asList(divisions);
    }

}

package com.gsd.fifa4.global.adapter;

import com.gsd.fifa4.global.error.RestException;
import com.gsd.fifa4.global.properties.RequestProperties;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import javax.annotation.PostConstruct;
import java.net.URI;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class HttpAdapter {

    private final RestTemplate restTemplate;
    private final RequestProperties requestProperties;
    private HttpEntity<?> nexonHttpEntity;

    @PostConstruct
    public void setHttpEntity() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization",requestProperties.getAuthorization());
        nexonHttpEntity =   new HttpEntity<>(headers);
    }


    /**
     * Path를 포함한 HTTP 통신을 하여, Response값을 받는다.
     * @apiNote api.nexon.co.kr/fifaonline4/v1.0/matches
     * @param domain API 도메인주소
     * @param searchParam REST 식별자 파라미터
     * @param clazz 반환해줄 Class 타입
     * @return Response 데이터를 담은 Entity 객체
     */
    public <T> T getRestApi(String domain, String searchParam, Class<T> clazz){
        URI uri = UriComponentsBuilder.fromUriString(requestProperties.getProtocol()+ domain)
                .pathSegment(searchParam)
                .build().encode()
                .toUri();

        return execute(uri, clazz);
    }

    /**
     * QueryString을 포함한 HTTP 통신을 하여, Response값을 받는다.
     * @apiNote api.nexon.co.kr/fifaonline4/v1.0/users?nickname={nickname}
     * @param domain API 도메인주소 ex)api.nexon.co.kr/fifaonline4/v1.0/matches/
     * @param queryParamMap 쿼리스트링을 담은 Map
     * @param clazz 반환해줄 Class 타입
     * @return Response 데이터를 담은 Entity 객체
     */
    public <T> T getQueryStringApi(String domain, MultiValueMap<String, String> queryParamMap, Class<T> clazz){
        URI uri = UriComponentsBuilder.fromUriString(requestProperties.getProtocol()+ domain)
                .queryParams(queryParamMap)
                .build().encode()
                .toUri();

      return execute(uri, clazz);
    }

    /**
     * Path와 QueryString을 포함한 HTTP 통신을 하여, Response값을 받는다.
     * @apiNote https://api.nexon.co.kr/fifaonline4/v1.0/users/09957c305a4b744584fd9ef2/matches?matchtype=50&offset=0&limit=10
     * @param domain API 도메인주소
     * @param queryParamMap 쿼리스트링을 담은 Map
     * @param clazz 반환해줄 Class 타입
     * @param pathSegments path값(가변인자)
     * @return Response 데이터를 담은 Entity 객체
     */
    public <T> T getPathAndQueryStringApi(String domain, MultiValueMap<String, String> queryParamMap,
                                          Class<T> clazz, String ... pathSegments){

        URI uri = UriComponentsBuilder.fromUriString(requestProperties.getProtocol()+domain)
                .pathSegment(pathSegments)
                .queryParams(queryParamMap)
                .build().encode()
                .toUri();

        return execute(uri, clazz);
    }


    private <T> T execute(URI uri, Class<T> clazz) {
        ResponseEntity<T> response = restTemplate.exchange(uri, HttpMethod.GET, nexonHttpEntity, clazz);

        if(!response.getStatusCode().is2xxSuccessful()) {
            log.error("Request Error. ErrorCode is [{}]", response.getStatusCodeValue());
            throw new RestException("요청 실패."+"["+uri+"]", response.getBody());
        }

        return Optional.ofNullable(response.getBody())
                .orElseThrow(() -> new RestException("Response 데이터가 없습니다.", null));
    }


}

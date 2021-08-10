package com.tistory.cookeat.cookeating.naver;

import com.tistory.cookeat.cookeating.naver.dto.SearchImageReq;
import com.tistory.cookeat.cookeating.naver.dto.SearchImageRes;
import com.tistory.cookeat.cookeating.naver.dto.SearchLocalReq;
import com.tistory.cookeat.cookeating.naver.dto.SearchLocalRes;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Component
@PropertySource("classpath:application-naver.yml")
public class NaverClient {

    @Value("${naver.client.id}")
    private String naverClientId;

    @Value("${naver.client.secret}")
    private String naverSecret;

    @Value("${naver.url.search.local}")
    private String naverLocalSearchUrl;

    @Value("${naver.url.search.image}")
    private String naverImageSearchUrl;

    public SearchLocalRes localSearch(SearchLocalReq searchLocalReq) {

        URI uri = UriComponentsBuilder.fromUriString(this.naverLocalSearchUrl)
                .queryParams(searchLocalReq.toMultiValueMap())
                .build()
                .encode()
                .toUri();

        HttpHeaders headers = new HttpHeaders();
        headers.set("X-Naver-Client-Id", this.naverClientId);
        headers.set("X-Naver-Client-Secret", this.naverSecret);
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity reqHttpEntity = new HttpEntity(headers);
        ParameterizedTypeReference<SearchLocalRes> responseType = new ParameterizedTypeReference<>() {};

        ResponseEntity<SearchLocalRes> responseEntity = new RestTemplate().exchange(
                uri,
                HttpMethod.GET,
                reqHttpEntity,
                responseType
        );

        return responseEntity.getBody();
    }

    public SearchImageRes ImageSearch(SearchImageReq searchImageReq) {
        URI uri = UriComponentsBuilder.fromUriString(this.naverImageSearchUrl)
                .queryParams(searchImageReq.toMultiValueMap())
                .build().encode().toUri();

        HttpHeaders headers = new HttpHeaders();
        headers.set("X-Naver-Client-Id", this.naverClientId);
        headers.set("X-Naver-Client-Secret", this.naverSecret);
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity reqHttpEntity = new HttpEntity(headers);
        ParameterizedTypeReference<SearchImageRes> responseType = new ParameterizedTypeReference<>() {};

        ResponseEntity<SearchImageRes> responseEntity = new RestTemplate().exchange(
                uri,
                HttpMethod.GET,
                reqHttpEntity,
                responseType
        );

        return responseEntity.getBody();
    }
}

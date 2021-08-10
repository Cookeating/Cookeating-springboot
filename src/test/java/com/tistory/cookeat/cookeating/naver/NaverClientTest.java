package com.tistory.cookeat.cookeating.naver;

import com.tistory.cookeat.cookeating.naver.dto.SearchImageReq;
import com.tistory.cookeat.cookeating.naver.dto.SearchImageRes;
import com.tistory.cookeat.cookeating.naver.dto.SearchLocalReq;
import com.tistory.cookeat.cookeating.naver.dto.SearchLocalRes;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class NaverClientTest {

    @Autowired
    private NaverClient naverClient;

    @Test
    void searchLocalTest() {

        SearchLocalReq searchLocalReq = new SearchLocalReq();
        searchLocalReq.setQuery("고기");

        SearchLocalRes searchLocalRes = naverClient.localSearch(searchLocalReq);
        assertTrue(searchLocalRes.getItems().size() > 0);
    }

    @Test
    void searchImage() {

        SearchImageReq searchImageReq = new SearchImageReq();
        searchImageReq.setQuery("고기");

        SearchImageRes searchImageRes = naverClient.ImageSearch(searchImageReq);
        assertTrue(searchImageRes.getItems().size() > 0);
    }
}
package com.tistory.cookeat.cookeating.service.search;

import com.tistory.cookeat.cookeating.dto.SearchResDTO;
import com.tistory.cookeat.cookeating.naver.NaverClient;
import com.tistory.cookeat.cookeating.naver.dto.SearchImageReq;
import com.tistory.cookeat.cookeating.naver.dto.SearchImageRes;
import com.tistory.cookeat.cookeating.naver.dto.SearchLocalReq;
import com.tistory.cookeat.cookeating.naver.dto.SearchLocalRes;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SearchService {

    private final NaverClient naverClient;

    public List<SearchResDTO> search(String query) {

        List<SearchResDTO> searchResDTOList = new ArrayList<>();

        SearchLocalReq searchLocalReq = new SearchLocalReq();
        searchLocalReq.setQuery(query);

        //지역검색
        SearchLocalRes searchLocalRes = naverClient.localSearch(searchLocalReq);
        if (searchLocalRes.getTotal() > 0) {
            //이미지 검색
            searchLocalRes.getItems().forEach(localItem -> {
                String imageQuery = localItem.getTitle().replace("<[^>]*>", "");
                SearchImageReq searchImageReq = new SearchImageReq();
                searchImageReq.setQuery(imageQuery);
                SearchImageRes searchImageRes = naverClient.ImageSearch(searchImageReq);

                String imageLink = "";
                if (searchImageRes.getTotal() > 0) {
                    imageLink = searchImageRes.getItems().stream().findFirst().get().getLink();
                }

                searchResDTOList.add(SearchResDTO.builder()
                        .title(localItem.getTitle())
                        .category(localItem.getCategory())
                        .address(localItem.getAddress())
                        .readAddress(localItem.getRoadAddress())
                        .homePageLink(localItem.getLink())
                        .imageLink(imageLink)
                        .build());
            });
        }
        //결과를 리턴
        return searchResDTOList;
    }
}

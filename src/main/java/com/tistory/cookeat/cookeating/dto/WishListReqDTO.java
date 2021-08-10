package com.tistory.cookeat.cookeating.dto;

import com.tistory.cookeat.cookeating.domain.wishlist.WishList;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@Data
public class WishListReqDTO {

    private String title;                   // 음식명, 장소명
    private String category;                // 카테고리
    private String address;                 // 주소
    private String roadAddress;             // 도로명
    private String homePageLink;            // 홈페이지 주소
    private String imageLink;               // 음식, 가게 이미지 주소
    private boolean isVisit;                // 방문 여부
    private int visitCount;                 // 방문 카운트
    private LocalDateTime lastVisitDate;    // 마지막 방문 일자

    @Builder
    public WishListReqDTO(String title, String category, String address, String roadAddress, String homePageLink, String imageLink, boolean isVisit, int visitCount, LocalDateTime lastVisitDate) {
        this.title = title;
        this.category = category;
        this.address = address;
        this.roadAddress = roadAddress;
        this.homePageLink = homePageLink;
        this.imageLink = imageLink;
        this.isVisit = isVisit;
        this.visitCount = visitCount;
        this.lastVisitDate = lastVisitDate;
    }

    public WishList toEntity() {
        return WishList.builder()
                .title(title)
                .category(category)
                .address(address)
                .roadAddress(roadAddress)
                .homePageLink(homePageLink)
                .imageLink(imageLink)
                .isVisit(isVisit)
                .visitCount(visitCount)
                .lastVisitDate(lastVisitDate)
                .build();
    }

}

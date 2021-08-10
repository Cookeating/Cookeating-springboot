package com.tistory.cookeat.cookeating.dto;

import com.tistory.cookeat.cookeating.domain.wishlist.WishList;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class WishListResDTO {

    private Long id;                        // index
    private String title;                   // 음식명, 장소명
    private String category;                // 카테고리
    private String address;                 // 주소
    private String roadAddress;             // 도로명
    private String homePageLink;            // 홈페이지 주소
    private String imageLink;               // 음식, 가게 이미지 주소
    private boolean isVisit;                // 방문 여부
    private int visitCount;                 // 방문 카운트
    private LocalDateTime lastVisitDate;    // 마지막 방문 일자

    public WishListResDTO(WishList wishList) {
        this.id = wishList.getWishItemId();
        this.title = wishList.getTitle();
        this.category = wishList.getCategory();
        this.address = wishList.getAddress();
        this.roadAddress = wishList.getRoadAddress();
        this.homePageLink = wishList.getHomePageLink();
        this.imageLink = wishList.getImageLink();
        this.isVisit = wishList.isVisit();
        this.visitCount = wishList.getVisitCount();
        this.lastVisitDate = wishList.getLastVisitDate();
    }


}

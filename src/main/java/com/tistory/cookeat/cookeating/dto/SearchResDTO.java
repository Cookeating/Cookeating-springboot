package com.tistory.cookeat.cookeating.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@Data
public class SearchResDTO {

    private String title;                   // 음식명, 장소명
    private String category;                // 카테고리
    private String address;                 // 주소
    private String readAddress;             // 도로명
    private String homePageLink;            // 홈페이지 주소
    private String imageLink;               // 음식, 가게 이미지 주소
    private boolean isVisit;                // 방문 여부
    private int visitCount;                 // 방문 카운트
    private LocalDateTime lastVisitDate;    // 마지막 방문 일자

    @Builder
    public SearchResDTO(String title, String category, String address, String readAddress, String homePageLink, String imageLink, boolean isVisit, int visitCount, LocalDateTime lastVisitDate) {
        this.title = title;
        this.category = category;
        this.address = address;
        this.readAddress = readAddress;
        this.homePageLink = homePageLink;
        this.imageLink = imageLink;
        this.isVisit = isVisit;
        this.visitCount = visitCount;
        this.lastVisitDate = lastVisitDate;
    }
}

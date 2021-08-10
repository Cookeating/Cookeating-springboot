package com.tistory.cookeat.cookeating.domain.wishlist;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@ToString
public class WishList {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long wishItemId;                // Index

    @Column(nullable = false)
    private String title;                   // 음식명, 장소명

    @Column
    private String category;                // 카테고리

    @Column
    private String address;                 // 주소

    @Column
    private String roadAddress;             // 도로명

    @Column
    private String homePageLink;            // 홈페이지 주소

    @Column
    private String imageLink;               // 음식, 가게 이미지 주소

    @Column
    private boolean isVisit;                // 방문 여부

    @Column
    private int visitCount;                 // 방문 카운트

    @Column
    private LocalDateTime lastVisitDate;    // 마지막 방문 일자

    @Builder
    public WishList(String title, String category, String address, String roadAddress, String homePageLink, String imageLink, boolean isVisit, int visitCount, LocalDateTime lastVisitDate) {
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
}

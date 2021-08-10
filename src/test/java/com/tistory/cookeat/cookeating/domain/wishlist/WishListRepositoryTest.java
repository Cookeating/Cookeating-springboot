package com.tistory.cookeat.cookeating.domain.wishlist;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class WishListRepositoryTest {

    @Autowired
    private WishListRepository wishListRepository;


    @Test
    public void saveTest() {

        WishList expect = create();
        wishListRepository.save(expect);

        WishList actual = wishListRepository.findAll().stream().findFirst().get();

        assertNotNull(actual);
        assertEquals(1, actual.getWishItemId());
        assertEquals(expect.getTitle(), actual.getTitle());
    }

    @Test
    public void updateTest() {

        WishList expect = create();
        WishList savedWishList = wishListRepository.save(expect);

        savedWishList.setTitle("updateTest Title");
        WishList actual = wishListRepository.save(savedWishList);

        assertEquals(1, actual.getWishItemId());
        assertEquals("updateTest Title", actual.getTitle());
    }

    @Test
    public void findByIdTest() {
        WishList expect = create();
        wishListRepository.save(expect);

        Optional<WishList> optionalWishList = wishListRepository.findById(1L);
        WishList actual = optionalWishList.get();

        assertEquals(true, optionalWishList.isPresent());
        assertEquals(1, actual.getWishItemId());

    }

    @Test
    public void deleteTest() {
        WishList expect = create();
        wishListRepository.save(expect);

        wishListRepository.deleteById(1L);
        List<WishList> all = wishListRepository.findAll();

        assertEquals(0, all.size());
    }

    @Test
    public void listAllTest() {
        WishList expect = create();
        wishListRepository.save(expect);

        WishList expect2 = create();
        wishListRepository.save(expect2);

        List<WishList> all = wishListRepository.findAll();

        assertEquals(2, all.size());
    }

    private WishList create() {
        WishList wishList = new WishList();
        wishList.setTitle("title");
        wishList.setCategory("category");
        wishList.setAddress("address");
        wishList.setRoadAddress("readAddress");
        wishList.setHomePageLink("");
        wishList.setImageLink("");
        wishList.setVisit(false);
        wishList.setVisitCount(0);
        wishList.setLastVisitDate(null);

        return wishList;
    }
}
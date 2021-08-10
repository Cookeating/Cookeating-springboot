package com.tistory.cookeat.cookeating.service.wishlist;

import com.tistory.cookeat.cookeating.domain.wishlist.WishList;
import com.tistory.cookeat.cookeating.domain.wishlist.WishListRepository;
import com.tistory.cookeat.cookeating.dto.WishListReqDTO;
import com.tistory.cookeat.cookeating.dto.WishListResDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class WishListService {

    private final WishListRepository wishListRepository;

    public WishListResDTO add(WishListReqDTO wishListDTO) {
        return new WishListResDTO(wishListRepository.save(wishListDTO.toEntity()));
    }

    public List<WishListResDTO> findAll() {
        List<WishList> entityList = wishListRepository.findAll();
        List<WishListResDTO> resDTOList = new ArrayList<>();
        entityList.forEach(item -> {
            resDTOList.add(new WishListResDTO(item));
        });
        return resDTOList;
    }

    public WishListResDTO addVisitCount(Long id) {
        Optional<WishList> byId = wishListRepository.findById(id);
        if (byId.isPresent()) {
            WishList wishList = byId.get();
            wishList.setVisit(true);
            wishList.setVisitCount(wishList.getVisitCount() + 1);
            return new WishListResDTO(wishListRepository.save(wishList));
        }
        return null;
    }

    public void deleteById(Long index) {
        wishListRepository.deleteById(index);
    }
}

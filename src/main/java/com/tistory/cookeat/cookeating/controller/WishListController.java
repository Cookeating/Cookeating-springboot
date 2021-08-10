package com.tistory.cookeat.cookeating.controller;

import com.tistory.cookeat.cookeating.dto.WishListReqDTO;
import com.tistory.cookeat.cookeating.dto.WishListResDTO;
import com.tistory.cookeat.cookeating.service.wishlist.WishListService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/wish")
public class WishListController {

    private final WishListService wishListService;

    @PostMapping("/add")
    public ResponseEntity<WishListResDTO> add(@RequestBody WishListReqDTO wishListReqDTO) {
        log.info("WishListReqDTO :: {}", wishListReqDTO);
        return ResponseEntity.ok(wishListService.add(wishListReqDTO));
    }

    @GetMapping("/list")
    public ResponseEntity<List<WishListResDTO>> findAll() {
        return ResponseEntity.ok(wishListService.findAll());
    }

    @PutMapping("/visit/{index}")
    public ResponseEntity<?> addVisitCount(@PathVariable Long id) {
        WishListResDTO wishListResDTO = wishListService.addVisitCount(id);
        if (wishListResDTO != null) {
            return ResponseEntity.ok(wishListResDTO);
        }
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

    }

    @DeleteMapping("/delete/{index}")
    public ResponseEntity delete(@PathVariable Long index) {
        wishListService.deleteById(index);
        return ResponseEntity.ok().build();
    }

}

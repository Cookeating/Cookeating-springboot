package com.tistory.cookeat.cookeating.controller;

import com.tistory.cookeat.cookeating.dto.SearchResDTO;
import com.tistory.cookeat.cookeating.service.search.SearchService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class SearchController {

    private final SearchService searchService;

    @GetMapping("/search")
    public List<SearchResDTO> search(@RequestParam String query) {
        return searchService.search(query);
    }
}

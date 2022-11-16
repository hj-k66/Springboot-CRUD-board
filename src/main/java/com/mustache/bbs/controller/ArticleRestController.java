package com.mustache.bbs.controller;

import com.mustache.bbs.domain.dto.ArticleAddRequest;
import com.mustache.bbs.domain.dto.ArticleAddResponse;
import com.mustache.bbs.domain.dto.ArticleDto;
import com.mustache.bbs.service.ArticleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/articles")
public class ArticleRestController {
    private final ArticleService articleService;

    public ArticleRestController(ArticleService articleService) {
        this.articleService = articleService;
    }
    @PostMapping
    public ResponseEntity<ArticleAddResponse> add(ArticleAddRequest request){
        ArticleAddResponse response = articleService.add(request);
        return ResponseEntity.ok().body(response);
    }
    @GetMapping("/{id}")
    public ResponseEntity<ArticleDto> get(@PathVariable Long id){
        ArticleDto articleDto = articleService.getArticle(id);
        return ResponseEntity.ok().body(articleDto);
    }
}

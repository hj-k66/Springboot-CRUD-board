package com.mustache.bbs.service;

import com.mustache.bbs.domain.dto.ArticleAddRequest;
import com.mustache.bbs.domain.dto.ArticleAddResponse;
import com.mustache.bbs.domain.dto.ArticleDto;
import com.mustache.bbs.domain.entity.Article;
import com.mustache.bbs.repository.ArticleRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class ArticleService {
    private final ArticleRepository articleRepository;

    public ArticleService(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    public ArticleAddResponse add(ArticleAddRequest dto){
        Article article = dto.toEntity();
        Article saveArticle = articleRepository.save(article);
        return new ArticleAddResponse(saveArticle.getId(), saveArticle.getTitle(), saveArticle.getContent());
    }

    public ArticleDto getArticle(Long id) {
        Optional<Article> opArticle = articleRepository.findById(id);
        Article article = opArticle.get();
        ArticleDto articleDto = Article.of(article);
        return articleDto;

    }

}

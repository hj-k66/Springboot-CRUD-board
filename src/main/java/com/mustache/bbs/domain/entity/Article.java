package com.mustache.bbs.domain.entity;

import com.mustache.bbs.domain.dto.ArticleDto;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
@Getter
@AllArgsConstructor
@Builder
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String content;

    public Article(String title, String content) {
        this.title = title;
        this.content = content;
    }
    public static ArticleDto of(Article article){
        return new ArticleDto(article.getId(), article.getTitle(), article.getContent());
    }


}

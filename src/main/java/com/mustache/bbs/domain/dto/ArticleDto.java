package com.mustache.bbs.domain.dto;

import com.mustache.bbs.domain.entity.Article;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Builder
@Getter
@ToString
@AllArgsConstructor
public class ArticleDto {
    private Long id;
    private String title;
    private String content;


    public Article toEntity(){
        return new Article(this.id, this.title, this.content);
    }

}

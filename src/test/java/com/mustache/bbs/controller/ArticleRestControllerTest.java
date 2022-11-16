package com.mustache.bbs.controller;

import com.mustache.bbs.domain.dto.ArticleDto;
import com.mustache.bbs.service.ArticleService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@WebMvcTest(ArticleRestController.class)
class ArticleRestControllerTest {
    @Autowired
    MockMvc mockMvc;

    @MockBean
    ArticleService articleService;

    @Test
    @DisplayName("1개의 게시글이 Json형태로 Response가 잘 오는 test")
    void responseArticleToJson() throws Exception{
        ArticleDto articleDto = ArticleDto.builder()
                .id(1L)
                .title("제목이다!")
                .content("내용이다!")
                .build();
        given(articleService.getArticle(1L))
                .willReturn(articleDto);

        Long articleId = 1L;
        String url = String.format("/api/vi/articles/%d", articleId);

        mockMvc.perform(get(url))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title").exists())
                .andExpect(jsonPath("$.title").value("제목이다!"))
                .andDo(print());

        verify(articleService).getArticle(articleId);

    }

}
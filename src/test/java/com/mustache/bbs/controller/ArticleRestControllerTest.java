package com.mustache.bbs.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mustache.bbs.domain.dto.ArticleAddRequest;
import com.mustache.bbs.domain.dto.ArticleAddResponse;
import com.mustache.bbs.domain.dto.ArticleDto;
import com.mustache.bbs.service.ArticleService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
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

    @Autowired
    ObjectMapper objectMapper;

    @Test
    @DisplayName("새 글 등록이 잘 되는지 테스트")
    void add() throws Exception{
        ArticleAddRequest dto = new ArticleAddRequest("제목목", "내요용");
        given(articleService.add(any()))
                .willReturn(new ArticleAddResponse(1L, dto.getTitle(), dto.getContent()));

        mockMvc.perform(post("/api/v1/articles")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsBytes(dto)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").exists())
                .andExpect(jsonPath("$.title").exists())
                .andExpect(jsonPath("$.title").value("제목목"))
                .andExpect(jsonPath("$.content").exists())
                .andExpect(jsonPath("$.content").value("내요용"))
                .andDo(print());


    }

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
        String url = String.format("/api/v1/articles/%d", articleId);

        mockMvc.perform(get(url))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title").exists())
                .andExpect(jsonPath("$.title").value("제목이다!"))
                .andDo(print());

        verify(articleService).getArticle(articleId);
    }

}
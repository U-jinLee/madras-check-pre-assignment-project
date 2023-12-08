package com.example.madrascheck.domain.fileextension.controller;

import com.example.madrascheck.IntegrationTest;
import com.example.madrascheck.domain.fileextension.dto.FileExtensionPostDto;
import com.example.madrascheck.domain.fileextension.model.Status;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class FileExtensionApiControllerTest extends IntegrationTest {

    @Test
    void 확장자_입력_성공() throws Exception {
        //given
        String name = "sh";
        Status status = Status.CUSTOM;
        FileExtensionPostDto.Request request =
                FileExtensionPostDto.Request.of(name, status);
        //when
        mvc.perform(post("/api/file-extensions")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andDo(print())
                //then
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").exists())
                .andExpect(jsonPath("$.name").value(name))
                .andExpect(jsonPath("$.status").value(status.name()));

    }
}
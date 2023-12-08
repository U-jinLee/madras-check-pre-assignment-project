package com.example.madrascheck.domain.fileextension.controller;

import com.example.madrascheck.IntegrationTest;
import com.example.madrascheck.domain.fileextension.dto.FileExtensionPostDto;
import com.example.madrascheck.domain.fileextension.entity.FileExtension;
import com.example.madrascheck.domain.fileextension.model.Status;
import com.example.madrascheck.global.config.RestDocsConfiguration;
import com.example.madrascheck.global.setup.FileExtensionSetUp;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.post;
import static org.springframework.restdocs.payload.PayloadDocumentation.*;
import static org.springframework.restdocs.request.RequestDocumentation.parameterWithName;
import static org.springframework.restdocs.request.RequestDocumentation.pathParameters;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Import(RestDocsConfiguration.class)
@AutoConfigureRestDocs
class FileExtensionApiControllerTest extends IntegrationTest {

    @Autowired
    FileExtensionSetUp fileExtensionSetUp;

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
                .andDo(document("post-file-extension",
                        requestFields(
                                fieldWithPath("name").description("확장자명"),
                                fieldWithPath("status").description("확장자 상태")
                        ),
                        responseFields(
                                fieldWithPath("id").description("확장자 ID"),
                                fieldWithPath("name").description("확장자명"),
                                fieldWithPath("status").description("확장자 상태")
                        )
                        ))
                //then
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").exists())
                .andExpect(jsonPath("$.name").value(name))
                .andExpect(jsonPath("$.status").value(status.name()));

    }

    @Test
    void 확장자_삭제_성공() throws Exception {
        //given
        FileExtension fileExtension = fileExtensionSetUp.save();

        //when
        mvc.perform(RestDocumentationRequestBuilders.delete("/api/file-extensions/{id}", fileExtension.getId())
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andDo(document("delete-file-extension",
                        pathParameters(
                                parameterWithName("id").description("확장자 ID")
                        )
                ))
                //then
                .andExpect(status().isNoContent());
    }
}
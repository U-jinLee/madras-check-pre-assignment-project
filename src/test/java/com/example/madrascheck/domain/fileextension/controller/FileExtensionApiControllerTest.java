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
import org.springframework.test.web.servlet.ResultActions;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.get;
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
    void 확장자_입력_길이검사() throws Exception {
        //given
        String name = "thisextensionislongerthanlimit";
        FileExtensionPostDto.Request request =
                FileExtensionPostDto.Request.from(name);
        //when
        postFileExtensionResultAction(request)
                //then
                .andExpect(status().isBadRequest())
                .andDo(document("errors",
                        responseFields(
                                fieldWithPath("message").description("에러 메시지"),
                                fieldWithPath("status").description("에러 상태"),
                                fieldWithPath("errors").description("에러 목록"),
                                fieldWithPath("errors[].field").description("에러 필드"),
                                fieldWithPath("errors[].value").description("에러 값"),
                                fieldWithPath("errors[].reason").description("에러 이유"),
                                fieldWithPath("code").description("에러 코드")
                        )
                ))
                .andExpect(jsonPath("$.message").exists())
                .andExpect(jsonPath("$.status").exists())
                .andExpect(jsonPath("$.errors").isArray())
                .andExpect(jsonPath("$.errors").exists())
                .andExpect(jsonPath("$.errors[0].field").exists())
                .andExpect(jsonPath("$.errors[0].value").exists())
                .andExpect(jsonPath("$.errors[0].reason").exists())
                .andExpect(jsonPath("$.code").exists());
    }

    @Test
    void 확장자_최대_갯수_검사() throws Exception {
        //given
        fileExtensionSetUp.save(200);

        String name = "jin";
        FileExtensionPostDto.Request request =
                FileExtensionPostDto.Request.from(name);
        //when
        postFileExtensionResultAction(request)
                //then
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.message").exists())
                .andExpect(jsonPath("$.status").exists())
                .andExpect(jsonPath("$.errors").isArray())
                .andExpect(jsonPath("$.errors").exists())
                .andExpect(jsonPath("$.code").exists());
    }

    @Test
    void DEFAULT_확장자_입력_성공() throws Exception {
        //given
        String name = "bat";
        FileExtensionPostDto.Request request =
                FileExtensionPostDto.Request.from(name);
        //when
        postFileExtensionResultAction(request)
                //then
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").exists())
                .andExpect(jsonPath("$.name").value(name))
                .andExpect(jsonPath("$.status").value(Status.DEFAULT.name()));
    }

    @Test
    void CUSTOM_확장자_입력_성공() throws Exception {
        //given
        String name = "sh";
        FileExtensionPostDto.Request request =
                FileExtensionPostDto.Request.from(name);
        //when
        postFileExtensionResultAction(request)
                .andDo(document("post-file-extension",
                        requestFields(
                                fieldWithPath("name").description("확장자명")
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
                .andExpect(jsonPath("$.status").value(Status.CUSTOM.name()));
    }

    private ResultActions postFileExtensionResultAction(FileExtensionPostDto.Request request) throws Exception {
        return mvc.perform(post("/api/file-extensions")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andDo(print());
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

    @Test
    void 확장자_리스트_가져오기() throws Exception {
        //given
        fileExtensionSetUp.saveList();
        //when
        mvc.perform(get("/api/file-extensions")
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andDo(document("get-file-extension",
                        responseFields(
                                fieldWithPath("count").description("CUSTOM 금지 확장자 갯수"),
                                fieldWithPath("defaultExtensions").description("기본 확장자 목록"),
                                fieldWithPath("defaultExtensions[].id").description("기본 확장자 ID"),
                                fieldWithPath("defaultExtensions[].name").description("기본 확장자명"),
                                fieldWithPath("defaultExtensions[].active").description("기본 확장자 활성 상태"),
                                fieldWithPath("customExtensions").description("사용자 확장자 목록"),
                                fieldWithPath("customExtensions[].id").description("사용자 확장자 ID"),
                                fieldWithPath("customExtensions[].name").description("사용자 확장자명")
                        )
                ))
                //then
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.count").exists())
                .andExpect(jsonPath("$.defaultExtensions").isArray())
                .andExpect(jsonPath("$.defaultExtensions[0].id").exists())
                .andExpect(jsonPath("$.defaultExtensions[0].name").exists())
                .andExpect(jsonPath("$.defaultExtensions[0].active").exists())
                .andExpect(jsonPath("$.customExtensions").isArray())
                .andExpect(jsonPath("$.customExtensions[0].id").exists())
                .andExpect(jsonPath("$.customExtensions[0].name").exists());
    }

}
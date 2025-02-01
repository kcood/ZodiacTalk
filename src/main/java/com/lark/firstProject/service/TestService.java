package com.lark.firstProject.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lark.firstProject.data.JsonTestData;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TestService {
    private final ObjectMapper objectMapper;

    public String jsonTest() throws JsonProcessingException {
        JsonTestData jsonTestData = new JsonTestData();
        jsonTestData.setField1("양띠");
        jsonTestData.setField2("최고의 행운");
        jsonTestData.setNumberAsInt(2);
        return objectMapper.writeValueAsString(jsonTestData);
    }
}

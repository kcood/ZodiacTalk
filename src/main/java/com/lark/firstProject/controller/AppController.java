package com.lark.firstProject.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.lark.firstProject.service.GenerateFortuneService;
import com.lark.firstProject.service.GetFortuneService;
import com.lark.firstProject.service.TestService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/astro")
@RequiredArgsConstructor
public class AppController {
    private final GenerateFortuneService generateFortuneService;
    private final GetFortuneService getFortuneService;
    private final TestService testService;

    @GetMapping("/getRecentFortune")
    public void getRecentFortune(){
        //앱에게 요청받은 날부터 10일치 운세 DB에서 가져와 리턴
        generateFortuneService.foo();
    }

    @GetMapping("/generateNewFortune")
    public void generateNewFortune(){
        //오픈 API or 크롤링으로 10일치 운세 생성 -> DB저장

    }


    @GetMapping("/jsonTest")
    public ResponseEntity<?> jsonTest(HttpServletRequest request) throws JsonProcessingException {
        System.out.println("Json Test Executed !!");
        System.out.println("HTTP Method: " + request.getMethod());
        return ResponseEntity.ok(testService.jsonTest());
    }

}

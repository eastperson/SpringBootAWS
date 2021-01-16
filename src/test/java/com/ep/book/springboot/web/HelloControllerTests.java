package com.ep.book.springboot.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)// JUnit 실행자가 아닌 다른 실행자, Controller 테스트
@WebMvcTest // Web에 집중하는 Test 어노테이션 @Controller, ControllerAdvice 사용 가능 단, @Service, @Component, @Respository는 사용x
public class HelloControllerTests {

    // 웹 API 사용을 위해 작성. 스프링 mvc테스트의 시작점.
    // http get,post 등에 대한 API 테스트 가능
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void helloTest() throws Exception {
        String hello = "hello";

        mockMvc.perform(get("/hello")) // 해당 주소로 get 요청
                .andExpect(status().isOk()) // 결과를 검증, OK(200인지 아닌지)
                .andExpect(content().string(hello)); // 결과 검증(hello인지)
    }


    @Test
    public void helloDto() throws Exception {

        String name = "hello";
        int amount = 1000;

        mockMvc.perform(get("/hello/dto")
            .param("name",name)
                .param("amount",String.valueOf(amount)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name",is(name)))
                .andExpect(jsonPath("$.amount",is(amount)));


    }

}

package com.ep.book.springboot.web.dto;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.web.bind.annotation.GetMapping;

@Getter
@RequiredArgsConstructor // 선언된 모든 final 필드가 포함된 생성자 생성
@ToString
public class HelloResponseDto {

    private final String name;
    private final int amount;
}

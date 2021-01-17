package com.ep.book.springboot.config;

import com.ep.book.springboot.config.auth.LoginUserArgumentReslover;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@RequiredArgsConstructor
@Configuration
public class WebConfig implements WebMvcConfigurer {
    private LoginUserArgumentReslover loginUserArgumentReslover;

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolverList){
        argumentResolverList.add(loginUserArgumentReslover);
    }

}

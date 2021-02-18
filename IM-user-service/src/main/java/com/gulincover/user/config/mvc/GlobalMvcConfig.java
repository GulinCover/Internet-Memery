package com.gulincover.user.config.mvc;

import com.gulincover.user.config.error.IMErrorMvcConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;
import java.util.function.Predicate;

//@Configuration
public class GlobalMvcConfig implements WebMvcConfigurer {
    @Override
    public void configureHandlerExceptionResolvers(List<HandlerExceptionResolver> resolvers) {
//        resolvers.add(0, new IMErrorMvcConfig());

    }
}

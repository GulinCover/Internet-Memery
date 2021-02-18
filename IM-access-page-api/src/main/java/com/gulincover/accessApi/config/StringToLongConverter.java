package com.gulincover.accessApi.config;

import org.springframework.core.convert.converter.Converter;

//@Component
public class StringToLongConverter implements Converter<String, Long> {
    @Override
    public Long convert(String s) {
        return Long.decode(s);
    }
}

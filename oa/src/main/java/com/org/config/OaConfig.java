package com.org.config;

import com.org.web.Handle;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class OaConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        Handle handle = new Handle();

        String a1[] = {"/oa/user"};
        String a2[] = {"/oa/login"};
        registry.addInterceptor(handle).addPathPatterns(a1).excludePathPatterns(a2);
    }
}

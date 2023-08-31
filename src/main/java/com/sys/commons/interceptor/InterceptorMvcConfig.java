package com.sys.commons.interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 拦截器配置
 */
@Configuration
public class InterceptorMvcConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //拦截user下所有请求，需用户登录
        String[] addPathPatterns={
                "/**"
        };
        //排除的路径，不需要登录
        String[] excludePathPatterns={
                "/sys/login","/sys/register","/static/**","/error"
        };
        //注册
        registry.addInterceptor(new PermissionInterceptor()).addPathPatterns(addPathPatterns).excludePathPatterns(excludePathPatterns);
    }
}

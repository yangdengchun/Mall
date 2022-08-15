package com.project.mall.config;

import com.project.mall.interceptor.CheckTokenInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author ydc
 * @create 2022-08-07 9:37
 */
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    @Autowired
    private  CheckTokenInterceptor checkTokenInterceptor;


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(checkTokenInterceptor)//拦截器开始加载到mvc中
                .addPathPatterns("/shopcart/**")//拦截的
                .addPathPatterns("/orders/**");


    }
}

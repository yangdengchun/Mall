//package com.project.mall.config;
//
//import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import springfox.documentation.builders.ApiInfoBuilder;
//import springfox.documentation.builders.PathSelectors;
//import springfox.documentation.builders.RequestHandlerSelectors;
//import springfox.documentation.service.ApiInfo;
//import springfox.documentation.service.Contact;
//import springfox.documentation.spi.DocumentationType;
//import springfox.documentation.spring.web.plugins.Docket;
//import springfox.documentation.swagger2.annotations.EnableSwagger2;
//
///**
// * @author ydc
// * @create 2022-07-30 2:47
// * 访问地址：http://localhost:8080/swagger-ui.html
// */
//@Configuration
//@EnableSwagger2
//@EnableKnife4j
//public class SwaggerConfig {
//    //1.配置文档信息
//    //2.配置生成文档信息
//    @Bean
//    public Docket getDocket(){
//        ApiInfoBuilder apiInfoBuilder = new ApiInfoBuilder();
//        apiInfoBuilder.title("后端接口说明文档")
//                      .description("描述信息")
//                      .version("v 2.0.1")
//                      .contact(new Contact("作者","url","@QQ.com"));
//        ApiInfo apiInfo = apiInfoBuilder.build();
//        Docket docket = new Docket(DocumentationType.SWAGGER_2)//指定文档风格
//                        .apiInfo(apiInfo)//指定生成的文档封面信息
//                        .select()
//                        .apis(RequestHandlerSelectors.basePackage("com.project.mall.controller"))
//                        //.paths(PathSelectors.regex("/user/"))//专门为这个路径创建
//                        .paths(PathSelectors.any())//任何一个
//                        .build();
//        return docket;
//    }
//}

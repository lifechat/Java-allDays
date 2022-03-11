//package com.immoc.config;
//
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
//@Configuration
//@EnableSwagger2
//public class Swagger2 {
////    访问地址 http://localhost:8090/swagger-ui.html
////    配置swagger核心配置
//    @Bean
//    public Docket createRestApi(){
//
//        return new Docket(DocumentationType.SWAGGER_2) //指定api类型
//                   .apiInfo(apiInfo()) //用于定义api文档汇总信息
//                   .select()
//                   .apis(RequestHandlerSelectors.basePackage("com.imooc.controller")) //扫描controller包
//                   .paths(PathSelectors.any()) //所有controller
//                   .build();
//    }
//
//    private ApiInfo apiInfo(){
//        return new ApiInfoBuilder()
//                .title("天天吃货 电商平台接口api") //文档网页标题
//                .contact(new Contact("imooc",
//                        "https://www.imooc.com",
//                        "lifechat@126.com"
//                        )) //联系人信息
//                .description("天天吃货平台的api接口文档") //描述信息
//                .version("1.0.1") //对应的api文档版本
//                .termsOfServiceUrl("https://www.imooc.com") //网站地址
//                .build();
//    }
//}

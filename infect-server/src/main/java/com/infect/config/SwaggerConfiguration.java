package com.infect.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;

@Configuration
@Slf4j
@EnableSwagger2WebMvc
public class SwaggerConfiguration {

//    @Bean
//    public Docket api() {
//        ApiInfo apiInfo = new ApiInfoBuilder()
//                .title("苍穹外卖项目接口文档")
//                .version("2.0")
//                .description("苍穹外卖项目接口文档")
//                .build();
//        Docket docket = new Docket(DocumentationType.SWAGGER_2)
//                .groupName("管理端接口")
//                .apiInfo(apiInfo)
//                .select()
//                .apis(RequestHandlerSelectors.basePackage("com.infect.controller"))
//                .paths(PathSelectors.any())
//                .build();
//        return docket;
//    }
//
//    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("/doc.html").addResourceLocations("classpath:/META-INF/resources/");
//        registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
//    }

}

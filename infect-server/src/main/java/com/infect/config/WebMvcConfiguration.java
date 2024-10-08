package com.infect.config;

import com.infect.interceptor.JwtTokenAdminInterceptor;
import com.infect.interceptor.JwtTokenCDCStaffInterceptor;
import com.infect.interceptor.JwtTokenMedicalStaffInterceptor;
import com.infect.interceptor.JwtTokenRailwayEmployeeInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class WebMvcConfiguration extends WebMvcConfigurationSupport {

    @Autowired
    private JwtTokenRailwayEmployeeInterceptor jwtTokenRailwayEmployeeInterceptor;

    @Autowired
    private JwtTokenAdminInterceptor jwtTokenAdminInterceptor;

    @Autowired
    private JwtTokenCDCStaffInterceptor jwtTokenCDCStaffInterceptor;

    @Autowired
    private JwtTokenMedicalStaffInterceptor jwtTokenMedicalStaffInterceptor;

    protected void addInterceptors(InterceptorRegistry registry) {
//        log.info("开始注册自定义拦截器...");
        registry.addInterceptor(jwtTokenRailwayEmployeeInterceptor)
                .addPathPatterns("/railwayemployee/**")
                .excludePathPatterns("/railwayemployee/labtest/file","/railwayemployee/diagnosis/file");

//        registry.addInterceptor(jwtTokenAdminInterceptor)
//                .addPathPatterns("/admin/**");
//
//        registry.addInterceptor(jwtTokenCDCStaffInterceptor)
//                .addPathPatterns("/cdcStaff/**")
//                .excludePathPatterns("/cdcStaff/promotionalMaterialsManager/getLearningMaterialFile/**");
//
//        registry.addInterceptor(jwtTokenMedicalStaffInterceptor)
//                .addPathPatterns("/medicalStaff/**");
    }

    @Bean
    public Docket api0() {
        ApiInfo apiInfo = new ApiInfoBuilder()
                .title("项目接口文档")
                .version("2.0")
                .description("项目接口文档")
                .build();
        Docket docket = new Docket(DocumentationType.SWAGGER_2)
                .groupName("通用接口")
                .apiInfo(apiInfo)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.infect.controller.common"))
                .paths(PathSelectors.any())
                .build();
        return docket;
    }

    @Bean
    public Docket api1() {
        ApiInfo apiInfo = new ApiInfoBuilder()
                .title("项目接口文档")
                .version("2.0")
                .description("项目接口文档")
                .build();
        Docket docket = new Docket(DocumentationType.SWAGGER_2)
                .groupName("铁路工人接口")
                .apiInfo(apiInfo)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.infect.controller.railwayEmployee"))
                .paths(PathSelectors.any())
                .build();
        return docket;
    }

    @Bean
    public Docket api2() {
        ApiInfo apiInfo = new ApiInfoBuilder()
                .title("项目接口文档")
                .version("2.0")
                .description("项目接口文档")
                .build();
        Docket docket = new Docket(DocumentationType.SWAGGER_2)
                .groupName("系统管理员接口")
                .apiInfo(apiInfo)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.infect.controller.admin"))
                .paths(PathSelectors.any())
                .build();
        return docket;
    }

    @Bean
    public Docket api3() {
        ApiInfo apiInfo = new ApiInfoBuilder()
                .title("项目接口文档")
                .version("2.0")
                .description("项目接口文档")
                .build();
        Docket docket = new Docket(DocumentationType.SWAGGER_2)
                .groupName("疾控中心管理人员接口")
                .apiInfo(apiInfo)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.infect.controller.cdcStaff"))
                .paths(PathSelectors.any())
                .build();
        return docket;
    }

    @Bean
    public Docket api4() {
        ApiInfo apiInfo = new ApiInfoBuilder()
                .title("项目接口文档")
                .version("2.0")
                .description("项目接口文档")
                .build();
        Docket docket = new Docket(DocumentationType.SWAGGER_2)
                .groupName("医护人员接口")
                .apiInfo(apiInfo)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.infect.controller.medicalStaff"))
                .paths(PathSelectors.any())
                .build();
        return docket;
    }
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/doc.html").addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
    }

}

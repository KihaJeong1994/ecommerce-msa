// package com.ecommerce.customer.config;

// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
// import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

// import springfox.documentation.builders.ApiInfoBuilder;
// import springfox.documentation.builders.PathSelectors;
// import springfox.documentation.builders.RequestHandlerSelectors;
// import springfox.documentation.service.ApiInfo;
// import springfox.documentation.spi.DocumentationType;
// import springfox.documentation.spring.web.plugins.Docket;

// @Configuration
// // @EnableSwagger2
// public class SwaggerConfig extends WebMvcConfigurationSupport{

//     @Override
//     protected void addResourceHandlers(ResourceHandlerRegistry registry) {
//         registry.addResourceHandler("/swagger-ui/**").addResourceLocations("classpath:/META-INF/resources/webjars/springfox-swagger-ui/"); 
//         registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/springfox-swagger-ui/");
//     }

//     private ApiInfo apiInfo() {

//         return new ApiInfoBuilder()
//                 .title("Customer")
//                 .description("Customer API EXAMPLE")
//                 .build();
//     }

//     @Bean
//     public Docket commonApi() {
//         return new Docket(DocumentationType.SWAGGER_2)
//                 .groupName("example")
//                 .apiInfo(this.apiInfo())
//                 .select()
//                 .apis(RequestHandlerSelectors
//                         .basePackage("com.ecommerce.customer.controller"))
//                 .paths(PathSelectors.ant("/api/**"))
//                 .build();
//     }

// }
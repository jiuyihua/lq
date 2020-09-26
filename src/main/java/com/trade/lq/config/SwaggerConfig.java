package com.trade.lq.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * describle :
 * author : huh
 * 2020/9/13 0013
 * 上午 11:46
 */
@Configuration
@EnableOpenApi
public class SwaggerConfig extends WebMvcConfigurationSupport {


    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.OAS_30).apiInfo(apiInfo()).select()
                .apis(RequestHandlerSelectors.basePackage("com.trade.lq.controller")).paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("我是标题").description("我是描述").contact(new Contact("联系人", "www.baidu.com", "jiuyi_huhua@163.com"))
                .version("1.0").build();
    }
/*

    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
    }
*/

    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {

        // 解决静态资源无法访问

        registry.addResourceHandler("/**").addResourceLocations("classpath:/static/");

        // 解决swagger无法访问

        registry.addResourceHandler("/swagger-ui/index.html").addResourceLocations("classpath:/META-INF/resources/");

        // 解决swagger的js文件无法访问

        registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");

    /*@Bean
    Docket docket(){
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.trade.lq.controller"))
                .paths(PathSelectors.any())
                .build().apiInfo(new ApiInfoBuilder()
                .description("")
                .contact(new Contact("huh","localhost:8089","jiuyi_huhua@163.com"))
                .version("verion1.0.0")
                .title("API测试文档")
                .license("Apachee2.0")
                .licenseUrl("http://www.appach.org/licenses/LICENSE-2.0")
                .build());
    }*/
    }

}

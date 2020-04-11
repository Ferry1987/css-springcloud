package com.css.provider.config;
import org.springframework.beans.factory.annotation.Value;
import springfox.documentation.service.Contact;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Created by bianxh on 2019/1/21.
 */
@Configuration
@EnableSwagger2
public class SwaggerConfigApp {
    @Value("${swagger.scan.package}")
    private String swaggerScanPackage;
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                //为当前包路径
                .apis(RequestHandlerSelectors.basePackage(swaggerScanPackage))
                .paths(PathSelectors.any())
                .build();
//        return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class)).build();
    }
    //构建 api文档的详细信息函数,注意这里的注解引用的是哪个
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                //页面标题
                .title("Swagger2 服务提供者 API")
                //创建人
                .contact(new Contact("沈阳大数据中心", "http://www.baiyupiaopiao.com/", "liw@css.com.cn"))
                //版本号
                .version("1.1.0")
                //描述
                .description("服务提供者服务清册。")
                .build();
    }
}
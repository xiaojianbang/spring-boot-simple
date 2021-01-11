package cn.xiaojianbang.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
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
 * Created by lf on 2020/12/31
 */
@ConditionalOnProperty(prefix = "swagger2",value = "enable",havingValue = "true")
@EnableSwagger2
@Configuration(proxyBeanMethods = false)
public class Swagger2Configuration {
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("cn.xiaojianbang"))//暴露api所属的包
                .paths(PathSelectors.any()) // 过滤api路径
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("spring-boot-simple文档")
                .description("spring-boot-undertow系统API")
//                .termsOfServiceUrl("/")
                .version("1.0")
                .build();
    }
}
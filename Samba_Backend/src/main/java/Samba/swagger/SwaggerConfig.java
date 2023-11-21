package Samba.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.service.ApiInfo;
@Configuration
public class SwaggerConfig implements WebMvcConfigurer {

    @Bean
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.companyname.app"))
                .paths(PathSelectors.regex("/.*"))
                .build()
                .apiInfo(apiInfoMetaData());
    }

    private ApiInfo apiInfoMetaData(){
        return new ApiInfoBuilder().title("NAME")
                .description("API")
                .contact(new Contact("Samba produce", "https://www.xvideos.com/", "video56319785/follo_a_mi_hermanastra_por_sorpresa_-_subtitulado_-_https_aii.sh_tn1yw"))
                .license("Apache 2.0")
                .licenseUrl("https://www.facebook.com/maia.redx")
                .version("1.0.0")
                .build();
    }
}

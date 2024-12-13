package sep.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfiguration {
    @Bean
    public OpenAPI  getApiInfo(){
        return new OpenAPI().info(
                new Info()
                        .title("Employee_Service")
                        .description("employee curd operations")
                        .contact(new Contact().name("Manideep Thatte").email("manideep1436@gmail.com").url("www.joctopus.com"))
                        .license(new License().name("new license").url("www.joctopus.com"))
                        .version("1.0.0")

        );
    }
}

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.spi.DocumentationType;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;


@Configuration
@EnableSwagger2WebMvc


public class SwaggerConfig {
	
	//configuration
	//enable swagger
	@Bean
	public Docket api()
	{
		return new Docket(DocumentationType.SWAGGER_2);
	}
	
	

}

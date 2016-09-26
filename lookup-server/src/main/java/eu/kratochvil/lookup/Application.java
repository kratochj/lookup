package eu.kratochvil.lookup;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@ComponentScan(basePackages = "eu.kratochvil.lookup")
@EnableAutoConfiguration
public class Application {

	public static void main(String[] args) throws Exception {
		SpringApplication app = new SpringApplicationBuilder(Application.class).build();
		app.run(args);

	}

}

package btiernay;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;
import org.hibernate.validator.constraints.URL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class App {

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}

	@Component
	@ConfigurationProperties
	public static class AppProperties {

		@Min(value = 1, message = "${badVariable} will throw exception")
		Integer p0 = -1;
		
		@URL(message = "${badVariable} is not a URL")
		String p1 = "foo";
		
		@Email(message = "${validatedValue} is not an email")
		String p2 = "bar";
		
		@NotEmpty(message = "${validatedValue} is empty")
		String p3 = "";
		
		@NotNull(message = "${validatedValue} is null")
		Integer p4;
		
		@Range(min = 1, max = 100, message = "${validatedValue} is not between ${min} and ${max}")
		Integer p5 = 1000;

	}
	
	@Autowired
	AppProperties properties;
	
}

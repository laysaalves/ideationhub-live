package dev.layseiras.IdeationHub;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class IdeationHubApplication {

	public static void main(String[] args) {

		Dotenv dotenv = Dotenv.load();
		System.setProperty("API_KEY", dotenv.get("API_KEY"));
		System.setProperty("API_URL", dotenv.get("API_URL"));

		SpringApplication.run(IdeationHubApplication.class, args);
	}

}

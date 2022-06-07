package pe.edu.galaxy.training.java.ms.gestion.instructores.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.databind.ObjectMapper;

@Configuration
public class GlobalConfiguration {

	public GlobalConfiguration() {
		// TODO Auto-generated constructor stub
	}
	@Bean//se crea un bean para poder inyectarlo el objectMapper
	public ObjectMapper objectMapper() {
		return new ObjectMapper();
	}

}

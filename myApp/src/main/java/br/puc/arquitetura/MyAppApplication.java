package br.puc.arquitetura;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import br.puc.arquitetura.dao.BookDAO;

@SpringBootApplication
public class MyAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyAppApplication.class, args);
	}
	
	@Bean
	public BookDAO getDAO(){
		return new BookDAO();
	}
	
}

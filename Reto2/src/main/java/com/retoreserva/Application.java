package main.java.com.retoreserva;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class Application extends SpringBootServletInitializer {

    // Es la clase principal que inicia la aplicación Spring Boot
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}

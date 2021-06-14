package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.session.jdbc.config.annotation.web.http.EnableJdbcHttpSession;

@SpringBootApplication
public class Ax4Application  {

    public static void main(String[] args) {
        SpringApplication.run(Ax4Application.class, args);
    }

}

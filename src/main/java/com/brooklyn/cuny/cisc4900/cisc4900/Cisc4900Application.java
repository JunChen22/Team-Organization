package com.brooklyn.cuny.cisc4900.cisc4900;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Arrays;

@SpringBootApplication
public class Cisc4900Application {

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder;
    }

    public static void main(String[] args) {

        //ApplicationContext ac = new ClassPathXmlApplicationContext("cisc4900.iml");
        SpringApplication.run(Cisc4900Application.class, args);
    }

}

package com.nightsky.cryptonate.spring.boot.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 *
 * @author Chris
 */
@SpringBootApplication
public class WebApp {

    /**
     * Point of entry for the application.
     *
     * @param args Command line arguments.
     */
    public static void main(String[] args) {
        SpringApplication.run(WebApp.class, args);
    }

}

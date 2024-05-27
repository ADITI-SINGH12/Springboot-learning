package com.constructor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.constructor","com.RestController"})
public class Mainfactory {
    public static void main(String[] args) {
        SpringApplication.run(Mainfactory.class, args);

    }
}
//** As I have send controller class to different package the request showing error because
//Beacuse Springboot application by default scan all classes that are under com.constructor.
//Now to remove this error. We will pass all packages under springboot application
//So that component scan can pass .

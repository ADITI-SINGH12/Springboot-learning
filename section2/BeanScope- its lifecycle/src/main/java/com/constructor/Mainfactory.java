package com.constructor;
//Here we will use Qualifiers and Primary annotation , both comes in usasge for multiple implementation
//Qualifier are given more priority than Primary annotation
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.constructor","com.RestController"})
public class Mainfactory {
    public static void main(String[] args) {
        SpringApplication.run(Mainfactory.class, args);

    }
}


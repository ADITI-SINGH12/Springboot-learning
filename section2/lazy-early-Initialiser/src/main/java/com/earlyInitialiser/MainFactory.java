package com.earlyInitialiser;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//Early initialisation calls all bean in start mode, even if there is no requirement of that bean
@SpringBootApplication
public class MainFactory {
    public static void main(String[] args) {
        SpringApplication.run(MainFactory.class,args);
    }
}

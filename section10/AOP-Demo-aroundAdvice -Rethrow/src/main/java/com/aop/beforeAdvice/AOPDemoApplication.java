package com.aop.beforeAdvice;

import com.aop.beforeAdvice.dao.AccountDao;
import com.aop.beforeAdvice.dao.MembershipDao;
import com.aop.beforeAdvice.service.FortuneService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AOPDemoApplication {

        public static void main(String[] args) {
            SpringApplication.run(AOPDemoApplication.class, args);
        }

        @Bean
        public CommandLineRunner commandLineRunner(AccountDao theAccountDao, MembershipDao themembershipDao,
                                                   FortuneService thefortuneService) {
            return runner -> {
              // addAccountdb(theAccountDao,themembershipDao);
                demoAroundAdvice(thefortuneService);
            };
        }

    private void demoAroundAdvice(FortuneService thefortuneService) {
            String res = thefortuneService.getFortuneService(true);
        System.out.println("\n=====>>> Executing from main method: "+res);
    }


}



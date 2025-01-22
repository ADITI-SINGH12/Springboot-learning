package com.aop.beforeAdvice;

import com.aop.beforeAdvice.dao.AccountDao;
import com.aop.beforeAdvice.dao.MembershipDao;
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
        public CommandLineRunner commandLineRunner(AccountDao theAccountDao, MembershipDao themembershipDao) {
            return runner -> {
               addAccountdb(theAccountDao,themembershipDao);
            };
        }

    private void addAccountdb(AccountDao theAccountDao, MembershipDao themembershipDao) {

            theAccountDao.addAccount();

            themembershipDao.addAccount();
    }
}



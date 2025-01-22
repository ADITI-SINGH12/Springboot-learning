package com.aop.beforeAdvice;

import com.aop.beforeAdvice.dao.AccountDao;
import com.aop.beforeAdvice.dao.MembershipDao;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class AOPDemoApplication {

        public static void main(String[] args) {
            SpringApplication.run(AOPDemoApplication.class, args);
        }

        @Bean
        public CommandLineRunner commandLineRunner(AccountDao theAccountDao, MembershipDao themembershipDao) {
            return runner -> {
              // addAccountdb(theAccountDao,themembershipDao);
                demoTheAfterFinallyAdvice(theAccountDao);
            };
        }

    private void demoTheAfterFinallyAdvice(AccountDao theAccountDao) {
        List<Account> theAccounts = null;
        try{
            boolean theTripWire = true;
            theAccounts =  theAccountDao.findAccount(theTripWire);
        }catch (Exception exception){
            System.out.println("\n\nMain Program: ... caught exception: " + exception);
        }
        System.out.println("\n\nMain Program: demoTheAfterThrowingAdvice");
        System.out.println("----");

        System.out.println(theAccounts);

        System.out.println("\n");
    }

    private void demoTheAfterThrowingAdvice(AccountDao theAccountDao) {
        List<Account> theAccounts = null;
            try{
               boolean theTripWire = true;
              theAccounts =  theAccountDao.findAccount(theTripWire);
            }catch (Exception exception){
                System.out.println("\n\nMain Program: ... caught exception: " + exception);
            }
        System.out.println("\n\nMain Program: demoTheAfterThrowingAdvice");
        System.out.println("----");

        System.out.println(theAccounts);

        System.out.println("\n");
    }

    private void addAccountdb(AccountDao theAccountDao, MembershipDao themembershipDao) {

            theAccountDao.addAccount();
theAccountDao.listAccounts();
       themembershipDao.addAccount();
    }
}



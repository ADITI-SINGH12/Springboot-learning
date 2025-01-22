package com.aop.beforeAdvice.service;

import com.aop.beforeAdvice.service.FortuneService;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class FortuneServiceImpl implements FortuneService {
    @Override
    public String getFortuneService(boolean tripwire) {
        if(tripwire){
          throw  new RuntimeException("There is heavy traffic");
        }
        // simulate a delay

//        try {
//            TimeUnit.SECONDS.sleep(5);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }

        // return a fortune
        return "Expect heavy traffic this morning";
    }
}

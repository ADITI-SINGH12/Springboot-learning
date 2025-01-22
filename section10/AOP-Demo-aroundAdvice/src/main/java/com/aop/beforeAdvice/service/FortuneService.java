package com.aop.beforeAdvice.service;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Service;


public interface FortuneService {
    String getFortuneService(boolean tripwire);
}

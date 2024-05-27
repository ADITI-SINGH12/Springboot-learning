package com.constructor.common;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class TennisCoach implements Coach{
    @Override
    public String getworkout() {
        return "Tennis workout is given ,you need to follow it";
    }
}

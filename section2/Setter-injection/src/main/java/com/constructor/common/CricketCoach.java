package com.constructor.common;

import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach{
    @Override
    public String getworkout() {
        return "Cricket workout is given ,you need to follow it";
    }
}

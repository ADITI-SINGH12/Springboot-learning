package com.constructor.common;

import org.springframework.stereotype.Component;

@Component
public class AtheleteCoach implements Coach{
    @Override
    public String getworkout() {
        return "Athelete workout is given ,you need to follow it";
    }
}

package com.constructor.common;

import org.springframework.stereotype.Component;

@Component
public class BadmintonCoach implements Coach{
    @Override
    public String getworkout() {
        return "Badminton workout is given ,you need to follow it";
    }
}

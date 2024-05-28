package com.earlyInitialiser;

import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach {
    public CricketCoach() {
        System.out.println("Cricket Coach is initialised");
    }

    @Override
    public String getWorkout() {
        return "Cricket workout is ready!!";
    }
}

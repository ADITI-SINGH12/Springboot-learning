package com.earlyInitialiser;

import org.springframework.stereotype.Component;

@Component
public class BadmintonCoach implements Coach {
    public BadmintonCoach() {
        System.out.println("Badminton Coach is initialised");
    }

    @Override
    public String getWorkout() {
        return "Tennis workout is ready!!";
    }
}

package com.earlyInitialiser;

import org.springframework.stereotype.Component;

@Component
public class SwimmingCoach implements Coach{
    public SwimmingCoach() {
        System.out.println("Swimming Coach is initialised");
    }

    @Override
    public String getWorkout() {
        return "Swimming workout is ready!!";
    }
}

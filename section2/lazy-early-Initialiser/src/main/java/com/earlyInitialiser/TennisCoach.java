package com.earlyInitialiser;

import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach{
    public TennisCoach() {
        System.out.println("Tennis Coach is initialised");
    }

    @Override
    public String getWorkout() {
        return "Tennis workout is ready!!";
    }
}

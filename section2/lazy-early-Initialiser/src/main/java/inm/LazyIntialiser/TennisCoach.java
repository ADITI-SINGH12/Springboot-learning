package inm.LazyIntialiser;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class TennisCoach implements Coach {
    public TennisCoach() {
        System.out.println("Tennis Coach is initialised");
    }

    @Override
    public String getWorkout() {
        return "Tennis workout is ready!!";
    }
}

package inm.LazyIntialiser;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class SwimmingCoach implements Coach {
    public SwimmingCoach() {
        System.out.println("Swimming Coach is initialised");
    }

    @Override
    public String getWorkout() {
        return "Swimming workout is ready!!";
    }
}

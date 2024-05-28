package inm.LazyIntialiser;


import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class CricketCoach implements Coach {
    public CricketCoach() {
        System.out.println("Cricket Coach is initialised");
    }

    @Override
    public String getWorkout() {
        return "Cricket workout is ready!!";
    }
}

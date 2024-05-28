package inm.LazyIntialiser;


import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class BadmintonCoach implements Coach {
    public BadmintonCoach() {
        System.out.println("Badminton Coach is initialised");
    }

    @Override
    public String getWorkout() {
        return "Badminton workout is ready!!";
    }
}

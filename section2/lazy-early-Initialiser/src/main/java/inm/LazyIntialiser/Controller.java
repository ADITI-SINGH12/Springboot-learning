package inm.LazyIntialiser;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    Coach coach;
    @Autowired
    public Controller(@Qualifier("badmintonCoach") Coach coach) {
        System.out.println("Controller is initialised");
        this.coach = coach;
    }

    @GetMapping("/work")
    public String getwork(){
        return coach.getWorkout();
    }
}

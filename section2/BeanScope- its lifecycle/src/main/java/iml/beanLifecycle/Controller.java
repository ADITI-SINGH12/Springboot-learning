package iml.beanLifecycle;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    Coach coach1;

    public Controller(@Qualifier("cricketCoach") Coach coach1) {
        this.coach1 = coach1;
    }

    @GetMapping("/")
    public String coachavialbility(){
        return coach1.getworkout();
    }

}

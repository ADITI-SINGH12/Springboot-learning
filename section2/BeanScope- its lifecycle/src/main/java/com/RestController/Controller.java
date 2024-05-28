package com.RestController;

import com.constructor.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    Coach coach1;
    Coach coach2;
    Coach coach3;
    Coach coach4;
    @Autowired
    public Controller(@Qualifier("cricketCoach") Coach coach1,@Qualifier("cricketCoach") Coach coach2,
                      @Qualifier("badmintonCoach") Coach coach3,@Qualifier("badmintonCoach") Coach coach4) {
        this.coach1 = coach1;
        this.coach2 = coach2;
        this.coach3 = coach3;
        this.coach4 = coach4;
    }
    @GetMapping("/cricket")
    public String workoutfactory(){
      return coach1.getworkout();
    }
    @GetMapping("/prototype")
    public String checkPrototypeScope(){
        //By default all beans are in singleton scope
        return "Singleton scope= "+coach1.equals(coach2);
    }
    @GetMapping("/singleton")
    public String checkSingletonScope(){
        //By default all beans are in singleton scope
        return "Singleton scope= "+coach3.equals(coach4);
    }

}

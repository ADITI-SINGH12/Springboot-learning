package com.RestController;

import com.constructor.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    Coach coach1;
    //Here Coach found the primary bean as TennisCoach because Tennis coach class
    //contains Primary annotation.
    //Suppose I have used both primary and qualifier annotation, at that time Qualifier bean
    // will get more priority than Primary bean
    @Autowired
    public Controller(@Qualifier("cricketCoach") Coach coach) {
        this.coach1 = coach;
    }
    @GetMapping("/cricket")
    public String workoutfactory(){
      return coach1.getworkout();
    }

}

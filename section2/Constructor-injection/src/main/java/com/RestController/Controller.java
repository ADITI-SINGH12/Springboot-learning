package com.RestController;

import com.constructor.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    Coach coach1;
    Coach coach2;
    @Autowired
    public Controller(Coach coach) {
        this.coach1 = coach;
    }
    @GetMapping("/cricket")
    public String workoutfactory(){
      return coach1.getworkout();
    }
}

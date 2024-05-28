package iml.beanLifecycle;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//By default Prototype scope of bean supports lazy initialisation.
//prototype scope doest not fall in method of predestroy phase.
//Singleton type bean supports all forms of lifecycle.
//Bean initialisation -> Bean Post Construct -> Bean do the work -> Bean just before destroyed(Pre Destroy)
// -> beandestroyed
@SpringBootApplication()
public class MainFactory {
    public static void main(String[] args) {
        SpringApplication.run(MainFactory.class, args);

    }
}

package inm.LazyIntialiser;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//Early initialisation calls all bean in start mode, even if there is no requirement of that bean
//To remove the problem and extra memory usasage ,one can use Lazy annotation to make bean as lazy initialisation
@SpringBootApplication
public class MainFactory {
    public static void main(String[] args) {
        SpringApplication.run(MainFactory.class,args);
    }
}

package iml.beanLifecycle;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class BadmintonCoach implements Coach{
    public BadmintonCoach() {
        System.out.println("Badmintion bean is intialised");
    }

    @PostConstruct
    public void postConstructBadminton(){
        System.out.println("Post construction of bean for Badminton bean");
    }
    @PreDestroy
    public void preDestroyBadminton(){
        System.out.println("Pre Destruction of bean for Badminton bean");
    }

    @Override
    public String getworkout() {
        return "Badminton workout is ready";
    }
}

package iml.beanLifecycle;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class CricketCoach implements Coach{
    public CricketCoach() {
        System.out.println("Cricket bean is  initialised");
    }

    @PostConstruct
    public void postConstructCricket(){
        System.out.println("Post construction of bean for Cricket bean");
    }
    @PreDestroy
    public void preDestroyCricket(){
        System.out.println("Pre Destruction of bean for Cricket bean");
    }

    @Override
    public String getworkout() {
        return "Cricket workout is ready";
    }
}

package firstspringprojects.configuration;

import firstspringprojects.coach.Coach;
import firstspringprojects.coach.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SportConfig {
    @Bean ("aquatic")
    public Coach swimCoach(){
        return new SwimCoach();
    }

}

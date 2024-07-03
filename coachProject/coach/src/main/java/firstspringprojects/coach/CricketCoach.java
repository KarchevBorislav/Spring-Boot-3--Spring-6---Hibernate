package firstspringprojects.coach;


import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach {


    @Override
    public String getDailyWorkout() {
        return "Practice daily  for about 10 minutes";
    }
}

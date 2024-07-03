package firstspringprojects.coach;

import org.springframework.stereotype.Component;

@Component
public class BaseballCoach implements Coach {
    @Override
    public String getDailyWorkout() {
        return "Daily dribble workouts!";
    }
}

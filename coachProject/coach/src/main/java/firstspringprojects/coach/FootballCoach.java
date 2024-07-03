package firstspringprojects.coach;

import org.springframework.stereotype.Component;

@Component

public class FootballCoach implements  Coach {
    @Override
    public String getDailyWorkout() {
        return "Practising long shots and sprints daily!";
    }
}

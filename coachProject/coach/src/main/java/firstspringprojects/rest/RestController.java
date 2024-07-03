package firstspringprojects.rest;

import firstspringprojects.coach.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;

@org.springframework.web.bind.annotation.RestController
public class RestController {
    private Coach myCoach;

    //Constructor Injection

    @Autowired
    public RestController(@Qualifier("aquatic") Coach myCoach) {
        this.myCoach = myCoach;
    }

    /*
        /*Setter Injection
        @Autowired
        public void setMyCoach(Coach myCoach) {
            this.myCoach = myCoach;
        }
    */
    @GetMapping("/dailyworkout")
    public String getDailyWorkout() {
        return myCoach.getDailyWorkout();
    }

}

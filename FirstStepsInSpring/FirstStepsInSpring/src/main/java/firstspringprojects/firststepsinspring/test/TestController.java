package firstspringprojects.firststepsinspring.test;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/")
    public String sayHello() {
        return "Say Hello!";
    }

    @GetMapping("/workout")
    public String workingOut() {
        return "Run for about 5 km!";
    }

    @GetMapping("/spring")
    public String getDailySpringUpdate() {
        return "I actually start to understand Spring!";

    }

    @Value("${coach.name}")
    private String coachName;
    @Value("${team.name}")
    private String teamName;
    @GetMapping("/teaminfo")
    public String getTeamInfo(){
        return "Coach:" + coachName + " Team:" + teamName;
    }


}

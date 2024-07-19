package firstspringprojects.springboot.demosecurity.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
@GetMapping("/showMyLoginPage")
    public String showMyLoginPage(){

    return "custom-login";


    }
    @GetMapping("/access-denied")
    public String showAccessDeniedPage(){
        return "access-denied";

    }

}

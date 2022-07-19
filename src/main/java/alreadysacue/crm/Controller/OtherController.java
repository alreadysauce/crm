package alreadysacue.crm.Controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class OtherController {
    @GetMapping("/calendar")
    public String calendar(){
        return "/Calendar/calendar";
        }
}

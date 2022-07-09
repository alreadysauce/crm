package alreadysacue.crm.Controller;

import alreadysacue.crm.Repository.UserRepository;
import alreadysacue.crm.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Slf4j
public class IndexController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @GetMapping("/")
    public String index(){
        return "index";
    }

    @GetMapping("/admin")
    public @ResponseBody String admin(){
        return "admin";
    }
    @GetMapping("/loginForm")
    public String login(){
        return "/Login/loginForm";
    }

    @GetMapping("/joinForm")
    public String joinForm(){
        return "/Login/joinForm";
    }

    @PostMapping("/join")
    public String join(User user) {
        log.info(user.toString());
        user.setRole("ROLE_ADMIN");
        String rawPassword = user.getPassword();
        String encPassword = bCryptPasswordEncoder.encode(rawPassword);
        user.setPassword(encPassword);
        userRepository.save(user);
        return "redirect:/loginForm";
    }
    @Secured("ROLE_ADMIN") //특정매서드에 간단하게 권한부여
    @GetMapping("/info")
    public @ResponseBody String info(){
        return "개인  정보";
    }
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_ADMIN')")//특정매서드에 간단하게 권한부여(2개이상)
    @GetMapping("/data")
    public @ResponseBody String data(){
        return "data";
    }

    @GetMapping("/map")
    public String map(){
        return "/Map/map";
    }
}

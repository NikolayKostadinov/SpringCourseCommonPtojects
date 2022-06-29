package bg.softuni.mobilele.web;

import bg.softuni.mobilele.model.dto.UserLoginDto;
import bg.softuni.mobilele.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/users")
public class UserLoginController {

    private final UserService userService;

    public UserLoginController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String login(){
        return "auth-login";
    }

//    @GetMapping("/logout")
//    public String logout(){
//        this.userService.logout();
//        return "redirect:/";
//    }
//
//    @PostMapping("/login")
//    public String login(UserLoginDto dto, HttpSession session){
//        if (this.userService.login(dto)){
//            session.setAttribute("username", dto.getUsername());
//        }
//        return "redirect:/";
//    }
}

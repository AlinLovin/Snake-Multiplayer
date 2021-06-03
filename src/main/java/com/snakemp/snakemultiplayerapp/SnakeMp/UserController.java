package com.snakemp.snakemultiplayerapp.SnakeMp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    @Autowired
    private UserRepository repo;

    @GetMapping("/")
    public String viewHomePage() {
        return "index";
    }

    @GetMapping("/signup")
    public String ShowSignUpForm(Model model) {
        model.addAttribute("user", new User());
        return "signup_form";
    }

    @PostMapping("process_register")
    public String processRegistration(User user) {
        try {
            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
            String encodedPassword = encoder.encode(user.getPassword());
            user.setPassword(encodedPassword);
            repo.save(user);
        } catch (Exception e) {
            System.out.println("Duplicate email !!!");
            return "redirect:/signup";
        }
        return "register_success";
    }

    @GetMapping("type_game")
    public String selectTypeGame() {
        return "type_game";
    }

    @GetMapping("/single_player")
    public String singlePlayerGame() {
        return "single_player";
    }

    @GetMapping("/multiplayer")
    public String multiplayer() {
        return "multiplayer";
    }

    @RequestMapping("/process_play_mp")
    public String playMp(@RequestParam(value = "code", required = false) String code, Model model) {
        System.out.println(code);
        return "play_mp";
    }
}

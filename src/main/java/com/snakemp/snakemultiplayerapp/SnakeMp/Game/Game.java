package com.snakemp.snakemultiplayerapp.SnakeMp.Game;

import com.snakemp.snakemultiplayerapp.SnakeMp.User.User;
import com.snakemp.snakemultiplayerapp.SnakeMp.UserRepository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.util.HtmlUtils;

import java.util.UUID;

@Controller
public class Game {
    @Autowired
    private UserRepository repo;

    public String UUIDCode() {
        UUID uuid = UUID.randomUUID();
        String uuidAsString = uuid.toString();
        System.out.println("Your UUID is: " + uuidAsString);
        return uuidAsString;
    }

    @GetMapping("/game/type_game")
    public String selectTypeGame() {
        return "type_game";
    }

    @GetMapping("/game/single_player")
    public String singlePlayerGame() {
        return "single_player";
    }

    @GetMapping("/game/multiplayer")
    public String multiplayer(Model model) {
        String myUUID = UUID.randomUUID().toString();
        System.out.println(myUUID);
        model.addAttribute("UUIDCode", myUUID);
        return "multiplayer";
    }

    @RequestMapping("/game/multiplayer/play_mp")
    public String playMp(@RequestParam(value = "code", required = false) String code) {
        System.out.println(code);
        return "play_mp";
    }
}

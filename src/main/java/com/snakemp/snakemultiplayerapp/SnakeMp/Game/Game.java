package com.snakemp.snakemultiplayerapp.SnakeMp.Game;

import com.snakemp.snakemultiplayerapp.SnakeMp.UserRepository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Game {
    @Autowired
    private UserRepository repo;

    @GetMapping("/game/type_game")
    public String selectTypeGame() {
        return "type_game";
    }

    @GetMapping("/game/single_player")
    public String singlePlayerGame() {
        return "single_player";
    }

    @GetMapping("/game/multiplayer")
    public String multiplayer() {
        return "multiplayer";
    }

    @RequestMapping("/game/multiplayer/play_mp")
    public String playMp(@RequestParam(value = "code", required = false) String code) {
        System.out.println(code);
        return "play_mp";
    }

}

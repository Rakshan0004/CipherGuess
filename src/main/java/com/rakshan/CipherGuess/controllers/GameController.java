package com.rakshan.CipherGuess.controllers;
import com.rakshan.CipherGuess.Services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class GameController {

    @Autowired
    GameService gameService;

    @GetMapping("/game-home")
    public String showGameHomePage(@RequestParam(value = "guessedChar", required = false) String guessChar, Model model) {

        System.out.println("guessedword : " + guessChar);
        String randomWord = gameService.toString();
        model.addAttribute("wordToDisplay", randomWord);

        if(guessChar != null){
            gameService.addGuessChar(guessChar.charAt(0));
        }

        return  "game-home-page";

    }
}

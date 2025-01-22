package com.rakshan.CipherGuess.controllers;
import com.rakshan.CipherGuess.Services.GameService;
import com.rakshan.CipherGuess.utils.GameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class GameController {

    private GameService gameService;
    private GameUtils gameUtils;

    @Autowired
    public GameController(GameService gameService, GameUtils gameUtils) {
        this.gameService = gameService;
        this.gameUtils = gameUtils;
    }

//    @Autowired
//    private GameService gameService;
//
//    @Autowired
//    private GameUtils gameUtils;

    @GetMapping("/game-home")
    public String showGameHomePage(@RequestParam(value = "guessedChar", required = false) String guessChar, Model model) {

        System.out.println("guessedword : " + guessChar);

        String randomWord = gameService.toString(); // _ _ _ _ _

        if(guessChar != null && !guessChar.isEmpty()){
            boolean isGuessCorrect = gameService.addGuessChar(guessChar.charAt(0));
            randomWord = gameService.toString();   // s _ _ _ _
            if(!isGuessCorrect){
                gameUtils.reduceAttempts();
            }
        }

        model.addAttribute("wordToDisplay", randomWord);

        model.addAttribute("triesRemaining", gameUtils.getRemainingTries());

        if (gameService.isWordGuessed()) {
            model.addAttribute("successMessage", "🎉 Hurray! You've guessed the word correctly! 🎉");
            model.addAttribute("playAgainLink", "/restart-game");
        }

        return "game-home-page";
    }


    @GetMapping("/restart-game")
    public String restartGame() {
        // Reset game state using gameService and gameUtils
        gameService.resetGame();
        gameUtils.resetAttempts();

        // Redirect to the game home page
        return "redirect:/game-home";
    }

}

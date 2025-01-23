package com.rakshan.CipherGuess.controllers;

import com.rakshan.CipherGuess.Services.GameService;
import com.rakshan.CipherGuess.utils.GameUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class GameControllerTest {

    @Mock
    private GameService gameService;

    @Mock
    private GameUtils gameUtils;

    @Mock
    private Model model;

    @InjectMocks
    private GameController gameController;

    @BeforeEach
    void setUp() {
        // Initialize the mocks manually
        MockitoAnnotations.openMocks(this);
        gameController = new GameController(gameService, gameUtils);
    }

    @Test
    void testShowGameHomePage_NoGuess() {
        // Mock the behavior of GameService and GameUtils
        when(gameService.toString()).thenReturn("_ _ _ _");
        when(gameUtils.getRemainingTries()).thenReturn(5);

        String viewName = gameController.showGameHomePage(null, model);

        // Verify the behavior
        verify(model).addAttribute("wordToDisplay", "_ _ _ _");
        verify(model).addAttribute("triesRemaining", 5);
        assertEquals("game-home-page", viewName);
    }

    @Test
    void testShowGameHomePage_WithCorrectGuess() {
        // Mock the behavior of GameService and GameUtils
        when(gameService.toString()).thenReturn("s _ _ _");
        when(gameUtils.getRemainingTries()).thenReturn(4);
        when(gameService.addGuessChar('s')).thenReturn(true);
        when(gameService.isWordGuessed()).thenReturn(false);

        String viewName = gameController.showGameHomePage("s", model);

        // Verify the behavior
        verify(model).addAttribute("wordToDisplay", "s _ _ _");
        verify(model).addAttribute("triesRemaining", 4);
        assertEquals("game-home-page", viewName);
    }

    @Test
    void testShowGameHomePage_WithIncorrectGuess() {
        // Mock the behavior of GameService and GameUtils
        when(gameService.toString()).thenReturn("_ _ _ _");
        when(gameUtils.getRemainingTries()).thenReturn(4);
        when(gameService.addGuessChar('z')).thenReturn(false);
        when(gameService.isWordGuessed()).thenReturn(false);

        String viewName = gameController.showGameHomePage("z", model);

        // Verify the behavior
        verify(model).addAttribute("wordToDisplay", "_ _ _ _");
        verify(model).addAttribute("triesRemaining", 4);
        verify(gameUtils).reduceAttempts();
        assertEquals("game-home-page", viewName);
    }

    @Test
    void testShowGameHomePage_WordGuessedSuccessfully() {
        // Mock the behavior of GameService and GameUtils
        when(gameService.toString()).thenReturn("s t a r");
        when(gameUtils.getRemainingTries()).thenReturn(3);
        when(gameService.isWordGuessed()).thenReturn(true);

        String viewName = gameController.showGameHomePage(null, model);

        // Verify the behavior
        verify(model).addAttribute("wordToDisplay", "s t a r");
        verify(model).addAttribute("triesRemaining", 3);
        verify(model).addAttribute("successMessage", "🎉 Hurray! You've guessed the word correctly! 🎉");
        verify(model).addAttribute("playAgainLink", "/restart-game");
        assertEquals("game-home-page", viewName);
    }

    @Test
    void testRestartGame() {
        // Mock the behavior of GameService and GameUtils
        doNothing().when(gameService).resetGame();
        doNothing().when(gameUtils).resetAttempts();

        String viewName = gameController.restartGame();

        // Verify the behavior
        verify(gameService).resetGame();
        verify(gameUtils).resetAttempts();
        assertEquals("redirect:/game-home", viewName);
    }
}

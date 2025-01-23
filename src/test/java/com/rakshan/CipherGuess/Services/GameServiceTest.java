package com.rakshan.CipherGuess.Services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameServiceTest {

    private GameService gameService;

    @BeforeEach
    void setUp() {
        // Initialize the GameService before each test
        gameService = new GameService();
    }

    @Test
    void testGetRandomlyChoosenWord() {
        String word = gameService.getRandomlyChoosenWord();
        assertNotNull(word, "The chosen word should not be null");
        assertTrue(word.length() > 0, "The chosen word should not be empty");
    }

    @Test
    void testAddGuessCharCorrectGuess() {
        // Ensure the word is not empty and add a correct guess
        String word = gameService.getRandomlyChoosenWord();
        char correctGuess = word.charAt(0);  // Get the first character of the word

        boolean result = gameService.addGuessChar(correctGuess);
        assertTrue(result, "The guess should be correct");
        assertEquals(correctGuess, gameService.getAllCharactersOfTheWord()[0], "The first letter should be revealed");
    }

    @Test
    void testAddGuessCharIncorrectGuess() {
        String word = gameService.getRandomlyChoosenWord();
        char incorrectGuess = 'z';  // A character not in the word

        boolean result = gameService.addGuessChar(incorrectGuess);
        assertFalse(result, "The guess should be incorrect");
    }

    @Test
    void testIsWordGuessed() {
        String word = gameService.getRandomlyChoosenWord();
        assertFalse(gameService.isWordGuessed(), "The word should not be guessed initially");

        // Make guesses
        gameService.addGuessChar(word.charAt(0));
        assertFalse(gameService.isWordGuessed(), "The word should still not be fully guessed");

        // After revealing the whole word, it should be guessed
        for (int i = 1; i < word.length(); i++) {
            gameService.addGuessChar(word.charAt(i));
        }

        assertTrue(gameService.isWordGuessed(), "The word should be fully guessed");
    }

    @Test
    void testResetGame() {
        String initialWord = gameService.getRandomlyChoosenWord();
        gameService.resetGame();
        String newWord = gameService.getRandomlyChoosenWord();

        assertNotEquals(initialWord, newWord, "The word should change after resetting the game");
    }
}

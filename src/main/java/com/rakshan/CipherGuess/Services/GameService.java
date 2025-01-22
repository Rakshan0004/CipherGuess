package com.rakshan.CipherGuess.Services;

import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class GameService {

    private String randomlyChoosenWord = null;

    private String[] randomWords = {"hello", "dog", "god", "cat", "tiger", "rose", "javascript", "hope"};

    private char[] allCharactersOfTheWord;

    Random rand = new Random();

    public GameService() {  //costructor
        randomlyChoosenWord = randomWords[rand.nextInt(randomWords.length)];
        System.out.println(randomlyChoosenWord);
        allCharactersOfTheWord = new char[randomlyChoosenWord.length()];
    }

    @Override
    public String toString(){

        StringBuilder result = new StringBuilder();

        for(char c : allCharactersOfTheWord){
            if(c == '\u0000'){
                result.append("_");
            }else {
                result.append(c);
            }
            result.append(" ");
        }

        return result.toString();
    }

    public boolean addGuessChar(char guessedChar){

        boolean isGuessCorrect = false;

        for(int i=0; i<randomlyChoosenWord.length(); i++){

            if(guessedChar == randomlyChoosenWord.charAt(i)){
                allCharactersOfTheWord[i] = guessedChar;
                isGuessCorrect = true;
            }
        }
        return isGuessCorrect;
    }

    public void resetGame() {
        // Reset the game state
        randomlyChoosenWord = randomWords[rand.nextInt(randomWords.length)];
        System.out.println("New randomly chosen word: " + randomlyChoosenWord);
        allCharactersOfTheWord = new char[randomlyChoosenWord.length()];
    }


    public boolean isWordGuessed() {
        for (char c : allCharactersOfTheWord) {
            if (c == '\u0000') {
                return false; // Word is not completely guessed
            }
        }
        return true; // All letters are guessed
    }

}

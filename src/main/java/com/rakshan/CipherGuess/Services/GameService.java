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
            }
            result.append(" ");
        }

        return result.toString();
    }

    public void addGuessChar(char guessedChar){
        for(int i=0; i<randomlyChoosenWord.length(); i++){

            if(guessedChar == randomlyChoosenWord.charAt(i)){

                allCharactersOfTheWord[i] = guessedChar;
            }
        }
    }
}

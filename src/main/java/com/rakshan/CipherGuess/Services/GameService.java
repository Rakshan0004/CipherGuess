package com.rakshan.CipherGuess.Services;

import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class GameService {

    public String randomlyChoosenWord = null;


    private String[] randomWords = {
            "cat", "dog", "fish", "ball", "rose", "moon", "star", "game", "play", "blue",
            "love", "hope", "rain", "fire", "wind", "cake", "sand", "tree", "bike", "kite",
            "dove", "snow", "gold", "loud", "fast", "luck", "path", "bear", "tiger", "wolf",
            "bike", "ball", "bear", "mice", "chair", "dance", "grape", "fruit", "leaf", "zebra",
            "quiz", "lime", "tune", "clay", "jump", "work", "house", "dream", "cloud", "light",
            "dawn", "fish", "frog", "hero", "race", "climb", "brave", "mood", "wood", "stone",
            "hope", "journey", "child", "speak", "rain", "sand", "clear", "earth", "drain", "song",
            "teeth", "fear", "smile", "palm", "fair", "calm", "ride", "rock", "wool", "drum",
            "juice", "hill", "deep", "flash", "glove", "sharp", "thick", "bright", "jump", "swift",
            "sweet", "band", "swing", "grape", "leap", "walk", "dream", "free", "clay", "skip",
            "breeze", "clean", "round", "stick", "storm", "goal", "land", "hold", "roll", "push",
            "step", "mind", "dream", "tall", "tree", "swan", "idea", "clear", "side", "vibe",
            "wind", "talk", "open", "grow", "walk", "hate", "love", "thank", "voice", "shout",
            "shade", "check", "hair", "cut", "star", "moon", "laugh", "shine", "tide", "work",
            "fall", "nail", "rich", "dust", "light", "edge", "bake", "path", "strong", "wound",
            "cold", "heat", "king", "queen", "warm", "gold", "rush", "hope", "train", "beach",
            "shade", "laugh", "kind", "nice", "team", "brick", "sand", "mount", "sun", "west",
            "east", "west", "dove", "peace", "shore", "catch", "dance", "water", "sail", "zoom",
            "buzz", "road", "moon", "soft", "mask", "love", "life", "car", "shine", "clear",
            "page", "wrap", "smile", "health", "rise", "kill", "cool", "hand", "bean", "fall",
            "leaf", "grip", "eye", "game", "trust", "track", "swift", "love", "run", "turn",
            "smash", "camp", "feather", "stone", "shell", "bead", "band", "arm", "hair", "cake",
            "water", "brush", "jump", "skip", "move", "vibe", "game", "big", "calm", "safely",
            "task", "lamp", "smoke", "rain", "wind", "bake", "sleep", "mild", "flash", "shine",
            "fall", "trick", "glow", "dove", "fill", "shade", "stare", "space", "cloud", "read",
            "solve", "work", "time", "run", "rays", "wind", "storm", "heart", "wheel", "care",
            "stop", "best", "hope", "truth", "care", "tough", "rich", "game", "bliss", "star",
            "talk", "day", "heel", "car", "sun", "soul", "god", "plant", "clear", "run", "walk",
            "last", "wait", "set", "pull", "grip", "push", "quick", "pick", "game", "goal", "edge",
            "grape", "moon", "tune", "yell", "bricks", "clock", "snow", "yellow", "blue", "ball",
            "light", "fire", "peace", "bliss", "seat", "punch", "dash", "hats", "cane", "sky",
            "wind", "birds", "star", "tiger", "tree", "cloud", "fruit", "hint", "hold", "reach",
            "heart", "waltz", "free", "bat", "fast", "cool", "tank", "roar", "hold", "race", "blow",
            "rain", "coat", "cat", "rays", "long", "short", "star", "bone", "cane", "wish", "dash",
            "fire", "shade", "turn", "soul", "join", "step", "pulse", "stick", "kick", "turn", "blast",
            "drift", "steer", "ball", "move", "chase", "sick", "moon", "hill", "drag", "lap", "date"
    };

    private char[] allCharactersOfTheWord;

    Random rand = new Random();

    public GameService() {  //costructor
        randomlyChoosenWord = randomWords[rand.nextInt(randomWords.length)];
        System.out.println(randomlyChoosenWord);
        allCharactersOfTheWord = new char[randomlyChoosenWord.length()];
    }

    public String getRandomlyChoosenWord() {
        return randomlyChoosenWord;
    }

    public char[] getAllCharactersOfTheWord() {
        return allCharactersOfTheWord;
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

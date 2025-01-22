package com.rakshan.CipherGuess.utils;


import org.springframework.stereotype.Component;

@Component
public class GameUtils {

    private static final int MAX_TRIES = 5;
    private int remainingTries;

    public GameUtils() {
        resetAttempts();
    }

    public void reduceAttempts() {
        if (remainingTries > 0) {
            remainingTries--;
        }
    }

    public void resetAttempts() {
        remainingTries = MAX_TRIES;
    }

    public int getRemainingTries() {
        return remainingTries;
    }
}



package com.david.games;

import com.david.utils.Color;

import java.util.ArrayList;
import java.util.List;

public class MasterLogicShot {
    private final List<Color> guesses;
    private final List<Color> result;
    private final int numberOfBlacks;

    public MasterLogicShot(List<Color> guesses, List<Color> result, int numberOfBlacks) {
        this.guesses = guesses;
        this.result = result;
        this.numberOfBlacks = numberOfBlacks;
    }

    public List<Color> getGuesses() {
        return new ArrayList<>(guesses);
    }

    public List<Color> getResult() {
        return new ArrayList<>(result);
    }

    public boolean isWon() {
        return numberOfBlacks >= 4;
    }
}

package com.david.games;

import com.david.annotations.Author;
import com.david.annotations.GameSelector;
import com.david.annotations.MasterLogic;
import com.david.exceptions.CheatinException;
import com.david.interfaces.Game;
import com.david.interfaces.GameParameter;
import com.david.utils.Color;
import com.david.utils.GameResult;
import com.david.utils.GameType;
import jakarta.enterprise.context.Dependent;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Dependent
@Author(name = "David", date = "2022-02-24")
// cdj inject
@MasterLogic
// factory miatt ebbol hozza meg a dontest (futas kozbe)
@GameSelector(GameType.MASTER_LOGIC)
public class MasterLogicGame implements Game {

    private List<Color> hidden;
    private List<MasterLogicShot> shots;
    private GameResult gameResult;

    public MasterLogicGame() {
        newGame();
    }

    public List<Color> getHidden() {
        if (!isInGame()) {
            return hidden;
        }
        throw new CheatinException("You are a little filthy cheater");
    }

    public List<MasterLogicShot> getShots() {
        return new ArrayList<>(shots);
    }

    @Override
    public boolean isInGame() {
        return gameResult == GameResult.IN_GAME;
    }

    @Override
    public GameResult getGameResult() {
        return gameResult;
    }

    public void newGame() {
        hidden = new ArrayList<>();
        shots = new ArrayList<>();
        hideRow();
        gameResult = GameResult.IN_GAME;
        System.out.println("hidden: " + hidden);
    }

    private void hideRow() {
        List<Color> colors = Color.colorsAsList();
        Collections.shuffle(colors);
        for (int i = 0; i < 4; i++) {
            hidden.add(colors.get(i));
        }
    }

    @Override
    public GameResult shot(GameParameter p) {
        MasterLogicParam params = (MasterLogicParam) p;
        List<Color> guesses = params.getGuesses();
        List<Color> result = new ArrayList<>();
        int won = check(guesses, result);
        Collections.shuffle(result);
        MasterLogicShot shot = new MasterLogicShot(guesses, result, won);
        shots.add(shot);
        if (shot.isWon()) {
            gameResult = GameResult.WON;
        } else if (shots.size() >= 10) {
            gameResult = GameResult.LOOSE;
        }
        return gameResult;
    }

    private int check(List<Color> guesses, List<Color> result) {
        int countOfBlacks = 0;
        for (int i = 0; i < hidden.size(); i++) {
            for (int j = 0; j < guesses.size(); j++) {
                if (hidden.get(i) == guesses.get(j)) {
                    if (i == j) {
                        result.add(Color.BLACK);
                        countOfBlacks++;
                    } else {
                        result.add(Color.WHITE);
                    }
                    j = guesses.size();
                }
            }
        }
        return countOfBlacks;
    }

    @Override
    public String toString() {
        return "MasterLogicGame";
    }
}
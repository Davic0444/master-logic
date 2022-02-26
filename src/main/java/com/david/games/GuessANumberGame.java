package com.david.games;

import com.david.annotations.GameSelector;
import com.david.annotations.GuessANumber;
import com.david.interfaces.Game;
import com.david.interfaces.GameParameter;
import com.david.utils.GameResult;
import com.david.utils.GameType;
import jakarta.enterprise.context.Dependent;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Dependent
@GuessANumber
@GameSelector(GameType.GUESS_A_NUMBER)
public class GuessANumberGame implements Game {

    private static final String[] resultPattern
            = {"meg nincs tipp", "a tipped nagyobb", "a tipped kisebb"};

    private Random random;
    private int secretNumber;
    private List<Integer> tips;
    private GameResult gameResult;
    private int lastResultIndex;

    public GuessANumberGame() {
        random = new Random();
        secretNumber = random.nextInt(100);
        System.out.println("gondolt szám: " + secretNumber);
        tips = new ArrayList<>();
        gameResult = GameResult.IN_GAME;
        lastResultIndex = 0;
    }

    public String getLastResultText() {
        return resultPattern[lastResultIndex];
    }

    public List<Integer> getTips() {
        return new ArrayList<>(tips);
    }

    @Override
    public boolean isInGame() {
        return gameResult == GameResult.IN_GAME;
    }

    @Override
    public GameResult getGameResult() {
        return gameResult;
    }

    @Override
    public GameResult shot(GameParameter p) {
        GuessANumberParam parameter = (GuessANumberParam) p;
        int tip = parameter.getTip();
        if (tip == secretNumber) {
            gameResult = GameResult.WON;
        } else {
            lastResultIndex = 2;
            if (tip > secretNumber) {
                lastResultIndex = 1;
            }
        }
        tips.add(tip);
        if (tips.size() >= 10) {
            gameResult = GameResult.LOOSE;
        }
        return gameResult;
    }
}

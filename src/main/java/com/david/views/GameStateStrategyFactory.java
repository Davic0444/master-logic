package com.david.views;

import com.david.interfaces.Game;
import com.david.interfaces.GameStateStrategy;
import com.david.utils.GameType;

public class GameStateStrategyFactory {

    private GameStateStrategyFactory() {
    }

    public static GameStateStrategy createGameStateStrategy(GameType gameType, Game game) {
        GameStateStrategy strategy = null;
        switch (gameType) {
            case GUESS_A_NUMBER:
                strategy = new GuessANumberStateStrategy(game);
                break;
            case MASTER_LOGIC:
                strategy = new MasterLogicStateStrategy(game);
                break;
        }
        return strategy;
    }
}


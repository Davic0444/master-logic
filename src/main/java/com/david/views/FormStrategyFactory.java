package com.david.views;

import com.david.interfaces.GameFormStrategy;
import com.david.utils.GameType;

public class FormStrategyFactory {

    private FormStrategyFactory() {
    }

    public static GameFormStrategy createFormStrategy(GameType gameType) {
        GameFormStrategy strategy = null;
        switch (gameType) {
            case GUESS_A_NUMBER:
                strategy = new GuessANumberFormStrategy();
                break;
            case MASTER_LOGIC:
                strategy = new MasterLogicFormStrategy();
                break;

        }
        return strategy;
    }
}

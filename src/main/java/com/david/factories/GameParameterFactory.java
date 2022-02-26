package com.david.factories;

import com.david.games.GuessANumberParam;
import com.david.games.MasterLogicParam;
import com.david.interfaces.GameParameter;
import com.david.utils.GameType;

import java.util.Map;

public class GameParameterFactory {
    public static GameParameter createParameter(Map<String, String[]> parameters, GameType gameType) {
        switch (gameType){
            case MASTER_LOGIC:
                return new MasterLogicParam(parameters);
            case GUESS_A_NUMBER:
                return new GuessANumberParam(parameters);
            default:
                throw new AssertionError();
        }
    }
}

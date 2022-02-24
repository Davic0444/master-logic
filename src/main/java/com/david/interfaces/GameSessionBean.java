package com.david.interfaces;

import com.david.utils.GameResult;
import com.david.utils.GameType;

import java.util.Map;

public interface GameSessionBean {

    Game getGame();

    GameType getGameType();

    GameResult shot(Map<String, String[]> parameters);

    boolean isInGame();

    GameResult getGameResult();

}

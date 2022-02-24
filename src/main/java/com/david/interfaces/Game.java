package com.david.interfaces;

import com.david.utils.GameResult;

public interface Game {

    GameResult shot(GameParameter p);

    boolean isInGame();

    GameResult getGameResult();

}

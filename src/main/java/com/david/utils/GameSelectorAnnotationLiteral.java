package com.david.utils;

import com.david.annotations.GameSelector;
import jakarta.enterprise.util.AnnotationLiteral;

public class GameSelectorAnnotationLiteral extends AnnotationLiteral<GameSelector> implements GameSelector {

    private GameType gameType;

    private GameSelectorAnnotationLiteral(GameType gameType) {
        this.gameType = gameType;
    }

    @Override
    public GameType value() {
        return gameType;
    }

    public static GameSelectorAnnotationLiteral createGameSelectorAnnotationLiteral(GameType gameType){
        return new GameSelectorAnnotationLiteral(gameType);
    }
}

package com.david.utils;

public enum GameType {

    MASTER_LOGIC, GUESS_A_NUMBER;

    private static final GameType[] gameTypeValues;

    static {
        gameTypeValues = GameType.values();
    }

    public static GameType[] getGameTypeValues() {
        return gameTypeValues;
    }

    public static GameType getGameTypeByIndex(int index) {
        return gameTypeValues[index];
    }

}

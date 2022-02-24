package com.david.utils;

public enum GameType {

    MASTER_LOGIC, GUESS_A_NUMBER;

    private static final GameType[] gameTypeValue;

    static {
        gameTypeValue = GameType.values();
    }

    public static GameType[] getGameTypeValues(){
        return gameTypeValue;
    }

    public static GameType getGameTypeByIndex(int index){
        return gameTypeValue[index];
    }

}

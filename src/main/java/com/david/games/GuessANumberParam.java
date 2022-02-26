package com.david.games;

import com.david.interfaces.GameParameter;

import java.util.Map;

public class GuessANumberParam implements GameParameter {

    private int tip;

    public GuessANumberParam(Map<String, String[]> parameterMap) {
        tip = Integer.parseInt(parameterMap.get("tip")[0]);
    }

    public int getTip() {
        return tip;
    }
}

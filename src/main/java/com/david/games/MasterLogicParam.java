package com.david.games;

import com.david.interfaces.GameParameter;
import com.david.utils.Color;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MasterLogicParam implements GameParameter {

    private List<Color> colors;

    public MasterLogicParam(Map<String, String[]> parameterMap) {
        createColorsFromMap(parameterMap);
    }

    List<Color> getGuesses() {
        return new ArrayList<>(colors);
    }

    private void createColorsFromMap(Map<String, String[]> parameterMap) {
        colors = new ArrayList<>();
        Set<String> keys = parameterMap.keySet();
        for (String key : keys) {
            if (key.startsWith("color")) {
                int colorIndex = Integer.parseInt(parameterMap.get(key)[0]);
                colors.add(Color.findColorByIndex(colorIndex));
            }
        }
    }
}

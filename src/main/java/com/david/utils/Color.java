package com.david.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum Color {

    RED(0), GREEN(1), BLACK(2), YELLOW(3), WHITE(4), BLUE(5);

    private int index;

    private static final Color[] colors;

    static {
        colors = Color.values();
    }

    private Color(int index) {
        this.index = index;
    }

    public static Color findColorByIndex(int colorIndex){
        return colors[colorIndex];
    }

    public static List<Color> colorsAsList(){
        return new ArrayList<>(Arrays.asList(colors));
    }

    public static int length(){
        return colors.length;
    }

}

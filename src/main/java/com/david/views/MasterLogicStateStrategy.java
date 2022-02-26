package com.david.views;

import com.david.games.MasterLogicGame;
import com.david.games.MasterLogicShot;
import com.david.interfaces.Game;
import com.david.interfaces.GameStateStrategy;
import com.david.utils.Color;

import java.util.List;

public class MasterLogicStateStrategy implements GameStateStrategy {

    private static final String LS = System.lineSeparator();
    private static final String BR = "<br>";

    private StringBuilder builder;
    private MasterLogicGame game;
    private List<MasterLogicShot> shots;

    public MasterLogicStateStrategy(Game game) {
        this.game = (MasterLogicGame) game;
        shots = this.game.getShots();
    }

    @Override
    public String createGameStateHtml() {
        builder = new StringBuilder();
        builder.append("<div><p>");
        for (MasterLogicShot shot : shots) {
            createGuessRow(shot.getGuesses());
            createResultRectangle(shot.getResult());
        }
        builder.append("</p></div>");
        return builder.toString();
    }

    private void createGuessRow(List<Color> guesses) {
        for (Color guess : guesses) {
            builder.append("<svg height='100' width='100'><circle cx='50' cy='50' r='20' stroke='black' stroke-width='3' fill='");
            builder.append(guess);
            builder.append("' /></svg>");
            builder.append(LS);
        }
    }

    private void createResultRectangle(List<Color> result) {
        builder.append("<svg height='100' width='100' >");
        int x = 25, y = 25;
        for (int i = 0; i < result.size(); i++) {
            switch (i) {
                case 1:
                    x *= 3;
                    break;
                case 2:
                    y *= 3;
                    break;
                case 3:
                    y /= 3;
                    break;
            }
            builder.append("<circle cx='");
            builder.append(x);
            builder.append("' cy='");
            builder.append(y);
            builder.append("' r='10' stroke='black' stroke_width='3' fill='");
            builder.append(result.get(i));
            builder.append("' />");
            builder.append(LS);
        }
        builder.append("</svg>");
        builder.append(LS);
        builder.append(BR);
    }
}

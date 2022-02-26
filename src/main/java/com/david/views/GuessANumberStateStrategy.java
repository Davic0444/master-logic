package com.david.views;

import com.david.games.GuessANumberGame;
import com.david.interfaces.Game;
import com.david.interfaces.GameStateStrategy;

import java.util.List;

public class GuessANumberStateStrategy implements GameStateStrategy {

    private static final String LS = System.lineSeparator();
    private static final String BR = "<br>";
    private static final String[] DELIMITER_PATTERN = {", ", "."};

    private GuessANumberGame game;
    private StringBuilder builder;

    public GuessANumberStateStrategy(Game game) {
        this.game = (GuessANumberGame) game;
    }

    @Override
    public String createGameStateHtml() {
        builder = new StringBuilder();
        builder.append("<p>");
        builder.append("Az utolsó tipped: ");
        builder.append(game.getLastResultText());
        builder.append(LS);
        builder.append(BR);
        builder.append(LS);
        createTipList();
        builder.append("</p>");
        return builder.toString();

    }

    private void createTipList() {
        List<Integer> guesses = game.getTips();
        int divider = guesses.size();
        for (int i = 0; i < guesses.size(); i++) {
            builder.append(guesses.get(i));
            builder.append(DELIMITER_PATTERN[(i + 1) / divider]);
        }
        builder.append(LS);
        builder.append(BR);
        builder.append("Maradt még: ");
        builder.append(10 - guesses.size());
        builder.append(" tipped!");
    }
}

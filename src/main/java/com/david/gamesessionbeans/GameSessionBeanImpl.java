package com.david.gamesessionbeans;

import com.david.annotations.GameSelector;
import com.david.exceptions.NotInGameException;
import com.david.factories.GameParameterFactory;
import com.david.interfaces.Game;
import com.david.interfaces.GameParameter;
import com.david.interfaces.GameSessionBean;
import com.david.utils.GameResult;
import com.david.utils.GameSelectorAnnotationLiteral;
import com.david.utils.GameType;
import jakarta.enterprise.context.SessionScoped;
import jakarta.enterprise.inject.Any;
import jakarta.enterprise.inject.Instance;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.io.Serializable;
import java.util.Map;

@Named("gameSessionBean")
@SessionScoped
public class GameSessionBeanImpl implements Serializable, GameSessionBean {

    @Inject
    @Any
    private Instance<Game> games;

    private Game game;
    private GameType gameType;

    public void startGame(GameType gameType) {
        createGame(gameType);
    }

    @Override
    public Game getGame() {
        return game;
    }

    @Override
    public boolean isInGame() {
        return game.isInGame();
    }

    @Override
    public GameResult getGameResult() {
        return game.getGameResult();
    }

    @Override
    public GameType getGameType() {
        return gameType;
    }

    @Override
    public GameResult shot(Map<String, String[]> parameters) {
        checkInGame();
        GameParameter params = GameParameterFactory.createParameter(parameters, gameType);
        return game.shot(params);
    }

    private void checkInGame() {
        if (!game.isInGame()){
            throw new NotInGameException();
        }
    }

    private void createGame(GameType gameType) {
        this.gameType = gameType;
        GameSelector selector = GameSelectorAnnotationLiteral.createGameSelectorAnnotationLiteral(gameType);
        game = games.select(selector).get();
    }
}

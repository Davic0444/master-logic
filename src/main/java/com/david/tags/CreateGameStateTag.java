package com.david.tags;

import com.david.interfaces.GameSessionBean;
import com.david.interfaces.GameStateStrategy;
import com.david.utils.GameType;
import com.david.views.GameStateStrategyFactory;
import jakarta.servlet.jsp.JspException;
import jakarta.servlet.jsp.JspWriter;
import jakarta.servlet.jsp.tagext.TagSupport;

import java.io.IOException;

public class CreateGameStateTag extends TagSupport {

    private GameSessionBean gameBean;
    private GameStateStrategy strategy;

    public CreateGameStateTag() {
    }

    public void setGameBean(GameSessionBean gameBean) {
        this.gameBean = gameBean;
    }

    @Override
    public int doEndTag() throws JspException {
        try {
            strategy = GameStateStrategyFactory.createGameStateStrategy(gameBean.getGameType(), gameBean.getGame());
            JspWriter writer = pageContext.getOut();
            writer.println(strategy.createGameStateHtml());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return super.doEndTag();
    }
}

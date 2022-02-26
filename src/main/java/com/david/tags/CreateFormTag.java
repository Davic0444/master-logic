package com.david.tags;

import com.david.interfaces.GameFormStrategy;
import com.david.interfaces.GameSessionBean;
import com.david.views.FormStrategyFactory;
import jakarta.servlet.jsp.JspException;
import jakarta.servlet.jsp.JspWriter;
import jakarta.servlet.jsp.tagext.TagSupport;

import java.io.IOException;

public class CreateFormTag extends TagSupport {

    private String action;
    private GameSessionBean gameBean;
    private GameFormStrategy strategy;

    public void setAction(String action) {
        this.action = action;
    }


    public void setGameBean(GameSessionBean gameBean) {
        this.gameBean = gameBean;
    }

    @Override
    public int doEndTag() throws JspException {
        try {
            strategy = FormStrategyFactory.createFormStrategy(gameBean.getGameType());
            JspWriter writer = pageContext.getOut();
            writer.println(strategy.createForm(action));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return super.doEndTag();
    }
}

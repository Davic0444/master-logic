package com.david.servlets;

import com.david.gamesessionbeans.GameSessionBeanImpl;
import com.david.utils.GameType;
import jakarta.inject.Inject;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "StartGameServlet", value = "/startgame")
public class StartGameServlet extends HttpServlet {

    @Inject
    GameSessionBeanImpl gameBean;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        response.setContentType("text/html;charset=UTF-8");
        int parameter = Integer.parseInt(request.getParameter("gametype"));
        selectGame(parameter);
        response.sendRedirect("game");
    }

    private void selectGame(int index) {
        gameBean.startGame(GameType.getGameTypeByIndex(index));
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }
}

package com.david.servlets;

import com.david.interfaces.GameSessionBean;
import jakarta.inject.Inject;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "GameShotServlet", value = "/shot")
public class GameShotServlet extends HttpServlet {

    @Inject
    GameSessionBean gameBean;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        response.setContentType("text/html;charset=UTF-8");
        gameBean.shot(request.getParameterMap());
        String url="game";
        if (!gameBean.isInGame()){
            url="endofgame";
        }
        response.sendRedirect(url);
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

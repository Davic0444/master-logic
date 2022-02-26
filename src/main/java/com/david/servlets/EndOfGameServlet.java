package com.david.servlets;

import com.david.interfaces.GameSessionBean;
import com.david.utils.GameResult;
import jakarta.inject.Inject;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "EndOfGameServlet", value = "/endofgame")
public class EndOfGameServlet extends HttpServlet {

    @Inject
    GameSessionBean gameBean;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        response.setContentType("text/html;charset=UTF-8");
        String text = "<h1>Nyertél!</h1>";
        if (gameBean.getGameResult()== GameResult.LOOSE){
            text = "<h1>Vesztettél</h1>";
        }
        text+="<a href='index.html'>Új játék</a>";
        request.setAttribute("text", text);
        request.getRequestDispatcher("/gameover").forward(request,response);
        request.getSession().invalidate();

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

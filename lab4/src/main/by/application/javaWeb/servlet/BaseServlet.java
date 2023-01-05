package by.application.javaWeb.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class BaseServlet extends HttpServlet {

    public final static String WELCOME_PAGE = "/WEB-INF/views/welcome.jsp";
    public final static String MARKET_PAGE = "/WEB-INF/views/market.jsp";
    public final static String BASKET_PAGE = "/WEB-INF/views/basket.jsp";
    public final static String LOGIN_PAGE = "/WEB-INF/views/login.jsp";
    public final static String PROJECT_WAR = "Project_war";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.getRequestDispatcher(MARKET_PAGE).forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.getRequestDispatcher(MARKET_PAGE).forward(request, response);
    }

}

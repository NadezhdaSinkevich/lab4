package by.application.javaWeb.servlet;

import by.application.javaWeb.model.entity.User;
import by.application.javaWeb.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Optional;

import static by.application.javaWeb.servlet.BaseServlet.PROJECT_WAR;


@WebServlet("/")
public class WelcomeServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private UserService userService = new UserService();

    private static final String WELCOME = "Welcome to Auto Catalog";
    private static final String FORM_NAME = "<form action=\"/"+PROJECT_WAR+"/\" method=\"post\">" +
            " Name: <input name=\"name\" /><br><br>" +
            " <input type=\"submit\" value=\"Submit\" />" +
            " </form><br>";

    private static final String FORM_CATALOG = "<form action=\"/"+PROJECT_WAR+"/Catalog\" method=\"get\">\n" +
            " <input type=\"submit\" value=\"Auto Catalog\" />\n" +
            " </form>";

    private static final String FORM = " <form action=\"/"+PROJECT_WAR+"/\" method=\"post\" >" +
            " Login: <input name=\"login\" value=\"\" /><br><br>" +
            " Password: <input name=\"password\" value=\"\" /><br><br>" +
            " <input type=\"submit\" value=\"Authorization\" />" +
            "</form><br>";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        try {
            writer.println("<h2>"+WELCOME+"</h2>");
            writer.println(FORM);
            //writer.println(FORM_CATALOG);
        } finally {
            writer.close();
        }
        //request.getRequestDispatcher(WELCOME_PAGE).forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = "";
        try {
            String login = (String) request.getParameter("login");
            String password = (String) request.getParameter("password");

            if(null != login && null != password) {
                Optional<User> user = userService.isExistsUser(login, password);
                if(user.isPresent()) {
                    name = user.get().getName();
                }
            }
        } catch (Exception ex){
            System.out.println(ex.getMessage());
        }

        String msg = "<h2>"+WELCOME+" "+name+"</h2>";
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        try {
            writer.println(msg);
            if(name.equals("")) {
                writer.println(FORM);
            } else {
                writer.println(FORM_CATALOG);
            }
        } finally {
            writer.close();
        }
        //request.getRequestDispatcher(WELCOME_PAGE).forward(request, response);
    }

    private void print(HttpServletResponse response, String message) throws IOException {
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        try {
            writer.println(message);
        } finally {
            writer.close();
        }
    }

}

package com.bridgelabz.servletintroduction;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Pattern;

@WebServlet(
        description = "Login Servlet Testing",
        urlPatterns = {"/LoginServlet"},
        initParams = {
                @WebInitParam(name = "user", value = "Priyanka"),
                @WebInitParam(name = "password", value = "Vchutki@0606")
        }
)

public class LoginServlet extends HttpServlet {

        @Override
        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            //Get request parameters for userID and password
            String user = request.getParameter("user");
            boolean validuser = (user !=null)&& user.matches("[A-Z]{1}[a-z]{3,6}");
            String pwd = request.getParameter("pwd");
            boolean validpassword = (pwd !=null)&& pwd.matches("[A-Z]{1}[a-z]{7}[.^$@#?&*!]{1}[0-9]{1}");

            //Get servlet config init params
            String userId = getServletConfig().getInitParameter("user");
            String password = getServletConfig().getInitParameter("password");
            if (userId.equals(user) && password.equals(pwd)) {
                request.setAttribute("user", user);
                request.getRequestDispatcher("LoginSuccess.jsp").forward(request, response);
            } else {
                RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/login.html");
                PrintWriter out = response.getWriter();
                out.println("<font color = red > Either user name or password is wrong.</font>");
                requestDispatcher.include(request, response);

            }
        }
    }





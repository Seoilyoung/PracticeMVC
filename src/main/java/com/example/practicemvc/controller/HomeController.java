package com.example.practicemvc.controller;

import com.example.practicemvc.model.Test2Service;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "HomeController", value = "*.mvc")
public class HomeController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = request.getRequestURI();
        String viewName = null;

        if(url.contains("main.mvc"))
            viewName = "main.jsp";
        else if(url.contains("test1.mvc")) {
            viewName = "test1.jsp";
            String str1 = request.getParameter("data1");
            String str2 = request.getParameter("data2");

            int number1 = Integer.parseInt(str1);
            int number2 = Integer.parseInt(str2);

            int result = number1 + number2;

            request.setAttribute("result", result);
        }
        else if(url.contains("test2.mvc")) {
            viewName = "test2.jsp";

            int result = Test2Service.minus(request);
            request.setAttribute("result", result);
        }

        RequestDispatcher dis = request.getRequestDispatcher(viewName);
        dis.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

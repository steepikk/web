package ru.itmo.web;

import jakarta.servlet.http.HttpServlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;


public class ControllerServlet extends HttpServlet {
    private static final Logger logger = LogManager.getLogger(ControllerServlet.class);
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String xParam = request.getParameter("x");
        String yParam = request.getParameter("y");
        String rParam = request.getParameter("r");

        logger.info("Received GET request with parameters: x={}, y={}, r={}", xParam, yParam, rParam);

        if (xParam != null && yParam != null && rParam != null) {
            logger.info("Forwarding to /check");
            getServletContext().getRequestDispatcher("/check").forward(request, response);
        } else {
            logger.info("Forwarding to /index.jsp");
            getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}



// ssh -p2222 s413044@helios.cs.ifmo.ru -Y -L40912:localhost:40912
// ssh -p2222 s413044@helios.cs.ifmo.ru -Y -L40914:localhost:40914
// hEez<2098
// Username: Stepik
// Password: admin
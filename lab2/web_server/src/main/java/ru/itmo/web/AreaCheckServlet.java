package ru.itmo.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class AreaCheckServlet extends HttpServlet {
    private static final Logger logger = LogManager.getLogger(AreaCheckServlet.class);
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        double x = Double.parseDouble(request.getParameter("x"));
        double y = Double.parseDouble(request.getParameter("y"));
        double r = Double.parseDouble(request.getParameter("r"));

        logger.info("Received POST request with parameters: x={}, y={}, r={}", x, y, r);

        boolean isInside = checkArea(x, y, r);

        logger.info("Area check result: isInside={}", isInside);

        request.setAttribute("x", x);
        request.setAttribute("y", y);
        request.setAttribute("r", r);
        request.setAttribute("isInside", isInside);
        request.setAttribute("currentTime", LocalDateTime.now().format(formatter));

        HttpSession session = request.getSession();
        ResultBean resultBean = (ResultBean) session.getAttribute("resultBean");

        if (resultBean == null) {
            logger.info("Creating new ResultBean for session");
            resultBean = new ResultBean();
            session.setAttribute("resultBean", resultBean);
        }

        logger.info("Adding result to ResultBean: x={}, y={}, r={}, isInside={}", x, y, r, isInside);
        resultBean.addResult(new AreaResult(x, y, r, isInside));

        logger.info("Forwarding to /result.jsp");
        getServletContext().getRequestDispatcher("/result.jsp").forward(request, response);
    }

    private boolean checkArea(double x, double y, double r) {
        if (x >= 0 && y <= 0) {
            return (x * x + y * y <= (r * r / 4));
        } else if (x <= 0 && y >= 0) {
            return (x >= -r && y <= r);
        } else if (x <= 0 && y <= 0) {
            return (y >= -x / 2 - r / 2);
        }
        return false;
    }
}

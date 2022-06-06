package epam.project.bookshop.controller;

import epam.project.bookshop.command.Command;
import epam.project.bookshop.command.CommandType;
import epam.project.bookshop.exception.CommandException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

@WebServlet(name = "helloServlet", value = "/controller")
public class Controller extends HttpServlet {

    public void init() {
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");

        String command = request.getParameter("command");// input dagi name
        Command execute = CommandType.castToCommand(command);
        String page;
        try {
            page = execute.execute(request);
            request.getRequestDispatcher(page).forward(request, response);
        } catch (CommandException e) {
            throw new ServletException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        String command = req.getParameter("command");// input dagi name
        Command execute = CommandType.castToCommand(command);
        String page;
        try {
            page = execute.execute(req);
            req.getRequestDispatcher(page).forward(req, resp);
        } catch (CommandException e) {
            throw new ServletException(e); // 2
        }
    }

    public void destroy() {
    }

}
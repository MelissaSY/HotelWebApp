package by.tc.webapp.main.controller;

import by.tc.webapp.main.controller.commands.factory.CommandFactory;
import by.tc.webapp.main.controller.commands.interfaces.Command;
import by.tc.webapp.service.exception.ServiceException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class Controller extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            execute(request, response);
        } catch (ServiceException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            execute(request, response);
        } catch (ServiceException e) {
            throw new RuntimeException(e);
        }
    }
    private void execute(HttpServletRequest req, HttpServletResponse res) throws ServiceException {
        String commandName = req.getParameter("COMMAND");
        Command command = CommandFactory.getInstance().getCommand(commandName);
        command.execute(req, res);
    }
}

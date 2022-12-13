package by.tc.webapp.main.controller.commands.interfaces;

import by.tc.webapp.service.exception.ServiceException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public interface Command {
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException;
}

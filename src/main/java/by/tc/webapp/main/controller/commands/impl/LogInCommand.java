package by.tc.webapp.main.controller.commands.impl;

import by.tc.webapp.entity.User;
import by.tc.webapp.main.controller.commands.interfaces.Command;
import by.tc.webapp.service.exception.ServiceException;
import by.tc.webapp.service.factory.ServiceFactory;
import by.tc.webapp.service.interfaces.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Optional;

import static by.tc.webapp.service.factory.ServiceFactory.*;

public class LogInCommand implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException {
        try {
            String login = request.getParameter("LogUserLogin");
            String password = request.getParameter("LogUserPassword");
            UserService userService = getInstance().getUserService();
            Optional<User> foundUser = userService.login(login, password);
            if (foundUser.isPresent()) {
                request.getSession(true).setAttribute("userId", foundUser.get().getId());
                request.getSession().setAttribute("userLogin", foundUser.get().getEmail());
                request.getSession().setAttribute("userRole", foundUser.get().getIdRole());

                response.sendRedirect("Controller?COMMAND=GET_ROOMS");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ServiceException e) {
            throw new RuntimeException(e);
        }
    }
}

package by.tc.webapp.main.controller.commands.impl;

import by.tc.webapp.entity.User;
import by.tc.webapp.main.controller.commands.interfaces.Command;
import by.tc.webapp.service.exception.ServiceException;
import by.tc.webapp.service.factory.ServiceFactory;
import by.tc.webapp.service.interfaces.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class RegisterCommand implements Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException {
        try {
            String userLogin = request.getParameter("RegUserLogin");
            String userPassword = request.getParameter("RegPassword");
            String userName = request.getParameter("RegUserName");
            String userSurname = request.getParameter("RegSurname");

            UserService userService = ServiceFactory.getInstance().getUserService();
            if (userService.register(userName, userSurname, userLogin, userPassword)) {
                User user = userService.login(userLogin, userPassword).get();
                request.getSession(true).setAttribute("userId", user.getId());
                request.getSession().setAttribute("userLogin", user.getEmail());
                request.getSession().setAttribute("userRole", user.getIdRole());
                response.sendRedirect("Controller?COMMAND=GET_ROOMS");
            } else {
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

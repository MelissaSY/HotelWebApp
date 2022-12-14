package by.tc.webapp.main.controller.commands.impl;

import by.tc.webapp.main.controller.commands.interfaces.Command;
import by.tc.webapp.service.exception.ServiceException;
import by.tc.webapp.service.factory.ServiceFactory;
import by.tc.webapp.service.interfaces.BookingService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class GetReservedRoomsCommand implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException {
        try {
            int userId = (int) request.getSession().getAttribute("userId");
            BookingService service = ServiceFactory.getInstance().getBookingService();
            request.getSession().setAttribute("orders", service.retrieveBookingByUserId(userId));
            if((int)request.getSession().getAttribute("userRole") == 1){
                request.getRequestDispatcher("manager.jsp").forward(request, response);
            }
            else{
                request.getRequestDispatcher("user.jsp").forward(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

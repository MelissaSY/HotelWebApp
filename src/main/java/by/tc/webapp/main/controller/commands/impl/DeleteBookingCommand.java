package by.tc.webapp.main.controller.commands.impl;

import by.tc.webapp.main.controller.commands.interfaces.Command;
import by.tc.webapp.service.exception.ServiceException;
import by.tc.webapp.service.factory.ServiceFactory;
import by.tc.webapp.service.interfaces.BookingService;
import by.tc.webapp.service.interfaces.RoomService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class DeleteBookingCommand implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException {
        try {
            int bookingId = Integer.parseInt(request.getParameter("bookingId"));
            int roomId = Integer.parseInt(request.getParameter("roomId"));
            BookingService bookingService = ServiceFactory.getInstance().getBookingService();
            bookingService.updateStatusAtBookingById(bookingId, "canceled");
            RoomService roomService = ServiceFactory.getInstance().getRoomService();
            roomService.updateRoomStatusById(roomId, "reserved");
            request.getRequestDispatcher("Controller?COMMAND=GET_ROOMS").forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        } catch (ServiceException e) {
            throw new RuntimeException(e);
        }
    }
}

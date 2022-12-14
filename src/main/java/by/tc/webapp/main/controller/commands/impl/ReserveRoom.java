package by.tc.webapp.main.controller.commands.impl;

import by.tc.webapp.main.controller.commands.interfaces.Command;
import by.tc.webapp.service.exception.ServiceException;
import by.tc.webapp.service.factory.ServiceFactory;
import by.tc.webapp.service.interfaces.BookingService;
import by.tc.webapp.service.interfaces.RoomService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ReserveRoom implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException {
        try {
            String userId = (String) request.getSession().getAttribute("userId");
            String roomId = request.getParameter("roomId");

            BookingService orderService = ServiceFactory.getInstance().getBookingService();
            orderService.addNewBooking(userId, roomId);

            RoomService roomService = ServiceFactory.getInstance().getRoomService();
            roomService.updateRoomStatusById(Integer.parseInt(roomId), "reserved");

            request.getRequestDispatcher("Controller?COMMAND=GET_ROOMS").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

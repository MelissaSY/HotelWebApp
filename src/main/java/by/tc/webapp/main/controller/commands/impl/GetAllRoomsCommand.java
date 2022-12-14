package by.tc.webapp.main.controller.commands.impl;

import by.tc.webapp.entity.Room;
import by.tc.webapp.main.controller.commands.interfaces.Command;
import by.tc.webapp.service.exception.ServiceException;
import by.tc.webapp.service.factory.ServiceFactory;
import by.tc.webapp.service.interfaces.RoomService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

public class GetAllRoomsCommand implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException {
        RoomService roomService = ServiceFactory.getInstance().getRoomService();
        List<Room> rooms = roomService.retrieveALLRooms();
        try {
            request.getSession().setAttribute("rooms", rooms);
            response.sendRedirect("Controller?COMMAND=GET_RESERVATIONS");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

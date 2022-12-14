package by.tc.webapp.main.controller.commands.impl;

import by.tc.webapp.main.controller.commands.interfaces.Command;
import by.tc.webapp.service.exception.ServiceException;
import by.tc.webapp.service.factory.ServiceFactory;
import by.tc.webapp.service.interfaces.RoomService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class AddRoomCommand implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException {
        try {
            String price = request.getParameter("price");
            String roomNumber = request.getParameter("roomNumber");
            RoomService roomService = ServiceFactory.getInstance().getRoomService();
            roomService.addNewRoom("unreserved", roomNumber, price);
            response.sendRedirect("Controller?COMMAND=GET_ROOMS");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ServiceException e) {
            throw new RuntimeException(e);
        }
    }
}

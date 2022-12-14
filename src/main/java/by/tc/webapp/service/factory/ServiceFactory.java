package by.tc.webapp.service.factory;

import by.tc.webapp.dao.factory.DAOFactory;
import by.tc.webapp.service.impl.BookingServiceImpl;
import by.tc.webapp.service.impl.RoleServiceImpl;
import by.tc.webapp.service.impl.RoomServiceImpl;
import by.tc.webapp.service.impl.UserServiceImpl;
import by.tc.webapp.service.interfaces.BookingService;
import by.tc.webapp.service.interfaces.RoleService;
import by.tc.webapp.service.interfaces.RoomService;
import by.tc.webapp.service.interfaces.UserService;

public class ServiceFactory {
    private static final ServiceFactory instance = new ServiceFactory();
    private ServiceFactory() {
    }
    public static ServiceFactory getInstance() {
        return instance;
    }

    private final BookingService bookingService = new BookingServiceImpl();
    private final RoomService roomService = new RoomServiceImpl();
    private final UserService userService = new UserServiceImpl();
    private final RoleService roleService = new RoleServiceImpl();


    public RoomService getRoomService() {
        return roomService;
    }

    public RoleService getRoleService() {
        return roleService;
    }

    public UserService getUserService() {
        return userService;
    }

    public BookingService getBookingService() {
        return bookingService;
    }
}

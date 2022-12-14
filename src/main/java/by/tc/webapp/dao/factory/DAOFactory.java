package by.tc.webapp.dao.factory;

import by.tc.webapp.dao.impl.*;
import by.tc.webapp.dao.interfaces.BookingDAO;
import by.tc.webapp.dao.interfaces.RoleDAO;
import by.tc.webapp.dao.interfaces.RoomDAO;
import by.tc.webapp.dao.interfaces.UserDAO;

public class DAOFactory {
    private static final DAOFactory instance = new DAOFactory();
    private final BookingDAO bookingDAO = new BookingDAOImpl();
    private final RoleDAO roleDAO = new RoleDAOImpl();
    private final UserDAO userDAO = new UserDAOImpl();
    private final RoomDAO roomDAO = new RoomDAOImpl();
    public BookingDAO getBookingDAO() {
        return bookingDAO;
    }
    public RoleDAO getRoleDAO() {
        return roleDAO;
    }
    public UserDAO getUserDAO() {
        return userDAO;
    }
    public RoomDAO getRoomDAO() {
        return roomDAO;
    }
    public static DAOFactory getInstance() { return instance; }

}

package by.tc.webapp.service.impl;

import by.tc.webapp.dao.exception.DAOException;
import by.tc.webapp.dao.factory.DAOFactory;
import by.tc.webapp.dao.interfaces.RoleDAO;
import by.tc.webapp.dao.interfaces.UserDAO;
import by.tc.webapp.entity.Booking;
import by.tc.webapp.entity.Role;
import by.tc.webapp.entity.User;
import by.tc.webapp.service.exception.ServiceException;
import by.tc.webapp.service.interfaces.UserService;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class UserServiceImpl implements UserService {

    private static final String USER = "user";
    @Override
    public Optional<User> login(String email, String password) throws ServiceException {
        if (email == null || password == null) {
            return Optional.empty();
        }

        try {
            UserDAO userDao = DAOFactory.getInstance().getUserDAO();
            return userDao.findByEmailAndPassword(email, password);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public boolean register(String name, String surname, String email, String password) throws ServiceException {
        if (name == null || surname == null ||
                email == null || password == null) {
            return false;
        }
        try {
            UserDAO userDao = DAOFactory.getInstance().getUserDAO();
            if (userDao.findByEmail(email).isPresent()) {
                return false;
            }
            RoleDAO roleDao = DAOFactory.getInstance().getRoleDAO();
            Optional<Role> role = roleDao.findByName(USER);
            if (!role.isPresent()) {
                return false;
            }

            User user = new User(email, name, surname, role.get().getId(), password);

            userDao.save(user);

            return true;
        } catch (DAOException e) {

            throw new ServiceException(e);
        }
    }

    @Override
    public Optional<User> retrieveUserById(int userId) throws ServiceException {
        try {
            UserDAO userDAO = DAOFactory.getInstance().getUserDAO();
            Optional<User> result;
            result = userDAO.findById(userId);
            return result;
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public List<User> getUsersFromBookings(List<Booking> bookings) throws ServiceException {
        List<User> users = new LinkedList<>();
        try {
            for (Booking booking : bookings) {
                Optional<User> user = retrieveUserById(booking.getIdUser());
                if (user.isPresent()) {
                    if (!users.contains(user.get())) {
                        users.add(user.get());
                    }
                }
            }
        } catch (ServiceException e) {
            throw new ServiceException(e);
        }
        return users;
    }
}

package by.tc.webapp.service.interfaces;

import by.tc.webapp.entity.Booking;
import by.tc.webapp.entity.User;
import by.tc.webapp.service.exception.ServiceException;

import java.util.List;
import java.util.Optional;

public interface UserService {

    Optional<User> login(String email, String password) throws ServiceException;
    boolean register(String name, String surname,  String email,
                     String password) throws ServiceException;
    Optional<User> retrieveUserById(int userId) throws ServiceException;
    public List<User> getUsersFromBookings(List<Booking> orders) throws ServiceException;
}

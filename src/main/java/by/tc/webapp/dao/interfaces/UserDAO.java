package by.tc.webapp.dao.interfaces;

import by.tc.webapp.dao.dbhelper.tables.Table;
import by.tc.webapp.dao.exception.DAOException;
import by.tc.webapp.dao.mapper.factory.MapperFactory;
import by.tc.webapp.entity.User;

import java.util.Optional;

public interface UserDAO extends HotelDAO<User> {
    Optional<User> findByEmailAndPassword(String email, String password) throws DAOException;
    Optional<User> findByEmail(String email) throws DAOException;
    public int save(User user) throws DAOException;
}

package by.tc.webapp.dao.impl;

import by.tc.webapp.dao.dbhelper.tables.Table;
import by.tc.webapp.dao.exception.DAOException;
import by.tc.webapp.dao.interfaces.UserDAO;
import by.tc.webapp.dao.mapper.factory.MapperFactory;
import by.tc.webapp.entity.User;

import java.util.Optional;

public class UserDAOImpl extends HotelDAOImpl<User> implements UserDAO {
    private static final String userString = Table.table.get(Table.Tables.USER);
    private static final MapperFactory mapperFactory = MapperFactory.getInstance();
    private static final String FIND_USER_BY_EMAIL_AND_PASSWORD_QUERY =
            "SELECT * FROM " + userString + " WHERE email=? and password=?";
    private static final String FIND_USER_BY_EMAIL_QUERY =
            "SELECT * FROM " + userString + " WHERE email=?";
    private static final String SAVE_USER_QUERY =
            "INSERT INTO " + userString + " (email, password, role_id, name, surname) VALUES (?, ?, ?, ?, ?)";
    private static final String DELETE_USER_QUERY =
            "DELETE FROM " + userString + " WHERE id=?";

    public UserDAOImpl() {
        super(mapperFactory.getUserMapper(), userString);
    }

    @Override
    public Optional<User> findByEmailAndPassword(String email, String password) throws DAOException {
        return executeQueryForSingleResult(FIND_USER_BY_EMAIL_AND_PASSWORD_QUERY, email, password);
    }

    @Override
    public Optional<User> findByEmail(String email) throws DAOException {
        return executeQueryForSingleResult(FIND_USER_BY_EMAIL_QUERY, email);
    }
    @Override
    public int save(User user) throws DAOException {
        return executeInsertQuery(SAVE_USER_QUERY, user.getEmail(), user.getHashedPassword(),
                user.getIdRole(), user.getName(), user.getSurname());
    }

    @Override
    public void removeById(int id) throws DAOException {
        executeUpdateQuery(DELETE_USER_QUERY, id);
    }
}

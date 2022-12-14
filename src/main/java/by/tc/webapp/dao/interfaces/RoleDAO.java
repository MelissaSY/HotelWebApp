package by.tc.webapp.dao.interfaces;

import by.tc.webapp.dao.exception.DAOException;
import by.tc.webapp.entity.Role;

import java.util.Optional;

public interface RoleDAO extends HotelDAO<Role> {
    Optional<Role> findByName(String name) throws DAOException;
}

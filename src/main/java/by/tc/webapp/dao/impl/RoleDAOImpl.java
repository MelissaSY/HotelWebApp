package by.tc.webapp.dao.impl;

import by.tc.webapp.dao.dbhelper.tables.Table;
import by.tc.webapp.dao.exception.DAOException;
import by.tc.webapp.dao.interfaces.RoleDAO;
import by.tc.webapp.dao.mapper.factory.MapperFactory;
import by.tc.webapp.entity.Role;

import java.util.Optional;

public class RoleDAOImpl extends HotelDAOImpl<Role> implements RoleDAO {
    private static final String roleString = Table.table.get(Table.Tables.ROLE);
    private static final String SAVE_ROLE_QUERY = "INSERT INTO " + roleString + " (role) VALUES (?)";
    private static final String FIND_ROLE_BY_NAME_QUERY = "SELECT * FROM " + roleString + " WHERE role=?";

    public RoleDAOImpl() {
        super(MapperFactory.getInstance().getRoleMapper(), roleString);
    }

    @Override
    public int save(Role role) throws DAOException {
        return executeInsertQuery(SAVE_ROLE_QUERY, role.getRoleName());
    }

    @Override
    public Optional<Role> findByName(String name) throws DAOException {
        return executeQueryForSingleResult(FIND_ROLE_BY_NAME_QUERY, name);
    }
}

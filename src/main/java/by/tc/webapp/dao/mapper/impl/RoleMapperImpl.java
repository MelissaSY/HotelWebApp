package by.tc.webapp.dao.mapper.impl;

import by.tc.webapp.dao.mapper.Columns;
import by.tc.webapp.dao.mapper.interfaces.Mapper;
import by.tc.webapp.entity.Role;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RoleMapperImpl implements Mapper<Role> {
    @Override
    public Role map(ResultSet resultSet) throws SQLException {
        byte idRole = resultSet.getByte(Columns.column.get(Columns.Column.ROLE_ID));
        String roleName = resultSet.getString(Columns.column.get(Columns.Column.ROLE_NAME));
        return new Role(idRole, roleName);
    }
}

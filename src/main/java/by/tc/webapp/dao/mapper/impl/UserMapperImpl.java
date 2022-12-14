package by.tc.webapp.dao.mapper.impl;

import by.tc.webapp.dao.mapper.Columns;
import by.tc.webapp.dao.mapper.interfaces.Mapper;
import by.tc.webapp.entity.User;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapperImpl implements Mapper<User> {
    @Override
    public User map(ResultSet resultSet) throws SQLException {
        int idUser = resultSet.getInt(Columns.column.get(Columns.Column.USER_ID));
        String email = resultSet.getString(Columns.column.get(Columns.Column.USER_EMAIL));
        String name = resultSet.getString(Columns.column.get(Columns.Column.USER_NAME));
        String surname = resultSet.getString(Columns.column.get(Columns.Column.USER_SURNAME));
        String password = resultSet.getString(Columns.column.get(Columns.Column.USER_PASSWORD));
        byte idRole = resultSet.getByte(Columns.column.get(Columns.Column.ROLE_ID));
        return new User(email, name, surname, idRole, password);
    }
}

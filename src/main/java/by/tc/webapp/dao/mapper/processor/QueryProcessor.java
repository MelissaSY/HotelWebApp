package by.tc.webapp.dao.mapper.processor;

import by.tc.webapp.dao.dbhelper.Connector;
import by.tc.webapp.dao.exception.DAOException;
import by.tc.webapp.dao.mapper.interfaces.Mapper;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class QueryProcessor<T> {
    private final Mapper<T> mapper;
    public QueryProcessor(Mapper<T> mapper) {
        this.mapper = mapper;
    }
    protected List<T> executeQuery(String query, Object... params) throws DAOException {
        List<T> entities;
        try (PreparedStatement statement = createStatement(query, params);
             ResultSet resultSet = statement.executeQuery()) {
            entities = createEntitiesList(resultSet);
        } catch (SQLException e) {

            throw new DAOException();
        }
        return entities;
    }

    protected Optional<T> executeQueryForSingleResult(String query, Object... params) throws DAOException {
        List<T> items = executeQuery(query, params);
        if (items.isEmpty()) {
            return Optional.empty();
        }

        if (!(items.size() == 1)) {
            return Optional.empty();
        }

        return Optional.of(items.get(0));
    }

    protected int executeInsertQuery(String query, Object... params) throws DAOException {
        int result = 0;
        try (PreparedStatement statement = createStatement(query, params)) {
            statement.executeUpdate();
            ResultSet generatedKey = statement.getGeneratedKeys();
            if (generatedKey.next()) {
                result = generatedKey.getInt(1);
            }
        } catch (SQLException e) {

            throw new DAOException();
        }
        return result;
    }

    protected void executeUpdateQuery(String query, Object... params) throws DAOException {
        try (PreparedStatement statement = createStatement(query, params)) {
            statement.executeUpdate();
        } catch (SQLException e) {

            throw new DAOException();
        }
    }
    private PreparedStatement createStatement(String query, Object... params) throws DAOException {
        try {
            Connection connection = Connector.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            for (int i = 0; i < params.length; i++) {
                preparedStatement.setObject(i + 1, params[i]);
            }
            return preparedStatement;
        } catch (SQLException e) {
            throw new DAOException();
        }
    }

    private List<T> createEntitiesList(ResultSet resultSet) throws DAOException {
        List<T> entities = new ArrayList<>();
        try {
            while (resultSet.next()) {
                T entity = mapper.map(resultSet);
                entities.add(entity);
            }
        } catch (SQLException e) {
            throw new DAOException();
        }
        return entities;
    }
}

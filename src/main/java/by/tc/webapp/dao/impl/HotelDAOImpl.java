package by.tc.webapp.dao.impl;

import by.tc.webapp.dao.exception.DAOException;
import by.tc.webapp.dao.interfaces.HotelDAO;
import by.tc.webapp.dao.mapper.interfaces.Mapper;
import by.tc.webapp.dao.mapper.processor.QueryProcessor;
import by.tc.webapp.entity.interfaces.Identifiable;

import java.util.List;
import java.util.Optional;

public abstract class HotelDAOImpl<T extends Identifiable> extends QueryProcessor<T> implements HotelDAO<T> {

    private final String tableName;
    public HotelDAOImpl(Mapper<T> mapper, String tableName) {
        super(mapper);
        this.tableName = tableName;
    }

    @Override
    public List findAll() throws DAOException {
        String query = "SELECT * FROM " + tableName;
        return executeQuery(query);
    }

    @Override
    public Optional findById(int id) throws DAOException {
        String query = "SELECT * FROM " + tableName + " WHERE id=?";
        return executeQueryForSingleResult(query, id);
    }
    @Override
    public void removeById(int id) throws DAOException {
        String deleteQuery = "DELETE FROM " + tableName + " WHERE id=?";
        executeUpdateQuery(deleteQuery, id);
    }
}

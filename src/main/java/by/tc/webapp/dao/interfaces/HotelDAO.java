package by.tc.webapp.dao.interfaces;

import by.tc.webapp.dao.exception.DAOException;
import by.tc.webapp.dao.mapper.processor.QueryProcessor;
import by.tc.webapp.entity.interfaces.Identifiable;

import java.util.List;
import java.util.Optional;

public interface HotelDAO<T>{
    List<T> findAll() throws DAOException;
    Optional<T> findById(int id) throws DAOException;
    int save(T item) throws DAOException;
    void removeById(int id) throws DAOException;
}
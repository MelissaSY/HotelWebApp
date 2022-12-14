package by.tc.webapp.dao.interfaces;

import by.tc.webapp.dao.exception.DAOException;
import by.tc.webapp.entity.Room;

import java.util.List;

public interface RoomDAO extends HotelDAO<Room> {
    List<Room> findByStatus(String status) throws DAOException;
    void updateRoomById(int id, Room room) throws DAOException;
    void updateRoomStatusById(int id, String status) throws DAOException;
    List<Room> findByPrice(double from, double to) throws DAOException;
}

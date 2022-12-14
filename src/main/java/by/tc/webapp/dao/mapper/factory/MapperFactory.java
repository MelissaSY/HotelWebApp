package by.tc.webapp.dao.mapper.factory;

import by.tc.webapp.dao.mapper.impl.BookingMapperImpl;
import by.tc.webapp.dao.mapper.impl.RoleMapperImpl;
import by.tc.webapp.dao.mapper.impl.RoomMapperImpl;
import by.tc.webapp.dao.mapper.impl.UserMapperImpl;
import by.tc.webapp.dao.mapper.interfaces.Mapper;
import by.tc.webapp.entity.Booking;
import by.tc.webapp.entity.Role;
import by.tc.webapp.entity.Room;
import by.tc.webapp.entity.User;

public final class MapperFactory {
    private static final MapperFactory instance = new MapperFactory();
    public static MapperFactory getInstance() { return instance; }
    private final Mapper<User> userMapper = new UserMapperImpl();
    private final Mapper<Role> roleMapper = new RoleMapperImpl();
    private final Mapper<Booking> userOrderMapper = new BookingMapperImpl();
    private final Mapper<Room> roomMapper = new RoomMapperImpl();

    public Mapper<User> getUserMapper() {
        return userMapper;
    }
    public Mapper<Role> getRoleMapper() {
        return roleMapper;
    }
    public Mapper<Booking> getUserBookingMapper() {
        return userOrderMapper;
    }
    public Mapper<Room> getRoomMapper() {
        return roomMapper;
    }
}

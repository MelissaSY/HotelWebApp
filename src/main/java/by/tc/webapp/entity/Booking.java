package by.tc.webapp.entity;

import by.tc.webapp.entity.interfaces.Identifiable;

import java.sql.Timestamp;

public class Booking implements Identifiable {
    private int id;
    private Timestamp startTime;
    private int idUser;
    private int idRoom;
    public Booking(int id, Timestamp startTime, int idUser, int idRoom) {
        this.id = id;
        this.idRoom = idRoom;
        this.idUser = idUser;
        this.startTime = startTime;
    }
    @Override
    public int getId() {
        return id;
    }
    public Timestamp getStartTime() {
        return this.startTime;
    }
    public int getIdUser() {
        return idUser;
    }
    public int getIdRoom() {
        return idRoom;
    }
    /*public void setId(int id) {
        this.id = id;
    }*/

}

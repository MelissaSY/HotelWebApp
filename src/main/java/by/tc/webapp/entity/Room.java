package by.tc.webapp.entity;

import by.tc.webapp.entity.interfaces.Identifiable;

public class Room implements Identifiable {
    private int idRoom;
    private boolean isReserved;
    private int number;
    private int price;
    public Room(int id, boolean isReserved, int price, int number) {
        this.idRoom = id;
        this.number = number;
        this.price = price;
        this.isReserved = isReserved;
    }
    public int getPrice() {
        return this.price;
    }
    public boolean getStatus() {
        return this.isReserved;
    }
    public void setStatus(boolean isReserved) {
        this.isReserved = isReserved;
    }
    public int getNumber() {
        return this.number;
    }
    @Override
    public int getId() {
        return idRoom;
    }
}

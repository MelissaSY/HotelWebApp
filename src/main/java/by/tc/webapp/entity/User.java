package by.tc.webapp.entity;

import by.tc.webapp.entity.interfaces.Identifiable;

public class User implements Identifiable {
    private static int currentId = 0;
    private int idUser;
    private String email;
    private String hashedPassword;
    private String name;
    private String surname;
    private int idRole;
    public User(String email, String name, String surname, int idRole, String hashedPassword) {
        this.hashedPassword = hashedPassword;
        this.email = email;
        this.idRole = idRole;
        this.idUser = currentId;
        this.surname = surname;
        this.name = name;
        currentId++;
    }
    public String getHashedPassword() {
        return hashedPassword;
    }
    public String getName() {
        return name;
    }
    public String getSurname() {
        return surname;
    }
    public int getIdRole() {
        return idRole;
    }
    public String getEmail() {
        return email;
    }
    @Override
    public int getId() {
        return idUser;
    }

}

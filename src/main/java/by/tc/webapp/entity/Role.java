package by.tc.webapp.entity;

import by.tc.webapp.entity.interfaces.Identifiable;

public class Role implements Identifiable {
    private byte idRole;
    private String roleName;
    public Role(byte idRole, String roleName) {
        this.idRole = idRole;
        this.roleName = roleName;
    }
    @Override
    public int getId() {
        return idRole;
    }
    public String getRoleName() {
        return this.roleName;
    }
}

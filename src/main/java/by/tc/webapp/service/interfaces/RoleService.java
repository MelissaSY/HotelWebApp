package by.tc.webapp.service.interfaces;

import by.tc.webapp.entity.Role;
import by.tc.webapp.service.exception.ServiceException;

import java.util.Optional;

public interface RoleService {
    Optional<Role> retrieveRoleById(int roleId) throws ServiceException;
    Optional<Role> retrieveRoleByRoleName(String roleName) throws ServiceException;
}

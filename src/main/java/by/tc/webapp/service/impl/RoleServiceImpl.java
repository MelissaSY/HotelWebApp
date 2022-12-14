package by.tc.webapp.service.impl;

import by.tc.webapp.dao.exception.DAOException;
import by.tc.webapp.dao.factory.DAOFactory;
import by.tc.webapp.dao.interfaces.RoleDAO;
import by.tc.webapp.entity.Role;
import by.tc.webapp.service.exception.ServiceException;
import by.tc.webapp.service.interfaces.RoleService;

import java.util.Optional;

public class RoleServiceImpl implements RoleService {
    @Override
    public Optional<Role> retrieveRoleById(int roleId) throws ServiceException {
        try {
            RoleDAO roleDao = DAOFactory.getInstance().getRoleDAO();
            Optional<Role> result;
            result = roleDao.findById(roleId);
            return result;
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public Optional<Role> retrieveRoleByRoleName(String roleName) throws ServiceException {
        try {
            RoleDAO roleDao = DAOFactory.getInstance().getRoleDAO();
            Optional<Role> result;
            result = roleDao.findByName(roleName);
            return result;
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }
}

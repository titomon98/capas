package arquitectura.capas.services;

import arquitectura.capas.entities.Role;

import java.util.List;
import java.util.Optional;

public interface RoleService {
    Optional<Role> getRoleById(Integer id);
    List<Role> getAllRoles();
    Role createRole(Role role);
    Optional<Role> updateRole(Role role);
    String deleteRole(Integer id);
}

package arquitectura.capas.services;

import arquitectura.capas.entities.Role;

import java.util.Optional;

public interface RoleService {
    Optional<Role> getRoleById(Integer id);
}

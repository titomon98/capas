package arquitectura.capas.services;

import arquitectura.capas.entities.Role;
import arquitectura.capas.repositories.roleRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class RoleServiceImpl implements RoleService { //Se conecta con la siguiente capa
    private final roleRepository roleRepository;
    //Constructor del repositorio
    public RoleServiceImpl(roleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Optional<Role> getRoleById(Integer id) {
        if (id == null) {
            return Optional.empty();
        }

        Optional<Role> roleValidation = roleRepository.findById(id);

        return roleValidation;
    }

    @Override
    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }

    @Override
    public Role createRole(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public Optional<Role> updateRole(Role role) {
        Optional<Role> roleValidation = roleRepository.findById(role.getId());

        if (roleValidation.isEmpty()) {
            return Optional.empty();
        }
        //Tomar el objeto Role de Optional<Role>
        Role updatedRole = roleValidation.get();
        //Poner los nuevos datos
        updatedRole.setType(role.getType());
        updatedRole.setDescription(role.getDescription());
        updatedRole.setStatus(role.getStatus());
        updatedRole.setUpdatedAt(LocalDateTime.now());

        return Optional.of(roleRepository.save(updatedRole));
    }
}

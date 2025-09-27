package arquitectura.capas.services;

import arquitectura.capas.entities.Role;
import arquitectura.capas.repositories.roleRepository;
import org.springframework.stereotype.Service;

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


}

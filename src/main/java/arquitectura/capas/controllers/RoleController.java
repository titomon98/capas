package arquitectura.capas.controllers;

import arquitectura.capas.entities.Role;
import arquitectura.capas.services.RoleService;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/role")
public class RoleController {
    final private RoleService roleService;

    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @GetMapping("/{id}")
    public Optional<Role> getRoleById(@PathVariable Integer id){
        return roleService.getRoleById(id);
    }
}

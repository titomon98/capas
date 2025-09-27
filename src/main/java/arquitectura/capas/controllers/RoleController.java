package arquitectura.capas.controllers;

import arquitectura.capas.entities.Role;
import arquitectura.capas.services.RoleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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

    @GetMapping("/all")
    public List<Role> getAllRoles(){
        return roleService.getAllRoles();
    }

    @PostMapping("/create")
    public Role createRole(@RequestBody Role role){
        return roleService.createRole(role);
    }

    @PutMapping("/update")
    public Optional<Role> updateRole(@RequestBody Role role){
        return roleService.updateRole(role);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteRole(@PathVariable Integer id){
        return roleService.deleteRole(id);
    }

    //TRATEN DE RESPETAR SIEMPRE MAYUSCULAS Y MINUSCULAS EN SUS VARIABLES
}

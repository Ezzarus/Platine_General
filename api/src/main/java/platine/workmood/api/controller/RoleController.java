package platine.workmood.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import platine.workmood.api.model.Role;
import platine.workmood.api.service.RoleService;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/role")
public class RoleController {

    @Autowired
    RoleService roleService;

    @GetMapping("")
    public List<Role> list() {
        return roleService.listAllRole();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Role> get(@PathVariable Integer id) {
        try {
            Role role = roleService.getRole(id);
            return new ResponseEntity<Role>(role, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Role>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping("")
    public void add(@RequestBody Role role) {
        roleService.saveRole(role);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Role role, @PathVariable Integer id) {
        try {
            role.setId(id);
            roleService.updateRole(role);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {

        roleService.deleteRole(id);
    }
}

package platine.workmood.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import platine.workmood.api.model.Role;
import platine.workmood.api.repository.RoleRepository;

import java.util.List;

@Service
@Transactional
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;

    public List<Role> listAllRole() {
        return roleRepository.findAll();
    }

    public Role getRole(Integer id) {
        return roleRepository.findById(id).get();
    }

    public void saveRole(Role role) {
        roleRepository.save(role);
    }

    public void updateRole(Role role) {
        roleRepository.save(role);
    }

    public void deleteRole(Integer id) {
        roleRepository.deleteById(id);
    }
}

package platine.workmood.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import platine.workmood.api.model.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {
}

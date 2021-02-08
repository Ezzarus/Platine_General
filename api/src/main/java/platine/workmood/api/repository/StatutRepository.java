package platine.workmood.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import platine.workmood.api.model.Statut;

public interface StatutRepository extends JpaRepository<Statut, Integer> {
}

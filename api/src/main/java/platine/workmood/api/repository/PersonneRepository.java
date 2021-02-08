package platine.workmood.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import platine.workmood.api.model.Personne;

public interface PersonneRepository extends JpaRepository<Personne, Integer> {
}

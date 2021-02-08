package platine.workmood.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import platine.workmood.api.model.Probleme;

public interface ProblemeRepository  extends JpaRepository<Probleme, Integer> {
}

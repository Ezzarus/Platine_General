package platine.workmood.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import platine.workmood.api.model.Categorie;

public interface CategorieRepository extends JpaRepository<Categorie, Integer> {
}

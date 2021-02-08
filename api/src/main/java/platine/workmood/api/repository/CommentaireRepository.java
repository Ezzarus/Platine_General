package platine.workmood.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import platine.workmood.api.model.Commentaire;

public interface CommentaireRepository extends JpaRepository<Commentaire, Integer> {
}

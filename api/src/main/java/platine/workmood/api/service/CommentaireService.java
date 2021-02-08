package platine.workmood.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import platine.workmood.api.model.Commentaire;
import platine.workmood.api.repository.CommentaireRepository;

import java.util.List;

@Service
@Transactional
public class CommentaireService {

    @Autowired
    private CommentaireRepository commentaireRepository;

    public List<Commentaire> listAllCommentaire() {
        return commentaireRepository.findAll();
    }

    public Commentaire getCommentaire(Integer id) {
        return commentaireRepository.findById(id).get();
    }

    public void saveCommentaire(Commentaire commentaire) {
        commentaireRepository.save(commentaire);
    }

    public void updateCommentaire(Commentaire commentaire) {
        commentaireRepository.save(commentaire);
    }

    public void deleteCommentaire(Integer id) {
        commentaireRepository.deleteById(id);
    }
}

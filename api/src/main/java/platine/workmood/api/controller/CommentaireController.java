package platine.workmood.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import platine.workmood.api.model.Commentaire;
import platine.workmood.api.service.CommentaireService;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/commentaire")
public class CommentaireController {

    @Autowired
    CommentaireService commentaireService;

    @GetMapping("")
    public List<Commentaire> list() {
        return commentaireService.listAllCommentaire();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Commentaire> get(@PathVariable Integer id) {
        try {
            Commentaire commentaire = commentaireService.getCommentaire(id);
            return new ResponseEntity<Commentaire>(commentaire, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Commentaire>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping("")
    public void add(@RequestBody Commentaire commentaire) {
        commentaireService.saveCommentaire(commentaire);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Commentaire commentaire, @PathVariable Integer id) {
        try {
            commentaire.setId(id);
            commentaireService.updateCommentaire(commentaire);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {

        commentaireService.deleteCommentaire(id);
    }
}

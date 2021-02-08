package platine.workmood.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import platine.workmood.api.model.Statut;
import platine.workmood.api.service.StatutService;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/statut")
public class StatutController {

    @Autowired
    StatutService statutService;

    @GetMapping("")
    public List<Statut> list() {
        return statutService.listAllStatut();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Statut> get(@PathVariable Integer id) {
        try {
            Statut statut = statutService.getStatut(id);
            return new ResponseEntity<Statut>(statut, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Statut>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping("")
    public void add(@RequestBody Statut statut) {
        statutService.saveStatut(statut);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Statut statut, @PathVariable Integer id) {
        try {
            statut.setId(id);
            statutService.updateStatut(statut);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {

        statutService.deleteStatut(id);
    }
}

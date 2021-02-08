package platine.workmood.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import platine.workmood.api.model.Personne;
import platine.workmood.api.service.PersonneService;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/personne")
public class PersonneController {

    @Autowired
    PersonneService personneService;

    @GetMapping("")
    public List<Personne> list() {
        return personneService.listAllPersonne();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Personne> get(@PathVariable Integer id) {
        try {
            Personne personne = personneService.getPersonne(id);
            return new ResponseEntity<Personne>(personne, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Personne>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping("")
    public void add(@RequestBody Personne personne) {
        personneService.savePersonne(personne);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Personne personne, @PathVariable Integer id) {
        try {
            personne.setId(id);
            personneService.updatePersonne(personne);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {

        personneService.deletePersonne(id);
    }
}
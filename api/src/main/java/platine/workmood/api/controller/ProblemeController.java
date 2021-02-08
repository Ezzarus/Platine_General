package platine.workmood.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import platine.workmood.api.model.Probleme;
import platine.workmood.api.service.ProblemeService;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/probleme")
public class ProblemeController {

    @Autowired
    ProblemeService problemeService;

    @GetMapping("")
    public List<Probleme> list() {
        return problemeService.listAllProbleme();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Probleme> get(@PathVariable Integer id) {
        try {
            Probleme probleme = problemeService.getProbleme(id);
            return new ResponseEntity<Probleme>(probleme, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Probleme>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping("")
    public void add(@RequestBody Probleme probleme) {
        problemeService.saveProbleme(probleme);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Probleme probleme, @PathVariable Integer id) {
        try {
            probleme.setId(id);
            problemeService.updateProbleme(probleme);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {

        problemeService.deleteProbleme(id);
    }
}

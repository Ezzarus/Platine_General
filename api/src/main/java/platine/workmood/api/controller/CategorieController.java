package platine.workmood.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import platine.workmood.api.model.Categorie;
import platine.workmood.api.service.CategorieService;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/categorie")
public class CategorieController {

    @Autowired
    CategorieService categorieService;

    @GetMapping("")
    public List<Categorie> list() {
        return categorieService.listAllCategorie();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Categorie> get(@PathVariable Integer id) {
        try {
            Categorie categorie = categorieService.getCategorie(id);
            return new ResponseEntity<Categorie>(categorie, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Categorie>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping("")
    public void add(@RequestBody Categorie categorie) {
        categorieService.saveCategorie(categorie);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Categorie categorie, @PathVariable Integer id) {
        try {
            categorie.setId(id);
            categorieService.updateCategorie(categorie);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {

        categorieService.deleteCategorie(id);
    }
}

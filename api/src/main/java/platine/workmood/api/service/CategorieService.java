package platine.workmood.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import platine.workmood.api.model.Categorie;
import platine.workmood.api.repository.CategorieRepository;

import java.util.List;

@Service
@Transactional
public class CategorieService {

    @Autowired
    private CategorieRepository categorieRepository;

    public List<Categorie> listAllCategorie() {
        return categorieRepository.findAll();
    }

    public Categorie getCategorie(Integer id) {
        return categorieRepository.findById(id).get();
    }

    public void saveCategorie(Categorie categorie) {
        categorieRepository.save(categorie);
    }

    public void updateCategorie(Categorie categorie) {
        categorieRepository.save(categorie);
    }

    public void deleteCategorie(Integer id) {
        categorieRepository.deleteById(id);
    }
}

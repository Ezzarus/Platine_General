package platine.workmood.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import platine.workmood.api.model.Personne;
import platine.workmood.api.repository.PersonneRepository;

import java.util.List;

@Service
@Transactional
public class PersonneService {

    @Autowired
    private PersonneRepository personneRepository;

    public List<Personne> listAllPersonne() {
        return personneRepository.findAll();
    }

    public Personne getPersonne(Integer id) {
        return personneRepository.findById(id).get();
    }

    public void savePersonne(Personne personne) {
        personneRepository.save(personne);
    }

    public void updatePersonne(Personne personne) {
        personneRepository.save(personne);
    }

    public void deletePersonne(Integer id) {
        personneRepository.deleteById(id);
    }
}

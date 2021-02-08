package platine.workmood.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import platine.workmood.api.model.Statut;
import platine.workmood.api.repository.StatutRepository;

import java.util.List;

@Service
@Transactional
public class StatutService {

    @Autowired
    private StatutRepository statutRepository;

    public List<Statut> listAllStatut() {
        return statutRepository.findAll();
    }

    public Statut getStatut(Integer id) {
        return statutRepository.findById(id).get();
    }

    public void saveStatut(Statut statut) {
        statutRepository.save(statut);
    }

    public void updateStatut(Statut statut) {
        statutRepository.save(statut);
    }

    public void deleteStatut(Integer id) {
        statutRepository.deleteById(id);
    }
}

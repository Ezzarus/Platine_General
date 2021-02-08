package platine.workmood.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import platine.workmood.api.model.Probleme;
import platine.workmood.api.repository.ProblemeRepository;

import java.util.List;

@Service
@Transactional
public class ProblemeService {

    @Autowired
    private ProblemeRepository problemeRepository;

    public List<Probleme> listAllProbleme() {
        return problemeRepository.findAll();
    }

    public Probleme getProbleme(Integer id) {
        return problemeRepository.findById(id).get();
    }

    public void saveProbleme(Probleme probleme) {
        problemeRepository.save(probleme);
    }

    public void updateProbleme(Probleme probleme) {
        problemeRepository.save(probleme);
    }

    public void deleteProbleme(Integer id) {
        problemeRepository.deleteById(id);
    }


}

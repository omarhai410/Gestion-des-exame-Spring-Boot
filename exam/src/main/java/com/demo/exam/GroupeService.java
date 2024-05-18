package com.demo.exam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class GroupeService {

    @Autowired
    private GroupeRepository groupeRepository;

    public List<Groupe> getAllGroupes() {
        return groupeRepository.findAll();
    }

    public Optional<Groupe> getGroupeById(Long id) {
        return groupeRepository.findById(id);
    }

    public Groupe saveOrUpdateGroupe(Groupe groupe) {
        return groupeRepository.save(groupe);
    }

    public void deleteGroupe(Long id) {
        groupeRepository.deleteById(id);
    }


}

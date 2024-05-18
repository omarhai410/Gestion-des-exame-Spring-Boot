package com.demo.exam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PersonnelService {

    @Autowired
    private PersonnelRepository personnelRepository;

    public List<Personnel> getAllPersonnel() {
        return personnelRepository.findAll();
    }

    public Optional<Personnel> getPersonnelById(Long id) {
        return personnelRepository.findById(id);
    }

    public Personnel saveOrUpdatePersonnel(Personnel personnel) {
        return personnelRepository.save(personnel);
    }

    public void deletePersonnel(Long id) {
        personnelRepository.deleteById(id);
    }
}

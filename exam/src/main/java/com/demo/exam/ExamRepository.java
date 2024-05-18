package com.demo.exam;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExamRepository extends JpaRepository<Exam, Long> {
    List<Exam> findByElementPedagogiqueName(String elementPedagogiqueName);
    List<Exam> findBySemester(String semester);
    List<Exam> findBySession(String session);
    // Ajoutez d'autres méthodes de recherche personnalisées si nécessaire
    List<Exam> findByDateAndStartTime(String date, String startTime);

}


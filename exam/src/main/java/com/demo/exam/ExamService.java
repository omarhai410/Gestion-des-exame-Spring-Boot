package com.demo.exam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExamService {

    @Autowired
    private ExamRepository examRepository;

    public void addExam(Exam exam) {
        if (areControllersAndInvigilatorsAvailable(exam)) {
            examRepository.save(exam);
        } else {
            // Gérer la situation où les contrôleurs d'absence ou les surveillants ne sont pas disponibles
            throw new RuntimeException("Impossible d'ajouter l'examen. Les contrôleurs d'absence ou les surveillants ne sont pas disponibles.");
        }
    }

    public List<Exam> searchExams(String element, String semester, String session) {
        // Vous pouvez ajouter la logique de recherche en fonction des critères fournis
        if (element != null && !element.isEmpty()) {
            // Recherche par nom d'élément pédagogique
            return examRepository.findByElementPedagogiqueName(element);
        } else if (semester != null && !semester.isEmpty()) {
            // Recherche par semestre
            return examRepository.findBySemester(semester);
        } else if (session != null && !session.isEmpty()) {
            // Recherche par session
            return examRepository.findBySession(session);
        } else {
            // Aucun critère de recherche spécifié, renvoie tous les examens
            return examRepository.findAll();
        }
    }
    public List<Exam> findByElementPedagogiqueName(String elementPedagogiqueName) {
        return examRepository.findByElementPedagogiqueName(elementPedagogiqueName);
    }

    public List<Exam> findBySemester(String semester) {
        return examRepository.findBySemester(semester);
    }

    public List<Exam> findBySession(String session) {
        return examRepository.findBySession(session);
    }

    public List<Exam> getAllExams() {
        return examRepository.findAll();
    }

    public void deleteExamById(Long examId) {
        Optional<Exam> optionalExam = examRepository.findById(examId);
        if (optionalExam.isPresent()) {
            examRepository.deleteById(examId);
        }
    }

    public boolean areControllersAndInvigilatorsAvailable(Exam exam) {
        List<String> controllers = exam.getAbsenceControllers();
        List<String> invigilators = exam.getInvigilators();

        List<Exam> scheduledExams = examRepository.findByDateAndStartTime(exam.getDate(), exam.getStartTime());

        for (Exam scheduledExam : scheduledExams) {
            List<String> scheduledControllers = scheduledExam.getAbsenceControllers();
            for (String controller : controllers) {
                if (scheduledControllers.contains(controller)) {
                    return false;
                }
            }
        }

        for (Exam scheduledExam : scheduledExams) {
            List<String> scheduledInvigilators = scheduledExam.getInvigilators();
            for (String invigilator : invigilators) {
                if (scheduledInvigilators.contains(invigilator)) {
                    return false;
                }
            }
        }

        return true;
    }
}

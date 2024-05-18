package com.demo.exam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class ExamController {

    @Autowired
    private ExamService examService;

    @GetMapping("/exams/add")
    public String showAddExamForm(Model model) {
        model.addAttribute("exam", new Exam());
        return "exam";
    }

    @PostMapping("/exams/add")
    public String addExam(@ModelAttribute("exam") Exam exam, RedirectAttributes redirectAttributes) {
        if (!examService.areControllersAndInvigilatorsAvailable(exam)) {
            redirectAttributes.addFlashAttribute("errorMessage", "Les contrôleurs d'absence ou les surveillants ne sont pas disponibles.");
            return "redirect:/exams/add"; // Redirigez l'utilisateur vers la page d'ajout d'examen
        }

        examService.addExam(exam);
        return "redirect:/exams/add"; // Redirigez l'utilisateur vers la page d'ajout d'examen
    }

    @GetMapping("/search")
    public String searchExams(
            @RequestParam(required = false) String elementPedagogiqueName,
            @RequestParam(required = false) String semester,
            @RequestParam(required = false) String session,
            Model model) {

        List<Exam> exams;

        if (elementPedagogiqueName != null) {
            exams = examService.findByElementPedagogiqueName(elementPedagogiqueName);
        } else if (semester != null) {
            exams = examService.findBySemester(semester);
        } else if (session != null) {
            exams = examService.findBySession(session);
        } else {
            // Si aucun paramètre de recherche n'est fourni, renvoyer tous les examens
            exams = examService.getAllExams();
        }

        model.addAttribute("exams", exams);
        return "exam";
    }

    @PostMapping("/exams/delete")
    public String deleteExam(@RequestParam("examId") Long examId) {
        examService.deleteExamById(examId);
        return "redirect:/search"; // Redirigez l'utilisateur vers la page de recherche après la suppression
    }
}

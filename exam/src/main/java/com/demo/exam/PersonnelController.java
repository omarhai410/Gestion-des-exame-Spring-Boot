package com.demo.exam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/personnel")
public class PersonnelController {

    @Autowired
    private PersonnelService personnelService;

    @GetMapping("/")
    public String getAllPersonnel(Model model) {
        List<Personnel> personnelList = personnelService.getAllPersonnel();
        model.addAttribute("personnelList", personnelList);
        return "personnel";
    }

    @GetMapping("/details/{id}")
    public String getPersonnelDetails(@PathVariable("id") Long id, Model model) {
        Optional<Personnel> personnel = personnelService.getPersonnelById(id);
        model.addAttribute("selectedPersonnel", personnel.orElse(null));
        return "personnel";
    }

    @PostMapping("/create")
    public String createPersonnel(@ModelAttribute Personnel personnel) {
        personnelService.saveOrUpdatePersonnel(personnel);
        return "redirect:/personnel/";
    }

    @GetMapping("/delete/{id}")
    public String deletePersonnel(@PathVariable("id") Long id) {
        personnelService.deletePersonnel(id);
        return "redirect:/personnel/";
    }
}

package com.demo.exam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/groupes")
public class GroupeController {

    @Autowired
    private GroupeService groupeService;

    @GetMapping("/")
    public String getAllGroupes(Model model) {
        List<Groupe> groupeList = groupeService.getAllGroupes();
        model.addAttribute("groupeList", groupeList);
        return "personnel";
    }

    @GetMapping("/details/{id}")
    public String getGroupeDetails(@PathVariable("id") Long id, Model model) {
        Optional<Groupe> groupe = groupeService.getGroupeById(id);
        model.addAttribute("selectedGroupe", groupe.orElse(null));
        return "personnel";
    }

    @PostMapping("/create")
    public String createGroupe(@ModelAttribute Groupe groupe) {
        groupeService.saveOrUpdateGroupe(groupe);
        return "redirect:/groupes/";
    }

    @GetMapping("/delete/{id}")
    public String deleteGroupe(@PathVariable("id") Long id) {
        groupeService.deleteGroupe(id);
        return "redirect:/groupes/";
    }
}

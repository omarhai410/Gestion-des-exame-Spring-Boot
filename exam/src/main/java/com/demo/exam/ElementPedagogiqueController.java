package com.demo.exam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/element")
public class ElementPedagogiqueController {
    @Autowired
    private ElementPedagogiqueService elementPedagogiqueService;

    @GetMapping
    public String getAllElementsPedagogiques(Model model) {
        List<ElementPedagogique> elementsPedagogiques = elementPedagogiqueService.getAllElementsPedagogiques();
        model.addAttribute("elementsPedagogiques", elementsPedagogiques);
        model.addAttribute("newElement", new ElementPedagogique()); // Pour le formulaire d'ajout
        return "element"; // Retourne le nom de la vue à résoudre (element.html)
    }

    @PostMapping("/add")
    public String addElementPedagogique(@ModelAttribute ElementPedagogique elementPedagogique) {
        elementPedagogiqueService.addElementPedagogique(elementPedagogique);
        return "redirect:/element"; // Redirection vers la page d'éléments après l'ajout
    }

    @PostMapping("/update/{id}")
    public String updateElementPedagogique(@PathVariable Long id, @ModelAttribute ElementPedagogique updatedElementPedagogique) {
        elementPedagogiqueService.updateElementPedagogique(id, updatedElementPedagogique);
        return "redirect:/element"; // Redirection vers la page d'éléments après la mise à jour
    }

    @PostMapping("/delete/{id}")
    public String deleteElementPedagogique(@PathVariable Long id) {
        elementPedagogiqueService.deleteElementPedagogique(id);
        return "redirect:/element"; // Redirection vers la page d'éléments après la suppression
    }
}

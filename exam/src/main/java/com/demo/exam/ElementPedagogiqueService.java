package com.demo.exam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ElementPedagogiqueService {
    @Autowired
    private ElementPedagogiqueRepository elementPedagogiqueRepository;

    public List<ElementPedagogique> getAllElementsPedagogiques() {
        return elementPedagogiqueRepository.findAll();
    }

    public ElementPedagogique getElementPedagogiqueById(Long id) {
        return elementPedagogiqueRepository.findById(id).orElse(null);
    }

    public ElementPedagogique addElementPedagogique(ElementPedagogique elementPedagogique) {
        return elementPedagogiqueRepository.save(elementPedagogique);
    }

    public void deleteElementPedagogique(Long id) {
        elementPedagogiqueRepository.deleteById(id);
    }

    public ElementPedagogique updateElementPedagogique(Long id, ElementPedagogique updatedElementPedagogique) {
        if (elementPedagogiqueRepository.existsById(id)) {
            updatedElementPedagogique.setId(id);
            return elementPedagogiqueRepository.save(updatedElementPedagogique);
        }
        return null;
    }
}

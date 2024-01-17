package net.ndiayeinf.categorieservice.web;

import net.ndiayeinf.categorieservice.entities.Categorie;
import net.ndiayeinf.categorieservice.repository.CategorieRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CategorieRestController {

    private CategorieRepository categorieRepository;

    public CategorieRestController(CategorieRepository categorieRepository) {
        this.categorieRepository = categorieRepository;
    }

    @GetMapping("/categories")
    public List<Categorie> categorieList() {
        return categorieRepository.findAll();
    }

    @GetMapping("/categories/{id}")
    public Categorie categorieById(@PathVariable Long id) {
        return categorieRepository.findById(id).get();
    }
}

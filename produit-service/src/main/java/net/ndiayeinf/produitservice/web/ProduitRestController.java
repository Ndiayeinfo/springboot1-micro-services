package net.ndiayeinf.produitservice.web;

import net.ndiayeinf.produitservice.clients.CategorieRestClient;
import net.ndiayeinf.produitservice.entities.Produit;
import net.ndiayeinf.produitservice.model.Categorie;
import net.ndiayeinf.produitservice.repository.ProduitRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProduitRestController {

    private ProduitRepository produitRepository;
    private CategorieRestClient categorieRestClient;

    public ProduitRestController(ProduitRepository produitRepository, CategorieRestClient categorieRestClient) {
        this.produitRepository = produitRepository;
        this.categorieRestClient = categorieRestClient;
    }

    @GetMapping("/produits")
    public List<Produit> produitList() {
        List<Produit> produitList = produitRepository.findAll();
        produitList.forEach(produit -> {
            produit.setCategorieParent(categorieRestClient.findCategorieById(produit.getCategorieId()));
        });
        return produitList;
    }

    @GetMapping("/produits/{id}")
    public Produit produitById(@PathVariable Long id) {
        Produit produit = produitRepository.findById(id).get();
        Categorie categorie = categorieRestClient.findCategorieById(produit.getCategorieId());
        produit.setCategorieParent(categorie);
        return produit;
    }
}

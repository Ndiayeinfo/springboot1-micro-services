package net.ndiayeinf.produitservice.clients;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import net.ndiayeinf.produitservice.model.Categorie;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "CATEGORIE-SERVICE")
public interface CategorieRestClient {
    @CircuitBreaker(name = "categorieService", fallbackMethod = "getDefaultCategorie")
    @GetMapping("/api/categories/{id}")
    Categorie findCategorieById(@PathVariable Long id);

    @CircuitBreaker(name = "categorieService", fallbackMethod = "getAllCategories")
    @GetMapping("/api/categories")
    List<Categorie> allCategories();

    default Categorie getDefaultCategorie(Long id, Exception exception) {
        Categorie categorie = new Categorie();
        categorie.setId(id);
        categorie.setNom("NOT AVAILABLE");
        categorie.setDescription("NOT AVAILABLE");
        return categorie;
    }

    default List<Categorie> getAllCategories(Exception exception) {
        return List.of();
    }
}

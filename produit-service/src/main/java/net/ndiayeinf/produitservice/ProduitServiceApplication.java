package net.ndiayeinf.produitservice;

import net.ndiayeinf.produitservice.clients.CategorieRestClient;
import net.ndiayeinf.produitservice.entities.Produit;
import net.ndiayeinf.produitservice.repository.ProduitRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@EnableFeignClients
@SpringBootApplication
public class ProduitServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProduitServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(ProduitRepository produitRepository,
                                        CategorieRestClient categorieRestClient) {
        return args -> {
            categorieRestClient.allCategories().forEach(c -> {
                Produit produit1 = Produit.builder()
                        .nom("Smart Phone")
                        .prix(Math.random() * 80000)
                        .categorieId(Long.valueOf(c.getId()))
                        .build();
                Produit produit2 = Produit.builder()
                        .nom("Nike")
                        .prix(Math.random() * 65432)
                        .categorieId(Long.valueOf(c.getId()))
                        .build();
                Produit produit3 = Produit.builder()
                        .nom("Tesla")
                        .prix(Math.random() * 100000)
                        .categorieId(Long.valueOf(c.getId()))
                        .build();
                produitRepository.save(produit1);
                produitRepository.save(produit2);
                produitRepository.save(produit3);
            });
        };
    }

}

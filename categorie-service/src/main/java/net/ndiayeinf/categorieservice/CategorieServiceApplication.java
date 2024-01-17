package net.ndiayeinf.categorieservice;

import net.ndiayeinf.categorieservice.entities.Categorie;
import net.ndiayeinf.categorieservice.repository.CategorieRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CategorieServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CategorieServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(CategorieRepository categorieRepository) {
        return args -> {
            List<Categorie> categorieList = List.of(
                    Categorie.builder()
                            .nom("Electronique")
                            .description("Electronique")
                            .build(),
                    Categorie.builder()
                            .nom("Sport")
                            .description("Sport")
                            .build()
            );
            categorieRepository.saveAll(categorieList);
        };
    }
}

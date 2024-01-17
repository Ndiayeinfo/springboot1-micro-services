package net.ndiayeinf.categorieservice.repository;

import net.ndiayeinf.categorieservice.entities.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategorieRepository extends JpaRepository<Categorie, Long> {
}

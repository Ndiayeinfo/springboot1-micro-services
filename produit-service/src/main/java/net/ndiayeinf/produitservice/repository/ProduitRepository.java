package net.ndiayeinf.produitservice.repository;

import net.ndiayeinf.produitservice.entities.Produit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProduitRepository extends JpaRepository<Produit, Long> {
}

package net.ndiayeinf.produitservice.entities;

import jakarta.persistence.*;
import lombok.*;
import net.ndiayeinf.produitservice.model.Categorie;


@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Produit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private double prix;
    private String description;
    @Transient
    private Categorie categorieParent;
    private Long categorieId;
}

package net.ndiayeinf.produitservice.model;

import jakarta.persistence.Entity;
import lombok.*;

@Getter
@Setter
@ToString
public class Categorie {
    private Long id;
    private String nom;
    private String description;
}

package com.maissaude.api.entity;

import jakarta.persistence.*;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "clinica")
public class Clinica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 255)
    private String nome;

    @Column(nullable = false, unique = true, length = 18)
    private String cnpj;

    @Column(length = 255)
    private String endereco;

    // Muitos-para-muitos com Medico (lado inverso)
    @ManyToMany(mappedBy = "clinicas")
    @JsonIgnore
    private Set<Medico> medicos = new HashSet<>();

    // Uma clínica tem muitas consultas (1:N)
    @OneToMany(mappedBy = "clinica", cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Consulta> consultas = new HashSet<>();
}
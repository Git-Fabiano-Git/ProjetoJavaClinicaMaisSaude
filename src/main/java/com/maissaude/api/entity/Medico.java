package com.maissaude.api.entity;

import jakarta.persistence.*;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "medico")
public class Medico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 255)
    private String nome;

    @Column(nullable = false, unique = true, length = 20)
    private String crm;

    @Column(nullable = false, length = 100)
    private String email;

    @Column(nullable = false, unique = true, length = 11)
    private String telefone;

    @Column(nullable = false)
    private Boolean ativo;

    // Muitos-para-muitos com Especialidade
    @ManyToMany
    @JoinTable(
            name = "medico_especialidade",
            joinColumns = @JoinColumn(name = "id_medico"),
            inverseJoinColumns = @JoinColumn(name = "id_especialidade")
    )
    private Set<Especialidade> especialidades = new HashSet<>();

    // Muitos-para-muitos com Clinica
    @ManyToMany
    @JoinTable(
            name = "medico_clinica",
            joinColumns = @JoinColumn(name = "id_medico"),
            inverseJoinColumns = @JoinColumn(name = "id_clinica")
    )
    private Set<Clinica> clinicas = new HashSet<>();

    // Um-para-muitos com Consulta (lado inverso)
    @OneToMany(mappedBy = "medico", cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Consulta> consultas = new HashSet<>();
}
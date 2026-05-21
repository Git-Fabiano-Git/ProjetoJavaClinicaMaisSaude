package com.maissaude.api.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "consulta")
public class Consulta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private LocalDateTime dataHora;

    @Column(nullable = false, length = 20)
    private String status;  // AGENDADA, REALIZADA, CANCELADA

    @Column(columnDefinition = "TEXT")
    private String observacao;

    // Relacionamento N:1 com Medico
    @ManyToOne
    @JoinColumn(name = "id_medico", nullable = false)
    private Medico medico;

    // Relacionamento N:1 com Paciente
    @ManyToOne
    @JoinColumn(name = "id_paciente", nullable = false)
    private Paciente paciente;

    // Relacionamento N:1 com Clinica
    @ManyToOne
    @JoinColumn(name = "id_clinica", nullable = false)
    private Clinica clinica;
}
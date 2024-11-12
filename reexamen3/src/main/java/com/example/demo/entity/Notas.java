package com.example.demo.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="notas")
public class Notas {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long idnota;
    @Column(name="nota1")
    private Double nota1;
    @Column(name="nota2")
    private Double nota2;
    @Column(name="nota3")
    private Double nota3;
    @Column(name="promedio")
    private Double promedio;
    
    @ManyToOne
    @JoinColumn(name="idalumno", referencedColumnName = "idalumno", nullable = false)
    private Alumnos alumnos;
    @ManyToOne
    @JoinColumn(name="idcurso", referencedColumnName = "idcurso", nullable = false)
    private Cursos cursos;
}

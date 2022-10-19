package co.edu.uniquindio.proyecto.entidades;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class Consultation implements Serializable
{
    //llave primaria examen
    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_consultation")
    private Integer id_consultation;

    //Atributo fecha cita
    @Column(nullable = false)
    private LocalDate dateConsultation;

    //Atributo hora inicio de la cita
    @Column(nullable = false)
    private LocalTime startConsultation;

    //Atributo hora fin de la cita
    @Column(nullable = false)
    private LocalTime endConsultation;

    @Column(name = "status", nullable = false)
    private Integer status;

    //Relaciones

    //id del veterinario
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_veterinary")
    private Veterinary veterinary;

    //id de la mascota
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_pet")
    private Pet pet;

    //id del tipo de consulta
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_type_consultation")
    private TypeMedicalConsultation typeMedicalConsultation;

    //atencion veterinaria
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_veterinary_care")
    private VeterinaryCare veterinaryCare;
}

package com.tpdb2.tpdb2.model;
import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class Persona {
    private int id;

    private String apellido;
    private String nombre;
    private String dni;
    private Calle calle;
    

     //Evitamos recursividad
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @JsonBackReference
    private AfiliacionObraSocial afiliacionObraSocial;
}
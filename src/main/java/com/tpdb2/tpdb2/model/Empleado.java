package com.tpdb2.tpdb2.model;
import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Empleado extends Persona {
    private String cuil;

    
    //Evitamos recursividad
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @JsonBackReference
    private Sucursal sucursal;
}
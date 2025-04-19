package com.tpdb2.tpdb2.model;

import lombok.*;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Sucursal {
    private UUID id;
    private Calle calle;
    private Empleado encargado;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @JsonManagedReference
    private List<Empleado> empleados;
}

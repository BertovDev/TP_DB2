package com.tpdb2.tpdb2.model;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class AfiliacionObraSocial {
    private UUID id;
    private String numeroAfiliado;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @JsonManagedReference
    private Persona persona;
    private ObraSocial obraSocial;
}

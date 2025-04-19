package com.tpdb2.tpdb2.model;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Calle {
    private String calle;
    private String numero;
    private String localidad;
    private String provincia;
}
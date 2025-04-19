package com.tpdb2.tpdb2.model;

import lombok.*;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Producto {
    private UUID id;
    private String descripcion;
    private String tipo;
    private double precio;
}

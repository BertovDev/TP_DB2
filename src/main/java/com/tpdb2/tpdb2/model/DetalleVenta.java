package com.tpdb2.tpdb2.model;

import lombok.*;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DetalleVenta {
    private UUID id;
    private Producto producto;
    private int cantidad;
    private double precioUnitario;
    private double total;
}


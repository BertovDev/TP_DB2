package com.tpdb2.tpdb2.model;

import java.util.UUID;
import java.util.Date;
import java.util.List;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Venta {
    private UUID id;
    private String numeroTicket;
    private String puntoVenta; 
    private Date fecha;
    private double total;
    private String formaPago; 
    private Cliente cliente;
    private Empleado empleadoAtiende;
    private Empleado empleadoCobra;
    private Sucursal sucursal;
    private List<DetalleVenta> detalles;
}

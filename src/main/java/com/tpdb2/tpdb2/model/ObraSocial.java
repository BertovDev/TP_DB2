package com.tpdb2.tpdb2.model;

import lombok.*;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ObraSocial {
    private UUID id;
    private String nombre;
}

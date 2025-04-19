package com.tpdb2.tpdb2;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import com.tpdb2.tpdb2.model.AfiliacionObraSocial;
import com.tpdb2.tpdb2.model.Calle;
import com.tpdb2.tpdb2.model.Cliente;
import com.tpdb2.tpdb2.model.DetalleVenta;
import com.tpdb2.tpdb2.model.Empleado;
import com.tpdb2.tpdb2.model.ObraSocial;
import com.tpdb2.tpdb2.model.Producto;
import com.tpdb2.tpdb2.model.Sucursal;
import com.tpdb2.tpdb2.model.Venta;

public class DataGenerator {

    public static Venta GenerateVenta(Empleado empleadoAtiende, Calle calle1){
         // Crear domicilio
        Calle domicilioCliente = new Calle("Calle Falsa", "12223", "Springfield", "Provincia X");

        // Crear cliente

		Cliente cliente = new Cliente();
		cliente.setId(1);
		cliente.setNombre("Juan");
		cliente.setApellido("Perez");
		cliente.setDni("12345678");
		cliente.setCalle(domicilioCliente);


		// Calle calle1 = new Calle("Av. Siempre Viva", "742", "Springfield", "Buenos Aires");
		Calle calle2 = new Calle("Suipacha", "119", "Lanus", "Buenos Aires");

            
        Empleado empleadoCobra = new Empleado();
		empleadoCobra.setId(2);	
		empleadoCobra.setApellido("Berto");
		empleadoCobra.setNombre("Bautista");
		empleadoCobra.setDni("43199443");
		empleadoCobra.setCalle(calle2);
		empleadoCobra.setCuil("20-43199443-8");

        // Crear sucursal
        Sucursal sucursal = new Sucursal(
                UUID.randomUUID(),
                new Calle("Av. Central", "1000", "Springfield", "Provincia X"),
                empleadoAtiende,
                List.of(empleadoAtiende, empleadoCobra)
        );

        empleadoAtiende.setSucursal(sucursal);

        // Crear laboratorio

        // Crear productos
        Producto prod1 = new Producto(UUID.randomUUID(), "Ibuprofeno 400mg", "medicamento", 1500.0);
        Producto prod2 = new Producto(UUID.randomUUID(), "Shampoo", "perfumería", 2000.0);

        // Crear detalles de venta
        DetalleVenta det1 = new DetalleVenta(UUID.randomUUID(), prod1, 2, prod1.getPrecio(), 2 * prod1.getPrecio());
        DetalleVenta det2 = new DetalleVenta(UUID.randomUUID(), prod2, 1, prod2.getPrecio(), prod2.getPrecio());

        List<DetalleVenta> detalles = List.of(det1, det2);

        // Calcular total
        double total = detalles.stream().mapToDouble(DetalleVenta::getTotal).sum();

        // Crear venta
        Venta venta = new Venta(
                UUID.randomUUID(),
                "0001-00000001",
                "0001",
                new Date(),
                total,
                "tarjeta",
                cliente,
                empleadoAtiende,
                empleadoCobra,
                sucursal,
                detalles
        );

        System.out.println("Venta creada");

        return venta;
    }

    public static AfiliacionObraSocial GenerateAfiliadoObraSocial(Empleado empleado, Calle calle1 ){

        ObraSocial obraSocial = new ObraSocial(UUID.randomUUID(),"Osde");

        AfiliacionObraSocial afiliado =  new AfiliacionObraSocial(UUID.randomUUID(),"AF1",empleado,obraSocial);
        empleado.setAfiliacionObraSocial(afiliado);
        return afiliado;
    }

    public static Sucursal GenerateSucursal(Empleado encargado, Calle calle){

        Empleado empleado1 = new Empleado();
		empleado1.setId(4);	
		empleado1.setApellido("Berto");
		empleado1.setNombre("Bautista");
		empleado1.setDni("43199443");
		empleado1.setCalle(calle);
		empleado1.setCuil("20-43199443-8");

        Empleado empleado2 = new Empleado();
		empleado2.setId(32);	
		empleado2.setApellido("nes");
		empleado2.setNombre("Jijo");
		empleado2.setDni("43192243");
		empleado2.setCalle(calle);
		empleado2.setCuil("20-43192243-8");

        List<Empleado> empleados = List.of(encargado, empleado1, empleado2);

        Sucursal sucursal = new Sucursal(UUID.randomUUID(),calle,encargado, empleados);
        return sucursal;
    }

}

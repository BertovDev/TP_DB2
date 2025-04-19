package com.tpdb2.tpdb2;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.tpdb2.tpdb2.model.Calle;
import com.tpdb2.tpdb2.model.Cliente;
import com.tpdb2.tpdb2.model.DetalleVenta;
import com.tpdb2.tpdb2.model.Empleado;
import com.tpdb2.tpdb2.model.Producto;
import com.tpdb2.tpdb2.model.Sucursal;
import com.tpdb2.tpdb2.model.Venta;

import java.io.File;

@SpringBootApplication
public class Tpdb2Application {

	private static String PATH = "./jsons";

	public static void main(String[] args) {
		SpringApplication.run(Tpdb2Application.class, args);

			try {

			//Creo un empleado y una calle asi reuso
			Calle calle1 = new Calle("Av. Siempre Viva", "742", "Springfield", "Buenos Aires");
			Empleado empleadoAtiende = new Empleado();
			empleadoAtiende.setId(1);	
			empleadoAtiende.setApellido("Messi");
			empleadoAtiende.setNombre("Lionel");
			empleadoAtiende.setDni("87654321");
			empleadoAtiende.setCalle(calle1);
			empleadoAtiende.setCuil("20-12345678-9");

			ObjectMapper mapper = new ObjectMapper();
			mapper.enable(SerializationFeature.INDENT_OUTPUT);
			
			// //Venta
			File file = new File(PATH + "/venta.json");
			mapper.writeValue(file, DataGenerator.GenerateVenta(empleadoAtiende, calle1));

		    //Afiliado
			File afiliadoFile = new File(PATH + "/afiliado.json");
			mapper.writeValue(afiliadoFile, DataGenerator.GenerateAfiliadoObraSocial(empleadoAtiende, calle1));

			//Empleado
			File empleadoFile = new File(PATH + "/empleado.json");
			mapper.writeValue(empleadoFile, empleadoAtiende);

			//Sucursal

			File sucursalFile = new File(PATH + "/sucursal.json");
			mapper.writeValue(sucursalFile, DataGenerator.GenerateSucursal(empleadoAtiende,calle1));

		} catch(Exception e) {
			e.printStackTrace();
		}
        System.out.println("estructura.json generado correctamente.");

	}

}

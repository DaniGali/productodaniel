package org.jesuitasrioja.HolaMundo.controllers;

import java.util.ArrayList;
import java.util.List;

import org.jesuitasrioja.HolaMundo.modelo.Producto;
import org.jesuitasrioja.HolaMundo.repository.IProductosRepository;
import org.jesuitasrioja.HolaMundo.repository.ProductosRepository;
import org.jesuitasrioja.HolaMundo.repository.ProductosRepositoryMongoDB;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST})
public class ProductoController {

	private IProductosRepository pr = new ProductosRepositoryMongoDB();

	@GetMapping("/productos")
	public List<Producto> allProducts() {
		
		return pr.getAll();
	}

	@GetMapping("/producto/{id}")
	public Producto getProducto(@PathVariable String id) {

		return pr.getById(id);
	}

	@GetMapping("/producto")
	public Producto getProducto2(@RequestParam(value = "id") String id) {
		return pr.getById(id);
	}

	@PostMapping("/producto")
	public String postProducto(@RequestBody Producto nuevo) {

		return String.valueOf(pr.aniadirProducto(nuevo));
	}

	@PutMapping("/producto/{id}")
	public String putProducto(@RequestBody Producto editado, @PathVariable String id) {

		return null;
	}

	@DeleteMapping("/producto")
	public String deleteProducto(String id) {
		return String.valueOf(pr.eliminarProducto(id));
	}

//	@GetMapping("/saludos/{nombre}")
//	public String getSaludo(@PathVariable String nombre) {
//		return "Hola "+nombre;
//	}
//	
//	@GetMapping("/saludos")
//	public String getSaludo(@RequestParam String nombre) {
//		return "Hola "+nombre;
//	}
//	
//	@PostMapping("/saludos")
//	public String postSaludo(@RequestBody String cuerpo) {
//		System.out.println("----Cuerpo----");
//		System.out.println(cuerpo);
//		return cuerpo;
//	}
//	
//	@DeleteMapping("/saludos")
//	public String deleteSaludo() {
//		return "Hola Mundo Delete";
//	}
//	
//	@PutMapping("/saludos")
//	public String putSaludo() {
//		return "Hola Mundo Put";
//	}
}

package org.jesuitasrioja.HolaMundo.controllers;

import java.util.ArrayList;
import java.util.List;

import org.jesuitasrioja.HolaMundo.modelo.Producto;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductoController {
	
	@GetMapping("/productos")
	public List<Producto> allProducts(){
		List<Producto> listaProducto= new ArrayList<>();
		listaProducto.add(new Producto("1", "patata", 1.50));
		listaProducto.add(new Producto("2", "tomate", 2.50));
		listaProducto.add(new Producto("3", "lechuga", 3.50));
		
		return listaProducto;
	}
	
	@GetMapping("/producto/{id}")
	public Producto getProducto(@PathVariable String id) {
		
		return new Producto("1", "patata", 1.50);
	}
	
	@GetMapping("/producto")
	public Producto getProducto2(@RequestParam(value="id") String id) {
		return new Producto("1", "patata", 1.50);
	}
	
	@PostMapping("/producto")
	public Producto postProducto(@RequestBody Producto nuevo) {
		
		return null;
	}
	
	@PutMapping("/producto/{id}")
	public Producto putProducto(@RequestBody Producto editado, @PathVariable String id) {
		
		return null;
	}
	
	@DeleteMapping("/producto")
	public Producto deleteProducto() {
		 return null;
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

package org.jesuitasrioja.HolaMundo.repository;

import java.util.List;

import org.jesuitasrioja.HolaMundo.modelo.Producto;

public interface IProductosRepository {

	Producto getById(String id);

	List<Producto> getAll();

	boolean aniadirProducto(Producto producto);

	boolean eliminarProducto(String id);

}
package org.jesuitasrioja.HolaMundo.repository;

import java.util.List;

import org.bson.Document;
import org.jesuitasrioja.HolaMundo.modelo.Producto;

import com.google.gson.Gson;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;

public class ProductosRepositoryMongoDB implements IProductosRepository {

	private MongoCollection<Document> collection;

	public ProductosRepositoryMongoDB() {
		MongoClient mongo = new MongoClient("localhost", 27017);
		MongoDatabase database = mongo.getDatabase("productosDB");
		collection = database.getCollection("productos");
	}

	/**
	 * @return El producto con el id passado por parametro
	 */
	@Override
	public Producto getById(String id) {
		Document productosDocument = collection.find(Filters.eq("id", id)).first();
		Producto p = null;
		if (productosDocument != null) {
			p = documentToProducto(productosDocument);
		}
		return p;

	}

	@Override
	public List<Producto> getAll() {

		return null;
	}

	@Override
	public boolean aniadirProducto(Producto producto) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean eliminarProducto(String id) {
		// TODO Auto-generated method stub
		return false;
	}

	private Producto documentToProducto(Document productosDocument) {
		Producto p;
		Gson gson = new Gson();
		String productoJSON = productosDocument.toJson();
		p = gson.fromJson(productoJSON, Producto.class);
		return p;
	}

}

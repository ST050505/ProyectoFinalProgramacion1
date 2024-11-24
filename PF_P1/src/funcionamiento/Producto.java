package funcionamiento;

public class Producto implements ManejadorDeInventario {
	
	private int idProducto;
	private String nombre;
	private String marca;
	private double precio;
	private int cantidadDeInventario;
	
	public Producto(int idProducto, String nombre, String marca, double precio, 
	int cantidadDeInventario) {
		
		this.idProducto = idProducto;
		this.nombre = nombre;
		this.marca = marca;
		this.precio = precio;
		this.cantidadDeInventario = cantidadDeInventario;
	}
	
	//Metodos implementacion de interfaz ManejadorDeInventario

	@Override
	public void agregarproducto(Producto producto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actualizarProducto(Producto producto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminarProducto(int idProducto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Producto consultarProducto(int idProducto) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
}

package funcionamiento;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class Factura extends Documento implements ManejadorDeFacturacion{
	
	private Cliente cliente;
	static List<Producto> detallesFactura = new ArrayList<Producto>();

	public Factura(int idDocumento, Date fechaEmision, double montoTotal, Cliente cliente) {
		super(idDocumento, fechaEmision, montoTotal);
		this.cliente = cliente;
	}
	
	//Metodos de clase Factura
	
	public void calcularImpuesto() {}
	
	public void agregarProducto() {}
	
	//Metodos de herencia de clase abstracta Documento 

	@Override
	public String generarDocumento() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double calcularMontoTotal() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	//Metodos de las interfaz ManejadorDrFacturacion 

	@Override
	public Factura crearFactura(Cliente cliente, List<Producto> producto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Factura> listarFacturas() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double calcularTotales(Factura factura) {
		// TODO Auto-generated method stub
		return 0;
	}

}

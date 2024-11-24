package funcionamiento;

import java.sql.Date;
import java.util.List;

public class ReciboDePago extends Documento implements ManejadorDePagos {
	
	private Factura facturaAsociada;

	public ReciboDePago(int idDocumento, Date fechaEmision, double montoTotal, Factura facturaAsociada) {
		super(idDocumento, fechaEmision, montoTotal);
		this.facturaAsociada = facturaAsociada;
	}
	
	//Metodo de clase 
	
	public boolean validarMonto(double monto) {
		return false;
	}
	
	public String generarComprobante() {
		return null;
		
	}
	
	//Metodo de herencia de clase abstracta Documento 

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
	
	//Metodo de interfaces 

	@Override
	public ReciboDePago registrarPago(Factura factura, double monto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ReciboDePago> consultarPagos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean validarMontoPago(Factura factura, double monto) {
		// TODO Auto-generated method stub
		return false;
	}

}

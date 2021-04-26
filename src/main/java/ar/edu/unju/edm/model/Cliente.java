package ar.edu.unju.edm.model;

import java.time.LocalDate;
import java.time.Period;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

@Component
public class Cliente {
	private int nroDocumento;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	
	private LocalDate fechaNacimiento;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	
	private LocalDate fechaUltimaCompra;
private String nombreApellido;
	private String tipoDocumento;
	private int numTelefono;
	private int edad;
	private String email;
	private String password;
	private String datosAdicionales;
	private int codigoAreaTelefono;

	public Cliente() {
		// TODO Auto-generated constructor stub
	}

	public int getEdad() {
		return edad;
	}

	public String getDatosAdicionales() {
		return datosAdicionales;
	}

	public void setDatosAdicionales(String datosAdicionales) {
		this.datosAdicionales = datosAdicionales;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public LocalDate getFechaUltimaCompra() {
		return fechaUltimaCompra;
	}

	public void setFechaUltimaCompra(LocalDate fechaUltimaCompra) {
		this.fechaUltimaCompra = fechaUltimaCompra;
	}

	public String getNombreApellido() {
		return nombreApellido;
	}

	public void setNombreApellido(String nombreApellido) {
		this.nombreApellido = nombreApellido;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getNroDocumento() {
		return nroDocumento;
	}

	public void setNroDocumento(int nroDocumento) {
		this.nroDocumento = nroDocumento;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public int getCodigoAreaTelefono() {
		return codigoAreaTelefono;
	}

	public void setCodigoAreaTelefono(int codigoAreaTelefono) {
		this.codigoAreaTelefono = codigoAreaTelefono;
	}

	public int getNumTelefono() {
		return numTelefono;
	}

	public void setNumTelefono(int numTelefono) {
		this.numTelefono = numTelefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getTiempoDesdeUltimaCompra() {
		LocalDate fechaActual = LocalDate.now();
		Period periodo = Period.between(fechaUltimaCompra, fechaActual);
		return " T Desde Ultima Compra:  Año: " + periodo.getYears() + " Mes: " + periodo.getMonths() + " Dia: " + periodo.getDays();
	}
	

	public String getTiempoProxCumple() {
		LocalDate fechaActual= LocalDate.now();
        LocalDate fechaCumple= getFechaNacimiento();

        LocalDate proxCumple = fechaCumple.withYear(fechaActual.getYear());

        if (proxCumple.isBefore(fechaActual) || proxCumple.isEqual(fechaActual)) {
        	proxCumple = proxCumple.plusYears(1);
        }

        Period periodo = Period.between(fechaActual, proxCumple);
        return "T Hasta Prox Cumpleaños: " + " Mes: " + periodo.getMonths() + " Dia: " + periodo.getDays();
	}
}

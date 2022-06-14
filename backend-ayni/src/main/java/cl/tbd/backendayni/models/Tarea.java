package cl.tbd.backendayni.models;

import java.util.ArrayList;
import java.sql.Date;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan
public class Tarea{
	//ATRIBUTOS DE TAREA
    /**
	 * @param id de la tarea 
	 * @param id_emergencia de la tarea
	 * @param nombre de la tarea 
	 * @param descripcion de la tarea 
	 * @param fecha de la tarea 
	 * @param requerimientos de la tarea
	 * @param longitude de la tarea 
	 * @param latitude de la tarea 
	 */

	private long id;
	private long id_emergencia;
	private String nombre;
	private String descripcion;
	private Date fecha;
	private String requerimientos;
	private long longitude;
	private long latitude;

	//CONSTRUCTOR TAREA
	public Tarea(){
	}

	//CONSTRUCTOR TAREA
	public Tarea(long id, long id_emergencia, String nombre, String descripcion, Date fecha, String requerimientos, long longitude, long latitude){
		this.id = id;
		this.id_emergencia = id_emergencia;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.fecha = fecha;
		this.requerimientos = requerimientos;
		this.longitude = longitude;
		this.latitude = latitude;
	}

	//GETTERS TAREA

	/**
	 * @return id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @return id_emergencia
	 */
	public long getId_emergencia() {
		return id_emergencia;
	}

	/**
	 * @return nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @return descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * @return fecha
	 */
	public Date getFecha() {
		return fecha;
	}

	/**
	 * @return requerimientos
	 */
	public String getRequerimientos() {
		return requerimientos;
	}

	/**
	 * @return longitude
	 */
	public long getLongitude() {
		return longitude;
	}

	/**
	 * @return latitude
	 */
	public long getLatitude() {
		return latitude;
	}

	//SETTERS TAREA

	/**
	 * @param id de la tarea 
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @param id_emergencia de la tarea
	 */
	public void setId_emergencia(long id_emergencia) {
		this.id_emergencia = id_emergencia;
	}

	/**
	 * @param nombre de la tarea 
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @param descripcion de la tarea 
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * @param fecha de la tarea 
	 */
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	/**
	 * @param requerimientos de la tarea
	 */
	public void setRequerimientos(String requerimientos) {
		this.requerimientos = requerimientos;
	}

	/**
	 * @param longitude de la tarea 
	 */
	public void setLongitude(long longitude) {
		this.longitude = longitude;
	}

	/**
	 * @param latitude de la tarea 
	 */
	public void setLatitude(long latitude) {
		this.latitude = latitude;
	}

	//TOSTRING TAREA
	
	/**
	 * @return String con los datos de la tarea
	 */
	@Override
	public String toString() {
		return "Tarea [id=" + id + ", id_emergencia=" + id_emergencia + ", nombre=" + nombre + ", descripcion=" + descripcion + ", fecha=" + fecha + ", requerimientos=" + requerimientos + ", longitude=" + longitude + ", latitude=" + latitude + "]";
	}


}
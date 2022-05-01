package cl.tbd.backendayni.models;

import java.util.ArrayList;
import java.sql.Date;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan
public class Tarea{
	//ATRIBUTOS
    /**
	 * @param id de la tarea 
	 * @param nombre de la tarea 
	 * @param descripcion de la tarea 
	 * @param fecha de la tarea 
	 * @param longitud de la tarea 
	 * @param latitud de la tarea 
	 * @param tareaHabilidad de la tarea 
	 * @param estadoTarea de la tarea 
	 */

    private long id;
	private String nombre;
    private String descripcion;
    private Date fecha;
    private long longitud;
    private long latitud;
	private ArrayList<Habilidad> requerimientos;

    
    
	public Tarea(long id, String nombre, String descripcion, Date fecha, long longitud, long latitud) {
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.fecha = fecha;
		this.longitud = longitud;
		this.latitud = latitud;

	}


	public long getId() {
		return id;
	}


	public String getNombre(){
		return nombre;
	}


	public String getDescripcion(){
		return descripcion;
	}


	public Date getFecha(){
		return fecha;
	}


	public long getLongitud(){
		return longitud;
	}


	public long getLatitud(){
		return latitud;
	}



	public void setId(long id) {
		this.id = id;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}


	public void setLongitud(long longitud) {
		this.longitud = longitud;
	}


	public void setLatitud(long latitud) {
		this.latitud = latitud;
	}



	public ArrayList<Habilidad> getRequisitos() {
		return requerimientos;
	}

}
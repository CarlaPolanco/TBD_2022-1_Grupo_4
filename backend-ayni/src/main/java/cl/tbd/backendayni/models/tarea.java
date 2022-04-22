package cl.tbd.backendayni.models;

import java.util.Date;

public class Tarea{
    private long id;
	private String nombre;
    private String descripcion;
    private Date fecha;
    private long longitud;
    private long latitud;
    private TareaHabilidad tareaHabilidad;
    private EstadoTarea estadoTarea;

    /**
	 * @param id
	 * @param nombre
	 * @param descripcion
	 * @param fecha
	 * @param longitud
	 * @param latitud
	 * @param tareaHabilidad
	 * @param estadoTarea
	 */
	public Tarea(long id, String nombre, String descripcion, Date fecha, long longitud, long latitud,
			TareaHabilidad tareaHabilidad, EstadoTarea estadoTarea) {
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.fecha = fecha;
		this.longitud = longitud;
		this.latitud = latitud;
		this.tareaHabilidad = tareaHabilidad;
		this.estadoTarea = estadoTarea;
	}
	
    public long getId(){
        return id;
    }
    public String getNombre(){
        return nombre;
    }
	/**
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}
	/**
	 * @return the fecha
	 */
	public Date getFecha() {
		return fecha;
	}
	/**
	 * @return the longitud
	 */
	public long getLongitud() {
		return longitud;
	}
	/**
	 * @return the latitud
	 */
	public long getLatitud() {
		return latitud;
	}
	/**
	 * @return the tareaHabilidad
	 */
	public TareaHabilidad getTareaHabilidad() {
		return tareaHabilidad;
	}
	/**
	 * @return the estadoTarea
	 */
	public EstadoTarea getEstadoTarea() {
		return estadoTarea;
	}
	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
	 * @param descripcion the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	/**
	 * @param fecha the fecha to set
	 */
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	/**
	 * @param longitud the longitud to set
	 */
	public void setLongitud(long longitud) {
		this.longitud = longitud;
	}
	/**
	 * @param latitud the latitud to set
	 */
	public void setLatitud(long latitud) {
		this.latitud = latitud;
	}
	/**
	 * @param tareaHabilidad the tareaHabilidad to set
	 */
	public void setTareaHabilidad(TareaHabilidad tareaHabilidad) {
		this.tareaHabilidad = tareaHabilidad;
	}
	/**
	 * @param estadoTarea the estadoTarea to set
	 */
	public void setEstadoTarea(EstadoTarea estadoTarea) {
		this.estadoTarea = estadoTarea;
	}


}
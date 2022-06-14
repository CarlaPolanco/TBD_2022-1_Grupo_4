package cl.tbd.backendayni.models;


public class EstadoTarea {
	
	/**
	 * ATRIBUTOS DE EstadoTarea
	 * @param id del EstadoTarea
	 * @param id_estado del EstadoTarea
	 * @param id_tarea del EstadoTarea
	 */

	private long id;
	private long id_estado;
	private long id_tarea;

	//CONSTRUCTOR EstadoTarea
	public EstadoTarea(){
	}

	//CONSTRUCTOR EstadoTarea
	public EstadoTarea(long id, long id_estado, long id_tarea){
		this.id = id;
		this.id_estado = id_estado;
		this.id_tarea = id_tarea;
	}

	//GETTERS EstadoTarea

	/**
	 * @return id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @return id_estado
	 */
	public long getId_estado() {
		return id_estado;
	}

	/**
	 * @return id_tarea
	 */
	public long getId_tarea() {
		return id_tarea;
	}

	//SETTERS EstadoTarea

	/**
	 * @param id del EstadoTarea
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @param id_estado del EstadoTarea
	 */
	public void setId_estado(long id_estado) {
		this.id_estado = id_estado;
	}

	/**
	 * @param id_tarea del EstadoTarea
	 */
	public void setId_tarea(long id_tarea) {
		this.id_tarea = id_tarea;
	}

	//TOSTRING EstadoTarea

	/**
	 * @return String con los datos del EstadoTarea
	 */
	@Override
	public String toString() {
		return "EstadoTarea [id=" + id + ", id_estado=" + id_estado + ", id_tarea=" + id_tarea + "]";
	}
	
}

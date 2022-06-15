package cl.tbd.backendayni.models;


public class Estado_Tarea {
	
	/**
	 * ATRIBUTOS DE Estado_Tarea
	 * @param id del Estado_Tarea
	 * @param id_estado del Estado_Tarea
	 * @param id_tarea del Estado_Tarea
	 */

	private long id;
	private long id_estado;
	private long id_tarea;

	//CONSTRUCTOR Estado_Tarea
	public Estado_Tarea(){
	}

	//CONSTRUCTOR Estado_Tarea
	public Estado_Tarea(long id, long id_estado, long id_tarea){
		this.id = id;
		this.id_estado = id_estado;
		this.id_tarea = id_tarea;
	}

	//GETTERS Estado_Tarea

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

	//SETTERS Estado_Tarea

	/**
	 * @param id del Estado_Tarea
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @param id_estado del Estado_Tarea
	 */
	public void setId_estado(long id_estado) {
		this.id_estado = id_estado;
	}

	/**
	 * @param id_tarea del Estado_Tarea
	 */
	public void setId_tarea(long id_tarea) {
		this.id_tarea = id_tarea;
	}

	//TOSTRING Estado_Tarea

	/**
	 * @return String con los datos del Estado_Tarea
	 */
	@Override
	public String toString() {
		return "Estado_Tarea [id=" + id + ", id_estado=" + id_estado + ", id_tarea=" + id_tarea + "]";
	}
	
}

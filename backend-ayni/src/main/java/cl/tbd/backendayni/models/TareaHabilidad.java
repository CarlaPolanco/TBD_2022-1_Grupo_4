package cl.tbd.backendayni.models;

public class TareaHabilidad {

	/**
	 * ATRIBUTOS DE TareaHabilidad
	 * @param id de la TareaHabilidad
	 * @param id_tarea de la TareaHabilidad
	 * @param id_habilidad de la TareaHabilidad
	 */

	private long id;
	private long id_tarea;
	private long id_habilidad;

	//CONSTRUCTOR TareaHabilidad
	public TareaHabilidad(){
	}

	//CONSTRUCTOR TareaHabilidad
	public TareaHabilidad(long id, long id_tarea, long id_habilidad){
		this.id = id;
		this.id_tarea = id_tarea;
		this.id_habilidad = id_habilidad;
	}

	//GETTERS TareaHabilidad

	/**
	 * @return id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @return id_tarea
	 */
	public long getId_tarea() {
		return id_tarea;
	}

	/**
	 * @return id_habilidad
	 */
	public long getId_habilidad() {
		return id_habilidad;
	}

	//SETTERS TareaHabilidad

	/**
	 * @param id de la TareaHabilidad
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @param id_tarea de la TareaHabilidad
	 */
	public void setId_tarea(long id_tarea) {
		this.id_tarea = id_tarea;
	}

	/**
	 * @param id_habilidad de la TareaHabilidad
	 */
	public void setId_habilidad(long id_habilidad) {
		this.id_habilidad = id_habilidad;
	}

	//TOSTRING TareaHabilidad

	/**
	 * @return String con los datos de la TareaHabilidad
	 */
	@Override
	public String toString() {
		return "TareaHabilidad [id=" + id + ", id_tarea=" + id_tarea + ", id_habilidad=" + id_habilidad + "]";
	}

    
    
}

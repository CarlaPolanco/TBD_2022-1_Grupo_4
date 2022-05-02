package cl.tbd.backendayni.models;

public class TareaHabilidad {
	private long id;
    private long idTarea;
    private long idHabilidad;
    
	public TareaHabilidad(long id, long idTarea, long idHabilidad) {
		this.id = id;
		this.idTarea = idTarea;
		this.idHabilidad = idHabilidad;
	}

	public long getIdTabla() {
		return id;
	}

	public long getIdTarea() {
		return idTarea;
	}

	public long getIdHabilidad() {
		return idHabilidad;
	}

	public void setIdTabla(long idTabla) {
		this.id = idTabla;
	}

	public void setIdTarea(long idTarea) {
		this.idTarea = idTarea;
	}

	public void setIdHabilidad(long idHabilidad) {
		this.idHabilidad = idHabilidad;
	}
    
    
}

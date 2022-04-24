package cl.tbd.backendayni.models;

public class TareaHabilidad {
	private long idTabla;
    private long idTarea;
    private long idHabilidad;
    
	public TareaHabilidad(long idTabla, long idTarea, long idHabilidad) {
		this.idTabla = idTabla;
		this.idTarea = idTarea;
		this.idHabilidad = idHabilidad;
	}

	public long getIdTabla() {
		return idTabla;
	}

	public long getIdTarea() {
		return idTarea;
	}

	public long getIdHabilidad() {
		return idHabilidad;
	}

	public void setIdTabla(long idTabla) {
		this.idTabla = idTabla;
	}

	public void setIdTarea(long idTarea) {
		this.idTarea = idTarea;
	}

	public void setIdHabilidad(long idHabilidad) {
		this.idHabilidad = idHabilidad;
	}
    
    
}

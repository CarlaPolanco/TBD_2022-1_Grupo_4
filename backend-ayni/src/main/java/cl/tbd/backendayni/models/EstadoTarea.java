package cl.tbd.backendayni.models;


public class EstadoTarea {
	private long idTabla;
    private long idEstado;
    private long idTarea;
    
	public EstadoTarea(long idTabla, long idEstado, long idTarea) {
		this.idTabla = idTabla;
		this.idEstado = idEstado;
		this.idTarea = idTarea;
	}

	public long getIdTabla() {
		return idTabla;
	}

	public long getIdEstado() {
		return idEstado;
	}

	public long getIdTarea() {
		return idTarea;
	}

	public void setIdTabla(long idTabla) {
		this.idTabla = idTabla;
	}

	public void setIdEstado(long idEstado) {
		this.idEstado = idEstado;
	}

	public void setIdTarea(long idTarea) {
		this.idTarea = idTarea;
	}

    
}

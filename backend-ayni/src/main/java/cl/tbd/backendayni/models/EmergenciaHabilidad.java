package cl.tbd.backendayni.models;

public class EmergenciaHabilidad {

    private long id_emergencia_habilidad;
    private long id_emergencia;
    private long id_habilidad;

    public EmergenciaHabilidad() {
    }

    public EmergenciaHabilidad(long id_emergencia_habilidad, long id_emergencia, long id_habilidad) {
        this.id_emergencia_habilidad = id_emergencia_habilidad;
        this.id_emergencia = id_emergencia;
        this.id_habilidad = id_habilidad;
    }

    public long getId_emergencia_habilidad() {
        return id_emergencia_habilidad;
    }

    public void setId_emergencia_habilidad(long id_emergencia_habilidad) {
        this.id_emergencia_habilidad = id_emergencia_habilidad;
    }

    public long getId_emergencia() {
        return id_emergencia;
    }

    public void setId_emergencia(long id_emergencia) {
        this.id_emergencia = id_emergencia;
    }

    public long getId_habilidad() {
        return id_habilidad;
    }

    public void setId_habilidad(long id_habilidad) {
        this.id_habilidad = id_habilidad;
    }
}

package cl.tbd.backendayni.models;

public class VoluntarioHabilidad {

    private long id_voluntario_habilidad;
    private long id_voluntario;
    private long id_habilidad;


    public VoluntarioHabilidad(long id_voluntario_habilidad, long id_voluntario, long id_habilidad) {
        this.id_voluntario_habilidad = id_voluntario_habilidad;
        this.id_voluntario = id_voluntario;
        this.id_habilidad = id_habilidad;
    }

    public long getId_voluntario_habilidad() {
        return id_voluntario_habilidad;
    }

    public void setId_voluntario_habilidad(long id_voluntario_habilidad) {
        this.id_voluntario_habilidad = id_voluntario_habilidad;
    }

    public long getId_voluntario() {
        return id_voluntario;
    }

    public void setId_voluntario(long id_voluntario) {
        this.id_voluntario = id_voluntario;
    }

    public long getId_habilidad() {
        return id_habilidad;
    }

    public void setId_habilidad(long id_habilidad) {
        this.id_habilidad = id_habilidad;
    }
}

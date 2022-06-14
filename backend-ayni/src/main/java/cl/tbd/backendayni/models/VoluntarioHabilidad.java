package cl.tbd.backendayni.models;

public class VoluntarioHabilidad {

    /**
     * ATRIBUTOS DE VoluntarioHabilidad
     * @param id de la VoluntarioHabilidad
     * @param id_voluntario de la VoluntarioHabilidad
     * @param id_habilidad de la VoluntarioHabilidad
     */
    
    private long id;
    private long id_voluntario;
    private long id_habilidad;

    //CONSTRUCTOR VoluntarioHabilidad
    public VoluntarioHabilidad(){
    }

    //CONSTRUCTOR VoluntarioHabilidad
    public VoluntarioHabilidad(long id, long id_voluntario, long id_habilidad){
        this.id = id;
        this.id_voluntario = id_voluntario;
        this.id_habilidad = id_habilidad;
    }

    //GETTERS VoluntarioHabilidad

    /**
     * @return id
     */
    public long getId() {
        return id;
    }

    /**
     * @return id_voluntario
     */
    public long getId_voluntario() {
        return id_voluntario;
    }

    /**
     * @return id_habilidad
     */
    public long getId_habilidad() {
        return id_habilidad;
    }

    //SETTERS VoluntarioHabilidad

    /**
     * @param id de la VoluntarioHabilidad
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * @param id_voluntario de la VoluntarioHabilidad
     */
    public void setId_voluntario(long id_voluntario) {
        this.id_voluntario = id_voluntario;
    }

    /**
     * @param id_habilidad de la VoluntarioHabilidad
     */
    public void setId_habilidad(long id_habilidad) {
        this.id_habilidad = id_habilidad;
    }

    //TOSTRING VoluntarioHabilidad

    /**
     * @return String con los atributos de la VoluntarioHabilidad
     */
    @Override
    public String toString() {
        return "VoluntarioHabilidad{" +
                "id=" + id +
                ", id_voluntario=" + id_voluntario +
                ", id_habilidad=" + id_habilidad +
                '}';
    }
    
}

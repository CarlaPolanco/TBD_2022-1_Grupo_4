package cl.tbd.backendayni.models;

public class EmergenciaHabilidad {

    /**
     * ATRIBUTOS DE EmergenciaHabilidad
     * @param id de la EmergenciaHabilidad
     * @param id_emergencia de la EmergenciaHabilidad
     * @param id_habilidad de la EmergenciaHabilidad
     */

    private long id;
    private long id_emergencia;
    private long id_habilidad;

    //CONSTRUCTOR EmergenciaHabilidad
    public EmergenciaHabilidad(){
    }

    //CONSTRUCTOR EmergenciaHabilidad
    public EmergenciaHabilidad(long id, long id_emergencia, long id_habilidad){
        this.id = id;
        this.id_emergencia = id_emergencia;
        this.id_habilidad = id_habilidad;
    }

    //GETTERS EmergenciaHabilidad

    /**
     * @return id
     */
    public long getId() {
        return id;
    }

    /**
     * @return id_emergencia
     */
    public long getId_emergencia() {
        return id_emergencia;
    }

    /**
     * @return id_habilidad
     */
    public long getId_habilidad() {
        return id_habilidad;
    }

    //SETTERS EmergenciaHabilidad

    /**
     * @param id de la EmergenciaHabilidad
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * @param id_emergencia de la EmergenciaHabilidad
     */
    public void setId_emergencia(long id_emergencia) {
        this.id_emergencia = id_emergencia;
    }

    /**
     * @param id_habilidad de la EmergenciaHabilidad
     */
    public void setId_habilidad(long id_habilidad) {
        this.id_habilidad = id_habilidad;
    }

    //TOSTRING EmergenciaHabilidad

    /**
     * @return String con los datos de la EmergenciaHabilidad
     */
    @Override
    public String toString() {
        return "EmergenciaHabilidad{" +
                "id=" + id +
                ", id_emergencia=" + id_emergencia +
                ", id_habilidad=" + id_habilidad +
                '}';
    }
    

}

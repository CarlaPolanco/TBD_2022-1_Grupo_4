package cl.tbd.backendayni.models;

public class Voluntario_Habilidad {

    /**
     * ATRIBUTOS DE Voluntario_Habilidad
     * @param id de la Voluntario_Habilidad
     * @param id_voluntario de la Voluntario_Habilidad
     * @param id_habilidad de la Voluntario_Habilidad
     */
    
    private long id;
    private long id_voluntario;
    private long id_habilidad;

    //CONSTRUCTOR Voluntario_Habilidad
    public Voluntario_Habilidad(){
    }

    //CONSTRUCTOR Voluntario_Habilidad
    public Voluntario_Habilidad(long id, long id_voluntario, long id_habilidad){
        this.id = id;
        this.id_voluntario = id_voluntario;
        this.id_habilidad = id_habilidad;
    }

    //GETTERS Voluntario_Habilidad

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

    //SETTERS Voluntario_Habilidad

    /**
     * @param id de la Voluntario_Habilidad
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * @param id_voluntario de la Voluntario_Habilidad
     */
    public void setId_voluntario(long id_voluntario) {
        this.id_voluntario = id_voluntario;
    }

    /**
     * @param id_habilidad de la Voluntario_Habilidad
     */
    public void setId_habilidad(long id_habilidad) {
        this.id_habilidad = id_habilidad;
    }

    //TOSTRING Voluntario_Habilidad

    /**
     * @return String con los atributos de la Voluntario_Habilidad
     */
    @Override
    public String toString() {
        return "Voluntario_Habilidad{" +
                "id=" + id +
                ", id_voluntario=" + id_voluntario +
                ", id_habilidad=" + id_habilidad +
                '}';
    }
    
}

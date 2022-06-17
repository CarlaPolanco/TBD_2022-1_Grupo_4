package cl.tbd.backendayni.models;


import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan
public class Ranking_Voluntario {
    /**
     * ATRIBUTOS DE Ranking_Voluntario
     * @param id_voluntario de rannking_voluntario
     * @param nombre de ranking_voluntario
     * @param porcentaje de ranking_voluntario
     */

    private long id_voluntario;
    private String nombre;
    private float porcentaje;
 
    public Ranking_Voluntario() {
    }

    //CONSTRUCTOR Ranking_Voluntario
    public Ranking_Voluntario(long id_voluntario, String nombre, float porcentaje) {
        this.id_voluntario = id_voluntario;
        this.nombre = nombre;
        this.porcentaje = porcentaje;
    }

    //GETTERS Ranking_Voluntario

    /**
     * @return id_voluntario
     */
    public long getId_voluntario() {
        return id_voluntario;
    }

    /**
     * @return nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @return porcentaje
     */
    public float getPorcentaje() {
        return porcentaje;
    }

    //SETTERS Ranking_Voluntario

    /**
     * @param id_voluntario id_voluntario a setear
     */

    public void setId_voluntario(long id_voluntario) {
        this.id_voluntario = id_voluntario;
    }

    /**
     * @param nombre nombre a setear
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @param porcentaje porcentaje a setear
     */
    public void setPorcentaje(float porcentaje) {
        this.porcentaje = porcentaje;
    }

    //TOSTRING Ranking_Voluntario

    /**
     * @return string con los datos del ranking_voluntario
     */
    @Override
    public String toString() {
        return "Ranking_Voluntario [id_voluntario=" + id_voluntario + ", nombre=" + nombre + ", porcentaje=" + porcentaje + "]";
    }
    
}

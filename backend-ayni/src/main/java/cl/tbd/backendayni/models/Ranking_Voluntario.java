package cl.tbd.backendayni.models;


import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan
public class Ranking_Voluntario {
    /**
     * ATRIBUTOS DE Ranking_Voluntario
     * @param id_voluntario de rannking_voluntario
     * @param usuario de ranking_voluntario
     * @param porcentaje de ranking_voluntario
     */

    private long id_voluntario;
    private String usuario;
    private float porcentaje;
 
    public Ranking_Voluntario() {
    }

    //CONSTRUCTOR Ranking_Voluntario
    public Ranking_Voluntario(long id_voluntario, String usuario, float porcentaje) {
        this.id_voluntario = id_voluntario;
        this.usuario = usuario;
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
     * @return usuario
     */
    public String getUsuario() {
        return usuario;
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
     * @param usuario usuario a setear
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
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
        return "Ranking_Voluntario [id_voluntario=" + id_voluntario + ", usuario=" + usuario + ", porcentaje=" + porcentaje + "]";
    }
    
}

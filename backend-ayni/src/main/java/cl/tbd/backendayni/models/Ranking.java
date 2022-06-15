package cl.tbd.backendayni.models;

import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan
public class Ranking {
    /**
    * ATRIBUTOS DE Ranking
    * @param id del Ranking
    * @param porcentaje del Ranking
    * @param id_tarea del Ranking
    * @param id_voluntario del Ranking
    */

    private long id;
    private long porcentaje;
    private long id_tarea;
    private long id_voluntario;

    //CONSTRUCTOR Ranking
    public Ranking(){
    }
    
    //CONSTRUCTOR Ranking
    public Ranking(long id, long porcentaje, long id_tarea, long id_voluntario){
        this.id = id;
        this.porcentaje = porcentaje;
        this.id_tarea = id_tarea;
        this.id_voluntario = id_voluntario;
    }

    //GETTERS Ranking

    /**
     * @return id
     */
    public long getId() {
        return id;
    }

    /**
     * @return porcentaje
     */
    public long getPorcentaje() {
        return porcentaje;
    }

    /**
     * @return id_tarea
     */
    public long getId_tarea() {
        return id_tarea;
    }

    /**
     * @return id_voluntario
     */
    public long getId_voluntario() {
        return id_voluntario;
    }

    //SETTERS Ranking

    /**
     * @param id del Ranking
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * @param porcentaje del Ranking
     */
    public void setPorcentaje(long porcentaje) {
        this.porcentaje = porcentaje;
    }

    /**
     * @param id_tarea del Ranking
     */
    public void setId_tarea(long id_tarea) {
        this.id_tarea = id_tarea;
    }

    /**
     * @param id_voluntario del Ranking
     */
    public void setId_voluntario(long id_voluntario) {
        this.id_voluntario = id_voluntario;
    }

    //TOSTRING Ranking

    /**
     * @return String con los datos del Ranking
     */
    @Override
    public String toString() {
        return "Ranking{" +
                "id=" + id +
                ", porcentaje=" + porcentaje +
                ", id_tarea=" + id_tarea +
                ", id_voluntario=" + id_voluntario +
                '}';
    }

}
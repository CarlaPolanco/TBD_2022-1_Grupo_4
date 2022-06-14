package cl.tbd.backendayni.models;

import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan
public class Habilidad {
    /**
     * ATRIBUTOS DE Habilidad
     * @param id de la habilidad
     * @param nombre de la habilidad
     */

    private long id;
    private String nombre;

    //CONSTRUCTOR Habilidad
    public Habilidad(){
    }

    //CONSTRUCTOR Habilidad
    public Habilidad(long id, String nombre){
        this.id = id;
        this.nombre = nombre;
    }

    //GETTERS Habilidad

    /**
     * @return id
     */
    public long getId() {
        return id;
    }
    
    /**
     * @return nombre
     */
    public String getNombre() {
        return nombre;
    }

    //SETTERS Habilidad

    /**
     * @param id de la habilidad
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * @param nombre de la habilidad
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    //TOSTRING Habilidad

    /**
     * @return String
     */
    @Override
    public String toString() {
        return "Habilidad{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                '}';
    }
    
}

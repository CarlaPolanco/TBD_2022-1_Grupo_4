package cl.tbd.backendayni.models;

import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan
public class Institucion {
    /** 
    * ATRIBUTOS DE INSTITUCION
    * @param id de la institucion
    * @param password de la institucion
    * @param nombre de la institucion
    * @param correo de la institucion
    * @param numero de la institucion
    */

    private long id;
    private String password;
    private String nombre;
    private String correo;
    private String numero;

    //CONSTRUCTOR INSTITUCION
    public Institucion(){
    }

    //CONSTRUCTOR INSTITUCION
    public Institucion(long id, String password, String nombre, String correo, String numero){
        this.id = id;
        this.password = password;
        this.nombre = nombre;
        this.correo = correo;
        this.numero = numero;
    }

    //GETTERS INSTITUCION

    /**
     * @return id
     */
    public long getId() {
        return id;
    }

    /**
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @return nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @return correo
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * @return numero
     */
    public String getNumero() {
        return numero;
    }

    //SETTERS INSTITUCION

    /**
     * @param id de la institucion
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * @param password de la institucion
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @param nombre de la institucion
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @param correo de la institucion
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    /**
     * @param numero de la institucion
     */
    public void setNumero(String numero) {
        this.numero = numero;
    }

    //TOSTRING INSTITUCION

    /**
     * @return toString de la institucion
     */
    @Override
    public String toString() {
        return "Institucion{" +
                "id=" + id +
                ", password='" + "*******" + '\'' +
                ", nombre='" + nombre + '\'' +
                ", correo='" + correo + '\'' +
                ", numero='" + numero + '\'' +
                '}';
    }

}

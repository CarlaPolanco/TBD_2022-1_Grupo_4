package cl.tbd.backendayni.models;

import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan
public class Institucion {
    /** 
    * ATRIBUTOS DE INSTITUCION
    * @param id de la institucion
    * @param nombre de la institucion
    * @param usuario de la institucion
    * @param password de la institucion
    * @param correo de la institucion
    * @param numero de la institucion
    */

    private long id;
    private String nombre;
    private String usuario;
    private String password;
    private String correo;
    private String numero;

    //CONSTRUCTOR INSTITUCION
    public Institucion(){
    }

    //CONSTRUCTOR INSTITUCION
    public Institucion(long id, String nombre, String usuario, String password, String correo, String numero){
        this.id = id;
        this.nombre = nombre;
        this.usuario = usuario;
        this.password = password;
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
     * @return nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @return usuario
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * @return password
     */
    public String getPassword() {
        return password;
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
     * @param nombre de la institucion
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @param usuario de la institucion
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    
    /**
     * @param password de la institucion
     */
    public void setPassword(String password) {
        this.password = password;
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
                ", nombre='" + nombre + '\'' +
                ", nombre='" + usuario + '\'' +
                ", password='" + "*******" + '\'' +
                ", correo='" + correo + '\'' +
                ", numero='" + numero + '\'' +
                '}';
    }

}


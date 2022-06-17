package cl.tbd.backendayni.models;

import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan
public class Voluntario {
    /** 
    * ATRIBUTOS DE Voluntario
    * @param  id
    * @param correo 
    * @param usuario
    * @param nombre
    * @param password
    * @param atributos 
    */

    private long id;
    private String correo;
    private String usuario;
    private String nombre;
    private String password;
    private String atributos;

    //CONSTRUCTOR Voluntario
    public Voluntario(){
    }

    //CONSTRUCTOR Voluntario
    public Voluntario(long id, String correo, String usuario, String nombre, String password, String atributos){
        this.id = id;
        this.correo = correo;
        this.usuario = usuario;
        this.nombre = nombre;
        this.password = password;
        this.atributos = atributos;
    }

    //GETTERS Voluntario

    /**
     * @return id
     */
    public long getId() {
        return id;
    }

    /**
     * @return correo
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * @return usuario
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * @return nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @return atributos
     */
    public String getAtributos() {
        return atributos;
    }

    //SETTERS Voluntario

    /**
     * @param id id a setear
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * @param correo correo a setear
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    /**
     * @param usuario usuario a setear
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    /**
     * @param nombre nombre a setear
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @param password password a setear
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @param atributos atributos a setear
     */
    public void setAtributos(String atributos) {
        this.atributos = atributos;
    }

    //TOSTRING Voluntario

    /**
     * @return String
     */
    @Override
    public String toString() {
        return "Voluntario{" +
                "id=" + id +
                ", correo='" + correo + '\'' +
                ", usuario='" + usuario + '\'' +
                ", nombre='" + nombre + '\'' +
                ", password='" + "******" + '\'' +
                ", atributos='" + atributos + '\'' +
                '}';
    }


}

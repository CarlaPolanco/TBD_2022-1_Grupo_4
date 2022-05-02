package cl.tbd.backendayni.models;

import java.util.ArrayList;

import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan
public class Voluntario {
    /** 
    * @param  id
    * @param correo 
    * @param nombre
    * @param contrasena
    * @param atributos 
    */

    private long id;
    private String correo;
    private String nombreUsuario;
    private String contrasena;
    private String atributos;

    public Voluntario(long id, String correo, String nombreUsuario, String contrasena, String atributos) {

        this.id = id;
        this.correo = correo;
        this.nombreUsuario = nombreUsuario;
        this.contrasena = contrasena;
        this.atributos = atributos;
    }
 

    /**
	 * @return the id
	 */
    public long getId() {
        return id;
    }
    
    /**
	 * @return the descripcion
	 */
    public String getCorreo() {
        return correo;
    }

    /**
	 * @return the descripcion
	 */
    public String getNombreusuario() {
        return nombreUsuario;
    }

    /**
	 * @return the descripcion
	 */
    public String getContrasena() {
        return contrasena;
    }

    /**
	 * @return the descripcion
	 */
    public String getAtributos() {
        return atributos;
    }
    //SETTERS 

    /**
	 * @param correo the correo to set
	 */
    public void setId(long id) {
        this.id = id;
    }

    /**
	 * @param correo the correo to set
	 */
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    /**
	 * @param atributos the atributos to set
	 */
    public void setAtributos(String atributos) {
        this.atributos = atributos;
    }

    /**
	 * @param nombre the nombre to set
	 */
    public void setNombreusuario(String nombreusuario) {
        this.nombreUsuario = nombreusuario;
    }
    
    /**
	 * @param contrasena the contrasena to set
	 */
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
    
}

package cl.tbd.backendayni.models;

import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan
public class Voluntario {
    /** 
    * @param  id
    * @param correo 
    * @param nombre
    * @param contrasena
    * @param ranking
    * @param habilidades
    * @param atributos 
    */

    private long id;
    private String correo;
    private String nombreUsuario;
    private String contrasena;
    private Ranking rankingUser;
    private Habilidad habilidades;
    private String atributos;

    public Voluntario(long id, String correo, String nombreUsuario, String contrasena, Ranking rankingUser,
            Habilidad habilidades, String atributos) {

        this.id = id;
        this.correo = correo;
        this.nombreUsuario = nombreUsuario;
        this.contrasena = contrasena;
        this.rankingUser = rankingUser;
        this.habilidades = habilidades;
        this.atributos = atributos;
    }
    //SETTERS

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
    public Ranking getRankinguser() {
        return rankingUser;
    }

    /**
	 * @return the descripcion
	 */  
    public Habilidad getHabilidades() {
        return habilidades;
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
    
    /**
	 * @param makinguser the makinguser to set
	 */
    public void setRankinguser(Ranking rankingUser) {
        this.rankingUser = rankingUser;
    }
    
    /**
	 * @param habilidad the habilidad to set
	 */
    public void setHabilidades(Habilidad habilidades) {
        this.habilidades = habilidades;
    }
}

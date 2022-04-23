package cl.tbd.backendayni.models;

import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan
public class Voluntario {
    /** 
    * @param  id
    * @param correo 
    * @param nombre
    * @param usuario
    * @param contraseña
    * @param ranking 
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

    // GET ID
    public long getId() {
        return id;
    }
    
    // SET ID
    public void setId(long id) {
        this.id = id;
    }

    // GET CORREO
    public String getCorreo() {
        return correo;
    }

    // SET CORREO
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    // GET NOMBRE
    public String getNombreusuario() {
        return nombreUsuario;
    }

    // SET NOMBRE
    public void setNombreusuario(String nombreusuario) {
        this.nombreUsuario = nombreusuario;
    }

    // GET CONTRASENA
    public String getContrasena() {
        return contrasena;
    }

    // SET CONTRASENA
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    // GET RANKINGUSER
    public Ranking getRankinguser() {
        return rankingUser;
    }

    // SET RANKINGUSER
    public void setRankinguser(Ranking rankingUser) {
        this.rankingUser = rankingUser;
    }

    // GET HABILIDADES   
    public Habilidad getHabilidades() {
        return habilidades;
    }
    // SET HABILIDADES
    public void setHabilidades(Habilidad habilidades) {
        this.habilidades = habilidades;
    }

    // GET ATRIBUTOS
    public String getAtributos() {
        return atributos;
    }

    // SET ATRIBUTOS
    public void setAtributos(String atributos) {
        this.atributos = atributos;
    }

}

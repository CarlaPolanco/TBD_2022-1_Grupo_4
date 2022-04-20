package cl.tbd.backendayni.models;

public class voluntario {
    //ATRIBUTOS DE LA ENTIDAD VOLUNTARIO
    // id, correo, nombre usuario, contraseña, ranking al cual pertenece,
    // habilidades, atributos

    private long id;
    private String correo;
    private String nombreusuario;
    private String contrasena;
    private ranking rankinguser;
    private habilidad habilidades;
    private String atributos;

    public voluntario(long id, String correo, String nombreusuario, String contrasena, ranking rankinguser,
            habilidad habilidades, String atributos) {

        this.id = id;
        this.correo = correo;
        this.nombreusuario = nombreusuario;
        this.contrasena = contrasena;
        this.rankinguser = rankinguser;
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
        return nombreusuario;
    }

    // SET NOMBRE
    public void setNombreusuario(String nombreusuario) {
        this.nombreusuario = nombreusuario;
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
    public ranking getRankinguser() {
        return rankinguser;
    }

    // SET RANKINGUSER
    public void setRankinguser(ranking rankinguser) {
        this.rankinguser = rankinguser;
    }

    // GET HABILIDADES   
    public habilidad getHabilidades() {
        return habilidades;
    }
    // SET HABILIDADES
    public void setHabilidades(habilidad habilidades) {
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

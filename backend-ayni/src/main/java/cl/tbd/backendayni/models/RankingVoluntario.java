package cl.tbd.backendayni.models;


import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan
public class RankingVoluntario {
    private long id;
    private String nombreUsuario;
    private float porcentajeRanking;

    public RankingVoluntario(){
    }
    
    public RankingVoluntario(long id, String nombreUsuario, float porcentajeRanking){
        this.id = id;
        this.nombreUsuario = nombreUsuario;
        this.porcentajeRanking = porcentajeRanking;
    }

    public long getId(){
        return id;
    }

    public void setId(long id){
        this.id = id;
    }

    public float getRanking(){
        return porcentajeRanking;
    }
    public void setRanking(float porcentajeRanking){
        this.porcentajeRanking = porcentajeRanking;
    }

    /**
	 * @return the descripcion
	 */
    public String getNombreusuario() {
        return nombreUsuario;
    }

    /**
	 * @param nombre the nombre to set
	 */
    public void setNombreusuario(String nombreusuario) {
        this.nombreUsuario = nombreusuario;
    }


}

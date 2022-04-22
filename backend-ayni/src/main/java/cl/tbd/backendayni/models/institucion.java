package cl.tbd.backendayni.models;

import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan
public class institucion {
    /** 
    ATRIBUTOS DE INSTITUCION
    @param id de la institucion
    @param nombre de la institucion
    @param correo de la institucion
    @param numero de la institucion
    
    VER DESPUES
    AGREGAR Clase Emergencia y tipo usuario contribuidor 
    */
    private long id;
    private String nombreInstitucion;
    private String correoInstitucion;
    private String numeroInstitucion;

    //CONSTRUCTOR institucion
    public institucion(long id, String nombreInstitucion,String correoInstitucion,String numeroInstitucion){
        this.id = id;
        this.nombreInstitucion = nombreInstitucion;
        this.correoInstitucion = correoInstitucion;
        this.numeroInstitucion = numeroInstitucion;
    }
    //GETTERS

    /**
	 * @return id
	*/
    public long getInstitucionid()
    {
        return id;
    }

    /**
	 * @return nombre institucion
	*/
    public String getInstitucionNombre()
    {
        return nombreInstitucion;
    }

    /**
	 * @return correo institucion
	*/
    public String getInstitucionCorreo()
    {
        return correoInstitucion;
    }

    /**
	 * @return numero institucion 
	*/
    public String getInstitucionNumero()
    {
        return correoInstitucion;
    }

    //SETTERS

    /**
	 * @param nombreInstitucion the nombre to set
	 */
    public void setInstitucionNombre(String nombreInstitucion)
    {
        this.nombreInstitucion = nombreInstitucion;
    }
    
    /**
	 * @param correoInstitucion the correo to set
	 */
    public void setInstitucionCorreo(String correoInstitucion)
    {
        this.correoInstitucion = correoInstitucion;
    } 

    /**
	 * @param numeroInstitucion the numero to set
	 */
    public void setInstitucionNumero(String numeroInstitucion)
    {
        this.numeroInstitucion = numeroInstitucion;
    } 
}

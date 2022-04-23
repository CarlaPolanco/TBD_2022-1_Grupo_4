package cl.tbd.backendayni.models;

import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan
public class Institucion {
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
    private String nombre;
    private String correo;
    private String numero;

    //CONSTRUCTOR institucion
    public Institucion(long id, String nombre,String correo,String numero){
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
        this.numero = numero;
    }
    //GETTERS

    /**
	 * @return id
	*/
    public long getInstitucionid()
    {
        return id;
    }

    public void setInstitucionId(long id)
    {
        this.id = id;
    }

    /**
	 * @return nombre institucion
	*/
    public String getInstitucionNombre()
    {
        return nombre;
    }

    /**
	 * @return correo institucion
	*/
    public String getInstitucionCorreo()
    {
        return correo;
    }

    /**
	 * @return numero institucion 
	*/
    public String getInstitucionNumero()
    {
        return numero;
    }

    //SETTERS

    /**
	 * @param nombre the nombre to set
	 */
    public void setInstitucionNombre(String nombre)
    {
        this.nombre = nombre;
    }
    
    /**
	 * @param correo the correo to set
	 */
    public void setInstitucionCorreo(String correo)
    {
        this.correo = correo;
    } 

    /**
	 * @param numero the numero to set
	 */
    public void setInstitucionNumero(String numero)
    {
        this.numero = numero;
    } 
}

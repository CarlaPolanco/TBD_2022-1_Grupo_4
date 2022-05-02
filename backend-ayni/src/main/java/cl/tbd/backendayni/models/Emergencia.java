package cl.tbd.backendayni.models;

import java.util.*;
import java.sql.Date;
import org.springframework.boot.autoconfigure.domain.EntityScan;


@EntityScan
public class Emergencia {
    /**
	ATRIBUTOS DE Emergencia
	@param id de la emergencia
	@param nombre de la emergencia
    @param descripcion de la emergencia
    @param fecha de la emergencia
    @param longitud de la emergencia
    @param latitud de la emergencia
	*/
    private long id;
    private String nombre;
    private String descripcion;
    private Date fecha;
    private long longitud;
    private long latitud;

    //private String[] requisitosGrupales;
    //private String[] requisitosIndividuales;

    private String requisitosGrupales;
    private String requisitosIndividuales;


    public Emergencia(){
    }

    public Emergencia(long id, String nombre, String descripcion, Date fecha, long longitud, long latitud,String requisitosGrupales,String requisitosIndividuales) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.longitud = longitud;
        this.latitud = latitud;
        this.requisitosGrupales = requisitosGrupales;
        this.requisitosIndividuales = requisitosIndividuales;
    }
    /*
    public Emergencia(long id, String nombre, String descripcion, Date fecha, long longitud, long latitud, String[] requisitosGrupales, String[] requisitosIndividuales) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.longitud = longitud;
        this.latitud = latitud;
        this.requisitosGrupales = requisitosGrupales;
        this.requisitosIndividuales = requisitosIndividuales;
    }*/
    //GETTERS

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    /**
	 * @return descripcion
	*/
    public String getDescripcion() {
        return descripcion;
    }

    /**
	 * @return fecha
	*/
    public Date getFecha() {
        return fecha;
    }

    /**
	 * @return longitud
	*/
    public long getLongitud() {
        return longitud;
    }
    
    /**
	 * @return latitud
	*/
    public long getLatitud() {
        return latitud;
    }

    
    /**
	 * @return array requisitos grupales
	*/
    public String getRequisitosGrupales() {
        return requisitosGrupales;
    }

    /**
	 * @return array requisitos individuales
	*/
    public String getRequisitosIndividuales() {
        return requisitosIndividuales;
    }

    //SETTERS

    /**
	 * @param nombre the nombre to set
	 */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
	 * @param descripcion the descripcion to set
	 */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
	 * @param fecha the fecha to set
	 */
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    /**
	 * @param longitud the longitud to set
	 */
    public void setLongitud(long longitud) {
        this.longitud = longitud;
    }

    /**
	 * @param latitud the latitud to set
	 */
    public void setLatitud(long latitud) {
        this.latitud = latitud;
    }

    /**
	 * @param requisitosGrupales the requisitosGrupales to set
	 */
    public void setRequisitosGrupales(String requisitosGrupales) {
        this.requisitosGrupales = requisitosGrupales;
    }    

    /**
	 * @param requisitosIndividuales the requisitosIndividuales to set
	 */
    public void setRequisitosIndividuales(String requisitosIndividuales) {
        this.requisitosIndividuales = requisitosIndividuales;
    }
}

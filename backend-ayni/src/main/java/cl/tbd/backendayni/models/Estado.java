package cl.tbd.backendayni.models;

import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan
public class Estado {
	/**
	ATRIBUTOS DE ESTADO
	@param id del estado
	@param nombre del estado
	*/

	private long id;
	private String nombre;

	//CONSTRUCTOR Estado
	public Estado(long id,String nombre) {
		this.id = id;
		this.nombre = nombre;
	}
	//GETTERS 
	/**
	 * @return id
	 */
	public long getId()
	{
		return id;
	}
	/**
	 * @return estado nombre
	 */
	public String getNombre()
	{
		return nombre;
	}
	//SETTERS
	/**
	 * @param id id to set
	 */
	public void setId(long id){
		this.id = id;
	}
	
	/**
	 * @param nombre nombre to set
	 */
	public void setNombre(String nombre){
		this.nombre = nombre;
	}
}

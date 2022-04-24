package cl.tbd.backendayni.models;

import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan
public class Habilidad {
    private long id;
    private String habilidad;

    public Habilidad(){
    }
    public Habilidad(String hab){
        this.habilidad = hab;     
    }

    public String getHabilidad(){
        return habilidad;
    }

    public long getId(){
        return id;
    }

    public void setHabilidad(String habilidad){
        this.habilidad = habilidad;
    }
    
    public void setId(long id){
        this.id = id;

    }
}

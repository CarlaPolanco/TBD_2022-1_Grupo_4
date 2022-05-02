package cl.tbd.backendayni.models;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import java.util.List;

@EntityScan
public class Ranking {
    private long id;
    private float porcentajeRanking;
    private long idTarea;
    private long idVoluntario;

    public Ranking(){

    }
    public Ranking(long id2, float porcentajeRanking, long id_voluntario, long id_tarea){
        this.idTarea = id_tarea;
        this.idVoluntario = id_voluntario;
        this.porcentajeRanking = porcentajeRanking;
        this.id = id2;
    }

    public long getIdVoluntario(){
        return idVoluntario;
    }
    
    public void setIdVoluntario(int idVol){
        this.idVoluntario = idVol;
    }

    public long getIdTarea(){
        return idTarea;
    }

    public void setIdTarea(int idTarea){
        this.idTarea = idTarea;
    }  
    
    public float getRanking(){
        return porcentajeRanking;
    }
    public void setRanking(float rank){
        this.porcentajeRanking = rank;
    }

    public long getId(){
        return id;
    }

    public void setId(long id){
        this.id = id;
    }

    public void generateRankingPercent(List<TareaHabilidad> listTH, List<VoluntarioHabilidad> listVH){
        int counter = 0;
        for(int i = 0; i< listTH.size(); i++){
            for(int j = 0; j< listTH.size(); j++){
                if(listTH.get(i).getIdHabilidad() == listVH.get(i).getId_habilidad()){
                    counter = counter + 1;
                }
            }
        }
        float porcentaje;
        porcentaje = (float) 4.0;
        this.porcentajeRanking = porcentaje;
    }

}
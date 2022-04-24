package cl.tbd.backendayni.models;

import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan
public class Ranking {
    private long id;
    private float porcentajeRanking;
    private long idTarea;
    private long idVoluntario;

    public Ranking(){

    }
    public Ranking(Voluntario vol, Tarea tar){
        this.idTarea = vol.getId();
        this.idVoluntario = tar.getId();
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


    public long getId(){
        return id;
    }


    /*Calculamos el ranking de la relacion Voluntario - Tarea haciendo un paso por los requisitos de la tarea y con las habildades que el voluntario
    tiene, calculamos el porcentaje de "acierto" y luego lo colocamos dentro del ranking */
    public void generateRankingPercent(Tarea tarea, Voluntario vol){
        if (tarea.getId() == this.idTarea && vol.getId() == this.idVoluntario){
            int contador = 0;
            for (int i = 0; i <tarea.getRequisitos().size(); i++ ){
                for(int j = 0; j < vol.getHabilidades().size(); j++){
                    if (tarea.getRequisitos().get(i) == vol.getHabilidades().get(j)){
                        contador = contador + 1;
                    }
                }
            }
            float ranking = (contador * 100)/tarea.getRequisitos().size();

            this.porcentajeRanking = ranking;
        }  
    }


}
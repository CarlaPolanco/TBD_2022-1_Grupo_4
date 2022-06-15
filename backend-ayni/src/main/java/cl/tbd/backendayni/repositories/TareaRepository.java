package cl.tbd.backendayni.repositories;

import cl.tbd.backendayni.models.Tarea;
import java.util.List;

public interface TareaRepository {
    
    public int countTareas();
    public int newId();
    public List<Tarea> getAll();
    public List<Tarea> showTareaById(long id);
    public Tarea createTarea(Tarea tarea);
    public void updateTarea(Tarea tarea);
    public void deleteTareaById(long id);
    //public List<Tarea> getAllTareasEmergency(long id);
}

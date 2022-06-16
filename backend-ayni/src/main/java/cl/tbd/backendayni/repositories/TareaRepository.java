package cl.tbd.backendayni.repositories;

import cl.tbd.backendayni.models.Tarea;
import java.util.List;

/*Interface para TareaRepository*/
public interface TareaRepository {
    //Funciones basicas de Tarea
    public int countTareas();
    public int newId();
    public List<Tarea> getAll();
    public List<Tarea> showTareaById(long id);
    public Tarea createTarea(Tarea tarea);
    public void updateTarea(Tarea tarea);
    public void deleteTareaById(long id);
    //Funcione Complementarias de Tarea
    public List<Tarea> getTareaByIdEmergencia(long id);
}

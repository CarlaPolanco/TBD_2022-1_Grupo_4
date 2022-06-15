package cl.tbd.backendayni.repositories;

import java.util.List;
import cl.tbd.backendayni.models.Estado_Tarea;

/**
 * Interface para Estado_TareaRepository
 */
public interface Estado_TareaRepository {

    public int countEstadosTarea();
    public int newId();
    public List<Estado_Tarea> getAll();
    public List<Estado_Tarea> showEstadoTareaById(long id);
    public Estado_Tarea createEstadoTarea(Estado_Tarea estado_tarea);
    public void deleteEstadoTareaById(long id);
    public void updateEstadoTarea(Estado_Tarea estado_tarea);
}

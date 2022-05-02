package cl.tbd.backendayni.repositories;

import java.util.List;
import cl.tbd.backendayni.models.EstadoTarea;

public interface EstadoTareaRepository {

    public int countEstadosTarea();
    public int newId();
    public List<EstadoTarea> getAll();
    public List<EstadoTarea> showEstadoTareaById(long id);
    public EstadoTarea createEstadoTarea(EstadoTarea estadotarea);
    public void deleteEstadoTareaById(long id);
    public void updateEstadoTarea(EstadoTarea estadotarea);
}

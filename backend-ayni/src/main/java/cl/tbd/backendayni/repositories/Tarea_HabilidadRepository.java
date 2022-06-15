package cl.tbd.backendayni.repositories;

import java.util.List;
import cl.tbd.backendayni.models.Tarea_Habilidad;

/**
 * Interface para Tarea_HabilidadRepository
 */
public interface Tarea_HabilidadRepository {
    
    public int countTareasHabilidad();
    public int newId();
    public List<Tarea_Habilidad> getAll();
    public List<Tarea_Habilidad> showTareaHabilidadById(long id);
    public Tarea_Habilidad createTareaHabilidad(Tarea_Habilidad tarea_habilidad);
    public void deleteTareaHabilidadById(long id);
    public void updateTareaHabilidad(Tarea_Habilidad tarea_habilidad);
}

package cl.tbd.backendayni.repositories;

import java.util.List;
import cl.tbd.backendayni.models.TareaHabilidad;

public interface TareaHabilidadRepository {
    
    public int countTareasHabilidad();
    public int newId();
    public List<TareaHabilidad> getAll();
    public List<TareaHabilidad> showTareaHabilidadById(long id);
    public TareaHabilidad createTareaHabilidad(TareaHabilidad tareahabilidad);
    public void deleteTareaHabilidadById(long id);
    public void updateTareaHabilidad(TareaHabilidad tareahabilidad);
}

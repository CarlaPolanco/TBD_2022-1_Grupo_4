package cl.tbd.backendayni.repositories;

import cl.tbd.backendayni.models.EmergenciaHabilidad;
import java.util.*;

public interface EmergenciaHabilidadRepository {
    public int countEmergenciaHabilidades();
    public int newId();
    public List<EmergenciaHabilidad> getAll();
    public List<EmergenciaHabilidad> showEmergenciaHabilidadById(long id);
    public EmergenciaHabilidad createEmergenciaHabilidad(EmergenciaHabilidad emergenciaHabilidad);
    public void deleteEmergenciaHabilidadById(long id);
    public void updateEmergenciaHabilidad(EmergenciaHabilidad emergenciaHabilidad);
}

package cl.tbd.backendayni.repositories;

import cl.tbd.backendayni.models.Emergencia_Habilidad;
import java.util.List;

/**
 * Interface para Emergencia_HabilidadRepository
 */
public interface Emergencia_HabilidadRepository {
    public int countEmergenciaHabilidades();
    public int newId();
    public List<Emergencia_Habilidad> getAll();
    public List<Emergencia_Habilidad> showEmergenciaHabilidadById(long id);
    public Emergencia_Habilidad createEmergenciaHabilidad(Emergencia_Habilidad emergencia_habilidad);
    public void deleteEmergenciaHabilidadById(long id);
    public void updateEmergenciaHabilidad(Emergencia_Habilidad emergencia_habilidad);
}

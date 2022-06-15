package cl.tbd.backendayni.repositories;

import java.util.List;
import cl.tbd.backendayni.models.Voluntario_Habilidad;

/**
 * Interface para Voluntario_HabilidadRepository
 */
public interface Voluntario_HabilidadRepository {
        
    public int countVoluntariosHabilidad();
    public int newId();
    public List<Voluntario_Habilidad> getAll();
    public List<Voluntario_Habilidad> showVoluntarioHabilidadById(long id);
    public Voluntario_Habilidad createVoluntarioHabilidad(Voluntario_Habilidad voluntario_habilidad);
    public void deleteVoluntarioHabilidadById(long id);
    public void updateVoluntarioHabilidad(Voluntario_Habilidad voluntario_habilidad);

}

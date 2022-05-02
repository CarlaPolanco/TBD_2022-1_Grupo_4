package cl.tbd.backendayni.repositories;

import java.util.List;
import cl.tbd.backendayni.models.VoluntarioHabilidad;

public interface VoluntarioHabilidadRepository {
        
    public int countVoluntariosHabilidad();
    public int newId();
    public List<VoluntarioHabilidad> getAll();
    public List<VoluntarioHabilidad> showVoluntarioHabilidadById(long id);
    public VoluntarioHabilidad createVoluntarioHabilidad(VoluntarioHabilidad voluntariohabilidad);
    public void deleteVoluntarioHabilidadById(long id);
    public void updateVoluntarioHabilidad(VoluntarioHabilidad voluntariohabilidad);

}

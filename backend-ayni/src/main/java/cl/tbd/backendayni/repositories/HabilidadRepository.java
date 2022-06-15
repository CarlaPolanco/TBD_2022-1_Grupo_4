package cl.tbd.backendayni.repositories;


import cl.tbd.backendayni.models.Habilidad;
import java.util.List;

/**
 * Interface para HabilidadRepository
 */
public interface HabilidadRepository {
    public int countHabilidades();
    public int newId();
    public List<Habilidad> getAll();
    public List<Habilidad> showHabilidadById(long id);
    public Habilidad createHabilidad(Habilidad habilidad);
    public void deleteHabilidadById(long id);
    public void updateHabilidad(Habilidad habilidad);
}

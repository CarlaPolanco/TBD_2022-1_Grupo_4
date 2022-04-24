package cl.tbd.backendayni.repositories;

<<<<<<< Updated upstream

import cl.tbd.backendayni.models.Habilidad;
import java.util.*;

public interface HabilidadRepository {
    public int countHabilidades();
    public int newId();
    public List<Habilidad> getAll();
    public List<Habilidad> showHabilidadById(long id);
    public Habilidad createHabilidad(Habilidad habilidad);
    public void deleteHabilidadById(long id);
    public void updateHabilidadById(Habilidad habilidad);
=======
import java.util.ArrayList;

import cl.tbd.backendayni.models.Habilidad;

public interface HabilidadRepository {
    
    public int countHabilidades();
    public ArrayList<Habilidad> getAll();
    
>>>>>>> Stashed changes
}

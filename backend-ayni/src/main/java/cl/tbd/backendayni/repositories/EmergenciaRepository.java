package cl.tbd.backendayni.repositories;


import cl.tbd.backendayni.models.Emergencia;
import java.util.*;


public interface EmergenciaRepository {
    
    public int countEmergencias();
    public int newId();
    public List<Emergencia> getAll();
    public List<Emergencia> showEmergenciaById(long id);
    public Emergencia createEmergencia(Emergencia emergencia);
    public void deleteEmergenciaById(long id);
    public void updateEmergenciaById(Emergencia emergencia);
}

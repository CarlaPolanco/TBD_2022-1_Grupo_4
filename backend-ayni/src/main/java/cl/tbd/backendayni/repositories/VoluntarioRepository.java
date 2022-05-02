package cl.tbd.backendayni.repositories;

import cl.tbd.backendayni.models.Voluntario;
import java.util.*;


public interface VoluntarioRepository {
    
    public int countVoluntarios();
    public int newId();
    public List<Voluntario> getAll();
    public void getVoluntarioLogin(String nombre, String password);
    public List<Voluntario> showVoluntarioById(long id);
    public Voluntario createVoluntario(Voluntario voluntario);
    public void deleteVoluntarioById(long id);
    public void updateVoluntario(Voluntario voluntario);
}


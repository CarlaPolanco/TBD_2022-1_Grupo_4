package cl.tbd.backendayni.repositories;


import java.util.*;
import cl.tbd.backendayni.models.Institucion;

public interface InstitucionRepository {

    public int countInstituciones();
    public int newId();
    public List<Institucion> getAll();
    public List<Institucion> showInstitucionById(long id);
    public Institucion createInstitucion(Institucion institucion);
    public void deleteInstitucionById(long id);
    public void updateInstitucion(Institucion institucion);
}

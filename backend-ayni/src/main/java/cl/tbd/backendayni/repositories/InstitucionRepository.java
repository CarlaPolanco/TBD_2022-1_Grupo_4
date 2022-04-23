package cl.tbd.backendayni.repositories;

import cl.tbd.backendayni.models.Institucion;

public interface InstitucionRepository {

    public void save(Institucion institucion);
    public void delete(Institucion institucion);
    public void update(Institucion institucion);
    public Institucion findById(long id);
    public Institucion findByNombre(String nombre);
    public Institucion findByCorreo(String correo);
    public Institucion findByNumero(String numero);
    
}

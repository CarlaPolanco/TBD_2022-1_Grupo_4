package cl.tbd.backendayni.repositories;


import org.springframework.stereotype.Repository;
import cl.tbd.backendayni.models.Habilidad;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

@Repository
public class HabilidadRepositoryImp implements HabilidadRepository {

    @Autowired
    private Sql2o sql2o;

    /**
     * @return {@value} int cantidad de habilidades
     * @throws Exception si no se puede obtener la cantidad de habilidades
     * @see cl.tbd.backendayni.repositories.HabilidadRepository#countHabilidades()
     */
    @Override
    public int countHabilidades(){
        int total = 0;
        String sql = "SELECT COUNT(*) FROM habilidad";
        try (Connection conn = sql2o.open()) {
            total = conn.createQuery(sql).executeScalar(Integer.class);
            return total;
        }
    }

    /**
     * @return {@value} int nuevo id
     * @throws Exception si no se puede obtener el id
     * @see cl.tbd.backendayni.repositories.HabilidadRepository#newId()
     */
    @Override
    public int newId(){
        int id = 0;
        String sql = "SELECT MAX(id) FROM habilidad";
        try (Connection conn = sql2o.open()) {
            id = conn.createQuery(sql).executeScalar(Integer.class);
            return id;
        }
    }

    /**
     * @return {@value} List<Habilidad> lista de habilidades
     * @throws Exception si no se puede obtener la lista de habilidades
     * @see cl.tbd.backendayni.repositories.HabilidadRepository#getAll()
     */
    @Override
    public List<Habilidad> getAll() {
        try(Connection conn = sql2o.open()){
            return conn.createQuery("SELECT * FROM habilidad ORDER BY habilidad.id ASC")
                    .executeAndFetch(Habilidad.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    
    /**
     * @param {@value} int id
     * @return {@value} Habilidad habilidad
     * @throws Exception si no se puede obtener la habilidad
     * @see cl.tbd.backendayni.repositories.HabilidadRepository#getById(int)
     */
    @Override
    public List<Habilidad> showHabilidadById(long id){
        try(Connection conn = sql2o.open()){
            return conn.createQuery("SELECT * FROM habilidad WHERE habilidad.id = :id")
                    .addParameter("id", id)
                    .executeAndFetch(Habilidad.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    /**
     * @param {@value} Habilidad habilidad
     * @return {@value} Habilidad habilidad
     * @throws Exception si no se puede crear la habilidad
     * @see cl.tbd.backendayni.repositories.HabilidadRepository#create(Habilidad)
     */
    @Override
    public Habilidad createHabilidad(Habilidad habilidad){
        Connection conn = sql2o.open();

        String SQL_INSERT = "INSERT INTO habilidad(nombre)" + "VALUES (:nombre2)";

        try{
            conn.createQuery(SQL_INSERT,true)
                .addParameter("nombre2", habilidad.getNombre())
                .executeUpdate();
            habilidad.setId(newId());
            return habilidad;

        } catch(Exception e) {
            System.out.println(e.getMessage() + e.getLocalizedMessage() + "No se pudo crear la habilidad\n");
            return null;
        }

    }

    /**
     * @param {@value} int id
     * @return void
     * @throws Exception si no se puede eliminar la habilidad
     * @see cl.tbd.backendayni.repositories.HabilidadRepository#deleteById(int)
     */
    @Override 
    public void deleteHabilidadById(long id){
        Connection conn = sql2o.open();
        String SQL_DELETE = "DELETE FROM habilidad WHERE habilidad.id = :id";

        try{
            conn.createQuery(SQL_DELETE).addParameter("id", id).executeUpdate();

        } catch(Exception e) {
            System.out.println(e.getMessage() + e.getLocalizedMessage() + "No se pudo borrar la habilidad\n");
        }
    }

    /**
     * @param {@value} Habilidad habilidad
     * @return void
     * @throws Exception si no se puede actualizar la habilidad
     * @see cl.tbd.backendayni.repositories.HabilidadRepository#update(Habilidad)
     */
    @Override
    public void updateHabilidad(Habilidad habilidad){

        String SQL_UPDATE = "UPDATE habilidad SET nombre = :nombre2 WHERE id = :id2";

        try(Connection conn = sql2o.open()) {

            conn.createQuery(SQL_UPDATE)
                .addParameter("nombre2", habilidad.getNombre())
                .addParameter("id2", habilidad.getId())
                .executeUpdate();

        } catch(Exception e) {
            System.out.println(e.getMessage() + e.getLocalizedMessage() + "No se pudo actualizar la habilidad\n");
        }
    }
}

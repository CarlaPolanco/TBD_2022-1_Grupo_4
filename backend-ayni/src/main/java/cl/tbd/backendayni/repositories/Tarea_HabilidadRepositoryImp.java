package cl.tbd.backendayni.repositories;


import cl.tbd.backendayni.models.Tarea_Habilidad;
import org.sql2o.Sql2o;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;


@Repository
public class Tarea_HabilidadRepositoryImp implements Tarea_HabilidadRepository{
    
    @Autowired
    private Sql2o sql2o;

    /**
     * @return {@value} int cantidad de tareas_habilidades
     * @throws Exception si no se puede obtener la cantidad de tareas_habilidades
     * @see cl.tbd.backendayni.repositories.Tarea_HabilidadRepository#countTareasHabilidad()
     */
    @Override
    public int countTareasHabilidad(){
        int total = 0;
        String sql = "SELECT COUNT(*) FROM tarea_habilidad";
        try (Connection conn = sql2o.open()) {
            total = conn.createQuery(sql).executeScalar(Integer.class);
            return total;
        }
    }

    /**
     * @return {@value} int nuevo id
     * @throws Exception si no se puede obtener el id
     * @see cl.tbd.backendayni.repositories.Tarea_HabilidadRepository#newId()
     */
    @Override
    public int newId(){
        int id = 0;
        String sql = "SELECT MAX(id) FROM tarea_habilidad";
        try (Connection conn = sql2o.open()) {
            id = conn.createQuery(sql).executeScalar(Integer.class);
            return id;
        }
    }

    /**
     * @return {@value} List<Tarea_Habilidad> lista de tareas_habilidades
     * @throws Exception si no se puede obtener la lista de tareas_habilidades
     * @see cl.tbd.backendayni.repositories.Tarea_HabilidadRepository#getAll()
     */
    @Override
    public List<Tarea_Habilidad> getAll() {
        try(Connection conn = sql2o.open()){
            return conn.createQuery("SELECT * FROM tarea_habilidad ORDER BY tarea_habilidad.id ASC")
                    .executeAndFetch(Tarea_Habilidad.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    /**
     * @param id {@value} int id de la tarea_habilidad
     * @return {@value} List<Tarea_Habilidad> lista de tareas_habilidades
     * @throws Exception si no se puede obtener la lista de tareas_habilidades
     * @see cl.tbd.backendayni.repositories.Tarea_HabilidadRepository#showTareaHabilidadById(long id)
     */
    @Override
    public List<Tarea_Habilidad> showTareaHabilidadById(long id){
        try(Connection conn = sql2o.open()){
            return conn.createQuery("SELECT * FROM tarea_habilidad WHERE tarea_habilidad.id = :id")
                    .addParameter("id", id)
                    .executeAndFetch(Tarea_Habilidad.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    } 
    
    /**
     * @param tarea_habilidad {@value} Tarea_Habilidad tarea_habilidad
     * @return {@value} Tarea_Habilidad tarea_habilidad
     * @throws Exception si no se puede crear la tarea_habilidad
     * @see cl.tbd.backendayni.repositories.Tarea_HabilidadRepository#createTareaHabilidad(Tarea_Habilidad tarea_habilidad)
     */  
    @Override
    public Tarea_Habilidad createTareaHabilidad(Tarea_Habilidad tarea_habilidad){
        Connection conn = sql2o.open();
        String SQL_INSERT = "INSERT INTO tarea_habilidad(id_tarea, id_habilidad)" + 
                            "VALUES(:id_tarea2, :id_habilidad2)";

        try{

            conn.createQuery(SQL_INSERT,true)
                .addParameter("id_tarea2", tarea_habilidad.getId_tarea())
                .addParameter("id_habilidad2", tarea_habilidad.getId_habilidad())
                .executeUpdate();


            tarea_habilidad.setId(newId());

            return tarea_habilidad;

        } catch(Exception e) {
            System.out.println(e.getMessage() + e.getLocalizedMessage() + "No se pudo crear tareahabilidad\n");
            return null;
        }
    }

    /**
     * @param id {@value} int id de la tarea_habilidad
     * @return void
     * @throws Exception si no se puede eliminar la tarea_habilidad
     * @see cl.tbd.backendayni.repositories.Tarea_HabilidadRepository#deleteTareaHabilidad(long id)
     */
    @Override 
    public void deleteTareaHabilidadById(long id){
        Connection conn = sql2o.open();
        String SQL_DELETE = "DELETE FROM tarea_habilidad WHERE tarea_habilidad.id = :id";

        try{
            conn.createQuery(SQL_DELETE).addParameter("id", id).executeUpdate();

        } catch(Exception e) {
            System.out.println(e.getMessage() + e.getLocalizedMessage() + "No se pudo borrar el tareahabilidad\n");
        }
    }

    /**
     * @param tarea_habilidad {@value} Tarea_Habilidad tarea_habilidad
     * @return void
     * @throws Exception si no se puede actualizar la tarea_habilidad
     * @see cl.tbd.backendayni.repositories.Tarea_HabilidadRepository#updateTareaHabilidad(Tarea_Habilidad tarea_habilidad)
     */
    @Override
    public void updateTareaHabilidad(Tarea_Habilidad tarea_habilidad){

        String SQL_UPDATE = "UPDATE tarea_habilidad SET id = :id2, id_tarea = id_tarea2, id_habilidad = id_habiliadad2 WHERE id = :id2";
        
        try(Connection conn = sql2o.open()) {

            conn.createQuery(SQL_UPDATE)
                .addParameter("id_tarea2", tarea_habilidad.getId_tarea())
                .addParameter("id_habilidad2", tarea_habilidad.getId_habilidad())
                .addParameter("id2", tarea_habilidad.getId())
                .executeUpdate();

        } catch(Exception e) {
            System.out.println(e.getMessage() + e.getLocalizedMessage() + "No se pudo actualizar el tareahabilidad\n");
        }
    }

}

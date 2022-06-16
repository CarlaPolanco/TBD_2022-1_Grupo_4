package cl.tbd.backendayni.repositories;

import org.springframework.stereotype.Repository;
import cl.tbd.backendayni.models.Tarea;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

@Repository
public class TareaRepositoryImp implements TareaRepository {

    @Autowired
    private Sql2o sql2o;

    /**
     * @return {@value} int cantidad de tareas
     * @throws Exception si no se puede obtener la cantidad de tareas
     * @see cl.tbd.backendayni.repositories.TareaRepository#countTareas()
     */
    @Override
    public int countTareas(){
        int total = 0;
        String sql = "SELECT COUNT(*) FROM tarea";
        try (Connection conn = sql2o.open()) {
            total = conn.createQuery(sql).executeScalar(Integer.class);
            return total;
        }
    }
    
    /**
     * @return {@value} int nuevo id
     * @throws Exception si no se puede obtener el id
     * @see cl.tbd.backendayni.repositories.TareaRepository#newId()
     */
    @Override
    public int newId(){
        int id = 0;
        String sql = "SELECT MAX(id) FROM tarea";
        try (Connection conn = sql2o.open()) {
            id = conn.createQuery(sql).executeScalar(Integer.class);
            return id;
        }
    }

    /**
     * @return {@value} List<Tarea> lista de tareas
     * @throws Exception si no se puede obtener la lista de tareas
     * @see cl.tbd.backendayni.repositories.TareaRepository#getAll()
     */
    @Override
    public List<Tarea> getAll() {
        try(Connection conn = sql2o.open()){
            return conn.createQuery("SELECT * FROM tarea ORDER BY tarea.id ASC")
                    .executeAndFetch(Tarea.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    /* 
    @Override
    public List<Tarea> getAllTareasEmergency(long id)
    {
        try(Connection conn = sql2o.open()){
            return conn.createQuery("SELECT DISTINCT tFinal.id, tFinal.nombre,tFinal.descripcion,tFinal.fecha,tFinal.requerimientos FROM (SELECT tHT.id_tarea as id, tHT.nombre, tHT.descripcion, tHT.fecha, tHT.requerimientos FROM (SELECT t1.id as id_tarea, t1.nombre, t1.descripcion, t1.fecha, t1.requerimientos, t3.id FROM tarea t1, tareahabilidad t2, habilidad t3 WHERE t1.id = t2.idtarea AND t3.id = t2.idhabilidad) tHT INNER JOIN(SELECT t6.id as id_habilidad, t4.id as id_emergencia FROM emergencia t4, emergenciahabilidad t5, habilidad t6 WHERE t4.id = t5.idemergencia AND t6.id = t5.idhabilidad) tHE ON  tHT.id_tarea =tHE.id_habilidad AND tHE.id_emergencia = :id) tFinal; ")
                .addParameter("id", id)
                .executeAndFetch(Tarea.class);
        }catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }*/

    /**
     * @param id {@value} long id de la tarea
     * @return {@value} List<Tarea> lista de tareas
     * @throws Exception si no se puede obtener la lista de tareas
     * @see cl.tbd.backendayni.repositories.TareaRepository#showTareaById(long id)
     */
    @Override
    public List<Tarea> showTareaById(long id){
        try(Connection conn = sql2o.open()){
            return conn.createQuery("SELECT * FROM tarea WHERE tarea.id = :id")
                    .addParameter("id", id)
                    .executeAndFetch(Tarea.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    /**
     * @param tarea {@value} Tarea tarea a crear
     * @return {@value} Tarea tarea creada
     * @throws Exception si no se puede crear la tarea
     * @see cl.tbd.backendayni.repositories.TareaRepository#createTarea(Tarea tarea)
     */
    @Override
    public Tarea createTarea(Tarea tarea){
        Connection conn = sql2o.open();

        String SQL_INSERT = "INSERT INTO tarea(id_emergencia, nombre, descripcion, fecha, requerimientos, longitude, latitude)" + 
        "VALUES (:id_emergencia2, :nombre2, :descripcion2, :fecha2, :requerimientos2, :longitude2, :latitude2)";

        try{
            conn.createQuery(SQL_INSERT)
                .addParameter("id_emergencia2", tarea.getId_emergencia())
                .addParameter("nombre2", tarea.getNombre())
                .addParameter("descripcion2", tarea.getDescripcion())
                .addParameter("fecha2", tarea.getFecha())
                .addParameter("requerimientos2", tarea.getRequerimientos())
                .addParameter("longitude2", tarea.getLongitude())
                .addParameter("latitude2", tarea.getLatitude())
                .executeUpdate();

            tarea.setId(newId());

            return tarea;

        } catch(Exception e) {
            System.out.println(e.getMessage() + e.getLocalizedMessage() + "No se pudo crear la emergencia\n");
            return null;
        }
    }

    /**
     * @param id {@value} long id de la tarea
     * @return {@value} Tarea tarea eliminada
     * @throws Exception si no se puede eliminar la tarea
     * @see cl.tbd.backendayni.repositories.TareaRepository#deleteTarea(long id)
     */
    @Override 
    public void deleteTareaById(long id){
        Connection conn = sql2o.open();
        String SQL_DELETE = "DELETE FROM tarea WHERE tarea.id = :id";

        try{
            conn.createQuery(SQL_DELETE).addParameter("id", id).executeUpdate();

        } catch(Exception e) {
            System.out.println(e.getMessage() + e.getLocalizedMessage() + "No se pudo borrar la tarea\n");
        }
    }


    /**
     * @param tarea {@value} Tarea tarea a actualizar
     * @return {@value} Tarea tarea actualizada
     * @throws Exception si no se puede actualizar la tarea
     * @see cl.tbd.backendayni.repositories.TareaRepository#updateTarea(Tarea tarea)
     */
    @Override
    public void updateTarea(Tarea tarea){

        String SQL_UPDATE = "UPDATE tarea SET id_emergencia = :id_emergencia2, nombre = :nombre2, descripcion = :descripcion2, fecha = :fecha2, requerimientos = :requerimientos2, longitude = :longitude2, latitude = :latitude2, id = :id2 WHERE id = :id2";
        
        try(Connection conn = sql2o.open()) {

            conn.createQuery(SQL_UPDATE)
                .addParameter("id_emergencia2", tarea.getId_emergencia())
                .addParameter("nombre2", tarea.getNombre())
                .addParameter("descripcion2", tarea.getDescripcion())
                .addParameter("fecha2", tarea.getFecha())
                .addParameter("requerimientos2", tarea.getRequerimientos())
                .addParameter("longitude2", tarea.getLongitude())
                .addParameter("latitude2", tarea.getLatitude())
                .addParameter("id2", tarea.getId())
                .executeUpdate();

        } catch(Exception e) {
            System.out.println(e.getMessage() + e.getLocalizedMessage() + "No se pudo actualizar la tarea\n");
        }
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    //COMPLEMENTARIOS    

    /**
     * @param id {@value} long id de la emergencia
     * @return {@value} List<Tarea> lista de tareas
     * @throws Exception si no se puede obtener la lista de tareas
     * @see cl.tbd.backendayni.repositories.TareaRepository#showTareaByIdEmergencia(long id)
     */
    @Override
    public List<Tarea> getTareaByIdEmergencia(long id){
        String SQL_SELECT = "SELECT * FROM tarea WHERE tarea.id_emergencia = :id";
        try(Connection conn = sql2o.open()){
            return conn.createQuery(SQL_SELECT)
                    .addParameter("id", id)
                    .executeAndFetch(Tarea.class);
        }catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

}

package cl.tbd.backendayni.repositories;


import cl.tbd.backendayni.models.EmergenciaHabilidad;
import org.sql2o.Sql2o;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jmx.export.annotation.ManagedAttribute;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Query;
import org.springframework.context.annotation.Bean;

@Repository
public class EmergenciaHabilidadRepositoryImp implements EmergenciaHabilidadRepository {
    @Autowired(required = false)
    private Sql2o sql2o;

    @Override
    public int countEmergenciaHabilidades(){
        int total = 0;
        String sql = "SELECT COUNT(*) FROM emergenciahabilidad";
        try (Connection conn = sql2o.open()) {
            total = conn.createQuery(sql).executeScalar(Integer.class);
            return total;
        }
    }


    @Override
    public int newId(){
        int id = 0;
        String sql = "SELECT MAX(id) FROM emergenciahabilidad";
        try (Connection conn = sql2o.open()) {
            id = conn.createQuery(sql).executeScalar(Integer.class);
            return id+1;
        }
    }


    @Override
    public List<EmergenciaHabilidad> getAll() {
        try(Connection conn = sql2o.open()){
            return conn.createQuery("SELECT * FROM emergenciahabilidad ORDER BY emergenciahabilidad.id ASC")
                    .executeAndFetch(EmergenciaHabilidad.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }


    @Override
    public List<EmergenciaHabilidad> showEmergenciaHabilidadById(long id){
        try(Connection conn = sql2o.open()){
            return conn.createQuery("SELECT * FROM emergenciahabilidad WHERE emergenciahabilidad.id = :id")
                    .addParameter("id", id)
                    .executeAndFetch(EmergenciaHabilidad.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    } 


    @Override
    public EmergenciaHabilidad createEmergenciaHabilidad(EmergenciaHabilidad emergenciaHabilidad) {
        Connection conn = sql2o.open();
        String SQL_INSERT = "INSERT INTO emergenciahabilidad(id_emergencia_habilidad, id_emergencia, id_habilidad)" + 
        "VALUES (:id_emergencia_habilidad2, :id_emergencia2, :id_habilidad2)";

        try{
            conn.createQuery(SQL_INSERT)
                .addParameter("id_emergencia_habilidad2", emergenciaHabilidad.getId_emergencia_habilidad())
                .addParameter("id_emergencia2", emergenciaHabilidad.getId_emergencia())
                .addParameter("id_habilidad2", emergenciaHabilidad.getId_habilidad())
                .executeUpdate();

            emergenciaHabilidad.setId_emergencia_habilidad(newId());

            return emergenciaHabilidad;

        } catch(Exception e) {
            System.out.println(e.getMessage() + e.getLocalizedMessage() + "No se pudo crear la emergenciaHabilidad\n");
            return null;
        }
    }


    @Override 
    public void deleteEmergenciaHabilidadById(long id){
        Connection conn = sql2o.open();
        String SQL_DELETE = "DELETE FROM emergenciahabilidad WHERE emergenciahabilidad.id = :id";

        try{
            conn.createQuery(SQL_DELETE).addParameter("id", id).executeUpdate();

        } catch(Exception e) {
            System.out.println(e.getMessage() + e.getLocalizedMessage() + "No se pudo borrar la emergenciaHabilidad\n");
        }
    }


    @Override
    public void updateEmergenciaHabilidad(EmergenciaHabilidad emergenciaHabilidad){
        String SQL_UPDATE = "UPDATE emergenciahabilidad SET id_emergencia_habilidad = :id_emergencia_habilidad2, id_emergencia = :id_emergencia2, id_habilidad = :id_habilidad2 WHERE emergenciahabilidad.id = :id";

        try(Connection conn = sql2o.open()) {
            conn.createQuery(SQL_UPDATE)
                .addParameter("id_emergencia_habilidad2", emergenciaHabilidad.getId_emergencia_habilidad())
                .addParameter("id_emergencia2", emergenciaHabilidad.getId_emergencia())
                .addParameter("id_habilidad2", emergenciaHabilidad.getId_habilidad())
                .addParameter("id", emergenciaHabilidad.getId_emergencia_habilidad())
                .executeUpdate();

        } catch(Exception e) {
            System.out.println(e.getMessage() + e.getLocalizedMessage() + "No se pudo actualizar la emergenciaHabilidad\n");
        }
    }
}

package cl.tbd.backendayni.repositories;

import cl.tbd.backendayni.models.Voluntario;
import org.sql2o.Sql2o;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jmx.export.annotation.ManagedAttribute;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Query;


@Repository
public class VoluntarioRepositoryImp implements VoluntarioRepository {
    
    @Autowired(required = false)
    private Sql2o sql2o;

    @Override
    public int countVoluntarios(){
        int total = 0;
        String sql = "SELECT COUNT(*) FROM voluntario";
        try (Connection conn = sql2o.open()) {
            total = conn.createQuery(sql).executeScalar(Integer.class);
            return total;
        }
    }


    @Override
    public int newId(){
        int id = 0;
        String sql = "SELECT MAX(id) FROM voluntario";
        try (Connection conn = sql2o.open()) {
            id = conn.createQuery(sql).executeScalar(Integer.class);
            return id+1;
        }
    }

    
    @Override
    public List<Voluntario> getAll() {
        try(Connection conn = sql2o.open()){
            return conn.createQuery("SELECT * FROM voluntario ORDER BY voluntario.id ASC")
                    .executeAndFetch(Voluntario.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }


    @Override
    public List<Voluntario> showVoluntarioById(long id){
        try(Connection conn = sql2o.open()){
            return conn.createQuery("SELECT * FROM voluntario WHERE voluntario.id = :id")
                    .addParameter("id", id)
                    .executeAndFetch(Voluntario.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    } 
    
    /*
    @Override
    public Voluntario createVoluntario(Voluntario voluntario){
        Connection conn = sql2o.open();
        String SQL_INSERT = "INSERT INTO emergencia(nombre, correo, nombreUsuario, contrasena, atributos)" + 
                            "VALUES(:nombre2, :descripcion2, :fecha2, :longitud2, :latitud2, :requisitosGrupales2, :requisitosIndividuales2)";

        try{

            conn.createQuery(SQL_INSERT)
                .addParameter("nombre2", emergencia.getNombre())
                .addParameter("descripcion2", emergencia.getDescripcion())
                .addParameter("fecha2", emergencia.getFecha())
                .addParameter("longitud2", emergencia.getLongitud())
                .addParameter("latitud2", emergencia.getLatitud())
                .addParameter("requisitosGrupales2", emergencia.getRequisitosGrupales())
                .addParameter("requisitosIndividuales2", emergencia.getRequisitosIndividuales())
                .executeUpdate();

            emergencia.setId(newId());

            return emergencia;

        } catch(Exception e) {
            System.out.println(e.getMessage() + e.getLocalizedMessage() + "No se pudo crear la emergencia\n");
            return null;
        }
    }


    @Override 
    public void deleteEmergenciaById(long id){
        Connection conn = sql2o.open();
        String SQL_DELETE = "DELETE FROM emergencia WHERE emergencia.id = :id";

        try{
            conn.createQuery(SQL_DELETE).addParameter("id", id).executeUpdate();

        } catch(Exception e) {
            System.out.println(e.getMessage() + e.getLocalizedMessage() + "No se pudo borrar la emergencia\n");
        }
    }


    @Override
    public void updateEmergenciaById(Emergencia emergencia){

        String SQL_UPDATE = "UPDATE emergencia SET nombre = :nombre2, descripcion = :descripcion2, fecha = :fecha2, longitud = :longitud2, latitud = :latitud2, requisitosGrupales = :requisitosGrupales2, requisitosIndividuales = :requisitosIndividuales2, id = :id2 WHERE id = :id2";
        
        try(Connection conn = sql2o.open()) {

            conn.createQuery(SQL_UPDATE)
                .addParameter("nombre2", emergencia.getNombre())
                .addParameter("descripcion2", emergencia.getDescripcion())
                .addParameter("fecha2", emergencia.getFecha())
                .addParameter("longitud2", emergencia.getLongitud())
                .addParameter("latitud2", emergencia.getLatitud())
                .addParameter("requisitosGrupales2", emergencia.getRequisitosGrupales())
                .addParameter("requisitosIndividuales2", emergencia.getRequisitosIndividuales())
                .addParameter("id2", emergencia.getId())
                .executeUpdate();

        } catch(Exception e) {
            System.out.println(e.getMessage() + e.getLocalizedMessage() + "No se pudo actualizar la emergencia\n");
        }
    }*/

}


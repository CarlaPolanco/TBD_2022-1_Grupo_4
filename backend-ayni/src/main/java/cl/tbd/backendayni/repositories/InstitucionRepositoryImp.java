package cl.tbd.backendayni.repositories;

import org.springframework.stereotype.Repository;
import cl.tbd.backendayni.models.Institucion;
import org.sql2o.Sql2o;
import org.sql2o.Connection;
import org.sql2o.Query;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;


@Repository
public class InstitucionRepositoryImp implements InstitucionRepository {

    @Autowired(required = false)
    private Sql2o sql2o;

    @Override
    public int countInstituciones(){
        int total = 0;
        String sql = "SELECT COUNT(*) FROM institucion";
        try (Connection conn = sql2o.open()) {
            total = conn.createQuery(sql).executeScalar(Integer.class);
            return total;
        }
    }


    @Override
    public int newId(){
        int id = 0;
        String sql = "SELECT MAX(id) FROM institucion";
        try (Connection conn = sql2o.open()) {
            id = conn.createQuery(sql).executeScalar(Integer.class);
            return id+1;
        }
    }


    @Override
    public List<Institucion> getAll() {
        try(Connection conn = sql2o.open()){
            return conn.createQuery("SELECT * FROM institucion ORDER BY institucion.id ASC")
                    .executeAndFetch(Institucion.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }


    @Override
    public List<Institucion> showInstitucionById(long id){
        try(Connection conn = sql2o.open()){
            return conn.createQuery("SELECT * FROM institucion WHERE institucion.id = :id")
                    .addParameter("id", id)
                    .executeAndFetch(Institucion.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    } 
    

    @Override
    public Institucion createInstitucion(Institucion institucion){
        Connection conn = sql2o.open();
        String SQL_INSERT = "INSERT INTO institucion (id, nombre, correo, numero) VALUES (:id2, :nombre2, :correo2, :numero2)";

        try{

            conn.createQuery(SQL_INSERT)
                .addParameter("id2", institucion.getInstitucionid())
                .addParameter("nombre2", institucion.getInstitucionNombre())
                .addParameter("correo2", institucion.getInstitucionCorreo())
                .addParameter("numero2", institucion.getInstitucionCorreo())
                .executeUpdate();

            institucion.setInstitucionId(newId());
            return institucion;

        } catch(Exception e) {
            System.out.println(e.getMessage() + e.getLocalizedMessage() + "No se pudo crear la institucion\n");
            return null;
        }
    }
    

    @Override 
    public void deleteInstitucionById(long id){
        Connection conn = sql2o.open();
        String SQL_DELETE = "DELETE FROM intitucion WHERE institucion.id = :id";

        try{
            conn.createQuery(SQL_DELETE).addParameter("id", id).executeUpdate();

        } catch(Exception e) {
            System.out.println(e.getMessage() + e.getLocalizedMessage() + "No se pudo borrar la institucion\n");
        }
    }


    @Override
    public void updateInstitucion(Institucion institucion){

        String SQL_UPDATE = "UPDATE institucion SET institucion.nombre = :nombre2, institucion.correo = :correo2, institucion.numero = :numero2 WHERE institucion.id = :id2";

        
        try(Connection conn = sql2o.open()) {

            conn.createQuery(SQL_UPDATE)
                .addParameter("id2", institucion.getInstitucionid())
                .addParameter("nombre2", institucion.getInstitucionNombre())
                .addParameter("correo2", institucion.getInstitucionCorreo())
                .addParameter("numero2", institucion.getInstitucionCorreo())
                .executeUpdate();

        } catch(Exception e) {
            System.out.println(e.getMessage() + e.getLocalizedMessage() + "No se pudo actualizar la institucion\n");
        }
    }

}
    


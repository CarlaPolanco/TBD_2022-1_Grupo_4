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
    
    @Override
    public List<Voluntario> getVoluntarioLogin(String nombre,String password){
        try(Connection conn = sql2o.open())
        {
            return conn.createQuery("SELECT * FROM voluntario WHERE nombreUsuario = :nombreUsuario2 AND contrasena = :contrasena2")
                .addParameter("nombreUsuario2",nombre)
                .addParameter("contrasena2",password)
                .executeAndFetch(Voluntario.class);
        } catch(Exception e) {
            System.out.println(e.getMessage() + e.getLocalizedMessage() + "Nombre de Usuario o Contrasena incorrectos\n");
            return null;
        }
    }
    
    @Override
    public Voluntario createVoluntario(Voluntario voluntario){
        Connection conn = sql2o.open();
        String SQL_INSERT = "INSERT INTO voluntario(correo, nombreUsuario, contrasena, atributos)" + 
                            "VALUES(:correo2, :nombreUsuario2, :contrasena2, :atributos2)";

        try{

            conn.createQuery(SQL_INSERT)
                .addParameter("correo2", voluntario.getCorreo())
                .addParameter("nombreUsuario2", voluntario.getNombreusuario())
                .addParameter("contrasena2", voluntario.getContrasena())
                .addParameter("atributos2", voluntario.getAtributos())
                .executeUpdate();

            voluntario.setId(newId());

            return voluntario;

        } catch(Exception e) {
            System.out.println(e.getMessage() + e.getLocalizedMessage() + "No se pudo crear la voluntario\n");
            return null;
        }
    }


    @Override 
    public void deleteVoluntarioById(long id){
        Connection conn = sql2o.open();
        String SQL_DELETE = "DELETE FROM voluntario WHERE voluntario.id = :id";

        try{
            conn.createQuery(SQL_DELETE).addParameter("id", id).executeUpdate();

        } catch(Exception e) {
            System.out.println(e.getMessage() + e.getLocalizedMessage() + "No se pudo borrar el voluntario\n");
        }
    }


    @Override
    public void updateVoluntario(Voluntario voluntario){

        String SQL_UPDATE = "UPDATE voluntario SET correo = :correo2, nombreUsuario = :nombreUsuario2, contrasena = :contrasena2, atributos = :atributos2, id = :id2 WHERE id = :id2";
        
        try(Connection conn = sql2o.open()) {

            conn.createQuery(SQL_UPDATE)
                .addParameter("correo2", voluntario.getCorreo())
                .addParameter("nombreUsuario2", voluntario.getNombreusuario())
                .addParameter("contrasena2", voluntario.getContrasena())
                .addParameter("atributos2", voluntario.getAtributos())
                .addParameter("id2", voluntario.getId())
                .executeUpdate();

        } catch(Exception e) {
            System.out.println(e.getMessage() + e.getLocalizedMessage() + "No se pudo actualizar el voluntario\n");
        }
    }

}


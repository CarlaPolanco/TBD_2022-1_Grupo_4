package cl.tbd.backendayni.repositories;

import cl.tbd.backendayni.models.Voluntario;
import org.sql2o.Sql2o;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;


@Repository
public class VoluntarioRepositoryImp implements VoluntarioRepository {
    
    @Autowired
    private Sql2o sql2o;

    /**
     * @return {@value} int cantidad de voluntarios
     * @throws Exception si no se puede obtener la cantidad de voluntarios
     * @see cl.tbd.backendayni.repositories.VoluntarioRepository#countVoluntarios()
     */
    @Override
    public int countVoluntarios(){
        int total = 0;
        String sql = "SELECT COUNT(*) FROM voluntario";
        try (Connection conn = sql2o.open()) {
            total = conn.createQuery(sql).executeScalar(Integer.class);
            return total;
        }
    }

    /**
     * @return {@value} int nuevo id
     * @throws Exception si no se puede obtener el id
     * @see cl.tbd.backendayni.repositories.VoluntarioRepository#newId()
     */
    @Override
    public int newId(){
        int id = 0;
        String sql = "SELECT MAX(id) FROM voluntario";
        try (Connection conn = sql2o.open()) {
            id = conn.createQuery(sql).executeScalar(Integer.class);
            return id;
        }
    }

    /**
     * @return {@value} List<Voluntario> lista de voluntarios
     * @throws Exception si no se puede obtener la lista de voluntarios
     * @see cl.tbd.backendayni.repositories.VoluntarioRepository#getAll()
     */
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

    /**
     * @param id {@value} int id del voluntario
     * @return {@value} Voluntario voluntario
     * @throws Exception si no se puede obtener el voluntario
     * @see cl.tbd.backendayni.repositories.VoluntarioRepository#showVoluntarioById(int id)
     */
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
    
    /**
     * @param nombre {@value} String nombre del voluntario
     * @param password {@value} String password del voluntario
     * @return {@value} List<Voluntario> lista de voluntarios
     * @throws Exception si no se puede obtener la lista de voluntarios
     * @see cl.tbd.backendayni.repositories.VoluntarioRepository#getVoluntarioLogin(String nombre, String password)
     */
    @Override
    public List<Voluntario> getVoluntarioLogin(String nombre,String password){
        try(Connection conn = sql2o.open())
        {
            return conn.createQuery("SELECT * FROM voluntario WHERE usuario = :usuario2 AND password = :password2")
                .addParameter("usuario2",nombre)
                .addParameter("password2",password)
                .executeAndFetch(Voluntario.class);
        } catch(Exception e) {
            System.out.println(e.getMessage() + e.getLocalizedMessage() + "Nombre de Usuario o Contrasena incorrectos\n");
            return null;
        }
    }
    
    /**
     * @param voluntario {@value} Voluntario voluntario
     * @return {@value} Voluntario voluntario
     * @throws Exception si no se puede crear el voluntario
     * @see cl.tbd.backendayni.repositories.VoluntarioRepository#createVoluntario(Voluntario voluntario)
     */
    @Override
    public Voluntario createVoluntario(Voluntario voluntario){
        Connection conn = sql2o.open();
        String SQL_INSERT = "INSERT INTO voluntario(correo, usuario, nombre, password, atributos)" + 
                            "VALUES(:correo2, :usuario2, :nombre2, :password2, :atributos2)";

        try{
            conn.createQuery(SQL_INSERT)
                .addParameter("correo2",voluntario.getCorreo())
                .addParameter("usuario2",voluntario.getUsuario())
                .addParameter("nombre2",voluntario.getNombre())
                .addParameter("password2",voluntario.getPassword())
                .addParameter("atributos2",voluntario.getAtributos())
                .executeUpdate();

            voluntario.setId(newId());
            return voluntario;

        } catch(Exception e) {
            System.out.println(e.getMessage() + e.getLocalizedMessage() + "No se pudo crear la voluntario\n");
            return null;
        }
    }

    /**
     * @param id {@value} int id del voluntario
     * @return void
     */
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

    /**
     * @param voluntario {@value} Voluntario voluntario
     * @return void
     */
    @Override
    public void updateVoluntario(Voluntario voluntario){

        String SQL_UPDATE = "UPDATE voluntario SET correo = :correo2, usuario = :usuario2, nombre = :nombre2, password = :password2, atributos = :atributos2, id = :id2 WHERE id = :id2";
        
        try(Connection conn = sql2o.open()) {
            conn.createQuery(SQL_UPDATE)
                .addParameter("correo2",voluntario.getCorreo())
                .addParameter("usuario2",voluntario.getUsuario())
                .addParameter("nombre2",voluntario.getNombre())
                .addParameter("password2",voluntario.getPassword())
                .addParameter("atributos2",voluntario.getAtributos())
                .addParameter("id2",voluntario.getId())
                .executeUpdate();

        } catch(Exception e) {
            System.out.println(e.getMessage() + e.getLocalizedMessage() + "No se pudo actualizar el voluntario\n");
        }
    }

}


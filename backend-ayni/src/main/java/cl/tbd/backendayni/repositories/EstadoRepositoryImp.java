package cl.tbd.backendayni.repositories;


import cl.tbd.backendayni.models.Estado;
import org.sql2o.Sql2o;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;

@Repository
public class EstadoRepositoryImp implements EstadoRepository {
    
    @Autowired
    private Sql2o sql2o;

    /**
     * @return {@value} int cantidad de estados
     * @throws Exception si no se puede obtener la cantidad de estados
     * @see cl.tbd.backendayni.repositories.EstadoRepository#countEstados()
     */
    @Override
    public int countEstados(){
        int total = 0;
        String sql = "SELECT COUNT(*) FROM estado";
        try (Connection conn = sql2o.open()) {
            total = conn.createQuery(sql).executeScalar(Integer.class);
            return total;
        }
    }

    /**
     * @return {@value} int nuevo id
     * @throws Exception si no se puede obtener el id
     * @see cl.tbd.backendayni.repositories.EstadoRepository#newId()
     */
    @Override
    public int newId(){
        int id = 0;
        String sql = "SELECT MAX(id) FROM estado";
        try (Connection conn = sql2o.open()) {
            id = conn.createQuery(sql).executeScalar(Integer.class);
            return id;
        }
    }

    /**
     * @return {@value} List<Estado> lista de estados
     * @throws Exception si no se puede obtener la lista de estados
     * @see cl.tbd.backendayni.repositories.EstadoRepository#getAll()
     */
    @Override
    public List<Estado> getAll() {
        try(Connection conn = sql2o.open()){
            return conn.createQuery("SELECT * FROM estado ORDER BY estado.id ASC")
                    .executeAndFetch(Estado.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    /**
     * @param id {@value} int id del estado
     * @return {@value} Estado estado
     * @throws Exception si no se puede obtener el estado
     */
    @Override
    public List<Estado> showEstadoById(long id){
        try(Connection conn = sql2o.open()){
            return conn.createQuery("SELECT * FROM estado WHERE estado.id = :id")
                    .addParameter("id", id)
                    .executeAndFetch(Estado.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    } 
    
    /**
     * @param estado {@value} Estado estado
     * @return {@value} Estado estado
     * @throws Exception si no se puede crear el estado
     * @see cl.tbd.backendayni.repositories.EstadoRepository#createEstado(cl.tbd.backendayni.models.Estado)
     */
    @Override
    public Estado createEstado(Estado estado){
        Connection conn = sql2o.open();
        String SQL_INSERT = "INSERT INTO estado(nombre)" + 
                            "VALUES(:nombre2)";
        try{

            conn.createQuery(SQL_INSERT,true)
                .addParameter("nombre2", estado.getNombre())
                .executeUpdate();
            estado.setId(newId());
            return estado;

        } catch(Exception e) {
            System.out.println(e.getMessage() + e.getLocalizedMessage() + "No se pudo crear el estado\n");
            return null;
        }
    }

    /**
     * @param id {@value} int id del estado
     * @throws Exception si no se puede eliminar el estado
     * @see cl.tbd.backendayni.repositories.EstadoRepository#deleteEstadoById(long)
     */
    @Override 
    public void deleteEstadoById(long id){
        Connection conn = sql2o.open();
        String SQL_DELETE = "DELETE FROM estado WHERE estado.id = :id";

        try{
            conn.createQuery(SQL_DELETE).addParameter("id", id).executeUpdate();

        } catch(Exception e) {
            System.out.println(e.getMessage() + e.getLocalizedMessage() + "No se pudo borrar el estado\n");
        }
    }

    /**
     * @param estado {@value} Estado estado
     * @throws Exception si no se puede actualizar el estado
     */
    @Override
    public void updateEstado(Estado estado){

        String SQL_UPDATE = "UPDATE estado SET nombre = :nombre2, id = :id2 WHERE id = :id2";
        
        try(Connection conn = sql2o.open()) {

            conn.createQuery(SQL_UPDATE)
                .addParameter("nombre2", estado.getNombre())
                .addParameter("id2", estado.getId())
                .executeUpdate();

        } catch(Exception e) {
            System.out.println(e.getMessage() + e.getLocalizedMessage() + "No se pudo actualizar el estado\n");
        }
    }    
    
}

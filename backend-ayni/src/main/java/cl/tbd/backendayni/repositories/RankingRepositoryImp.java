package cl.tbd.backendayni.repositories;

import java.util.ArrayList;
import java.util.List;
import cl.tbd.backendayni.models.Ranking;
import cl.tbd.backendayni.models.Tarea;
import cl.tbd.backendayni.models.Voluntario;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jmx.export.annotation.ManagedAttribute;
import org.sql2o.Connection;
import org.sql2o.Query;
import org.sql2o.Sql2o;


public class RankingRepositoryImp implements RankingRepository{

    @Override
    public int countAllRanks() {
        int total = 0;
        String sql = "SELECT COUNT(*) FROM ranking";
        try (Connection conn = sql2o.open()) {
            total = conn.createQuery(sql).executeScalar(Integer.class);
            return total;
        }
    }

    @Override
    public int newID() {
        int id = 0;
        String sql = "SELECT MAX(id) FROM ranking";
        try (Connection conn = sql2o.open()) {
            id = conn.createQuery(sql).executeScalar(Integer.class);
            return id+1;
        }
    }

    @Override
    public List<Ranking> getAll() {
        try(Connection conn = sql2o.open()){
            return conn.createQuery("SELECT * FROM tarea ORDER BY ranking.id ASC")
                    .executeAndFetch(Ranking.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<Ranking> showRankingById(long id) {

        try(Connection conn = sql2o.open()){
            return conn.createQuery("SELECT * FROM ranking WHERE ranking.id = :id")
                    .addParameter("id", id)
                    .executeAndFetch(Ranking.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public void deleteRankingById(long id) {
        Connection conn = sql2o.open();
        String SQL_DELETE = "DELETE FROM ranking WHERE ranking.id = :id";

        try{
            conn.createQuery(SQL_DELETE).addParameter("id", id).executeUpdate();

        } catch(Exception e) {
            System.out.println(e.getMessage() + e.getLocalizedMessage() + "No se pudo borrar el Ranking\n");
        }
    }

    @Override
    public void updateRankingById(Ranking ranking) {
        String SQL_UPDATE = "UPDATE ranking SET idVoluntario = :idVoluntario2, idTarea = :idTarea2, id = :id2 WHERE id = :id2";
        
        try(Connection conn = sql2o.open()) {

            conn.createQuery(SQL_UPDATE)
                .addParameter("idTarea2", ranking.getIdTarea())
                .addParameter("idVoluntario2", ranking.getIdVoluntario())
                .addParameter("id2", ranking.getId())
                .executeUpdate();
                
        } catch(Exception e) {
            System.out.println(e.getMessage() + e.getLocalizedMessage() + "No se pudo actualizar el Ranking\n");
        }
    }

    

    
}

package cl.tbd.backendayni.repositories;

import java.util.ArrayList;

import cl.tbd.backendayni.models.Ranking;
import cl.tbd.backendayni.models.Tarea;
import cl.tbd.backendayni.models.Voluntario;

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
    public ArrayList<Ranking> getAll() {
        try(Connection conn = sql2o.open()){
            return conn.createQuery("SELECT * FROM tarea ORDER BY ranking.id ASC")
                    .executeAndFetch(Ranking.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public ArrayList<Ranking> FilterByRanking(float min, float max) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Ranking> showRankingById(long id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Voluntario createVoluntario(Voluntario voluntario) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void deleteVoluntarioById(long id) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void updateVoluntarioById(Voluntario voluntario) {
        // TODO Auto-generated method stub
        
    }

    
}

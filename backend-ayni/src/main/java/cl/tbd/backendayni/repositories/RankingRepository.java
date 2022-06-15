package cl.tbd.backendayni.repositories;

import cl.tbd.backendayni.models.Ranking;
//import cl.tbd.backendayni.models.RankingVoluntario;
import java.util.List;

/*Interface para RankingRepository*/
public interface RankingRepository {

    public Ranking createRanking(Ranking ranking);
    public int countAllRanks();
    public int newID();
    public List<Ranking> getAll();
    public List<Ranking> showRankingById(long id);
    public void deleteRankingById(long id);
    public void updateRanking(Ranking ranking);
    //public void addNumberToRanking(Ranking ranking);
    //public List<Ranking> getAllByTarea(long id);
    //public List<RankingVoluntario> getAllVoluntariosByRanking(long id);
    //public Ranking createPercent(long id1,long id2);
}

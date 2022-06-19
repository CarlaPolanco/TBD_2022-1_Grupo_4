package cl.tbd.backendayni.services;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import cl.tbd.backendayni.models.Ranking;
import cl.tbd.backendayni.models.Ranking_Voluntario;
import cl.tbd.backendayni.repositories.RankingRepository;


@RestController
@RequestMapping("/ranking")
public class RankingService {
    private final RankingRepository rankingRepository;

    /**
     * @param rankingRepository
     */
    RankingService(RankingRepository rankingRepository) {
        this.rankingRepository = rankingRepository;
    }

    /**
     * @return {@value} List<Ranking> lista de rankings
     */
    @GetMapping
    public List<Ranking> getAll() {
        return rankingRepository.getAll();
    }

    /**
     * @return {@value} cantidad de rankings
     */
    @GetMapping("/count")
    public String countRanking(){
        int total = rankingRepository.countAllRanks();
        return String.format("Se tienen %s rankings.", total);
    }

    /**
     * @param ranking ranking a crear
     * @return {@value} Ranking ranking
     */
    @PostMapping("/create")
    @ResponseBody
    public Ranking createRanking(@RequestBody Ranking ranking){
        Ranking newRanking = rankingRepository.createRanking(ranking);
        return newRanking;
    }

    /**
     * @param id id de ranking
     * @return void
     */
    @RequestMapping(value = "/deleteById/{id}", method = RequestMethod.DELETE)
    public void deleteRanking(@PathVariable long id) {
        rankingRepository.deleteRankingById(id);
    }

    /**
     * @param ranking ranking a actualizar
     * @return void
     */
    @RequestMapping(value = "/updateById/{id}", method = RequestMethod.PUT)
    public void updateRanking(@RequestBody Ranking ranking) {
        rankingRepository.updateRanking(ranking);
    }

    /**
     * @param id id de ranking
     * @return {@value} <List>Ranking ranking
     */
    @RequestMapping(value = "/getById/{id}", method = RequestMethod.GET)
    public List<Ranking> getRankingById(@PathVariable long id) {
        return rankingRepository.showRankingById(id);
    }  

    //COMPLEMENTARIO 

    /**
     * @param id id de tarea
     * @return {@value} <List>RankingVoluntario rankingVoluntario
     */
    @RequestMapping(value = "/getRankingByIdTarea/{id}", method = RequestMethod.GET)
    public List<Ranking_Voluntario> getRankingByIdTarea(@PathVariable long id) {
        return rankingRepository.getRankingByIdTarea(id);
    }

    /**
     * @param id id de tarea
     * @return {@value} <List>Ranking ranking
     */
    @PostMapping("/createRankingByIdTarea/{id}")
    public List<Ranking> createRankingByIdTarea(@PathVariable long id) {
        List<Ranking> newRanking = rankingRepository.createRankingByIdTarea(id);
        return newRanking;
    }

    /**
     * @param id id de voluntario
     * @return {@value} <List>Ranking ranking
     */
    @PostMapping("/createRankingByIdVoluntario/{id}")
    public List<Ranking> createRankingByIdVoluntario(@PathVariable long id) {
        List<Ranking> newRanking = rankingRepository.createRankingByIdVoluntario(id);
        return newRanking;
    }



}

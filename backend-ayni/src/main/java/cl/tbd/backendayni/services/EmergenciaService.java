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
import cl.tbd.backendayni.models.Emergencia;
import cl.tbd.backendayni.repositories.EmergenciaRepository;


@RestController
@RequestMapping("/emergencia")
public class EmergenciaService {

    
    private final EmergenciaRepository emergenciaRepository;

    /**
     * @param emergenciaRepository
     */
    EmergenciaService(EmergenciaRepository emergenciaRepository) {
        this.emergenciaRepository = emergenciaRepository;
    }

    /**
     * @return {@value} List<Emergencia> lista de emergencias
     */
    @GetMapping
    public List<Emergencia> getAll() {
        return emergenciaRepository.getAll();
    }

    /**
     * @param emergencia
     * @return {@value} Emergencia emergencia
     */
    @PostMapping("/create")
    @ResponseBody
    public Emergencia createEmergencia(@RequestBody Emergencia emergencia){
        Emergencia newEmergencia = emergenciaRepository.createEmergencia(emergencia);
        return newEmergencia;
    }

    /**
     * @return String cantidad de emergencias
     */
    @GetMapping("/count")
    public String countEmergencia(){
        int total = emergenciaRepository.countEmergencias();
        return String.format("Se tienen %s emergencias.", total);
    }

    /**
     * @param id id de emergencia
     * @return void
     */
    @RequestMapping(value = "/deleteById/{id}", method = RequestMethod.DELETE)
    public void deleteEmergencia(@PathVariable long id) {
        emergenciaRepository.deleteEmergenciaById(id);
    }

    /**
     * @param emergencia
     * @return void
     */
    @RequestMapping(value = "/updateById/{id}", method = RequestMethod.PUT)
    public void updateEmergencia(@RequestBody Emergencia emergencia) {
        emergenciaRepository.updateEmergencia(emergencia);
    }

    /**
     * @param id id de emergencia
     * @return {@value} <List>Emergencia lista de emergencias
     */
    @RequestMapping(value = "/getById/{id}", method = RequestMethod.GET)
    public List<Emergencia> getEmergenciaById(@PathVariable long id) {
        return emergenciaRepository.showEmergenciaById(id);
    }    
}

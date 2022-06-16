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
import cl.tbd.backendayni.models.Habilidad;
import cl.tbd.backendayni.repositories.HabilidadRepository;


@RestController
@RequestMapping("/habilidad")
public class HabilidadService {

    private final HabilidadRepository habilidadRepository;

    /**
     * @param habilidadRepository
     */
    HabilidadService(HabilidadRepository habilidadRepository) {
        this.habilidadRepository = habilidadRepository;
    }

    /**
     * @return {@value} List<Habilidad> lista de habilidades
     */
    @GetMapping
    public List<Habilidad> getAll() {
        return habilidadRepository.getAll();
    }

    /**
     * @param id id de habilidad
     * @return {@value} Habilidad habilidad
     */
    @PostMapping("/create")
    @ResponseBody
    public Habilidad createHabilidad(@RequestBody Habilidad habilidad){
        Habilidad newHabilidad = habilidadRepository.createHabilidad(habilidad);
        return newHabilidad;
    }

    /**
     * @param id id de habilidad
     * @return String cantidad de habilidades
     */
    @GetMapping("/count")
    public String countHabilidad(){
        int total = habilidadRepository.countHabilidades();
        return String.format("Se tienen %s habilidades.", total);
    }

    /**
     * @param id id de habilidad
     * @return void
     */
    @RequestMapping(value = "/deleteById/{id}", method = RequestMethod.DELETE)
    public void deleteHabilidad(@PathVariable long id) {
        habilidadRepository.deleteHabilidadById(id);
    }

    /**
     * @param id id de habilidad
     * @return void
     */
    @RequestMapping(value = "/updateById/{id}", method = RequestMethod.PUT)
    public void updateHabilidad(@RequestBody Habilidad habilidad) {
        habilidadRepository.updateHabilidad(habilidad);
    }

    /**
     * @param id id de habilidad
     * @return void
     */
    @RequestMapping(value = "/getById/{id}", method = RequestMethod.GET)
    public List<Habilidad> getHabilidadById(@PathVariable long id) {
        return habilidadRepository.showHabilidadById(id);
    }
}

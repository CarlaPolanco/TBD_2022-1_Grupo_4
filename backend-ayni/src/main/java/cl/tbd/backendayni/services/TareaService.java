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
import cl.tbd.backendayni.models.Tarea;
import cl.tbd.backendayni.repositories.TareaRepository;


@RestController
@RequestMapping("/tarea")
public class TareaService {
    private final TareaRepository tareaRepository;

    /**
     * @param tareaRepository
     */
    TareaService(TareaRepository tareaRepository) {
        this.tareaRepository = tareaRepository;
    }

    /**
     * @return {@value} List<Tarea> lista de tareas
     */
    @GetMapping
    public List<Tarea> getAll() {
        return tareaRepository.getAll();
    }

    /**
     * @param tarea tarea a crear
     * @return {@value} Tarea tarea
     */
    @PostMapping("/create")
    @ResponseBody
    public Tarea createTarea(@RequestBody Tarea tarea){
        Tarea newTarea = tareaRepository.createTarea(tarea);
        return newTarea;
    }

    /**
     * @return {@value} cantidad de tareas
     */
    @GetMapping("/count")
    public String countTarea(){
        int total = tareaRepository.countTareas();
        return String.format("Se tienen %s tareas.", total);
    }

    /**
     * @param id id de tarea
     * @return void
     */
    @RequestMapping(value = "/deleteById/{id}", method = RequestMethod.DELETE)
    public void deleteTarea(@PathVariable long id) {
        tareaRepository.deleteTareaById(id);
    }

    /**
     * @param id id de tarea
     * @return void
     */
    @RequestMapping(value = "/updateById/{id}", method = RequestMethod.PUT)
    public void updateTarea(@RequestBody Tarea tarea) {
        tareaRepository.updateTarea(tarea);
    }

    /**
     * @param id id de tarea
     * @return {@value} <List>Tarea tarea
     */
    @RequestMapping(value = "/getById/{id}", method = RequestMethod.GET)
    public List<Tarea> getTareaById(@PathVariable long id) {
        return tareaRepository.showTareaById(id);
    }  
    
    /**
     * @param id id de la emergencia
     * @return {@value} <List>Tarea tarea
     */
    @RequestMapping(value = "/getTareaByIdEmergencia/{id}",method = RequestMethod.GET)
    public List<Tarea> getTareaByIdEmergencia(@PathVariable long id){
        return tareaRepository.getTareaByIdEmergencia(id);
    }


}

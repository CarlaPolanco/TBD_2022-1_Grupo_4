package cl.tbd.backendayni.services;

import java.util.List;

import com.fasterxml.jackson.databind.util.JSONPObject;

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
public class TareaService {
    private final TareaRepository tareaRepository;

    TareaService(TareaRepository tareaRepository) {
        this.tareaRepository = tareaRepository;
    }

    @GetMapping("/tarea")
    public List<Tarea> getAll() {
        return tareaRepository.getAll();
    }

    @PostMapping("/tarea/create")
    @ResponseBody
    public Tarea createTarea(@RequestBody Tarea tarea){
        Tarea newTarea = tareaRepository.createTarea(tarea);
        return newTarea;
    }

    @GetMapping("/tarea/count")
    public String countTarea(){
        int total = tareaRepository.countTareas();
        return String.format("Se tienen %s tareas.", total);
    }

    @RequestMapping(value = "/tarea/deleteById/{id}", method = RequestMethod.DELETE)
    public void deleteTarea(@PathVariable long id) {
        tareaRepository.deleteTareaById(id);
    }

    @RequestMapping(value = "/tarea/updateById/{id}", method = RequestMethod.PUT)
    public void updateTarea(@RequestBody Tarea tarea) {
        tareaRepository.updateTarea(tarea);
    }

    @RequestMapping(value = "/tarea/getById/{id}", method = RequestMethod.GET)
    public List<Tarea> getTareaById(@PathVariable long id) {
        return tareaRepository.showTareaById(id);
    }  

    @RequestMapping(value = "/tarea/getAlltareasId/{id}",method = RequestMethod.GET)
    public List<Tarea> getAllTareasEmergency(@PathVariable long id){
        return tareaRepository.getAllTareasEmergency(id);

    }
}

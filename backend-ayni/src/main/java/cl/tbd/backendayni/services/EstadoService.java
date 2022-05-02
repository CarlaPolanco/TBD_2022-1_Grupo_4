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
import cl.tbd.backendayni.models.Estado;
import cl.tbd.backendayni.repositories.EstadoRepository;


@RestController
public class EstadoService {
    private final EstadoRepository estadoRepository;

    EstadoService(EstadoRepository estadoRepository){
        this.estadoRepository = estadoRepository;
    }

    @GetMapping("/estado")
    public List<Estado> getAllEstados(){
        System.out.println(estadoRepository.getAll());
        return estadoRepository.getAll();
    }


    @GetMapping("/estado/getById/{id}")
    public List<Estado> getEstadoById(@PathVariable long id){
        return estadoRepository.showEstadoById(id);
    }


    @GetMapping("/estado/count")
    public String countEstado(){
        int total = estadoRepository.countEstados();
        return String.format("Se tienen %s estados.", total);
    }


    @PostMapping("/estado/create")
    @ResponseBody
    public Estado createEstado(@RequestBody Estado estado){
        Estado newEstado = estadoRepository.createEstado(estado);
        return newEstado;
    }
    

    @RequestMapping(value = "/estado/deleteById/{id}", produces = "application/json", method = {RequestMethod.GET, RequestMethod.DELETE})
    public void deleteEstado(@PathVariable long id){
        estadoRepository.deleteEstadoById(id);
    }

    @RequestMapping(value = "/estado/updateById/{id}", produces = "application/json", method = {RequestMethod.PUT})
    public void updateEstado(@RequestBody Estado estado){
        estadoRepository.updateEstado(estado);
    }
}

package co.com.sofka.biblioteca.Services;

import co.com.sofka.biblioteca.DTOs.RecursoDTO;
import co.com.sofka.biblioteca.Mappers.RecursoMapper;
import co.com.sofka.biblioteca.Messages.Mensaje;
import co.com.sofka.biblioteca.Models.Recurso;
import co.com.sofka.biblioteca.Repositories.RepositorioRecurso;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class ServicioRecurso {

    @Autowired
    RepositorioRecurso repositorioRecurso;
    RecursoMapper mapper = new RecursoMapper();

    public RecursoDTO encontrarPorId(String id){
        Recurso recurso = repositorioRecurso.findById(id).orElseThrow(() -> new RuntimeException("Recurso no encontrado"));
        return mapper.fromCollection(recurso);
    }

    public Mensaje obtenerIdValidarDisponibilidad(String id){
        RecursoDTO recursoDTO = encontrarPorId(id);
        return new Mensaje().imprimirMensajeDisponibilidad(recursoDTO.isDisponible(), recursoDTO.getFechaPrestamo());
    }

    public Mensaje prestarUnRecurso(String id){
        RecursoDTO recursoDTO = encontrarPorId(id);
        Mensaje mensaje = new Mensaje().imprimirMensajePrestamo(recursoDTO.isDisponible(), recursoDTO.getFechaPrestamo());
        if (recursoDTO.isDisponible()){
            recursoDTO.setDisponible(false);
            recursoDTO.setFechaPrestamo(new Date());
        }

        Recurso recurso = mapper.fromDTO(recursoDTO);
        mapper.fromCollection(repositorioRecurso.save(recurso));

        return mensaje;
    }

    public RecursoDTO crear(RecursoDTO recursoDTO){
        Recurso recurso = mapper.fromDTO(recursoDTO);
        return mapper.fromCollection(repositorioRecurso.save(recurso));
    }
}

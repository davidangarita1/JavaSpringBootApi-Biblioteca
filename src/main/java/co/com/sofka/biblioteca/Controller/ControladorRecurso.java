package co.com.sofka.biblioteca.Controller;

import co.com.sofka.biblioteca.DTOs.RecursoDTO;
import co.com.sofka.biblioteca.Services.ServicioRecurso;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/recursos")
public class ControladorRecurso {

    @Autowired
    ServicioRecurso servicioRecurso;

    @PostMapping("/crear")
    public ResponseEntity<RecursoDTO> create(@RequestBody RecursoDTO recursoDTO) {
        return new ResponseEntity(servicioRecurso.crear(recursoDTO), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RecursoDTO> mostrarDisponibilidad(@PathVariable("id") String id) {
        return new ResponseEntity(servicioRecurso.obtenerIdValidarDisponibilidad(id), HttpStatus.OK);
    }

    @PutMapping("/prestar/{id}")
    public ResponseEntity<RecursoDTO> prestar(@PathVariable String id) {
        return new ResponseEntity(servicioRecurso.prestarUnRecurso(id), HttpStatus.OK);

    }
    @PutMapping("/devolver/{id}")
    public ResponseEntity<RecursoDTO> devolver(@PathVariable String id) {
        return new ResponseEntity(servicioRecurso.devolverUnRecurso(id), HttpStatus.OK);
    }
}

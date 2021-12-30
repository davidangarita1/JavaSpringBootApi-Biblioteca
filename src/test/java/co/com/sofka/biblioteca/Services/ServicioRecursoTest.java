package co.com.sofka.biblioteca.Services;

import co.com.sofka.biblioteca.Repositories.RepositorioRecurso;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ServicioRecursoTest {

    @MockBean
    RepositorioRecurso repositorio;

    @Test
    void comprobarDisponibilidad() {
    }

    @Test
    void prestarUnRecurso() {
    }

    @Test
    void devolverUnRecurso() {
    }

    @Test
    void encontrarPorArea() {
    }

    @Test
    void encontrarPorTipo() {
    }

    @Test
    void encontrarPorAreaYTipo() {
    }
}
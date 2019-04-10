package es.cursojavaweb.alumnos.controlador;

import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;

import es.cursojavaweb.alumnos.modelo.*;
import es.cursojavaweb.alumnos.servicio.*;

@RestController
@CrossOrigin
public class ControladorAlumno {

    private final ServicioAlumno servicioAlumno;

    @Autowired
    public ControladorAlumno(ServicioAlumno servicioAlumno) {
        this.servicioAlumno = servicioAlumno;
    }

    @GetMapping("/alumnos")
    public List<Alumno> obtenerTodosLosAlumnos() {

        return this.servicioAlumno.obtenerTodosLosAlumnos();
    }

    @GetMapping("/alumnos/{id}")
    public Alumno obtenerAlumnoPorId(@PathVariable int id) {

        return this.servicioAlumno.obtenerAlumnoPorId(id);
    }

    @PostMapping("/alumnos")
    public void crearAlumno(@RequestBody Alumno alumno) {
        this.servicioAlumno.crearAlumno(alumno);
    }

    @PutMapping("/alumnos")
    public void modificarAlumno(@RequestBody Alumno alumno) {

        this.servicioAlumno.modificarAlumno(alumno);
    }

    @DeleteMapping("/alumnos/{id}")
    public void eliminarAlumno(@PathVariable int id) {
        this.servicioAlumno.eliminarAlumno(id);
    }

}

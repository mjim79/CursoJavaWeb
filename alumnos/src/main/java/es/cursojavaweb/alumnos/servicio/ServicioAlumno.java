package es.cursojavaweb.alumnos.servicio;

import java.util.*;

import es.cursojavaweb.alumnos.modelo.*;

public interface ServicioAlumno {

    List<Alumno> obtenerTodosLosAlumnos();

    Alumno obtenerAlumnoPorId(int id);

    void crearAlumno(Alumno alumno);

    void modificarAlumno(Alumno alumno);

    void eliminarAlumno(int id);

}

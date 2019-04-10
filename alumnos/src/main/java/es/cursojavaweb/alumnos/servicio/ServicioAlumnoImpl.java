package es.cursojavaweb.alumnos.servicio;

import java.util.*;

import javax.transaction.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import es.cursojavaweb.alumnos.modelo.*;
import es.cursojavaweb.alumnos.repositorio.*;

@Service
public class ServicioAlumnoImpl implements ServicioAlumno {

    private final RepositorioAlumno repositorioAlumno;

    @Autowired
    public ServicioAlumnoImpl(RepositorioAlumno repositorioAlumno) {
        this.repositorioAlumno = repositorioAlumno;
    }

    @Override
    public List<Alumno> obtenerTodosLosAlumnos() {
        return this.repositorioAlumno.findAll();
    }

    @Override
    public Alumno obtenerAlumnoPorId(int id) {

        final Alumno alumno = this.repositorioAlumno.findById(id).orElse(null);

        if (Objects.isNull(alumno)) {
            throw new AlumnoException("El alumno no existe");
        }

        return alumno;

    }

    @Override
    @Transactional
    public void crearAlumno(Alumno alumno) {

        if (this.repositorioAlumno.existsById(alumno.getId())) {
            throw new AlumnoException("El alumno ya existe");
        }

        this.repositorioAlumno.save(alumno);

    }

    @Override
    public void modificarAlumno(Alumno alumno) {
        this.verificaExistenciaAlumno(alumno.getId());

        this.repositorioAlumno.save(alumno);

    }

    @Override
    public void eliminarAlumno(int id) {

        this.verificaExistenciaAlumno(id);

        this.repositorioAlumno.deleteById(id);

    }

    private void verificaExistenciaAlumno(int id) {
        if (!this.repositorioAlumno.existsById(id)) {
            throw new AlumnoException("El alumno no existe");
        }
    }

}

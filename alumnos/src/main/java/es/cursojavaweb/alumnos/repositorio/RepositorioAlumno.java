package es.cursojavaweb.alumnos.repositorio;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.*;

import es.cursojavaweb.alumnos.modelo.*;

@Repository
public interface RepositorioAlumno extends JpaRepository<Alumno, Integer> {

}

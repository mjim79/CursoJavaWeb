package es.cursojavaweb.alumnos.modelo;

import javax.persistence.*;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Alumno {

    @Id
    private int id;

    private String nombre;

    private String apellidos;

    private String sexo;

    private String nacionalidad;

    private int edad;

}

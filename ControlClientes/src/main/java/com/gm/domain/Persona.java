package com.gm.domain;

import java.io.Serializable;
import javax.persistence.*;
//import javax.persistence.Table;
import lombok.Data;

@Data//esta anotacion de lombok agregas todos los metodos necesarios para los atributos de mi clase
@Entity //convireta la clase a entidad
@Table(name = "persona")
public class Persona implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id // indicio el campo de la llave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY) // asigno una estrategia para generar la llave primaria
    private Long idPersona;
    private String nombre;
    private String apellido;
    private String email;
    private String telefono; 
} 

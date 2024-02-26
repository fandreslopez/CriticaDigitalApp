package grupo5.criticadigital.models;

import jakarta.persistence.*;
import lombok.Data;

import javax.validation.constraints.Size;

@Data
@Entity
public class Asistencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idAsistencia;

    @Size(min = 3, max = 45)
    private String Situacion;

    @ManyToOne//Indico que hay una relacion de Muchos a uno, desde "Diputados Actuales"
    @JoinColumn(name = "id_diputado")//Indicamos el nombre de la columna que lleva la llave foránea
    private Diputado idDiputado;

    @ManyToOne//Indico que hay una relacion de Muchos a uno, desde "Sesiones"
    @JoinColumn(name = "id_Sesiones")//Indicamos el nombre de la columna que lleva la llave foránea
    private Sesiones idSesiones;
}


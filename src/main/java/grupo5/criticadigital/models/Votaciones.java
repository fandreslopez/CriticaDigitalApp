package grupo5.criticadigital.models;

import jakarta.persistence.*;
import lombok.Data;

import javax.validation.constraints.Size;
import java.sql.Date;

@Data
@Entity
public class Votaciones {

    

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idVotacion;

    private String Votacion;

    private String Boletin;

    @Column(length = 2000)
    private String Descripcion;

    @Column(length = 2000)
    private String Detalle;

    private String Tipo;

    private String Comision;

    private String Tramite;

    private String Informe;

    private Date Fecha;

    @ManyToOne//Indico que hay una relacion de Muchos a uno, desde "Diputados Actuales"
    @JoinColumn(name = "id_diputado")//Indicamos el nombre de la columna que lleva la llave foránea
    private Diputado idDiputado;

    @ManyToOne//Indico que hay una relacion de Muchos a uno, desde "Diputados Actuales"
    @JoinColumn(name = "id_Sesiones")//Indicamos el nombre de la columna que lleva la llave foránea
    private Sesiones idSesiones;

}

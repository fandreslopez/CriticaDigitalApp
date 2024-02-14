package grupo5.criticadigital.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.sql.Date;

@Data
@Entity
public class Votaciones {

    private String Votacion;

    private String Boletin;

    private String Descripcion;

    private String Detalle;

    private String Tipo;

    private String Comision;

    private String Tramite;

    private String Informe;

    private Date Fecha;

    @Id
    @ManyToOne//Indico que hay una relacion de Muchos a uno, desde "Diputados Actuales"
    @JoinColumn(name = "id_diputado")//Indicamos el nombre de la columna que lleva la llave foránea
    private Diputado idDiputado;

    @ManyToOne//Indico que hay una relacion de Muchos a uno, desde "Diputados Actuales"
    @JoinColumn(name = "id_Sesiones")//Indicamos el nombre de la columna que lleva la llave foránea
    private Sesiones idSesiones;

}

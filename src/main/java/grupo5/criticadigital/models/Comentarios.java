package grupo5.criticadigital.models;

import jakarta.persistence.*;
import lombok.Data;
import net.sf.jsqlparser.expression.DateTimeLiteralExpression;
import java.sql.Date;
@Entity
@Data
public class Comentarios {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idComentarios;

    private String comentarios;

    private Date fechaPublicacion;

    @ManyToOne//Indico que hay una relacion de Muchos a uno, desde el empleado
    @JoinColumn(name = "usuarioId")//Indicamos el nombre de la columna que lleva la llave foránea
    private Usuarios usuarioComentario;

    @ManyToOne//Indico que hay una relacion de Muchos a uno, desde el empleado
    @JoinColumn(name = "idDiputado")//Indicamos el nombre de la columna que lleva la llave foránea
    private Diputado diputadoComentario;

    @ManyToOne//Indico que hay una relacion de Muchos a uno, desde el empleado
    @JoinColumn(name = "idComentario")//Indicamos el nombre de la columna que lleva la llave foránea
    private TipoComentario tipoComentario;

}

package grupo5.criticadigital.models;


import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.relational.core.sql.Like;

import java.util.List;

@Entity
@Data
public class Likes{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id_likes;

    private String Likes;


    @ManyToOne//Indico que hay una relacion de Muchos a uno, desde el empleado

    @JoinColumn(name = "usuarioId")//Indicamos el nombre de la columna que lleva la llave foránea
    private Usuarios usuarioLike;

    @ManyToOne
    @JoinColumn(name = "idDiputado")
    private Diputado diputadoLike;

}

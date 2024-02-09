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
    @JoinColumn(name = "usuario_id")//Indicamos el nombre de la columna que lleva la llave foránea
    private Usuarios usaurioLike;

    @ManyToOne
    @JoinColumn(name = "idDiputado")
    private Diputados diputadoLike;


}

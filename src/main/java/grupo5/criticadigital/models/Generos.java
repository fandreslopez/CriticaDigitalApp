package grupo5.criticadigital.models;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Data
public class Generos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long generoId;

    private String generoValor;

}

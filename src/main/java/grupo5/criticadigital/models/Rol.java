package grupo5.criticadigital.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "roles")
public class Rol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    // Mapea un tipo enumerado (enum) de Java a una columna de la base de datos.
    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private ERol nombre;
}

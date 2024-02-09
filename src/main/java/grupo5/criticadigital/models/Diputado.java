package grupo5.criticadigital.models;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Data
public class Diputado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idDiputado;

    private String nombres;

    private String apellidos;

    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private Date fechaDeNacimiento;

    private Integer alias;

    @ManyToOne
    @JoinColumn(name = "regionId")
    private Region idRegion;
}

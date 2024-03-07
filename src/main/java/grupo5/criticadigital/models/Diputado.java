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

    private String alias;

    private String twitter;

    private String facebook;

    private String instagram;

    @ManyToOne
    @JoinColumn(name = "regionId")
    private Region idRegion;
}

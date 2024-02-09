package grupo5.criticadigital.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Region {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Integer regionID;

    private String nombreRegion;
}

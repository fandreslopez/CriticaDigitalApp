package grupo5.criticadigital.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Region {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Integer regionID;

    private String nombreRegion;
}

package grupo5.criticadigital.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Region {

    @Id
    private Integer regionId;

    private String nombreRegion;
}

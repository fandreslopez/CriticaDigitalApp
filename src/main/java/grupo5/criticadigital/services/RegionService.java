package grupo5.criticadigital.services;

import grupo5.criticadigital.models.Region;

import java.util.List;

public interface RegionService {

   List<Region> obtenerRegiones();

   Region obtenerRegionPorId(Long id);

   Region agregarRegion(Region region);
   void borrarRegion(Long id);

}

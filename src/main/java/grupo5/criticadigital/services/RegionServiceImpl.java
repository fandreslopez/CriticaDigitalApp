package grupo5.criticadigital.services;

import grupo5.criticadigital.models.Region;
import grupo5.criticadigital.repositories.RegionRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class RegionServiceImpl implements RegionService{

    private final RegionRepository regionRepository;

    @Override
    public List<Region> obtenerRegiones() {
        return regionRepository.findAll();
    }

    @Override
    public Region obtenerRegionPorId(Long id) {
        return regionRepository.findById(id).get();
    }

    @Override
    public Region agregarRegion(Region region) {
        if (region != null ) {
            return regionRepository.save(region);
        } else {
            return null;
        }
    }

    @Override
    public void borrarRegion(Long id) {
        Boolean regionExiste = regionRepository.existsById(id);

        if (regionExiste) {
            regionRepository.deleteById(id);
        }
    }
}
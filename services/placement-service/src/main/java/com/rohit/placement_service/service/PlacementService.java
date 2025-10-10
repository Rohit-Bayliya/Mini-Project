package com.rohit.placement_service.service;

import com.rohit.placement_service.entity.Placement;
import com.rohit.placement_service.repository.PlacementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlacementService {

    @Autowired
    private PlacementRepository placementRepository;

    public Placement createPlacement(Placement placement) {
        return placementRepository.save(placement);
    }

    public Placement getPlacementById(Long id) {
        return placementRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Placement not found with id: " + id));
    }

    public List<Placement> getAllPlacements() {
        return placementRepository.findAll();
    }

    public Placement updatePlacement(Long id, Placement updatedPlacement) {
        Placement existing = getPlacementById(id);
        existing.setCompanyName(updatedPlacement.getCompanyName());
        existing.setRole(updatedPlacement.getRole());
        existing.setPackageOffered(updatedPlacement.getPackageOffered());
        existing.setLocation(updatedPlacement.getLocation());
        existing.setApplicationDeadline(updatedPlacement.getApplicationDeadline());
        existing.setStatus(updatedPlacement.getStatus());
        return placementRepository.save(existing);
    }

    public void deletePlacement(Long id) {
        placementRepository.deleteById(id);
    }
}

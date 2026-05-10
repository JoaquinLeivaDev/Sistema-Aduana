package cl.duocuc.aduana_api.service;

import cl.duocuc.aduana_api.model.Vehiculo;
import cl.duocuc.aduana_api.repository.VehiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VehiculoService {
    @Autowired private VehiculoRepository repository;

    public Vehiculo registrarVehiculo(Vehiculo vehiculo) {
        // Lógica para validar patentes, plazos de 90/180 días, etc.
        return repository.save(vehiculo);
    }
}
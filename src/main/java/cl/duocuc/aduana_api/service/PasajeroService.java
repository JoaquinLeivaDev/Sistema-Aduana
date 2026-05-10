package cl.duocuc.aduana_api.service;

import cl.duocuc.aduana_api.model.Pasajero;
import cl.duocuc.aduana_api.repository.PasajeroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PasajeroService {
    @Autowired private PasajeroRepository repository;

    public Pasajero registrarPasajero(Pasajero pasajero) {
        // AQUÍ IRÍA LA LÓGICA DE NEGOCIO (Validaciones)
        return repository.save(pasajero);
    }

    public Pasajero buscarPorRut(String rut) {
        return repository.findByRut(rut);
    }

    public List<Pasajero> obtenerTodos() {
        return repository.findAll();
    }
}
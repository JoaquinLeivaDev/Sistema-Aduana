package cl.duocuc.aduana_api.service;

import cl.duocuc.aduana_api.model.Rol;
import cl.duocuc.aduana_api.repository.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class RolService {
    @Autowired private RolRepository repository;

    public List<Rol> obtenerTodos() {
        return repository.findAll();
    }

    // Si en el futuro necesitas crear roles dinámicamente:
    public Rol registrarRol(Rol rol) {
        return repository.save(rol);
    }
}
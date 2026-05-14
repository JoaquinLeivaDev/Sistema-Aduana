package cl.duocuc.aduana_api.controller;

import cl.duocuc.aduana_api.dto.PasajeroDto;
import cl.duocuc.aduana_api.model.Pasajero;
import cl.duocuc.aduana_api.service.PasajeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pasajeros")
public class PasajeroController {

    @Autowired
    private PasajeroService service;

    // GET: Listar todos los pasajeros
    @GetMapping
    public ResponseEntity<List<Pasajero>> listarTodos() {
        return ResponseEntity.ok(service.obtenerTodos());
    }

    // POST: Crear un nuevo registro
    @PostMapping
    public ResponseEntity<Pasajero> registrar(@RequestBody PasajeroDto dto) {
        // Aquí transformarías el DTO a Entidad.
        // Por ahora, para ir rápido, mapeamos manualmente o asumimos Pasajero
        Pasajero pasajero = new Pasajero();
        pasajero.setRut(dto.getRut());
        pasajero.setNombre(dto.getNombre());
        pasajero.setApellidos(dto.getApellidos());
        pasajero.setCorreo(dto.getCorreo());
        pasajero.setFechaNac(dto.getFechaNac());

        return ResponseEntity.ok(service.registrarPasajero(pasajero));
    }

    // GET: Buscar por RUT (¡Fundamental para la aduana!)
    @GetMapping("/{rut}")
    public ResponseEntity<Pasajero> buscarPorRut(@PathVariable String rut) {
        Pasajero pasajero = service.buscarPorRut(rut);
        return pasajero != null ? ResponseEntity.ok(pasajero) : ResponseEntity.notFound().build();
    }
}
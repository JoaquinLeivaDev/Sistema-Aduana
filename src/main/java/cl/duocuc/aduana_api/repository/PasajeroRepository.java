package cl.duocuc.aduana_api.repository;

import cl.duocuc.aduana_api.model.Pasajero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PasajeroRepository extends JpaRepository<Pasajero, Long> {

    // Spring Data JPA crea esta consulta mágicamente por el nombre del método
    // ¡Es vital para buscar pasajeros en el control fronterizo!
    Pasajero findByRut(String rut);
}
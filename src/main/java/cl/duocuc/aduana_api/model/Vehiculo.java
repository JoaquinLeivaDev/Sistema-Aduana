package cl.duocuc.aduana_api.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Entity
@Table(name = "vehiculo")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class Vehiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_vehiculo")
    private Long id;

    @Column(name = "patente", nullable = false, length = 10, unique = true)
    private String patente;

    @Column(name = "tipo", nullable = false, length = 50)
    private String tipo; // Ej: "Particular", "Diplomático"

    @Column(name = "fecha_admision", nullable = false)
    private LocalDate fechaAdmision;

    /*
     * Relación uno a uno con Documento.
     * Un vehículo tiene un formulario SATVA (Documento) asociado.
     */
    @OneToOne
    @JoinColumn(name = "id_documento", unique = true)
    private Documento documento;

    // Método de negocio (la lógica real va en el Service, esto es solo la firma)
    public boolean generarSATVA() {
        // Aquí irá la lógica que invocará el Servicio
        return true;
    }
}
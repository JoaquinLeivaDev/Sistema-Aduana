package cl.duocuc.aduana_api.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "turno")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Turno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_turno")
    private Long id;

    @Column(name = "numero", nullable = false)
    private Integer numero;

    @Column(name = "estado", nullable = false, length = 20)
    private String estado; // Ej: "En espera", "Atendido", "Cancelado"

    /*
     * Relación uno a uno con Pasajero.
     * Esto le dice a JPA: "Este turno le pertenece a este pasajero".
     */
    @OneToOne
    @JoinColumn(name = "id_pasajero", nullable = false)
    private Pasajero pasajero;
}
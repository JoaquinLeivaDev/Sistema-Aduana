package cl.duocuc.aduana_api.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "documento")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Documento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String tipo;
    private boolean estadoValidacion;
    private String urlArchivo;

    @ManyToOne
    @JoinColumn(name = "id_pasajero")
    private Pasajero pasajero;
}
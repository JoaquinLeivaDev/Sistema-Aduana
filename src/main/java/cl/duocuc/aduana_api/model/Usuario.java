package cl.duocuc.aduana_api.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "usuario")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Long id;

    @Column(name = "username", nullable = false, length = 50, unique = true)
    private String username;

    @Column(name = "password_hash", nullable = false, length = 255)
    private String passwordHash;

    /*
     * Relación muchos a uno: muchos usuarios pueden tener el mismo rol.
     * Esta es la forma profesional de manejar permisos.
     */
    @ManyToOne
    @JoinColumn(name = "id_rol", nullable = false)
    private Rol rol;
}
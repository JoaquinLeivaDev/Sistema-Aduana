package cl.duocuc.aduana_api.dto;

import jakarta.validation.constraints.*;
import lombok.Data;
import java.time.LocalDate;

@Data
public class PasajeroDto {

    @NotBlank(message = "El RUT es obligatorio")
    @Size(min = 8, max = 12, message = "El RUT debe tener entre 8 y 12 caracteres")
    private String rut;

    @NotBlank(message = "El nombre es obligatorio")
    private String nombre;

    @NotBlank(message = "El apellido es obligatorio")
    private String apellidos;

    @NotNull(message = "La fecha de nacimiento es obligatoria")
    private LocalDate fechaNac;

    @Email(message = "El correo debe tener un formato válido")
    private String correo;
}
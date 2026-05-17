package cl.duocuc.aduana_api.service;

import cl.duocuc.aduana_api.dto.LoginRequestDTO;
import cl.duocuc.aduana_api.dto.UsuarioRequestDTO;
import cl.duocuc.aduana_api.dto.UsuarioResponseDTO;
import cl.duocuc.aduana_api.exception.RolNotFoundException;
import cl.duocuc.aduana_api.exception.UsuarioNotFoundException;
import cl.duocuc.aduana_api.model.Rol;
import cl.duocuc.aduana_api.model.Usuario;
import cl.duocuc.aduana_api.repository.RolRepository;
import cl.duocuc.aduana_api.repository.UsuarioRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UsuarioService {

    private static final Logger log = LoggerFactory.getLogger(UsuarioService.class);

    private final UsuarioRepository usuarioRepository;
    private final RolRepository rolRepository;

    public UsuarioService(UsuarioRepository usuarioRepository,
                          RolRepository rolRepository) {
        this.usuarioRepository = usuarioRepository;
        this.rolRepository = rolRepository;
    }

    public List<UsuarioResponseDTO> obtenerTodos() {
        log.info("Obteniendo lista de todos los usuarios");
        return usuarioRepository.findAll()
                .stream()
                .map(this::toResponseDTO)
                .toList();
    }

    public UsuarioResponseDTO buscarPorId(Long id) {
        log.info("Buscando usuario con id: {}", id);
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> {
                    log.error("Usuario con id {} no encontrado", id);
                    return new UsuarioNotFoundException("Usuario con id " + id + " no encontrado");
                });
        return toResponseDTO(usuario);
    }

    public UsuarioResponseDTO registrarUsuario(UsuarioRequestDTO dto) {
        log.info("Registrando usuario: {}", dto.getUsername());

        if (usuarioRepository.existsByUsername(dto.getUsername())) {
            log.error("Ya existe un usuario con username: {}", dto.getUsername());
            throw new IllegalArgumentException("Ya existe un usuario con el username " + dto.getUsername());
        }

        Rol rol = rolRepository.findById(dto.getIdRol())
                .orElseThrow(() -> new RolNotFoundException(
                        "Rol con id " + dto.getIdRol() + " no encontrado"));

        Usuario usuario = new Usuario();
        usuario.setUsername(dto.getUsername());
        usuario.setPasswordHash(dto.getPassword());
        usuario.setRol(rol);

        Usuario guardado = usuarioRepository.save(usuario);
        log.info("Usuario registrado con id: {}", guardado.getId());
        return toResponseDTO(guardado);
    }

    public UsuarioResponseDTO login(LoginRequestDTO dto) {
        log.info("Intento de login para usuario: {}", dto.getUsername());

        Usuario usuario = usuarioRepository.findByUsername(dto.getUsername());
        if (usuario == null) {
            log.error("Login fallido: usuario {} no existe", dto.getUsername());
            throw new UsuarioNotFoundException("Credenciales inválidas");
        }

        if (!usuario.getPasswordHash().equals(dto.getPassword())) {
            log.error("Login fallido: contraseña incorrecta para {}", dto.getUsername());
            throw new IllegalArgumentException("Credenciales inválidas");
        }

        log.info("Login exitoso para usuario: {}", dto.getUsername());
        return toResponseDTO(usuario);
    }

    public UsuarioResponseDTO actualizarUsuario(Long id, UsuarioRequestDTO dto) {
        log.info("Actualizando usuario con id: {}", id);
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new UsuarioNotFoundException(
                        "Usuario con id " + id + " no encontrado"));

        usuario.setUsername(dto.getUsername());
        usuario.setPasswordHash(dto.getPassword());

        Usuario actualizado = usuarioRepository.save(usuario);
        log.info("Usuario con id {} actualizado exitosamente", id);
        return toResponseDTO(actualizado);
    }

    public void eliminarUsuario(Long id) {
        log.info("Eliminando usuario con id: {}", id);
        if (!usuarioRepository.existsById(id)) {
            log.error("No se puede eliminar: usuario con id {} no existe", id);
            throw new UsuarioNotFoundException("Usuario con id " + id + " no encontrado");
        }
        usuarioRepository.deleteById(id);
        log.info("Usuario con id {} eliminado exitosamente", id);
    }

    private UsuarioResponseDTO toResponseDTO(Usuario u) {
        return new UsuarioResponseDTO(
                u.getId(),
                u.getUsername(),
                u.getRol().getNombre()
        );
    }
}
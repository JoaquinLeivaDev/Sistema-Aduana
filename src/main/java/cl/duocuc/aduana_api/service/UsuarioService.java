package cl.duocuc.aduana_api.service;

import cl.duocuc.aduana_api.model.Usuario;
import cl.duocuc.aduana_api.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    // Crear un nuevo usuario (aquí se debe cifrar la contraseña!)
    public Usuario crearUsuario(Usuario usuario) {
        // REGLA DE NEGOCIO: Nunca guardar contraseñas en texto plano
        // usuario.setPasswordHash(passwordEncoder.encode(usuario.getPasswordHash()));
        return repository.save(usuario);
    }

    // Método para el Login
    public Usuario autenticar(String username, String password) {
        Usuario usuario = repository.findByUsername(username);

        // Aquí deberías comparar el password ingresado con el passwordHash
        // usando un PasswordEncoder. Por ahora dejamos la validación básica.
        if (usuario != null && usuario.getPasswordHash().equals(password)) {
            return usuario;
        }
        return null;
    }

    public List<Usuario> obtenerTodos() {
        return repository.findAll();
    }

    public void eliminarUsuario(Long id) {
        repository.deleteById(id);
    }
}
package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ListUsuarios {
    private static List<Usuario> listaUsuarios = new ArrayList<>();

    static {
        listaUsuarios.add(new Usuario("Juan", "Perez", 25456789, LocalDate.of(1980, 1, 1), Profesion.MEDICO));
        listaUsuarios.add(new Usuario("Raul", "Lopez", 24587587, LocalDate.of(1980, 1, 1), Profesion.EMPLEADO_PUBLICO));
        listaUsuarios.add(new Usuario("Carlos", "Gutierrez", 23458745, LocalDate.of(1980, 1, 1), Profesion.DEVELOPER));
        listaUsuarios.add(new Usuario("Ernesto", "Pietra", 40457895, LocalDate.of(1980, 1, 1), Profesion.MEDICO));
        listaUsuarios.add(new Usuario("Nestor", "Torres", 39587456, LocalDate.of(1980, 1, 1), Profesion.DEVELOPER));
        listaUsuarios.add(new Usuario("Lucas", "Gonzales", 40856325, LocalDate.of(1980, 1, 1), Profesion.EMPLEADO_PUBLICO));
    }
    public List<Usuario> obtenerTodosLosUsuarios() {
        return listaUsuarios;
    }

    public void agregarUsuario(Usuario usuario) {
        listaUsuarios.add(usuario);
    }

    public boolean existeDNI(int dni) {
        return listaUsuarios
                .stream()
                .anyMatch(u -> u.getDni() == dni);
    }
    public Usuario findByDni(int dni){
        return  listaUsuarios
                .stream()
                .filter(u -> u.getDni() == dni)
                .findFirst()
                .orElse(null);
    }

    public Usuario deleteUserByDni(int dni) {
        Optional<Usuario> usuarioEliminado = listaUsuarios
                .stream()
                .filter(u -> u.getDni() == dni)
                .findFirst();
        usuarioEliminado.ifPresent(u -> listaUsuarios.remove(u));
        return usuarioEliminado.orElse(null);
    }
}
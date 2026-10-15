package co.edu.ucompensar.veterinaria.service;

import co.edu.ucompensar.veterinaria.modelo.Mascota;

import java.util.List;

public interface MacostaService {
    public Mascota registrar(Mascota mascota);
    public Mascota actualizar(Mascota mascota, Long id);
    public boolean eliminar(Long id);


    public Mascota obtenerPorId(Long id);
    public List<Mascota> listarTodo();
}

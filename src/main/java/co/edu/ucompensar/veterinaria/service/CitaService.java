package co.edu.ucompensar.veterinaria.service;

import co.edu.ucompensar.veterinaria.modelo.Cita;

import java.util.List;

public interface CitaService {

    public Cita registrar(Cita Cita);
    public Cita actualizar(Cita Cita, Long id);
    public boolean eliminar(Long id);


    public Cita obtenerPorId(Long id);
    public List<Cita> listarTodo();
}

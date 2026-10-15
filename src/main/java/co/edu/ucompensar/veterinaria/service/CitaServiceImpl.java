package co.edu.ucompensar.veterinaria.service;

import co.edu.ucompensar.veterinaria.modelo.Cita;
import co.edu.ucompensar.veterinaria.repository.CitaRepository;
import co.edu.ucompensar.veterinaria.repository.MascotaRepository;

import java.util.List;

public class CitaServiceImpl implements CitaService {
    private CitaRepository citaRepository;

    public CitaServiceImpl(CitaRepository citaRepository){
        this.citaRepository = citaRepository;
    }

    @Override
    public Cita registrar(Cita Cita) {
        return null;
    }

    @Override
    public Cita actualizar(Cita Cita, Long id) {
        return null;
    }

    @Override
    public boolean eliminar(Long id) {
        return false;
    }

    @Override
    public Cita obtenerPorId(Long id) {
        return null;
    }

    @Override
    public List<Cita> listarTodo() {
        return List.of();
    }
}

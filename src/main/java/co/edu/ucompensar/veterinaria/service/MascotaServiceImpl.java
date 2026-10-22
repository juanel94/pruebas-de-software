package co.edu.ucompensar.veterinaria.service;

import co.edu.ucompensar.veterinaria.modelo.Mascota;
import co.edu.ucompensar.veterinaria.repository.MascotaRepository;
import org.springframework.stereotype.Service;
import co.edu.ucompensar.veterinaria.exception.ValidacionException;

import java.util.List;

@Service
public class MascotaServiceImpl implements MacostaService {

        private MascotaRepository mascotaRepository;

        public MascotaServiceImpl(MascotaRepository mascotaRepository){
            this.mascotaRepository = mascotaRepository;
    }

    @Override
    public Mascota registrar(Mascota mascota) {
        return mascotaRepository.save(mascota);
    }

    @Override
    public Mascota actualizar(Mascota mascota, Long id) {
            Mascota mascota1 = mascotaRepository.findById(id).get();
            mascota1.setNombre(mascota.getNombre());
            mascota1.setEspecie(mascota.getEspecie());
            mascota1.setTelefonoPropietario(mascota.getTelefonoPropietario());
            mascota1.setNombrePropietario(mascota.getNombrePropietario());

        if (mascota.getNombre() == null || mascota.getNombre().isBlank()) {
            throw new ValidacionException("El nombre es obligatorio");
        }

        if (mascota.getEspecie() == null || mascota.getEspecie().isBlank()) {
            throw new ValidacionException("La especie es obligatoria");
        }
        exigirTexto(mascota.getNombre(), "El nombre es obligatorio");
        exigirTexto(mascota.getEspecie(), "La especie es obligatoria");

        return mascotaRepository.save(mascota1);
    }

    private void exigirTexto(String valor, String mensaje) {
        if (valor == null || valor.isBlank()) {
            throw new ValidacionException(mensaje);
        }
    }
    @Override
    public boolean eliminar(Long id) {
            Mascota mascota1 = mascotaRepository.findById(id).get();
            if(mascota1 != null){
                mascotaRepository.delete(mascota1);
                return true;
        }
        return false;
    }

    @Override
    public Mascota obtenerPorId(Long id) {
        return mascotaRepository.findById(id).get();
    }

    @Override
    public List<Mascota> listarTodo() {
        return mascotaRepository.findAll();
    }

}

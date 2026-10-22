package co.edu.ucompensar.veterinaria;

import co.edu.ucompensar.veterinaria.Exception.ValidacionException;
import co.edu.ucompensar.veterinaria.modelo.Cita;
import co.edu.ucompensar.veterinaria.modelo.Mascota;
import co.edu.ucompensar.veterinaria.repository.MascotaRepository;
import co.edu.ucompensar.veterinaria.service.MascotaServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
public   class MascotaServiceImplTest {

    @Mock
    private MascotaRepository mascotaRepository;

    @InjectMocks
    private MascotaServiceImpl mascotaService;


    private Mascota mascotaValida() {
        Mascota mascota = new Mascota();
        mascota.setNombre("Firulais");
        mascota.setEspecie("perro");
        mascota.setNombrePropietario("Ana Gómez");
        mascota.setTelefonoPropietario("3001234567");
        return mascota;
    }

    @Test
    public void registrar_datosValidos_guardaMascota() {
        // Arrange
        Mascota entrada = mascotaValida();
        Mascota guardada = mascotaValida();
        guardada.setId(1L);
        when(mascotaRepository.save(entrada)).thenReturn(guardada);

        // Act
        Mascota resultado = mascotaService.registrar(entrada);

        // Assert
        assertEquals(1L, resultado.getId());
        verify(mascotaRepository).save(entrada);
    }

    @Test
    public void registrar_datos_Nombres_Vacios_Mascota() {
        // Arrange
        Mascota mascota = new Mascota();
        mascota.setEspecie("Dalmata");
        mascota.setNombre("Jhon");
        mascota.setTelefonoPropietario("3051234567");
        Assert.assertThrows(ValidacionException.class, () -> mascotaService.registrar(mascota));
        verify(mascotaRepository, never()).save(any());
    }

    @Test
    public void consultar_mascotaExistente_devuelveMascotaConCitas() {
        // Arrange
        Mascota mascota = mascotaValida();
        mascota.setId(1L);
        mascota.setCitas(List.of(new Cita()));
        when(mascotaRepository.findById(1L)).thenReturn(Optional.of(mascota));

        // Act
        Mascota resultado = mascotaService.obtenerPorId(1L);

        // Assert
        assertSame(mascota, resultado);
        assertEquals(1, resultado.getCitas().size());
    }
}


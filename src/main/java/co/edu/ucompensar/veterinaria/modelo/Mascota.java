package co.edu.ucompensar.veterinaria.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Mascota {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)


    private long id;
    private String nombre;
    private String Especie;
    private String NombrePropietario;
    private String TelefonoPropietario;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEspecie() {
        return Especie;
    }

    public void setEspecie(String especie) {
        Especie = especie;
    }

    public String getNombrePropietario() {
        return NombrePropietario;
    }

    public void setNombrePropietario(String nombrePropietario) {
        NombrePropietario = nombrePropietario;
    }

    public String getTelefonoPropietario() {
        return TelefonoPropietario;
    }

    public void setTelefonoPropietario(String telefonoPropietario) {
        TelefonoPropietario = telefonoPropietario;
    }
}

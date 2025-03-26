package org.primer.punto;

import java.util.Objects;

public class Participante {
    private String nombre;
    private String apellido;
    private int puntos;

    public Participante(String nombre , String apellido){
        this.nombre = nombre;
        this.apellido = apellido;
        this.puntos = 0;
    }
    public void cargarPuntos(int puntos){
        this.puntos += puntos;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Participante that = (Participante) o;
        return Objects.equals(nombre, that.nombre) && Objects.equals(apellido, that.apellido);
    }
    @Override
    public int hashCode() {
        return Objects.hash(nombre, apellido);
    }
}

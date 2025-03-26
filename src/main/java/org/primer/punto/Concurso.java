package org.primer.punto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Concurso {

    private String nombre ;
    private LocalDate fechaInicio ;
    private LocalDate fechaCierre ;
    private List<Participante> inscritos;

    public Concurso(String nombre, LocalDate fechaInicio, LocalDate fechaCierre) {
        this.nombre = nombre;
        this.fechaInicio = fechaInicio;
        this.fechaCierre = fechaCierre;
        this.inscritos = new ArrayList<>();
    }
    // public void cargarParticipante(Participante participante){
    //   inscritos.add(participante);
    // }
    public boolean validarIncripcion(LocalDate fechaIncripcion , Participante participante) throws Exception {
        if (!fechaIncripcion.isBefore(this.fechaInicio) && !fechaIncripcion.isAfter(this.fechaCierre)) {
            this.inscritos.add(participante);
            participante.cargarPuntos(10);
            return true;
        }
        return false;
    }

    public boolean participanteInscripto(Participante participante) {
        for (Participante inscripcion : inscritos) {
            if (inscripcion.equals(participante)) {
                return true;
            }
        }
        return false;
    }
    }


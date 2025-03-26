package tes.unr;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.primer.punto.Concurso;
import org.primer.punto.Participante;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ConcursoTest {
    private Concurso concurso;
    private Participante participante;

    @BeforeEach
    void ayudaParaTest() {
        LocalDate fechaInicio = LocalDate.of(2024, 3, 1);
        LocalDate fechaCierre = LocalDate.of(2024, 3, 31);
        concurso = new Concurso("Concurso de Programación", fechaInicio, fechaCierre);
        participante = new Participante("Juan " , "Perez");
    }

    @Test
    void testParticipanteSeInscribeEnConcurso() throws Exception {
        LocalDate fechaInscripcion = LocalDate.of(2024, 3, 15);
        boolean resultado = concurso.validarIncripcion(fechaInscripcion, participante);

        assertTrue(resultado, "El participante debería poder inscribirse dentro del rango permitido.");
        assertTrue(concurso.participanteInscripto(participante), "El participante debería estar registrado en el concurso.");
    }

    @Test
    void testParticipanteSeInscribePrimerDia() throws Exception {
        LocalDate fechaInscripcion = LocalDate.of(2024, 3, 1);
        boolean resultado = concurso.validarIncripcion(fechaInscripcion, participante);

        assertTrue(resultado, "El participante debería poder inscribirse el primer día de la inscripción.");
        assertTrue(concurso.participanteInscripto(participante), "El participante debería estar registrado en el concurso.");
    }

    @Test
    void testParticipanteIntentaInscribirseAntesDelInicio() throws Exception {
        LocalDate fechaInscripcion = LocalDate.of(2024, 2, 28);
        boolean resultado = concurso.validarIncripcion(fechaInscripcion, participante);

        assertFalse(resultado, "El participante no debería poder inscribirse antes del inicio del concurso.");
        assertFalse(concurso.participanteInscripto(participante), "El participante no debería estar registrado en el concurso.");
    }

    @Test
    void testParticipanteIntentaInscribirseDespuesDelCierre() throws Exception {
        LocalDate fechaInscripcion = LocalDate.of(2024, 4, 1);
        boolean resultado = concurso.validarIncripcion(fechaInscripcion, participante);

        assertFalse(resultado, "El participante no debería poder inscribirse después del cierre del concurso.");
        assertFalse(concurso.participanteInscripto(participante), "El participante no debería estar registrado en el concurso.");
    }

    @Test
    void testParticipanteInscriptoCorrectamente() throws Exception {
        LocalDate fechaInscripcion = LocalDate.of(2024, 3, 10);
        concurso.validarIncripcion(fechaInscripcion, participante);
        assertTrue(concurso.participanteInscripto(participante), "El participante debería estar en la lista de inscritos.");
    }
    @Test
    void testParticipanteNoInscripto() {
        Participante otroParticipante = new Participante("Maria" , "sanchez");
        assertFalse(concurso.participanteInscripto(otroParticipante), "Un participante que no se inscribió no debería estar en la lista.");
    }
}

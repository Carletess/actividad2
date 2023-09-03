package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class calcularPromedioSemanaTest {

    @Test
    void calcularPromedioSemana() {
        int[][] semanaCorta = {
                {15, 25, 30, 35, 40},
                {1, 22, 22, 32, 42},
        };

        // Calcula el resultado esperado
        double sumaTemperaturas = 0;
        int count = 0;
        for (int[] dia : semanaCorta) {
            for (int temperatura : dia) {
                sumaTemperaturas += temperatura;
                count++;
            }
        }
        double resultadoEsperado = sumaTemperaturas / count;

        // Calcula el resultado actual llamando al método que estás probando
        double resultadoActual = Main.calcularPromedioSemana(semanaCorta);

        // Compara el resultado actual con el resultado esperado
        assertEquals(resultadoEsperado, resultadoActual, 0.001); // Ajusta la tolerancia según tu precisión
    }
}

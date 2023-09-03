package org.example;

public class Main {
    public static void main(String[] args) {
        iniciar();
    }

    public static void iniciar() {
        int[][] semana = imprimirMatrizCompletada();
        double[] promedios = calcularPromedioDeFilas(semana);
        double diaMasCaluroso = obtenerDiaMasCaluroso(promedios);
        double diaMasFrio = obtenerDiaMasFrio(promedios);
        System.out.println("el promedio más bajo es: " + diaMasFrio);
    }

    public static int[][] imprimirMatrizCompletada() {
        int[][] semana = crearMatrizSemana();
        llenarMatrizSemana(semana);
        mostrarMatrizSemana(semana);
        return semana;
    }

    public static int[][] crearMatrizSemana() {
        return new int[7][24];
    }

    public static void mostrarMatrizSemana(int[][] semana) {
        for (int i = 0; i < semana.length; i++) {
            for (int j = 0; j < semana[0].length; j++) {
                System.out.print(semana[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int[][] llenarMatrizSemana(int[][] semana) {
        for (int x = 0; x < semana.length; x++) {
            for (int y = 0; y < semana[0].length; y++) {
                semana[x][y] = (int) ((Math.random() * 30) + 1);
            }
        }
        return semana;
    }

    public static double[] calcularPromedioDeFilas(int[][] semana) {
        double[] promedios = new double[semana.length];

        for (int fila = 0; fila < semana.length; fila++) {
            int suma = 0;
            for (int columna = 0; columna < semana[0].length; columna++) {
                suma += semana[fila][columna];
            }
            promedios[fila] = (double) suma / semana[0].length;
            System.out.println("El promedio de la fila " + fila + " es: " + promedios[fila]);
        }

        return promedios;
    }

    public static double obtenerDiaMasFrio(double[] promedios) {
        double diaFrio = promedios[0];

        for (int i = 1; i < promedios.length; i++) {
            if (promedios[i] < diaFrio) {
                diaFrio = promedios[i];
            }
        }

        return diaFrio;
    }

    public static double obtenerDiaMasCaluroso(double[] promedios) {
        double diaCaluroso = promedios[0];

        for (int i = 1; i < promedios.length; i++) {
            if (promedios[i] > diaCaluroso) {
                diaCaluroso = promedios[i];
            }
        }

        return diaCaluroso;
    }

    public static int obtenerHoraMasCalurosa() {
        return 0;
    }

    public static int obtenerHoraMasFria() {
        return 0;
    }
}
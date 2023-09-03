/* for (int fila = 0; fila < matriz.length; fila++) {
        for (int columna = 0; columna < matriz[0].length; columna++) { */

package org.example;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        iniciar();
    }

    public static void iniciar() {
        int [][] semana = crearMatrizSemana();
        llenarMatrizSemana(semana);
        double [] promedios = calcularPromedioDeFilas(semana);

        mostrarMenu(semana, promedios);
    }

    public static int[][] crearMatrizSemana() {
        return new int[7][24];
    }

    public static int[][] llenarMatrizSemana(int[][] semana) {
        for (int x = 0; x < semana.length; x++) {
            for (int y = 0; y < semana[0].length; y++) {
                semana[x][y] = (int) ((Math.random() * 30) + 1);
            }
        }
        return semana;
    }

    public static void mostrarMatrizSemana(int[][] semana) {
        for (int i = 0; i < semana.length; i++) {
            for (int j = 0; j < semana[0].length; j++) {
                System.out.print(semana[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static double calcularPromedio(int[][] matriz) {
        int suma = 0;
        int elementos = 0;

        for (int fila = 0; fila < matriz.length; fila++) {
            for (int columna = 0; columna < matriz[0].length; columna++) {
                suma += matriz[fila][columna];
                elementos++;
            }
        }

        return (double) suma / elementos;
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

    public static double calcularPromedioSemana(int[][] semana) {
        return calcularPromedio(semana);
    }

    public static int obtenerDiaMasFrio(double[] promedios) {
        double diaFrio = promedios[0];
        int diaMasFrio = 0;

        for (int i = 1; i < promedios.length; i++) {
            if (promedios[i] < diaFrio) {
                diaFrio = promedios[i];
                diaMasFrio = i;
            }
        }

        return diaMasFrio ;
    }

    public static int obtenerDiaMasCaluroso(double[] promedios) {
        double diaCaluroso = promedios[0];
        int diaMasCaluroso = 0;

        for (int i = 1; i < promedios.length; i++) {
            if (promedios[i] > diaCaluroso) {
                diaCaluroso = promedios[i];
                diaMasCaluroso = i;
            }
        }
        return diaMasCaluroso;
    }

    public static int obtenerHoraMasFria(int[][] semana) {
        int horaMasFria = 0;
        double temperaturaMasFria = semana[0][0];

        for (int dia = 0; dia < semana.length; dia++){
            for (int hora = 0; hora < semana[0].length; hora++) {
                if (semana[dia][hora] < temperaturaMasFria) {
                    temperaturaMasFria = semana[dia][hora];
                    horaMasFria = hora;
                }
            }
        }
        return horaMasFria;
    }
    public static int obtenerHoraMasCalurosa(int[][] semana) {
        int horaMasCalurosa = 0;
        double temperaturaMasCalurosa = semana[0][0];

        for (int hora = 0; hora < semana[0].length; hora++) {
            for (int dia = 0; dia < semana.length; dia++) {
                if (semana[dia][hora] > temperaturaMasCalurosa) {
                    temperaturaMasCalurosa = semana[dia][hora];
                    horaMasCalurosa = hora;
                }
            }
        }
        return horaMasCalurosa;
    }

    public static void mostrarMenu(int[][] semana, double[] promedios) {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\nMenu:");
            System.out.println("1. Mostrar matriz de temperaturas");
            System.out.println("2. Mostrar promedios de temperaturas por día");
            System.out.println("3. Mostrar dia mas caluroso");
            System.out.println("4. Mostrar dia mas frio");
            System.out.println("5. Mostrar hora mas fria");
            System.out.println("6. Mostrar hora mas calurosa");
            System.out.println("7. Mostrar promedio de la temperatura en la semana");
            System.out.println("8. Salir");
            System.out.print("Ingresa una opción: ");

            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("\nTemperaturas de la semana: (filas = dias ; columnas = horas)");
                    mostrarMatrizSemana(semana);
                    break;
                case 2:
                    System.out.println("\nPromedios de temperatura:");
                    for (int i = 0; i < promedios.length; i++) {
                        System.out.println("Dia " + (i + 1) + ": " + promedios[i]);
                    }
                    break;
                case 3:
                    System.out.println("\nEl dia mas caluroso fue el dia " + (obtenerDiaMasCaluroso(promedios) + 1));
                    break;
                case 4:
                    System.out.println("\nEl dia mas frio fue el dia "  + (obtenerDiaMasFrio(promedios) + 1));
                    break;

                case 5:
                    int diaHoraMasFria = obtenerDiaMasFrio(promedios);
                    int horaMasFria = obtenerHoraMasFria(semana);
                    double temperaturaMasFria = semana[diaHoraMasFria][horaMasFria];
                    System.out.println("\nLa hora mas fria fue en el dia " + (diaHoraMasFria + 1) + " con una temperatura de " + temperaturaMasFria + " grados.");
                    break;

                case 6:
                    int diaHoraMasCalurosa = obtenerDiaMasCaluroso(promedios);
                    int horaMasCalurosa = obtenerHoraMasCalurosa(semana);
                    double temperaturaMasCalurosa = semana[diaHoraMasCalurosa][horaMasCalurosa];
                    System.out.println("\nLa hora más calurosa fue en el día " + (diaHoraMasCalurosa + 1) + " con una temperatura de " + temperaturaMasCalurosa + " grados.");
                    break;

                case 7:
                    double promedioSemana = calcularPromedioSemana(semana);
                    System.out.println("\nPromedio de temperaturas de la semana: " + promedioSemana);
                    break;

                case 8:
                    System.out.println("\nSaliste");
                    break;

                default:
                    System.out.println("Ingresa un opcion valida");
            }

        } while (opcion != 8);
    }
}

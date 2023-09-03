package org.example;

public class Main {
    public static void main(String[] args) {
        imprimirMatrizCompletada();
    }

    public static int[][] imprimirMatrizCompletada(){
        int[][] semana = crearMatrizSemana();
        llenarMatrizSemana(semana);
        mostrarMatrizSemana(semana);
        return semana;
    }
    public static int [][] crearMatrizSemana(){
        return new int[7][24];
    }
    public static void mostrarMatrizSemana(int [][] semana){
        for (int i = 0; i < semana.length; i++){
            for (int j = 0; j < semana[0].length; j++){
                System.out.print(semana[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static int[][] llenarMatrizSemana(int [][] semana){
        for(int x = 0; x < semana.length; x++){
            for(int y = 0; y < semana[0].length; y++){
                semana[x][y] = (int) ((Math.random() * 10) + 1);
            }
        }
        return semana;
    }
    public static double calcularPromedio(int [][] semana) {
        double promedio = 0;

        for(int i = 0; i < 3; i++) {
            promedio += (i / 3);
        }
        return promedio;
    }

    public static int obtenerDiaMasFrio() {
        return 0;
    }

    public static int obtenerDiaMasCaluroso(){
        return 0;
    }

    public static int obtenerHoraMasCalurosa(){
        return 0;
    }

    public static int obtenerHoraMasFria(){
        return 0;
    }
}

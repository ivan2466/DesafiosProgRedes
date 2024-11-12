package TATETI;
import java.util.Scanner;

public class Tateti {

    // Tablero de 3x3 para el juego
    static char[][] tablero = {
        {' ', ' ', ' '},
        {' ', ' ', ' '},
        {' ', ' ', ' '}
    };

    // Función para imprimir el tablero
    public static void imprimirTablero() {
        System.out.println("  0   1   2");
        for (int i = 0; i < 3; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < 3; j++) {
                System.out.print(tablero[i][j]);
                if (j < 2) System.out.print(" | ");
            }
            System.out.println();
            if (i < 2) System.out.println(" ---|---|---");
        }
    }

    // Función para verificar si hay un ganador
    public static boolean verificarGanador(char jugador) {
        // Comprobar filas y columnas
        for (int i = 0; i < 3; i++) {
            if ((tablero[i][0] == jugador && tablero[i][1] == jugador && tablero[i][2] == jugador) || 
                (tablero[0][i] == jugador && tablero[1][i] == jugador && tablero[2][i] == jugador)) {
                return true;
            }
        }
        // Comprobar diagonales
        if ((tablero[0][0] == jugador && tablero[1][1] == jugador && tablero[2][2] == jugador) || 
            (tablero[0][2] == jugador && tablero[1][1] == jugador && tablero[2][0] == jugador)) {
            return true;
        }
        return false;
    }

    // Función para verificar si el tablero está lleno
    public static boolean tableroLleno() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (tablero[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char jugadorActual = 'X';  // 'X' empieza primero
        boolean hayGanador = false;
        
        // Juego hasta que haya un ganador o el tablero esté lleno
        while (!hayGanador && !tableroLleno()) {
            imprimirTablero();
            System.out.println("Jugador " + jugadorActual + ", ingresa tu movimiento.");
            System.out.print("Fila (0-2): ");
            int fila = scanner.nextInt();
            System.out.print("Columna (0-2): ");
            int columna = scanner.nextInt();
            
            // Verificar si la casilla está vacía
            if (tablero[fila][columna] == ' ') {
                tablero[fila][columna] = jugadorActual;
                
                // Verificar si el jugador actual ha ganado
                if (verificarGanador(jugadorActual)) {
                    hayGanador = true;
                } else {
                    // Cambiar al otro jugador
                    jugadorActual = (jugadorActual == 'X') ? 'O' : 'X';
                }
            } else {
                System.out.println("¡Esa casilla ya está ocupada! Intenta de nuevo.");
            }
        }

        // Mostrar el tablero final
        imprimirTablero();

        // Determinar el resultado
        if (hayGanador) {
            System.out.println("¡Jugador " + jugadorActual + " ha ganado!");
        } else {
            System.out.println("¡El juego ha terminado en empate!");
        }

        scanner.close();
    }
}

package Juego;
import java.util.Scanner;
import java.util.Random;

public class JuegoAdivinanza {
    public static void main(String[] args) {
        // Crear un objeto Random para generar números aleatorios
        Random random = new Random();
        
        // Generar un número aleatorio entre 1 y 100
        int numeroAleatorio = random.nextInt(100) + 1;
        
        // Crear un objeto Scanner para leer la entrada del usuario
        Scanner scanner = new Scanner(System.in);
        
        // Mensaje inicial
        System.out.println("¡Bienvenido al juego de adivinanza!");
        System.out.println("Estoy pensando en un número entre 1 y 100. ¿Puedes adivinar cuál es?");
        
        // Inicializar el número de intentos
        int intentos = 0;
        int adivinanza = 0;
        
        // Bucle para seguir pidiendo al usuario que adivine el número
        while (adivinanza != numeroAleatorio) {
            System.out.print("Introduce tu adivinanza: ");
            adivinanza = scanner.nextInt();
            intentos++;
            
            // Verificar si el número es mayor, menor o igual al número aleatorio
            if (adivinanza < numeroAleatorio) {
                System.out.println("Tu adivinanza es demasiado baja. Intenta de nuevo.");
            } else if (adivinanza > numeroAleatorio) {
                System.out.println("Tu adivinanza es demasiado alta. Intenta de nuevo.");
            } else {
                System.out.println("¡Felicidades! Adivinaste el número en " + intentos + " intentos.");
            }
        }
        
        // Cerrar el scanner
        scanner.close();
    }
}


import java.util.Scanner;

public class CapturaElDragon {
    public static void main(String[] args) {
        final int NUMERO_DE_TURNOS = 10;
        final int NUMERO_CUEVAS = 100;

        boolean capturado = false;
        int posicionDragon = generarPosicionInicial(NUMERO_CUEVAS);
        int turno = 0;

        System.out.println("¡Bienvenido al juego 'Captura al Dragón'!");
        System.out.println("El dragón está escondido en una de las " + NUMERO_CUEVAS + " cuevas. ¡Buena suerte!");

        while (turno < NUMERO_DE_TURNOS && !capturado) {
            turno++;
            System.out.println("\nTurno " + turno + " de " + NUMERO_DE_TURNOS);
            int cuevaJugador = pedirCueva(NUMERO_CUEVAS);

            if (cuevaJugador == posicionDragon) {
                capturado = true;
                System.out.println("¡Felicidades! Capturaste al dragón en el turno " + turno + " 🐉.");
            } else {
                darPista(posicionDragon, cuevaJugador);
                posicionDragon = moverDragon(posicionDragon, NUMERO_CUEVAS);
                System.out.println("El dragón se ha movido a otra cueva...");
            }
        }

        if (!capturado) {
            System.out.println("\n¡Lo siento! No capturaste al dragón. Escapó hacia la cueva " + posicionDragon + ".");
        }
    }

    static int generarPosicionInicial(int maxCuevas) {
        return (int) (Math.random() * maxCuevas) + 1;
    }

    static int pedirCueva(int maxCuevas) {
        Scanner entrada = new Scanner(System.in);
        int cueva;
        do {
            System.out.print("Elige una cueva (1-" + maxCuevas + "): ");
            cueva = entrada.nextInt();
        } while (cueva < 1 || cueva > maxCuevas);
        return cueva;
    }

    static void darPista(int posicionDragon, int cuevaJugador) {
        int distancia = Math.abs(posicionDragon - cuevaJugador);
        if (distancia == 1) {
            System.out.println("¡Estás muy cerca!");
        } else if (distancia <= 5) {
            System.out.println("Estás cerca, sigue buscando.");
        } else {
            System.out.println("El dragón está lejos...");
        }
    }

    static int moverDragon(int posicionActual, int maxCuevas) {
        int movimiento = (int) (Math.random() * 3) - 1;
        int nuevaPosicion = posicionActual + movimiento;

        if (nuevaPosicion < 1) {
            nuevaPosicion = 1;
        } else if (nuevaPosicion > maxCuevas) {
            nuevaPosicion = maxCuevas;
        }
        return nuevaPosicion;
    }
}
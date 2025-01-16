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
                System.out.println("¡Felicidades! Capturaste al dragón en el turno " + turno);
            }
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
}
public class CapturaElDragon {
    public static void main(String[] args) {
        
        final int NUMERO_DE_TURNOS = 10;
        final int NUMERO_CUEVAS = 100; 


        boolean capturado = false;
        int posicionDragon = generarPosicionInicial(NUMERO_CUEVAS);
        int turno = 0; 

        System.out.println("¡Bienvenido al juego 'Captura al Dragón'!");
        System.out.println("El dragón está escondido en una de las " + NUMERO_CUEVAS + " cuevas. ¡Buena suerte!");
    }


    static int generarPosicionInicial(int maxCuevas) {
        return (int) (Math.random() * maxCuevas) + 1; 
    }
}
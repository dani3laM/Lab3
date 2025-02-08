public class main {
    public static void main(String[] args) throws Exception {
        Fila fila = new Fila();

        // Crear e iniciar el generador de clientes
        GeneradorClientes generador = new GeneradorClientes(fila, 20);
        generador.start();

        // Crear e iniciar los 5 cajeros
        Cajero[] cajeros = new Cajero[5];
        for (int i = 0; i < cajeros.length; i++) {
            cajeros[i] = new Cajero(i + 1, fila);
            cajeros[i].start();
        }
    }
}

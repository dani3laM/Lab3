public class Cajero extends Thread{
    public int id ;
    public double factorCansancio = 1.0;
    public Fila fila;
    public Cajero(int id, Fila fila){
        this.id = id;
        this.fila = fila;
    }
    public void run() {
        while (true) {
            int[] cliente = fila.salirFila();
            if (cliente == null) {
                System.out.println("La fila no tiene más clientes. Finalizando turno.");
                break; 
            }
            int uidCliente = cliente[0];
            int tiempoBase = cliente[1];
            int tiempoCalculado = (int) (tiempoBase * factorCansancio);
            System.out.println("Cajero " + id + " atendiendo a Cliente " + uidCliente +
                    " Tiempo Base: " + tiempoBase + " ms" +
                    " Factor Cansancio: " + String.format("%.2f", factorCansancio) +
                    " Tiempo Calculado: " + tiempoCalculado + " ms");
            ;
            try {
                Thread.sleep(tiempoCalculado); 
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            factorCansancio += tiempoBase * 0.0001;
            System.out.println("Cajero " + id + " finalizó con Cliente " + uidCliente +
                    " Nuevo Factor Cansancio: " + String.format("%.2f", factorCansancio));
            
        }
    }
}

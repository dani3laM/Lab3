

public class GeneradorClientes extends Thread{
    
    public int numClientes;
    public Fila fila;
    public GeneradorClientes(Fila fila,int numClientes){
        this.numClientes = numClientes;
        this.fila = fila;
    }
    public void run(){
        for (int i = 0; i < numClientes; i++) {
            int tiempoBase = (int) (Math.random()*2001); 
            int[] cliente = {i+1, tiempoBase};

            fila.ingresarFila(cliente);
            System.out.println("Cliente creado: ID " + cliente[0] + ", Tiempo Base: " + tiempoBase + " ms");

            try {
                int tiempoEspera = (int) (Math.random() * 501); 
                Thread.sleep(tiempoEspera);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        fila.marcarFinalizacion();
    }

}


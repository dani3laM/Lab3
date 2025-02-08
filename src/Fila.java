import java.util.ArrayList;

public class Fila {
    private ArrayList<int[]> filaClientes;
    private boolean terminado = false;
    public Fila(){
        filaClientes = new ArrayList<int[]>();
    }
    public ArrayList<int[]> getClientes(){
        return this.filaClientes;
    }
    public synchronized void ingresarFila(int[]cliente){
        filaClientes.add(cliente);
        notifyAll();
    }
    public synchronized int[] salirFila(){
        while (filaClientes.isEmpty() && !terminado) {
            try {
                System.out.println("Cajero esperando clientes...");
                wait(); 
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        if (filaClientes.isEmpty() && terminado) {
            return null; 
        }
        return filaClientes.remove(0);
    }
    public synchronized void marcarFinalizacion() {
        terminado = true;
        notifyAll();
    }
}

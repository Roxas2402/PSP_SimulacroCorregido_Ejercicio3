import java.util.concurrent.Semaphore;

public class HiloHijo extends Thread {
    public static int cont;
    public static int contTotal = 0;
    private Semaphore semaphore;

    public HiloHijo(String name, Semaphore semaphore) {
        super(name);
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        try {
            semaphore.acquire();

            cont = 0;
            for (String color : Main.colores) {
                if (color.equalsIgnoreCase(this.getName())) {
                    cont++;
                    contTotal++;
                }
            }
            System.out.println("Soy " + this.getName() + " y tengo " + cont + " colores.");
            semaphore.release();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

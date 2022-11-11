import java.util.concurrent.Semaphore;

public class Main {
    public static String[] colores;

    static {
        colores = new String[]{"rojo", "verde", "azul", "rojo", "verde"};
    }

    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(1);
        HiloHijo rojo = new HiloHijo("rojo", semaphore);
        HiloHijo azul = new HiloHijo("azul", semaphore);
        HiloHijo verde = new HiloHijo("verde", semaphore);

        rojo.start();
        azul.start();
        verde.start();

        try {
            rojo.join();
            azul.join();
            verde.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Total colores: " + HiloHijo.contTotal);
    }
}
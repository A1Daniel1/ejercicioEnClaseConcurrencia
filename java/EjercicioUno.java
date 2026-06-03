import java.util.ArrayList;

class MyThread extends Thread {
    private final int minValue;
    private final int maxValue;
    private long suma;

    public MyThread(int min, int max) {
        this.minValue = min;
        this.maxValue = max;
        this.suma = 0;
    }

    @Override
    public void run() {
        for (int i = minValue; i < maxValue; i++) {
            suma += i;
        }
    }

    public long getSuma() {
        return suma;
    }
}

public class EjercicioUno {

    public static void main(String[] args) throws InterruptedException {

        int maximo = 500_000_000;
        int cantidadHilos = 1;

        int tamanoIntervalo = maximo / cantidadHilos;

        ArrayList<MyThread> hilos = new ArrayList<>();

        long inicioGlobal = System.nanoTime();

        for (int i = 0; i < cantidadHilos; i++) {

            int inicioIntervalo = i * tamanoIntervalo;

            int finIntervalo;

            if (i == cantidadHilos - 1) {
                finIntervalo = maximo;
            } else {
                finIntervalo = inicioIntervalo + tamanoIntervalo;
            }

            MyThread hilo = new MyThread(
                inicioIntervalo,
                finIntervalo
            );

            hilos.add(hilo);
            hilo.start();
        }

        long sumaTotal = 0;

        for (MyThread hilo : hilos) {
            hilo.join();
            sumaTotal += hilo.getSuma();
        }

        long finGlobal = System.nanoTime();

        System.out.println(
            "Tiempo total: "
            + ((finGlobal - inicioGlobal) / 1_000_000.0)
            + " ms"
        );
    }
}
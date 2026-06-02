import java.util.ArrayList;

class MyThread extends Thread {  
    private final int minValue;
    private final int maxValue;
    private final int threadId;

    public MyThread(int min, int max, int id) {
        this.minValue = min;
        this.maxValue = max;
        this.threadId = id;
    }

    @Override
    public void run() {
        long inicio = System.currentTimeMillis();
        
        for (int i = minValue; i < maxValue; i++) {
            System.out.println("Hilo " + threadId + " imprimiendo: " + i);
        }

        long fin = System.currentTimeMillis();
        long duracion = fin - inicio;

        System.out.println(">> Hilo " + threadId + " finalizado en: " + duracion + " ms");
    }
}

public class ejercicioUno {
    public static void main(String[] args) {
        int maximo = 50000;
        int intervalos = 100;

        ArrayList<ArrayList<Integer>> numeros = new ArrayList<>();
        int tamanoIntervalo = maximo / intervalos;

        for (int i = 0; i < intervalos; i++) {
            ArrayList<Integer> numerosTemp = new ArrayList<>();
            int inicioIntervalo = i * tamanoIntervalo;
            int finIntervalo = inicioIntervalo + tamanoIntervalo;

            for (int j = inicioIntervalo; j < finIntervalo; j++) {
                numerosTemp.add(j);
            }
            numeros.add(numerosTemp);  
        }

        

        for (int i = 0; i < intervalos; i++) {
            long inicio = System.currentTimeMillis();
            int minHilos = numeros.get(i).get(0);
            int maxHilos = numeros.get(i).get(numeros.get(i).size() - 1) + 1;

            MyThread hilo = new MyThread(minHilos, maxHilos, i + 1);
            hilo.start();
        }

    }
}

package Controller;

import java.util.concurrent.Semaphore;

public class ThreadTriatlo extends Thread {

    private static int pointRank = 250;

    private static int Rank = 0;
    private static int[] classificacao = new int[25];
    private int pontuacao = 0;
    private int idCompetidor;
    private Semaphore semaforo;
    public ThreadTriatlo(int idCompetidor, Semaphore semaforo) {
        this.idCompetidor = idCompetidor;
        this.semaforo = semaforo;

    }


    public void run() {
        corrida();

        try {
            semaforo.acquire();
            tiro();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaforo.release();
        }

        ciclismo();

        try{
            semaforo.acquire();
            resultado();
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaforo.release();
        }


        mostrarResultado();


    }

    private void mostrarResultado() {
        for(int i = 0; i < 25; i++) {

            System.out.println((i + 1) + " º Lugar com: " + classificacao[i] + " Pontos!");

        }
    }


    private void corrida() {
        int tamanhoCorrida = 3000;
        int percorridoCorrida = 0;

        while (percorridoCorrida < tamanhoCorrida) {


            percorridoCorrida = percorridoCorrida + (int) (Math.random() * 26) + 20;
            System.out.println("Atleta #" + idCompetidor + " já percorreu "+ percorridoCorrida + " metros da corrida!");

            try {
                sleep(30);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        System.out.println("Atleta #" + idCompetidor + " finalizou a corrida!");


    }

        private void tiro() {

            for(int i = 1; i <= 3; i++) {


                pontuacao = pontuacao + ((int) (Math.random() * 11));
            }

            System.out.println("Atleta #" + idCompetidor + " Pontuou " +  pontuacao + " no tiro ao alvo!");

        }

        private void ciclismo() {

            int tamanhoCiclismo = 5000;
            int percorridoCiclismo = 0;

            while (percorridoCiclismo < tamanhoCiclismo) {

                percorridoCiclismo = percorridoCiclismo + ((int) ((Math.random() * 31) + 40));
                System.out.println("Atleta #" + idCompetidor + " já percorreu "+ percorridoCiclismo + " metros do ciclismo!");


                try {
                    sleep(40);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }

            System.out.println("Atleta #" + idCompetidor + " finalizou o ciclismo!");




        }

    private void resultado() {

        pontuacao = pontuacao + pointRank;

        classificacao[Rank] = pontuacao;

        Rank += 1;

        pointRank = pointRank - 10;

    }

}




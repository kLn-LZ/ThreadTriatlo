package View;

import Controller.ThreadTriatlo;

import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args) {

        int permissao = 5;

        Semaphore semaphore = new Semaphore(permissao);

        for (int i = 1; i <= 25; i++) {
            Thread tTriatlo = new ThreadTriatlo(i, semaphore);
            tTriatlo.start();

        }

    }

}

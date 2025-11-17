package amoba;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Tabla palya = new Tabla(5);

        while (true) {
            palya.kirajzol();

            System.out.println("Add meg a sor és oszlop számát (1-től kezdve): ");
            int sor = sc.nextInt() - 1;
            int oszlop = sc.nextInt() - 1;

            if (!palya.lepes(sor, oszlop, 'X')) {
                System.out.println("Érvénytelen lépés! Próbáld újra.");
                continue;
            }

            if (palya.vanNyertes('X')) {
                palya.kirajzol();
                System.out.println("Játékos (X) nyert!");
                break;
            }

            List<int[]> szabadMezok = palya.getSzabadmezok();
            if (szabadMezok.isEmpty()) {
                System.out.println("Nincs több szabad mező! Döntetlen.");
                break;
            }

            Random rand = new Random();
            int[] gepLepes = szabadMezok.get(rand.nextInt(szabadMezok.size()));
            palya.lepes(gepLepes[0], gepLepes[1], 'O');

            if (palya.vanNyertes('O')) {
                palya.kirajzol();
                System.out.println("Gép (O) nyert!");
                break;
            }
        }
    }
}
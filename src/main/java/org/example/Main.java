package amoba;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        /*
        Tabla palya = new Tabla(3);
        palya.kirajzol();

        System.out.println("\nX lep a (0,0) mezore:");
        palya.lepes(0,0,'X');
        palya.kirajzol();   */

        Scanner sc = new Scanner(System.in);
        Tabla palya = new Tabla(5);

        while (true) {
            palya.kirajzol();

            System.out.println("Add meg a sor es oszlop szamat (1-tol kezdve): ");
            int sor =  sc.nextInt() - 1;
            int oszlop = sc.nextInt() - 1;

            if (!palya.lepes(sor, oszlop, 'X')) {
                System.out.println("Ervenytelen lepes! Probald ujra.");
                continue;
            }

            List<int[]> szabadMezok = palya.getSzabadmezok();
            if (szabadMezok.isEmpty()) {
                System.out.println("Nincs tobb szabad mezo! Dontetlen.");
                break;
            }

            Random rand = new Random();
            int[] gepLepes = szabadMezok.get(rand.nextInt(szabadMezok.size()));
            palya.lepes(gepLepes[0], gepLepes[1], 'O');
        }

    }
}
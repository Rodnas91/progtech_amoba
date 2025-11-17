package amoba;

import java.util.List;
import java.util.ArrayList;

public class Tabla {
    private final int meret;
    private final char[][] mezok;

    public Tabla(int meret) {
        this.meret = meret;
        this.mezok = new char[meret][meret];

        for (int i = 0; i < meret; i++) {
            for (int j = 0; j < meret; j++) {
                mezok[i][j] = ' ';
            }
        }
    }

    public void kirajzol() {
        System.out.print("   ");
        for (int oszlop = 1; oszlop <= meret; oszlop++) {
            System.out.printf(" %d  ", oszlop);
        }
        System.out.println();

        for (int sor = 0; sor < meret; sor++) {
            System.out.print("   ");
            for (int j = 0; j < meret; j++) {
                System.out.print("+---");
            }
            System.out.println("+");

            System.out.printf("%2d ", sor + 1); // Sor száma
            for (int oszlop = 0; oszlop < meret; oszlop++) {
                System.out.print("| " + mezok[sor][oszlop] + " ");
            }
            System.out.println("|");
        }

        System.out.print("   ");
        for (int j = 0; j < meret; j++) {
            System.out.print("+---");
        }
        System.out.println("+");
    }

    public boolean lepes(int sor, int oszlop, char jel) {
        if (sor >= 0 && sor < meret && oszlop >= 0 && oszlop < meret && mezok[sor][oszlop] == ' ') {
            mezok[sor][oszlop] = jel;
            return true;
        }   else {
            return false;
        }
    }

    public boolean vanNyertes(char jel) {
        //sor
        for (int i = 0; i < meret; i++) {
            int db = 0;
            for (int j = 0; j < meret; j++) {
                if (mezok[i][j] == jel) {
                    db++;
                    if (db == 5) return true;
                }   else {
                    db = 0;
                }
            }
        }

        //oszlop
        for (int j = 0; j < meret; j++) {
            int db = 0;
            for (int i = 0; i < meret; i++) {
                if (mezok[i][j] == jel) {
                    db++;
                    if (db == 5) return true;
                }   else {
                    db = 0;
                }
            }
        }

        //atlo bal
        for (int i = 0; i <= meret - 5; i++) {
            for (int j = 0; j <= meret - 5; j++) {
                int db = 0;
                for (int k = 0; k < meret; k++) {
                    if (mezok[i + k][j + k] == jel) {
                        db++;
                        if (db == 5) return true;
                    }   else {
                        break;
                    }
                }
            }
        }

        //atlo jobb
        for (int i = 0; i <= meret - 5; i++) {
            for (int j = 4; j < meret - 5; j++) {
                int db = 0;
                for (int k = 0; k < 5; k++) {
                    if  (mezok[i + k][j + k] == jel) {
                        db++;
                        if (db == 5) return true;
                    }   else {
                        break;
                    }
                }
            }
        }
        return false;
    }

    public int getMeret() {
        return meret;
    }
    public char getMezok(int sor, int oszlop) {
        return mezok[sor][oszlop];
    }

    public List<int[]> getSzabadmezok() {
        List<int[]> szabadMezok = new ArrayList<>();
        for (int i = 0; i < meret; i++) {
            for (int j = 0; j < meret; j++) {
                if (mezok[i][j] == ' ') {
                    szabadMezok.add(new int[]{i, j});
                }
            }
        }
        return szabadMezok;
    }


}

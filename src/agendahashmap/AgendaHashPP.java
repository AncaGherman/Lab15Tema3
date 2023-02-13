package agendahashmap;

import java.util.Scanner;

public class AgendaHashPP {
    public static void main(String[] args) {
        Agenda agenda = new Agenda();

        int n = 0;
        while (n != -1) {
            n = meniu();
            switch (n) {
                case 1:
                    agenda.adaugaNume();
                    break;
                case 2:
                    agenda.afiseazaAgenda();
                    break;
                case 3:
                    agenda.cautaNume();
                    break;
                case 4:
                    String stNume = agenda.cautaNume();
                    agenda.stergeNume(stNume);
                    break;
                case 5:
                    String stNumeV = agenda.cautaNume();
                    agenda.modifica(stNumeV);
                    break;
                case -1:
                    break;
                default:
                    System.out.println("Ati introdus gresit!");

            }
        }
    }

    public static int meniu() {
        int nr = 0;
        System.out.println("Alegeti operatia in agenda:");
        System.out.println(" 1 - adaugare");
        System.out.println(" 2 - afisare");
        System.out.println(" 3 - cautare");
        System.out.println(" 4 - stergere");
        System.out.println(" 5 - modificare");
        System.out.println("-1 - pentru iesire");

        try {
            nr = new Scanner(System.in).nextInt();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        finally {
            return nr;
        }
    }

}


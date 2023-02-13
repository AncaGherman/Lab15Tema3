package agendahashmap;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Agenda {
    private HashMap<String, String> ag = new HashMap<>();

    public Agenda() {
    }

    public HashMap<String, String> getAg() {
        return ag;
    }

    public void setAg(HashMap<String, String> ag) {
        this.ag = ag;
    }

    public void adaugaNume() {
        boolean gasit = false;
        System.out.print("Introduceti numele: ");
        String stNume = new Scanner(System.in).nextLine();
        if (ag.containsKey(stNume)) {
            System.out.println("Persoana mai exista deja, nu poate fi adaugata din nou!");
        } else {
            System.out.print("Introduceti nr de telefon: ");
            String stTel = new Scanner(System.in).nextLine();
            if (ag.containsValue(stTel)) {
                System.out.println("Numarul de telefon este introdus deja! ");
            } else {
                ag.put(stNume, stTel);
                System.out.println("Persoana a fost adaugata in agenda!");
            }
        }
    }

    public void afiseazaAgenda() {
        for (HashMap.Entry<String, String> elAg : ag.entrySet()) {
            System.out.println(elAg.getKey() + " " + elAg.getValue());
        }
    }

    public String cautaNume() {
        boolean gasit = false;
        String rez = "-1";
        System.out.print("Introduceti numele: ");
        String stNume = new Scanner(System.in).nextLine();

        if (ag.containsKey(stNume)) {
            System.out.print("Persoana a fost gasita: " + "Nume: " + stNume + ", Telefon: ");
            System.out.println(ag.get(stNume));
            rez = stNume;
        } else {
            System.out.println("Persoana nu a fost gasita!");
        }
        return rez;
    }

    public void stergeNume(String stNume) {
        //String stNume = agenda.cautaNume();
        if (!stNume.equals("-1")) {
            ag.remove(stNume);
            System.out.println("Persoana a fost stearsa!");
        }
    }

    public void modifica(String stNumeV) {
        if (!stNumeV.equals("-1")) {
            System.out.print("Introduceti numele nou: ");
            String stNumeN = new Scanner(System.in).nextLine();
            String stTelV = ag.get(stNumeV);
            if (ag.containsKey(stNumeN) && !stNumeV.equals(stNumeN)) {
                System.out.println("Numele exista deja in agenda ! Alegeti alt nume!");
                return;
            }
            System.out.print("Introduceti telefonul nou: ");
            String stTelN = new Scanner(System.in).nextLine();
            if (ag.containsValue(stTelN) && !stTelV.equals(stTelN)) {
                System.out.println("Numarul de telefon este introdus deja! ");
                return;
            }
            if (stNumeV.equals(stNumeN)) {
                ag.replace(stNumeV, stTelN);
            }
            else {
                ag.put(stNumeN, stTelN);
                ag.remove(stNumeV);
            }
            System.out.println("Datele persoanei au fost modificate!");
        }
    }
}

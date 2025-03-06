import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

/**
  * 
  * Razred za delovanje Škatle in vseh njenih lastnosti iz škatla.java in podrazredov teza/barva
  *
  * @author Luka Lelas
  * @version Vaja 35
  */

public class HelloŠkatla {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Izpis> skatle = new ArrayList<>();
        
        try {
            while (true) {
                System.out.println("Vnesite dimenzije škatle (širina, višina, globina) ali pritisnite Enter za konec:");
                String vnos = scanner.nextLine();
                if (vnos.isEmpty()) break;
                
                String[] deli = vnos.split(" ");
                if (deli.length < 3) {
                    System.out.println("Neveljaven vnos. Vnesite tri številke.");
                    continue;
                }
                
                double sirina = Double.parseDouble(deli[0]);
                double visina = Double.parseDouble(deli[1]);
                double globina = Double.parseDouble(deli[2]);
                
                System.out.println("Izberite tip škatle: 1 - Osnovna, 2 - Barvna, 3 - Težka");
                int tip = scanner.nextInt();
                scanner.nextLine();
                
                switch (tip) {
                    case 1:
                        skatle.add(new Skatla(sirina, visina, globina));
                        break;
                    case 2:
                        System.out.println("Vnesite barvo škatle:");
                        String barva = scanner.nextLine();
                        skatle.add(new BarvnaSkatla(sirina, visina, globina, barva));
                        break;
                    case 3:
                        System.out.println("Vnesite težo škatle:");
                        double teza = scanner.nextDouble();
                        scanner.nextLine();
                        skatle.add(new TezaSkatla(sirina, visina, globina, teza));
                        break;
                    default:
                        System.out.println("Neveljavna izbira.");
                }
            }
            
            System.out.println("Izpis vseh škatel v seznamu:");
            for (Izpis s : skatle) {
                s.izpisiPodatke();
            }
        } catch (IllegalArgumentException e) {
            System.err.println("Napaka: " + e.getMessage());
        } catch (ArithmeticException e) {
            System.err.println("Aritmetična napaka: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}

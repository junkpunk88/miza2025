/**
  * 
  * Razred za prikaz Škatle in njenih lastnosti
  *
  * @author Luka Lelas
  * @version Vaja 35
  */
  public class Skatla implements Izpis {
    private double sirina;
    private double visina;
    private double globina;

    // Konstruktor
    public Skatla(double sirina, double visina, double globina) {
		if (sirina <= 0 || visina <= 0 || globina <= 0) {
            throw new IllegalArgumentException("Dimenzije morajo biti pozitivne vrednosti.");
			}
        this.sirina = sirina;
        this.visina = visina;
        this.globina = globina;
    }
	 // Get metode
    public double getSirina() {
        return sirina;
    }

    public double getVisina() {
        return visina;
    }

    public double getGlobina() {
        return globina;
    }

    // Metoda za izračun volumna
    public double volumen() {
        return sirina * visina * globina;
    }

    // Metoda za izpis podatkov o škatli iz vmesnika Izpis
	@Override
    public void izpisiPodatke() {
        System.out.println("Škatla [Širina: " + sirina + ", Višina: " + visina + ", Globina: " + globina + "]");
    }
}

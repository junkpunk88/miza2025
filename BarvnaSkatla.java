/**
  * 
  * Podrazred za prikaz barve Škatle 
  * @author Luka Lelas
  * @version Vaja 35
  */
	// Podrazred BarvnaSkatla, ki dodaja barvo
	public class BarvnaSkatla extends Skatla implements Izpis {
    private String barva;

    // Konstruktor
    public BarvnaSkatla(double sirina, double visina, double globina, String barva) {
        super(sirina, visina, globina);
		if (barva == null || barva.trim().isEmpty()) {
            throw new IllegalArgumentException("Barva ne sme biti prazna.");
        }
        this.barva = barva;
    }
	// Get metoda za barvo
    public String getBarva() {
        return barva;
    }

    // Prepis metode za izpis podatkov iz vmesnika Izpis
    @Override
    public void izpisiPodatke() {
        super.izpisiPodatke();
        System.out.println("Barva: " + barva);
    }
}
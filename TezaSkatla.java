/**
  * 
  * Podrazred za prikaz teže Škatle
  *
  * @author Luka Lelas
  * @version Vaja 35
  */
	// Podrazred TezaSkatla, ki dodaja maso
	public class TezaSkatla extends Skatla implements Izpis {
    private double masa;

    // Konstruktor
    public TezaSkatla(double sirina, double visina, double globina, double masa) {
        super(sirina, visina, globina);
		if (masa <= 0) {
            throw new IllegalArgumentException("Masa mora biti pozitivna vrednost.");
			}
        this.masa = masa;
    }
	// Get metoda za maso
    public double getMasa() {
        return masa;
	}
    // Metoda za izračun gostote
    public double gostota() {
		double volumen = volumen();
		if (volumen == 0) {
            throw new ArithmeticException("Volumen ne sme biti enak 0.");
        }
        return masa / volumen();
    }

    // Prepis metode za izpis podatkov iz vmesnika Izpis
    @Override
    public void izpisiPodatke() {
        super.izpisiPodatke();
        System.out.println("Masa: " + masa + " kg, Gostota: " + gostota() + " kg/m³");
    }
}

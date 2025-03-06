/**
  * Razred za prikaz uporabe DEDOVANJA
  * Razširja razred Steklenica
  *
  * @author Luka Lelas
  * @version Primer 20 - GUI
  */
public class PivskaSteklenica extends Steklenica implements AlkoholnaPijaca {
	
		// Vse lastnosti od nadrazreda Steklenica se prenesjo
		//Deklariramo dodatne lastnosti, ki so skupne le za pivske steklenice
		
		/**
		 * Znamka piva
		 */
		private String znamka;
		
		/**
		 * Temperatura piva v steklenici (v stopinjah celzija)
		 */
		private double temperatura;
		/**
		 * Stopnja alkohola piva v steklenici (v odstotkih in ne v deležu)
		 */
		private double stopnjaAlkohola;
		
		/**
		 * Konstruktor za inicializacijo nove pivske steklenice, ki je polna in zaprta
		 * Inicializira vse lastnosti
		 * @param k Kapaciteta steklenice (ml)
		 * @param z Znamka piva
		 * @param t Začetna temperatura steklenice ( v stopinjah celzija ) 
		 * @param s Stopnja alkohola (v odstotkih in ne v deležu)
		 */
		public PivskaSteklenica(int k, String z, double t, double s) {
			
			//Pokličemo konstruktor nadrazreda - Steklenica, ki bo inicializirau lastnosti nadrazreda
			super(k, "Pivo");
			
			//Inicializiramo dodatne lastnosti
			znamka = z;
			temperatura = t;
			stopnjaAlkohola = s;
			System.out.println("Pivska steklenica je znamke " + z + " s stopnjo alkohola " + s + " %.");
		}
		
		/**
		 * Konstruktor za inicializacijo nove pivske steklenice, ki je polna in zaprta
		 * Inicializira vse lastnosti
		 * @param k Kapaciteta steklenice (ml)
		 * @param z Znamka piva
		 * @param t Začetna temperatura steklenice ( v stopinjah celzija ) 
		 */
		public PivskaSteklenica(int k, String z, double t) {
			
			//Pokličemo drug konstruktor z default vrednostjo
			this(k, z, t, 4.50);
			
		}
		/**
		 * Konstruktor za inicializacijo nove pivske steklenice, ki je polna in zaprta
		 * Inicializira vse lastnosti
		 * @param k Kapaciteta steklenice (ml)
		 * @param z Znamka piva
		 */
		public PivskaSteklenica(int k, String z) {
			
			//Pokličemo drug konstruktor
			this(k, z, 8.0);
			
			
		}
		/**
		 * Metoda, predpisana z vmesnikom AlkoholnaPijaca
		 * vrne stopnjo alkohola v odstotkih
		 */
		 
		public double getStopnjaAlkohola(){
			return stopnjaAlkohola;
			
		}
		/**
		 * Metoda vrne znamko piva
		 * @return Znamka piva
		 */
		 
		public String getZnamka(){
			return znamka;
			
		}
}
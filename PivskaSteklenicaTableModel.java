import javax.swing.table.*;

/**
  * Razred za delo s tabelo pivskih steklenic
  * Razširja razred tabele
  *
  * @author Luka Lelas
  * @version Primer 20 - Grafični uporabniški vmesnik
  * 
  */
 public class PivskaSteklenicaTableModel extends DefaultTableModel {
	 
	 /**
	  * Konstruktor, ki ustvari tabelo steklenic na mizi
	  */
	public PivskaSteklenicaTableModel() {
	 
		//pokličemo konstruktor nadrazreda
		super();
		
		//dodamo stolpce v tabelo
		addColumn("Znamka");
		addColumn("Stopnja alkohola");
		
		//Ustvarimo seznam objektov / nizov , ki predstavljajo vrstico tabele
		Object[] vrstica  = new Object[] {"Testna znamka", "5.0"};
	
		//vrstico vstavimo v tabelo
		addRow(vrstica);
	}
	/**
	 * javna metoda, ki doda pivsko steklenico v tabelo
	 * @param ps objekt, ki ga dodamo v tabelo
	 */
	public void addPivskaSteklenica(PivskaSteklenica ps) {
		
		//Ustvarimo seznam objektov / nizov , ki predstavljajo vrstico tabele
		Object[] vrstica  = new Object[] {ps.getZnamka(), ps.getStopnjaAlkohola()};
	
		//vrstico vstavimo v tabelo
		addRow(vrstica);
	}
 }
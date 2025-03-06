//Uvozimo razred za delo z  z vhodno-izhodnimi operacijami ter pripomočke
//alpa import java.io.BufferedReader;
import java.io.*;
import java.util.*;
import javax.swing.*;
import java.awt.event.*;

/**
  * Razred za prikaz delvoanja grafičnega uporabniškega vmesnika
  * Razširja razred za delo z okni
  *
  * @author Luka Lelas
  * @version Primer 20 - Grafični uporabniški vmesnik
  * 
  */
  public class Miza extends JFrame implements ActionListener {
	  
	//Deklariramo zasebne lastnosti
	private JPanel povrsina;
	
	private JButton dodajButton;
	private JTextField znamkaTextField;
	private JTextField stopnjaAlkoholaTextField;
	
	private PivskaSteklenicaTableModel modelTabele;
	
	/**
	 * 	Glavna metoda programa. Zažene se vedno ob zagonu. 
	 *
	 *  @param args Seznam argumentov iz ukazne vrstice
	 */	
  public static void main(String[] args)	{
	  
	  //Izpišemo začetek
	  System.out.println("Zaganjam GUI...");
	  
	  // Ustvarimo objekt razreda Miza - kličemo konstruktor razreda miza
	  Miza m = new Miza();
	}
	/**
	 * Konstruktor, ki postavi osnovne lastnosti okna
	 */
	 public Miza() {
		 //Pokličemo konstruktor nadrazreda
		 super("Miza s steklenicami");
		 
		 //Nastavimo obnašanje križca X tako, da konča aplikacijo
		 setDefaultCloseOperation(EXIT_ON_CLOSE);
		 
		 //Nastavimo velikost okna
		 setSize(800, 600);
		 
		 // Inicializiramo elemente GUI
		 povrsina = new JPanel();
		 
		 //Vnosna polja za dodajanje steklenice
		 znamkaTextField = new JTextField(32);
		 stopnjaAlkoholaTextField = new JTextField(4);
		 
		 //Dodamo vnosna polja na površino
		 povrsina.add(new JLabel("Znamka piva:"));
		 povrsina.add(znamkaTextField);
		 
		 povrsina.add(new JLabel("Stopnja alkohola:"));
		 povrsina.add(stopnjaAlkoholaTextField);
		 
		 //Gumb za dodanjanje steklenice
		 dodajButton = new JButton("Dodaj");
		 
		 // Gumbu dodamo action listener za dodajanje steklenic
		 dodajButton.addActionListener(this);
		 
		 //Dodamo gumb na površino
		 povrsina.add(dodajButton);
		 
		 //Inicializiramo model tabele
		 modelTabele = new PivskaSteklenicaTableModel();
		 
		 //Tabelo postavimo na površino
		 //Ustvarimo anonimen objekt razreda JTable z modelomTabele
		 povrsina.add(new JTable(modelTabele));
		 
		 //Površino dodamo na okno
		 add(povrsina);
		 
		 //Prikažemo okno
		 setVisible(true);
	 }
	 
	 /**
	  * Metoda, ki jo predpisuje vmesnik ActionListener
	  * se kliče vedno, ko je pritisnjen gumb
	  * @param e Dogodek ob kliku
	  */
	  public void actionPerformed(ActionEvent e) {
		  //V konzolo izpiše če je action performed
		  System.out.println("Dodajam steklenico...");
		  System.out.println("Znamka piva: " + znamkaTextField.getText());
		  System.out.println("Stopnja alkohola: " + stopnjaAlkoholaTextField.getText());
		  
		  //Spremenljivsko za stopnjo alkohola
		  double sa = Double.parseDouble(stopnjaAlkoholaTextField.getText());
		  
		  //Ustvarimo nov objekt tipa PivskaSteklenica
		  PivskaSteklenica nova = new PivskaSteklenica(500, znamkaTextField.getText(), 8.0, sa);
		  
		  //Objekt dodamo v tabelo
		  modelTabele.addPivskaSteklenica(nova);
	  }
}

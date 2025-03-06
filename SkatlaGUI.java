import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
  * 
  * Razred za GUI za omogočanje dodajanja novih škatel in prikaz njihovih lastnosti v tabeli
  *
  * @author Luka Lelas
  * @version Vaja 35
  */

public class SkatlaGUI extends JFrame {
    private JTextField sirinaField;
    private JTextField visinaField;
    private JTextField globinaField;
    private JTextField barvaField;
    private JTextField masaField;
    private JButton dodajButton;
    private JTable skatlaTable;
    private SkatlaTableModel tableModel;
    
    public SkatlaGUI() {
        setTitle("Upravljanje s Škatlami");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Postavitev komponent
        sirinaField = new JTextField(5);
        visinaField = new JTextField(5);
        globinaField = new JTextField(5);
        barvaField = new JTextField(5);
        masaField = new JTextField(5);
        dodajButton = new JButton("Dodaj škatlo");

        // Tabela za prikaz škatel
        tableModel = new SkatlaTableModel();
        skatlaTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(skatlaTable);

        // Akcije na gumbu
        dodajButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double sirina = Double.parseDouble(sirinaField.getText());
                    double visina = Double.parseDouble(visinaField.getText());
                    double globina = Double.parseDouble(globinaField.getText());

                    // Izbira vrste škatle
                    String tip = JOptionPane.showInputDialog(SkatlaGUI.this, "Izberite tip škatle (1 - Osnovna, 2 - Barvna, 3 - Težka):");
                    int tipInt = Integer.parseInt(tip);
                    
                    switch (tipInt) {
                        case 1:
                            Skatla skatla = new Skatla(sirina, visina, globina);
                            tableModel.dodajSkatlo(skatla);
                            break;
                        case 2:
                            String barva = barvaField.getText();
                            BarvnaSkatla barvnaSkatla = new BarvnaSkatla(sirina, visina, globina, barva);
                            tableModel.dodajSkatlo(barvnaSkatla);
                            break;
                        case 3:
                            double masa = Double.parseDouble(masaField.getText());
                            TezaSkatla tezaSkatla = new TezaSkatla(sirina, visina, globina, masa);
                            tableModel.dodajSkatlo(tezaSkatla);
                            break;
                        default:
                            JOptionPane.showMessageDialog(SkatlaGUI.this, "Neveljavna izbira.");
                            break;
                    }

                    // Počiščenje vnosnih polj po dodajanju
                    sirinaField.setText("");
                    visinaField.setText("");
                    globinaField.setText("");
                    barvaField.setText("");
                    masaField.setText("");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(SkatlaGUI.this, "Vnesite veljavne številke.");
                }
            }
        });

        // Panel za vnosne komponente
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6, 2));
        panel.add(new JLabel("Širina:"));
        panel.add(sirinaField);
        panel.add(new JLabel("Višina:"));
        panel.add(visinaField);
        panel.add(new JLabel("Globina:"));
        panel.add(globinaField);
        panel.add(new JLabel("Barva:"));
        panel.add(barvaField);
        panel.add(new JLabel("Masa:"));
        panel.add(masaField);
        panel.add(dodajButton);

        // Nastavitve okna
        getContentPane().add(panel, BorderLayout.NORTH);
        getContentPane().add(scrollPane, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                SkatlaGUI gui = new SkatlaGUI();
                gui.setVisible(true);
            }
        });
    }
}

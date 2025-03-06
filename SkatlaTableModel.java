import javax.swing.table.DefaultTableModel;

/**
  * 
  * Razred za DefaultTableModel, za razširitev seznama objekotv in njihovnih lastnosti
  *
  * @author Luka Lelas
  * @version Vaja 35
  */

public class SkatlaTableModel extends DefaultTableModel {
    private static final String[] COLUMN_NAMES = {"Vrsta", "Širina", "Višina", "Globina", "Barva", "Masa", "Gostota"};

    public SkatlaTableModel() {
        super(COLUMN_NAMES, 0);
    }

    public void dodajSkatlo(Izpis skatla) {
        Object[] rowData = new Object[COLUMN_NAMES.length];
        rowData[0] = skatla.getClass().getSimpleName();  // Tip objekta
        if (skatla instanceof Skatla) {
            Skatla s = (Skatla) skatla;
            rowData[1] = s.getSirina();
            rowData[2] = s.getVisina();
            rowData[3] = s.getGlobina();
            rowData[4] = null;  // Barva je samo za BarvnaSkatla
            rowData[5] = null;  // Masa je samo za TezaSkatla
            rowData[6] = null;  // Gostota je samo za TezaSkatla
        }
        if (skatla instanceof BarvnaSkatla) {
            BarvnaSkatla bs = (BarvnaSkatla) skatla;
            rowData[4] = bs.getBarva();
        }
        if (skatla instanceof TezaSkatla) {
            TezaSkatla ts = (TezaSkatla) skatla;
            rowData[5] = ts.getMasa();
            rowData[6] = ts.gostota();
        }
        addRow(rowData);
    }
}

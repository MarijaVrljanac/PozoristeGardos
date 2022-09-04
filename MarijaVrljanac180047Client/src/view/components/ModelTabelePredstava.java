/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.components;

import controller.ControllerClient;
import domain.Gledalac;
import domain.Predstava;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author marij
 */
public class ModelTabelePredstava extends AbstractTableModel{
    ArrayList<Predstava> lista;
    String[] kolone = {"Naziv predstave", "Datum i vreme", "Detalji", "Scena"};
    String parametar = "";

    public ModelTabelePredstava() {
        lista = new ArrayList<>();
    }

    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Predstava p = lista.get(rowIndex);
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy. HH:mm");
        
        switch(columnIndex){
            case 0: return p.getNazivPredstave();
            case 1: return sdf.format(p.getDatumIzvodjenja());
            case 2: return p.getDetalji();
            case 3: return p.getScena().getNazivScene();
            default: return "Default case";
        }
    }

    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }

    public ArrayList<Predstava> getLista() {
        return lista;
    }

    public void dodajPredstave(ArrayList<Predstava> predstave) {
        lista = predstave;
        fireTableDataChanged();
    }

    public Predstava vratiPredstavu(int red) {
        return lista.get(red);
    }

    public void setParametar(String parametar) {
        this.parametar = parametar;
        osveziTabelu();
    }
    
    public void osveziTabelu() {
        try {
            lista = (ArrayList<Predstava>) ControllerClient.getInstance().getAllPredstave();
            if (!parametar.equals("")) {
                ArrayList<Predstava> novaLista = new ArrayList<>();
                for (Predstava predstava : lista) {
                    if (predstava.getNazivPredstave().toLowerCase().contains(parametar.toLowerCase()))
                            {
                        novaLista.add(predstava);
                    }
                }
                lista = novaLista;
            }

            fireTableDataChanged();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


    public void vratiPredstave(ArrayList<Predstava> listaBaza) {
        lista = listaBaza;
        fireTableDataChanged();
    }
}

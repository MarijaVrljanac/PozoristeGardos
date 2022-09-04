/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.components;

import controller.ControllerClient;
import domain.Gledalac;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author marij
 */
public class ModelTabeleClanovi extends AbstractTableModel{
    private ArrayList<Gledalac> lista;
//    private String[] kolone = {"Ime i prezime člana kluba",  "Datum rođenja", "Broj telefona"};
    private String[] kolone = {"Ime i prezime člana kluba"};
    private String parametar = "";

    public ModelTabeleClanovi() {
        try {

            lista = ControllerClient.getInstance().getAllGledalac();

        } catch (Exception ex) {
            Logger.getLogger(ModelTabeleClanovi.class.getName()).log(Level.SEVERE, null, ex);
        }
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
    public String getColumnName(int i) {
        return kolone[i];
    }

    @Override
    public Object getValueAt(int row, int column) {
        Gledalac g = lista.get(row);
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy.");
        
        switch (column) {
            case 0:
                return g.getImePrezime();
            case 1:
                return sdf.format(g.getDatumRodjenja());
            case 2:
                return g.getBrojTelefona();
            default: return "Default case";
               
        }
    }

    public Gledalac getSelectedGledalac(int row) {
        return lista.get(row);
    }

    public ArrayList<Gledalac> getLista() {
        return lista;
    }


    public void setParametar(String parametar) {
        this.parametar = parametar;
        osveziTabelu();
    }

    public void osveziTabelu() {
        try {
            lista = ControllerClient.getInstance().getAllGledalac();
            if (!parametar.equals("")) {
                ArrayList<Gledalac> novaLista = new ArrayList<>();
                for (Gledalac gledalac : lista) {
                    if (gledalac.getImePrezime().toLowerCase().contains(parametar.toLowerCase()))
                            {
                        novaLista.add(gledalac);
                    }
                }
                lista = novaLista;
            }

            fireTableDataChanged();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}

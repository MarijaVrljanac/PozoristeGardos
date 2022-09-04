/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.components;

import controller.ControllerClient;
import domain.Nalog;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author marij
 */
public class ModelTabeleNalog extends AbstractTableModel{
    private ArrayList<Nalog> lista;
    private String[] kolone = {"NalogID", "Korisničko ime"};
    private String parametar = "";

    public ModelTabeleNalog() {
        try {

            lista = ControllerClient.getInstance().getAllNalog();

        } catch (Exception ex) {
            Logger.getLogger(ModelTabeleNalog.class.getName()).log(Level.SEVERE, null, ex);
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
        Nalog n = lista.get(row);
        
        switch (column) {
            case 0:
                return n.getNalogID();
            case 1:
                return n.getKorisnickoIme();
            default: return "Default case";
               
        }
    }

    public Nalog getSelectedNalog(int row) {
        return lista.get(row);
    }

    public ArrayList<Nalog> getLista() {
        return lista;
    }


    public void setParametar(String parametar) {
        this.parametar = parametar;
        osveziTabelu();
    }

    public void osveziTabelu() {
        try {
            lista = ControllerClient.getInstance().getAllNalog();
            if (!parametar.equals("")) {
                ArrayList<Nalog> novaLista = new ArrayList<>();
                for (Nalog nalog : lista) {
                    if (nalog.getKorisnickoIme().toLowerCase().contains(parametar.toLowerCase()))
                            {
                        novaLista.add(nalog);
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

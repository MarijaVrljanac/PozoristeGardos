/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.components;

import controller.ControllerClient;
import domain.Karta;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author marij
 */
public class ModelTabeleRezervisaneKarte extends AbstractTableModel{
    private ArrayList<Karta> lista;
    private String[] kolone = {"Nalog", "Predstava", "KartaID", "Red", "Kolona", "Cena"};
    private String parametar = "";

    public ModelTabeleRezervisaneKarte() {
        try {

            lista = ControllerClient.getInstance().getAllKarta();

        } catch (Exception ex) {
            Logger.getLogger(ModelTabeleRezervisaneKarte.class.getName()).log(Level.SEVERE, null, ex);
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
        Karta k = lista.get(row);
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy.");
        
        switch (column) {
            case 0:
                return k.getNalog().getKorisnickoIme();
            case 1:
                return k.getPredstava().getNazivPredstave();
            case 2:
                return k.getKartaID();
            case 3:
                return k.getRed();
            case 4:
                return k.getKolona();
            case 5:
                return k.getCena();
            default: return "Default case";
               
        }
    }

    public Karta getSelectedKarta(int row) {
        return lista.get(row);
    }

    public ArrayList<Karta> getLista() {
        return lista;
    }


    public void setParametar(String parametar) {
        this.parametar = parametar;
        osveziTabelu();
    }

    public void osveziTabelu() {
        try {
            lista = ControllerClient.getInstance().getAllKarta();
            if (!parametar.equals("")) {
                ArrayList<Karta> novaLista = new ArrayList<>();
                for (Karta k : lista) {
                    if (k.getNalog().getKorisnickoIme().toLowerCase().contains(parametar.toLowerCase()))
                            {
                        novaLista.add(k);
                    }
                }
                lista = novaLista;
            }

            fireTableDataChanged();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void dodajKartu(Karta k) {
        lista.add(k);
        fireTableDataChanged();
    }

    public void otkaziKartu(int red) {
        lista.remove(red);
        fireTableDataChanged();
    }
}

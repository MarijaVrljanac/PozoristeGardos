/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.components;

import controller.ControllerClient;
import domain.Predstava;
import domain.Rezervacija;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author marij
 */
public class ModelTabeleRezervacije extends AbstractTableModel{

    ArrayList<Rezervacija> lista;
    String[] kolone = {"Predstava", "Datum i vreme", "Ime i prezime", "Broj karata"};
    int rb = 0;
    String parametar = "";

    public ModelTabeleRezervacije() {
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
        Rezervacija r = lista.get(rowIndex);
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy.");
        
        switch(columnIndex){
            case 0: return r.getPredstava();
            case 1: return sdf.format(r.getDatumIVreme());
            case 2: return r.getImePrezime();
            case 3: return r.getBrojKarata();
            default: return "Default case";
        }
    }

    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }

    public ArrayList<Rezervacija> getLista() {
        return lista;
    }

    public void obrisiRezervaciju(int red) {        
        lista.remove(red);
        fireTableDataChanged();
    }

    public Rezervacija vratiRezervaciju(int red) {
        return lista.get(red);
    }

    public void izmeniRezervaciju(int red, Rezervacija r) {
        lista.set(red, r);
        fireTableDataChanged();
    }

    public void dodajRezervaciju(Rezervacija r) {
        r.setRezervacijaID(++rb);
        lista.add(r);
        fireTableDataChanged();
    }

    public void dodajRezervacije(ArrayList<Rezervacija> rezervacije) {
        lista = rezervacije;
        fireTableDataChanged();
    }

    public void setParametar(String parametar) {
        this.parametar = parametar;
        osveziTabelu();
    }

      public boolean postoji(Rezervacija r) {
        for (Rezervacija rez : lista) {
            if (rez.getPredstava().equals(r.getPredstava())
                   && rez.getImePrezime().equals(r.getImePrezime()) && rez.getDatumIVreme().equals(r.getDatumIVreme())) {
                return true;
            }
        }
        return false;
    }
    
 
  public void osveziTabelu() {
        try {
            lista = (ArrayList<Rezervacija>) ControllerClient.getInstance().getAllRezervacije();
            if (!parametar.equals("")) {
                ArrayList<Rezervacija> novaLista = new ArrayList<>();
                for (Rezervacija rez : lista) {
                    if (rez.getPredstava().getNazivPredstave().toLowerCase().contains(parametar.toLowerCase()) ||
                             rez.getImePrezime().toLowerCase().contains(parametar.toLowerCase()))
                            {
                        novaLista.add(rez);
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author marija
 */
public class Predstava extends AbstractDomainObject{
    private int predstavaID;
    private String nazivPredstave;
    private Date datumIzvodjenja;
    private String detalji;
    private Scena scena;

    public Predstava() {
    }

    public Predstava(int predstavaID, String nazivPredstave, Date datumIzvodjenja, String detalji, Scena scena) {
        this.predstavaID = predstavaID;
        this.nazivPredstave = nazivPredstave;
        this.datumIzvodjenja = datumIzvodjenja;
        this.detalji = detalji;
        this.scena = scena;
    }

    

    public int getPredstavaID() {
        return predstavaID;
    }

    public void setPredstavaID(int predstavaID) {
        this.predstavaID = predstavaID;
    }

    public String getNazivPredstave() {
        return nazivPredstave;
    }

    public void setNazivPredstave(String nazivPredstave) {
        this.nazivPredstave = nazivPredstave;
    }

    public Date getDatumIzvodjenja() {
        return datumIzvodjenja;
    }

    public void setDatumIzvodjenja(Date datumIzvodjenja) {
        this.datumIzvodjenja = datumIzvodjenja;
    }

    public String getDetalji() {
        return detalji;
    }

    public void setDetalji(String detalji) {
        this.detalji = detalji;
    }


    public Scena getScena() {
        return scena;
    }

    public void setScena(Scena scena) {
        this.scena = scena;
    }



    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + this.predstavaID;
        hash = 29 * hash + Objects.hashCode(this.nazivPredstave);
        hash = 29 * hash + Objects.hashCode(this.datumIzvodjenja);
        hash = 29 * hash + Objects.hashCode(this.detalji);
        hash = 29 * hash + Objects.hashCode(this.scena);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Predstava other = (Predstava) obj;
        if (this.predstavaID != other.predstavaID) {
            return false;
        }
        if (!Objects.equals(this.nazivPredstave, other.nazivPredstave)) {
            return false;
        }
        if (!Objects.equals(this.detalji, other.detalji)) {
            return false;
        }
        if (!Objects.equals(this.datumIzvodjenja, other.datumIzvodjenja)) {
            return false;
        }
        if (!Objects.equals(this.scena, other.scena)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {        
        return nazivPredstave;
    }

    
    
    public String info() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy. HH:mm");
        
        return "PREDSTAVA " + " \"" + nazivPredstave + "\" \n\n" + "Datum izvodjenja: " + sdf.format(datumIzvodjenja) + "\n" + "Detalji: " + detalji + "\n" + "Scena: " + scena;
    }

    
    @Override
    public String nazivTabele() {
        return "Predstava";
    }

    @Override
    public String alijas() {
        return "p";
    }

    @Override
    public String spajanje() {
        return "JOIN Scena s on(s.ScenaID=p.ScenaID)";
    }

    @Override
    public ArrayList<AbstractDomainObject> selectLista(ResultSet rs) throws SQLException {
        ArrayList<AbstractDomainObject> lista = new ArrayList<>();
        while (rs.next()) {
            Scena s = new Scena(rs.getInt("ScenaID"), rs.getString("NazivScene"), rs.getInt("Kapacitet"));
            Predstava p = new Predstava(rs.getInt("PredstavaID"), rs.getString("NazivPredstave"), rs.getDate("DatumIzvodjenja"), rs.getString("Detalji"), s);
            lista.add(p);
        }
        rs.close();
        return lista;
    }

    @Override
    public String koloneZaInsert() {
        return "(NazivPredstave, DatumIzvodjenja, Detalji, ScenaID)";
    }

    @Override
    public String primarniKljuc() {
        return "PredstavaID= "+predstavaID;
    }

    @Override
    public String vrednostiZaInsert() {
        return "'"+nazivPredstave + "','" + new java.sql.Timestamp(datumIzvodjenja.getTime()) + "','" + detalji+"',"+scena.getScenaID();
    }

    @Override
    public String vrednostiZaUpdate() {
        return "DatumIzvodjenja= '"+new java.sql.Timestamp(datumIzvodjenja.getTime())+"'";
    }

    @Override
    public String id() {
        return "PredstavaID= "+predstavaID;
        
    }
    
    
    
}

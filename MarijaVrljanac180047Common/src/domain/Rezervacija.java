/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.Serializable;
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
public class Rezervacija extends AbstractDomainObject{
    private Predstava predstava;
    private Nalog nalog;
    private int rezervacijaID;
    private String imePrezime;
    private Date datumIVreme;
    private int brojKarata;

    public Rezervacija() {
    }

    public Rezervacija(Predstava predstava, Nalog nalog, int rezervacijaID, String imePrezime, Date datumIVreme, int brojKarata) {
        this.predstava = predstava;
        this.nalog = nalog;
        this.rezervacijaID = rezervacijaID;
        this.imePrezime = imePrezime;
        this.datumIVreme = datumIVreme;
        this.brojKarata = brojKarata;
    }

    public int getRezervacijaID() {
        return rezervacijaID;
    }

    public void setRezervacijaID(int rezervacijaID) {
        this.rezervacijaID = rezervacijaID;
    }

    public String getImePrezime() {
        return imePrezime;
    }

    public void setImePrezime(String imePrezime) {
        this.imePrezime = imePrezime;
    }

    public Date getDatumIVreme() {
        return datumIVreme;
    }

    public void setDatumIVreme(Date datumIVreme) {
        this.datumIVreme = datumIVreme;
    }

    public Predstava getPredstava() {
        return predstava;
    }

    public void setPredstava(Predstava predstava) {
        this.predstava = predstava;
    }

    public Nalog getNalog() {
        return nalog;
    }

    public void setNalog(Nalog nalog) {
        this.nalog = nalog;
    }

    public int getBrojKarata() {
        return brojKarata;
    }

    public void setBrojKarata(int brojKarata) {
        this.brojKarata = brojKarata;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 83 * hash + Objects.hashCode(this.predstava);
        hash = 83 * hash + Objects.hashCode(this.nalog);
        hash = 83 * hash + this.rezervacijaID;
        hash = 83 * hash + Objects.hashCode(this.imePrezime);
        hash = 83 * hash + Objects.hashCode(this.datumIVreme);
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
        final Rezervacija other = (Rezervacija) obj;
        if (this.rezervacijaID != other.rezervacijaID) {
            return false;
        }
        if (!Objects.equals(this.imePrezime, other.imePrezime)) {
            return false;
        }
        if (!Objects.equals(this.predstava, other.predstava)) {
            return false;
        }
        if (!Objects.equals(this.nalog, other.nalog)) {
            return false;
        }
        if (!Objects.equals(this.datumIVreme, other.datumIVreme)) {
            return false;
        }
        return true;
    }

    

    

    @Override
    public String toString() {
        return imePrezime;
    }
    
     public String info() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy. HH:mm");
        
        return "REZERVACIJA ZA PREDSTAVU: " + " \"" + predstava.getNazivPredstave() + "\" \n\n" + "Datum izvodjenja: " + sdf.format(predstava.getDatumIzvodjenja()) + "\n" + "Ime i prezime: " + imePrezime;
    }
    
    
    @Override
    public String nazivTabele() {
        return "Rezervacija";
    }

    @Override
    public String alijas() {
        return "r";
    }

    @Override
    public String spajanje() {
        return "JOIN Predstava p ON (p.PredstavaID = r.PredstavaID) "
                + "JOIN Nalog n ON (n.NalogID=r.NalogID) "
                + "JOIN Scena s ON (p.ScenaID = s.ScenaID)";

    }

    @Override
    public ArrayList<AbstractDomainObject> selectLista(ResultSet rs) throws SQLException {
        ArrayList<AbstractDomainObject> lista = new ArrayList<>();
        while (rs.next()) {
            Scena s = new Scena(rs.getInt("ScenaID"), rs.getString("NazivScene"), rs.getInt("Kapacitet"));
            Predstava p = new Predstava(rs.getInt("PredstavaID"), rs.getString("NazivPredstave"), rs.getDate("DatumIzvodjenja"), rs.getString("Detalji"), s);
            Nalog n = new Nalog(rs.getInt("NalogID"), rs.getString("EmailAdresa"), rs.getString("KorisnickoIme"), rs.getString("Sifra"));
            Rezervacija r = new Rezervacija(p, n, rs.getInt("RezervacijaID"), rs.getString("ImePrezime"), rs.getDate("DatumIVreme"), rs.getInt("BrojKarata"));
            lista.add(r);
        }
        rs.close();
        return lista;
    }

    @Override
    public String koloneZaInsert() {
        return "(PredstavaID, NalogID, RezervacijaID, ImePrezime, DatumIVreme, BrojKarata)";
    }

    @Override
    public String primarniKljuc() {
        return "RezervacijaID= "+rezervacijaID;
    }

    @Override
    public String vrednostiZaInsert() {
        return predstava.getPredstavaID()+"," +nalog.getNalogID()+"," +rezervacijaID+",'" +imePrezime + "','" + new java.sql.Date(datumIVreme.getTime())+"',"+brojKarata ;
    }

    @Override
    public String vrednostiZaUpdate() {
        return "PredstavaID= "+ predstava.getPredstavaID()+ ", NalogID= " + nalog.getNalogID() + ", RezervacijaID= " + rezervacijaID + ", ImePrezime= '" + imePrezime + ", DatumIVreme= '" + new java.sql.Date(datumIVreme.getTime()) + "', BrojKarata= "+ brojKarata;
                  
    }

    @Override
    public String id() {
        return "RezervacijaID= "+rezervacijaID;
    }
    
}

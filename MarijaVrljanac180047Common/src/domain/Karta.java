/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author marija
 */
public class Karta extends AbstractDomainObject{
    private Predstava predstava;
    private Nalog nalog;
    private int kartaID;
    private String red;
    private int kolona;
    private double cena;
    private Rezervacija rezervisana;

    public Karta() {
    }

    public Karta(Predstava predstava, Nalog nalog, int kartaID, String red, int kolona, double cena, Rezervacija rezervisana) {
        this.predstava = predstava;
        this.nalog = nalog;
        this.kartaID = kartaID;
        this.red = red;
        this.kolona = kolona;
        this.cena = cena;
        this.rezervisana = rezervisana;
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

    public int getKartaID() {
        return kartaID;
    }

    public void setKartaID(int kartaID) {
        this.kartaID = kartaID;
    }

    public String getRed() {
        return red;
    }

    public void setRed(String red) {
        this.red = red;
    }

    public int getKolona() {
        return kolona;
    }

    public void setKolona(int kolona) {
        this.kolona = kolona;
    }

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }  

    public Rezervacija getRezervisana() {
        return rezervisana;
    }

    public void setRezervisana(Rezervacija rezervisana) {
        this.rezervisana = rezervisana;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 17 * hash + Objects.hashCode(this.predstava);
        hash = 17 * hash + Objects.hashCode(this.nalog);
        hash = 17 * hash + this.kartaID;
        hash = 17 * hash + Objects.hashCode(this.red);
        hash = 17 * hash + this.kolona;
        hash = 17 * hash + (int) (Double.doubleToLongBits(this.cena) ^ (Double.doubleToLongBits(this.cena) >>> 32));
        hash = 17 * hash + Objects.hashCode(this.rezervisana);
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
        final Karta other = (Karta) obj;
        if (this.kartaID != other.kartaID) {
            return false;
        }
        if (this.kolona != other.kolona) {
            return false;
        }
        if (Double.doubleToLongBits(this.cena) != Double.doubleToLongBits(other.cena)) {
            return false;
        }
        if (!Objects.equals(this.red, other.red)) {
            return false;
        }
        if (!Objects.equals(this.predstava, other.predstava)) {
            return false;
        }
        if (!Objects.equals(this.nalog, other.nalog)) {
            return false;
        }
        if (!Objects.equals(this.rezervisana, other.rezervisana)) {
            return false;
        }
        return true;
    }

    

    @Override
    public String toString() {
        return "Karta [" + " Predstava: '" + predstava + "', na ime: " + nalog + ", red: "+red+" kolona: " + kolona + ']';
    }

    

    @Override
    public String nazivTabele() {
        return "Karta";
    }

    @Override
    public String alijas() {
        return "k";
    }

    @Override
    public String spajanje() {
        return " JOIN Predstava p ON (p.PredstavaID = k.PredstavaID) "
                + "JOIN Nalog n on (n.NalogID = k.NalogID) "
                + "JOIN Rezervacija r on (r.RezervacijaID = k.Rezervisana) "
                + "JOIN Scena s on (p.ScenaID = s.ScenaID) ";
    }

    @Override
    public ArrayList<AbstractDomainObject> selectLista(ResultSet rs) throws SQLException {
        ArrayList<AbstractDomainObject> lista = new ArrayList<>();
        while (rs.next()) {
            Scena s = new Scena(rs.getInt("ScenaID"), rs.getString("NazivScene"), rs.getInt("Kapacitet"));
            Predstava p = new Predstava(rs.getInt("PredstavaID"), rs.getString("NazivPredstave"), rs.getDate("DatumIzvodjenja"), rs.getString("Detalji"), s);
            Nalog n = new Nalog(rs.getInt("NalogID"), rs.getString("EmailAdresa"), rs.getString("KorisnickoIme"), rs.getString("Sifra"));
//            Gledalac g = new Gledalac(rs.getInt("GledalacID"), rs.getString("ImePrezime"), rs.getDate("DatumRodjenja"), rs.getString("BrojTelefona"), n);
            Rezervacija r = new Rezervacija(p, n, rs.getInt("RezervacijaID"), rs.getString("ImePrezime"), rs.getDate("DatumIVreme"), rs.getInt("BrojKarata"));
            Karta k = new Karta(p, n, rs.getInt("KartaID"), rs.getString("Red"), rs.getInt("Kolona"), rs.getDouble("Cena"), r);
            lista.add(k);
        }
        rs.close();
        return lista;
    }

    @Override
    public String koloneZaInsert() {
        return "(PredstavaID, NalogID, KartaID, Red, Kolona, Cena, Rezervisana)";
    }

    @Override
    public String primarniKljuc() {
        return "KartaID= "+kartaID;
    }

    @Override
    public String vrednostiZaInsert() {
        return predstava.getPredstavaID() + "," + nalog.getNalogID() + "," + kartaID+",'" +red+"',"+kolona+","+cena +","+rezervisana.getRezervacijaID();
    }

    @Override
    public String vrednostiZaUpdate() {
        return "";
    }

    @Override
    public String id() {
        return "KartaID= "+kartaID;
    }
    
 
    
}

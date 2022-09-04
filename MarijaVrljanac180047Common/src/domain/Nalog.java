/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author marija
 */
public class Nalog extends AbstractDomainObject{
    private int nalogID;
    private String emailAdresa;
    private String korisnickoIme;
    private String sifra;

    public Nalog() {
    }

    public Nalog(int nalogID, String emailAdresa, String korisnickoIme, String sifra) {
        this.nalogID = nalogID;
        this.emailAdresa = emailAdresa;
        this.korisnickoIme = korisnickoIme;
        this.sifra = sifra;
    }

    public int getNalogID() {
        return nalogID;
    }

    public void setNalogID(int nalogID) {
        this.nalogID = nalogID;
    }

    public String getEmailAdresa() {
        return emailAdresa;
    }

    public void setEmailAdresa(String emailAdresa) {
        this.emailAdresa = emailAdresa;
    }

    public String getKorisnickoIme() {
        return korisnickoIme;
    }

    public void setKorisnickoIme(String korisnickoIme) {
        this.korisnickoIme = korisnickoIme;
    }

    public String getSifra() {
        return sifra;
    }

    public void setSifra(String sifra) {
        this.sifra = sifra;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + this.nalogID;
        hash = 67 * hash + Objects.hashCode(this.emailAdresa);
        hash = 67 * hash + Objects.hashCode(this.korisnickoIme);
        hash = 67 * hash + Objects.hashCode(this.sifra);
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
        final Nalog other = (Nalog) obj;
        if (this.nalogID != other.nalogID) {
            return false;
        }
        if (!Objects.equals(this.emailAdresa, other.emailAdresa)) {
            return false;
        }
        if (!Objects.equals(this.korisnickoIme, other.korisnickoIme)) {
            return false;
        }
        if (!Objects.equals(this.sifra, other.sifra)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "NALOG\n\n" + "NalogID: " + nalogID + "\n" +"EmailAdresa: " + emailAdresa + "\n" +"Korisnicko ime: " + korisnickoIme;
    }


    @Override
    public String nazivTabele() {
        return "Nalog";
    }

    @Override
    public String alijas() {
        return "n";
    }

    @Override
    public String spajanje() {
        return "";
    }

    @Override
    public ArrayList<AbstractDomainObject> selectLista(ResultSet rs) throws SQLException {
        
        ArrayList<AbstractDomainObject> lista = new ArrayList<>();
        while (rs.next()) {
            Nalog n = new Nalog(rs.getInt("NalogID"), rs.getString("EmailAdresa"), rs.getString("KorisnickoIme"), rs.getString("Sifra"));
            lista.add(n);
        }
        rs.close();
        return lista;
    }

    @Override
    public String koloneZaInsert() {
        return "(EmailAdresa, KorisnickoIme, Sifra)";
    }

    @Override
    public String primarniKljuc() {
        return "NalogID= "+nalogID;
    }

    @Override
    public String vrednostiZaInsert() {
        return "'"+emailAdresa + "','" + korisnickoIme + "','" + sifra+"'";
    }

    @Override
    public String vrednostiZaUpdate() {
        return "KorisnickoIme= '" + korisnickoIme + "', Sifra= '" + sifra + "'";
    }

    @Override
    public String id() {
        return "NalogID= "+nalogID;
    }
    

    
    
    
}

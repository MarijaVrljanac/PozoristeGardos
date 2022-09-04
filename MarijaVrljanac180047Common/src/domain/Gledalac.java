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
public class Gledalac extends AbstractDomainObject{
    private int gledalacID;
    private String imePrezime;
    private Date datumRodjenja;
    private String brojTelefona;
    private Nalog nalog;

    public Gledalac() {
    }

    public Gledalac(int gledalacID, String imePrezime, Date datumRodjenja, String brojTelefona, Nalog nalog) {
        this.gledalacID = gledalacID;
        this.imePrezime = imePrezime;
        this.datumRodjenja = datumRodjenja;
        this.brojTelefona = brojTelefona;
        this.nalog = nalog;
    }

    public int getGledalacID() {
        return gledalacID;
    }

    public void setGledalacID(int gledalacID) {
        this.gledalacID = gledalacID;
    }

    public String getImePrezime() {
        return imePrezime;
    }

    public void setImePrezime(String imePrezime) {
        this.imePrezime = imePrezime;
    }

    public Date getDatumRodjenja() {
        return datumRodjenja;
    }

    public void setDatumRodjenja(Date datumRodjenja) {
        this.datumRodjenja = datumRodjenja;
    }

    public String getBrojTelefona() {
        return brojTelefona;
    }

    public void setBrojTelefona(String brojTelefona) {
        this.brojTelefona = brojTelefona;
    }

    public Nalog getNalog() {
        return nalog;
    }

    public void setNalog(Nalog nalog) {
        this.nalog = nalog;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + this.gledalacID;
        hash = 89 * hash + Objects.hashCode(this.imePrezime);
        hash = 89 * hash + Objects.hashCode(this.datumRodjenja);
        hash = 89 * hash + Objects.hashCode(this.brojTelefona);
        hash = 89 * hash + Objects.hashCode(this.nalog);
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
        final Gledalac other = (Gledalac) obj;
        if (this.gledalacID != other.gledalacID) {
            return false;
        }
        if (!Objects.equals(this.imePrezime, other.imePrezime)) {
            return false;
        }
        if (!Objects.equals(this.brojTelefona, other.brojTelefona)) {
            return false;
        }
        if (!Objects.equals(this.datumRodjenja, other.datumRodjenja)) {
            return false;
        }
        if (!Objects.equals(this.nalog, other.nalog)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return imePrezime;
    }
    
    public String info() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy.");
        
        return "GLEDALAC: " + imePrezime + " \n\n" + "Datum rođenja: " + sdf.format(datumRodjenja) + "\n" + "Broj telefona: " + brojTelefona + "\n" + "Korisničko ime: " + nalog.getKorisnickoIme();
    }

    @Override
    public String nazivTabele() {
        return "Gledalac";
    }

    @Override
    public String alijas() {
        return "g";
    }

    @Override
    public String spajanje() {
        return "JOIN nalog n on(n.nalogid=g.nalogid)";
    }

    @Override
    public ArrayList<AbstractDomainObject> selectLista(ResultSet rs) throws SQLException {
        ArrayList<AbstractDomainObject> lista = new ArrayList<>();
        while (rs.next()) {
            Nalog n = new Nalog(rs.getInt("NalogID"), rs.getString("EmailAdresa"), rs.getString("KorisnickoIme"), rs.getString("Sifra"));
            Gledalac g = new Gledalac(rs.getInt("GledalacID"), rs.getString("ImePrezime"), rs.getDate("DatumRodjenja"), rs.getString("BrojTelefona"), n);
            lista.add(g);
        }
        rs.close();
        return lista;
    }

    @Override
    public String koloneZaInsert() {
        return "(GledalacID, ImePrezime, DatumRodjenja, BrojTelefona, NalogID)";
    }

    @Override
    public String primarniKljuc() {
        return "GledalacID= "+gledalacID;
    }

    @Override
    public String vrednostiZaInsert() {
        return gledalacID+",'"+imePrezime + "','" + new java.sql.Date(datumRodjenja.getTime()) + "','" + brojTelefona+"',"+nalog.getNalogID();
    }

    @Override
    public String vrednostiZaUpdate() {
        return "BrojTelefona= '" + brojTelefona + "'";
    }

    @Override
    public String id() {
        return "GledalacID= "+gledalacID;
    }
    
    
}

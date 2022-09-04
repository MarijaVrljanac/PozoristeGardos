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
public class Racun extends AbstractDomainObject{
    private Predstava predstava;
    private Nalog nalog;
    private int racunID;
    private Date datumIVreme;
    private double iznos;
    private String ziroRacun;
    private Karta karta;

    public Racun() {
    }

    public Racun(Predstava predstava, Nalog nalog, int racunID, Date datumIVreme, double iznos, String ziroRacun, Karta karta) {
        this.predstava = predstava;
        this.nalog = nalog;
        this.racunID = racunID;
        this.datumIVreme = datumIVreme;
        this.iznos = iznos;
        this.ziroRacun = ziroRacun;
        this.karta = karta;
    }

  

   

    

    public int getRacunID() {
        return racunID;
    }

    public void setRacunID(int racunID) {
        this.racunID = racunID;
    }

    public Date getDatumIVreme() {
        return datumIVreme;
    }

    public void setDatumIVreme(Date datumIVreme) {
        this.datumIVreme = datumIVreme;
    }

    public double getIznos() {
        return iznos;
    }

    public void setIznos(double iznos) {
        this.iznos = iznos;
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

   

    public String getZiroRacun() {
        return ziroRacun;
    }

    public void setZiroRacun(String ziroRacun) {
        this.ziroRacun = ziroRacun;
    }

    public Karta getKarta() {
        return karta;
    }

    public void setKarta(Karta karta) {
        this.karta = karta;
    }
    
    

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.predstava);

        hash = 97 * hash + this.racunID;
        hash = 97 * hash + Objects.hashCode(this.datumIVreme);
        hash = 97 * hash + (int) (Double.doubleToLongBits(this.iznos) ^ (Double.doubleToLongBits(this.iznos) >>> 32));
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
        final Racun other = (Racun) obj;
        if (this.racunID != other.racunID) {
            return false;
        }
        if (Double.doubleToLongBits(this.iznos) != Double.doubleToLongBits(other.iznos)) {
            return false;
        }
        if (!Objects.equals(this.predstava, other.predstava)) {
            return false;
        }
      
        if (!Objects.equals(this.datumIVreme, other.datumIVreme)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy. HH:mm");
        return "Hvala na poverenju! \n\n"+"RACUN"+"\n" + "Predstava: " + predstava + "\n"+"Datum i vreme: " + sdf.format(predstava.getDatumIzvodjenja()) +"\n"+ "Iznos: " + iznos;
    }


    
    @Override
    public String nazivTabele() {
        return "Racun";
    }

    @Override
    public String alijas() {
        return "rac";
    }

    @Override
    public String spajanje() {
        return "JOIN Predstava p on (p.predstavaid=rac.predstavaid) "
                + "JOIN Nalog n on (n.NalogID=rac.NalogID) "
                + "JOIN Karta k on (k.KartaID = rac.KartaID) "
                + "JOIN Scena s on (s.ScenaID = p.ScenaID) "
                + "JOIN Rezervacija r on (r.RezervacijaID = k.Rezervisana)";
    }

    @Override
    public ArrayList<AbstractDomainObject> selectLista(ResultSet rs) throws SQLException {
        ArrayList<AbstractDomainObject> lista = new ArrayList<>();
        while (rs.next()) {
            Scena s = new Scena(rs.getInt("ScenaID"), rs.getString("NazivScene"), rs.getInt("Kapacitet"));
            Predstava p = new Predstava(rs.getInt("PredstavaID"), rs.getString("NazivPredstave"), rs.getDate("DatumIzvodjenja"), rs.getString("Detalji"), s);
            Nalog n = new Nalog(rs.getInt("NalogID"), rs.getString("EmailAdresa"), rs.getString("KorisnickoIme"), rs.getString("Sifra"));
            Rezervacija r = new Rezervacija(p, n, rs.getInt("RezervacijaID"), rs.getString("ImePrezime"), rs.getDate("DatumIVreme"), rs.getInt("BrojKarata"));
//            Gledalac g = new Gledalac(rs.getInt("GledalacID"), rs.getString("ImePrezime"), rs.getDate("DatumRodjenja"), rs.getString("BrojTelefona"), n);
            Karta k = new Karta(p, n, rs.getInt("KartaID"), rs.getString("Red"), rs.getInt("Kolona"), rs.getDouble("Cena"), r);
            Racun rac = new Racun(p, n, rs.getInt("RacunID"), rs.getDate("DatumIVreme"), rs.getDouble("Iznos"), rs.getString("ZiroRacun"), k);
            lista.add(rac);
        }
        rs.close();
        return lista;
    }

    @Override
    public String koloneZaInsert() {
        return "(PredstavaID, NalogID, RacunID, DatumIVreme, Iznos, ZiroRacun, KartaID)";
    }

    @Override
    public String primarniKljuc() {
        return "RacunID= "+racunID;
    }

    @Override
    public String vrednostiZaInsert() {
        return predstava.getPredstavaID() + "," + nalog.getNalogID() + "," + racunID+",'" +new java.sql.Date(datumIVreme.getTime())+"',"+iznos+",'"+ziroRacun +"',"+karta.getKartaID();
    }

    @Override
    public String vrednostiZaUpdate() {
        return "";
    }

    @Override
    public String id() {
        return "RacunID= "+racunID;
    }
    
    
    
            
}

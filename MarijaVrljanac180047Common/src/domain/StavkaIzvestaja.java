/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author marija
 */
public class StavkaIzvestaja implements Serializable{
    private String nazivPredstave;
    private String scena;
    private Date datumIzvodjenja;
    private int ukupnoKarata;
    private int rezervisanoKarata;

    public StavkaIzvestaja() {
    }

    public StavkaIzvestaja(String nazivPredstave, String scena, Date datumIzvodjenja, int ukupnoKarata, int rezervisanoKarata) {
        this.nazivPredstave = nazivPredstave;
        this.scena = scena;
        this.datumIzvodjenja = datumIzvodjenja;
        this.ukupnoKarata = ukupnoKarata;
        this.rezervisanoKarata = rezervisanoKarata;
    }

    public String getNazivPredstave() {
        return nazivPredstave;
    }

    public void setNazivPredstave(String nazivPredstave) {
        this.nazivPredstave = nazivPredstave;
    }

    public String getScena() {
        return scena;
    }

    public void setScena(String scena) {
        this.scena = scena;
    }

    public int getUkupnoKarata() {
        return ukupnoKarata;
    }

    public void setUkupnoKarata(int ukupnoKarata) {
        this.ukupnoKarata = ukupnoKarata;
    }

    public int getRezervisanoKarata() {
        return rezervisanoKarata;
    }

    public void setRezervisanoKarata(int rezervisanoKarata) {
        this.rezervisanoKarata = rezervisanoKarata;
    }

    public Date getDatumIzvodjenja() {
        return datumIzvodjenja;
    }

    public void setDatumIzvodjenja(Date datumIzvodjenja) {
        this.datumIzvodjenja = datumIzvodjenja;
    }
    
    
    
    
}

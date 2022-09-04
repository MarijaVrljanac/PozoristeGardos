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
public class Scena extends AbstractDomainObject{
    private int scenaID;
    private String nazivScene;
    private int kapacitet;

    public Scena() {
    }

    public Scena(int scenaID, String nazivScene, int kapacitet) {
        this.scenaID = scenaID;
        this.nazivScene = nazivScene;
        this.kapacitet = kapacitet;
    }

    public int getScenaID() {
        return scenaID;
    }

    public void setScenaID(int scenaID) {
        this.scenaID = scenaID;
    }

    public String getNazivScene() {
        return nazivScene;
    }

    public void setNazivScene(String nazivScene) {
        this.nazivScene = nazivScene;
    }

    public int getKapacitet() {
        return kapacitet;
    }

    public void setKapacitet(int kapacitet) {
        this.kapacitet = kapacitet;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 23 * hash + this.scenaID;
        hash = 23 * hash + Objects.hashCode(this.nazivScene);
        hash = 23 * hash + this.kapacitet;
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
        final Scena other = (Scena) obj;
        if (this.scenaID != other.scenaID) {
            return false;
        }
        if (this.kapacitet != other.kapacitet) {
            return false;
        }
        if (!Objects.equals(this.nazivScene, other.nazivScene)) {
            return false;
        }
        return true;
    }      

    @Override
    public String toString() {
        return nazivScene;
    }
    
    
    @Override
    public String nazivTabele() {
        return "Scena";
    }

    @Override
    public String alijas() {
        return "s";
    }

    @Override
    public String spajanje() {
        return "";
    }

    @Override
    public ArrayList<AbstractDomainObject> selectLista(ResultSet rs) throws SQLException {
        ArrayList<AbstractDomainObject> lista = new ArrayList<>();
        while (rs.next()) {
            Scena s = new Scena(rs.getInt("ScenaID"), rs.getString("NazivScene"), rs.getInt("Kapacitet"));
            lista.add(s);
        }
        rs.close();
        return lista;
    }

    @Override
    public String koloneZaInsert() {
        return "(NazivScene, Kapacitet)";
    }

    @Override
    public String primarniKljuc() {
        return "ScenaID= "+scenaID;
    }

    @Override
    public String vrednostiZaInsert() {
        return "'"+nazivScene + "','" + kapacitet + "'";
    }

    @Override
    public String vrednostiZaUpdate() {
        return "NazivScene= '" + nazivScene + "', Kapacitet= '" + kapacitet + "'";
    }

    @Override
    public String id() {
        return "ScenaID= "+scenaID;
    }
    
}

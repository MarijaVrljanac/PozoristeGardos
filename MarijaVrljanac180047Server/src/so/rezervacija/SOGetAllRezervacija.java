/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.rezervacija;

import db.DBBroker;
import domain.AbstractDomainObject;
import domain.Rezervacija;
import java.sql.SQLException;
import java.util.ArrayList;
import so.AbstractSO;

/**
 *
 * @author marij
 */
public class SOGetAllRezervacija extends AbstractSO{
     private ArrayList<Rezervacija> lista;

    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if (!(ado instanceof Rezervacija)) {
            throw new Exception("Nevalidan objekat");
        }
    }

    @Override
    protected void execute(AbstractDomainObject ado) throws SQLException {

        ArrayList<AbstractDomainObject> rezervacije = DBBroker.getInstance().selectBezUslova(ado);
        lista = (ArrayList<Rezervacija>) (ArrayList<?>) rezervacije;  

    }

    public ArrayList<Rezervacija> getLista() {
        return lista;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.rezervacija;

import db.DBBroker;
import domain.AbstractDomainObject;
import domain.Rezervacija;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import so.AbstractSO;

/**
 *
 * @author marij
 */
public class SOAddRezervacija extends AbstractSO{
     private boolean uspesno;

    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if (!(ado instanceof Rezervacija)) {
            uspesno = false;
            throw new Exception("Nevalidan objekat!");
        }
        Rezervacija r = (Rezervacija) ado;

        ArrayList<AbstractDomainObject> rezervacije = DBBroker.getInstance().selectBezUslova(ado);

        ArrayList<Rezervacija> lista = (ArrayList<Rezervacija>) (ArrayList<?>) rezervacije;

        for (Rezervacija rezervacija : lista) {

            if (rezervacija.getImePrezime().equals(r.getImePrezime()) && rezervacija.getPredstava().equals(r.getPredstava()) && rezervacija.getDatumIVreme().equals(r.getDatumIVreme())) {
                uspesno=false;
                throw new Exception("Već postoji navedena rezervacija!");
            }
        }

    }

    @Override
    protected void execute(AbstractDomainObject ado) throws SQLException {

        DBBroker.getInstance().insert(ado);
        uspesno = true;

    }

    public boolean isUspesno() {
        return uspesno;
    }
    

   
}

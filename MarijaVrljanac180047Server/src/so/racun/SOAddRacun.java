/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.racun;

import db.DBBroker;
import domain.AbstractDomainObject;
import domain.Racun;
import java.sql.SQLException;
import java.util.ArrayList;
import so.AbstractSO;

/**
 *
 * @author marij
 */
public class SOAddRacun extends AbstractSO{
     private boolean uspesno;

    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if (!(ado instanceof Racun)) {
            uspesno = false;
            throw new Exception("Nevalidan objekat!");
        }
        Racun r = (Racun) ado;

        ArrayList<AbstractDomainObject> racuni = DBBroker.getInstance().selectBezUslova(ado);

        ArrayList<Racun> lista = (ArrayList<Racun>) (ArrayList<?>) racuni;

        for (Racun racun : lista) {
             if (racun.getKarta().getKartaID() == r.getKarta().getKartaID()) {
                uspesno=false;
                throw new Exception("Greška... Navedena karta nije dostupna.");
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

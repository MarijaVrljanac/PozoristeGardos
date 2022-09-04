/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.karta;

import db.DBBroker;
import domain.AbstractDomainObject;
import domain.Karta;
import java.sql.SQLException;
import java.util.ArrayList;
import so.AbstractSO;

/**
 *
 * @author marij
 */
public class SOAddKarta extends AbstractSO{
     private boolean uspesno;

    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if (!(ado instanceof Karta)) {
            uspesno = false;
            throw new Exception("Nevalidan objekat!");
        }
        Karta k = (Karta) ado;

        ArrayList<AbstractDomainObject> karte = DBBroker.getInstance().selectBezUslova(ado);

        ArrayList<Karta> lista = (ArrayList<Karta>) (ArrayList<?>) karte;

        for (Karta karta : lista) {
            if (karta.getKartaID() == k.getKartaID()) {
                uspesno=false;
                throw new Exception("Već postoji predstava sa istim nazivom!");
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

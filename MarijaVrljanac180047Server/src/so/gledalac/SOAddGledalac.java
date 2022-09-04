/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.gledalac;

import db.DBBroker;
import domain.AbstractDomainObject;
import domain.Gledalac;
import java.sql.SQLException;
import java.util.ArrayList;
import so.AbstractSO;

/**
 *
 * @author marij
 */
public class SOAddGledalac extends AbstractSO{
    
    private boolean uspesno;

    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if (!(ado instanceof Gledalac)) {
            uspesno = false;
            throw new Exception("Nevalidan objekat!");
        }
        Gledalac  g = (Gledalac ) ado;

        ArrayList<AbstractDomainObject> clanovi = DBBroker.getInstance().selectBezUslova(ado);

        ArrayList<Gledalac > lista = (ArrayList<Gledalac >) (ArrayList<?>) clanovi;

        for (Gledalac  gledalac : lista) {
            if (gledalac.getBrojTelefona().equals(g.getBrojTelefona())) {
                uspesno=false;
                throw new Exception("Već postoji član sa navedenim brojem telefona!");
            }
        }

    }

    @Override
    protected void execute(AbstractDomainObject ado) throws SQLException {

        DBBroker.getInstance().insertReg(ado);
        uspesno = true;

    }

    public boolean isUspesno() {
        return uspesno;
    }
    
}

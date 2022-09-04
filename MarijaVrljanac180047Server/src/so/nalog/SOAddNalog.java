/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.nalog;

import db.DBBroker;
import domain.AbstractDomainObject;
import domain.Nalog;
import java.sql.SQLException;
import java.util.ArrayList;
import so.AbstractSO;

/**
 *
 * @author marij
 */
public class SOAddNalog extends AbstractSO{
    
    private boolean uspesno;

    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if (!(ado instanceof Nalog)) {
            uspesno = false;
            throw new Exception("Nevalidan objekat!");
        }
        Nalog n = (Nalog) ado;

        ArrayList<AbstractDomainObject> clanovi = DBBroker.getInstance().selectBezUslova(ado);

        ArrayList<Nalog> lista = (ArrayList<Nalog>) (ArrayList<?>) clanovi;

        for (Nalog nalog : lista) {
            if (nalog.getEmailAdresa().equals(n.getEmailAdresa())) {
                uspesno=false;
                throw new Exception("Već postoji nalog sa navedenom email adresom!");
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

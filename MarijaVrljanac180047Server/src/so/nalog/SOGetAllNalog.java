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
public class SOGetAllNalog extends AbstractSO{

    private ArrayList<Nalog> lista;

    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if (!(ado instanceof Nalog)) {
            throw new Exception("Nevalidan objekat");
        }
    }

    @Override
    protected void execute(AbstractDomainObject ado) throws SQLException {

        ArrayList<AbstractDomainObject> nalog = DBBroker.getInstance().selectBezUslova(ado);
        lista = (ArrayList<Nalog>) (ArrayList<?>) nalog;  

    }

    public ArrayList<Nalog> getLista() {
        return lista;
    }
    
}

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
public class SOGetAllKarta extends AbstractSO{
     private ArrayList<Karta> lista;

    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if (!(ado instanceof Karta)) {
            throw new Exception("Nevalidan objekat");
        }
    }

    @Override
    protected void execute(AbstractDomainObject ado) throws SQLException {

        ArrayList<AbstractDomainObject> karte = DBBroker.getInstance().selectBezUslova(ado);
        lista = (ArrayList<Karta>) (ArrayList<?>) karte;  

    }

    public ArrayList<Karta> getLista() {
        return lista;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.scena;

import db.DBBroker;
import domain.AbstractDomainObject;
import domain.Scena;
import java.sql.SQLException;
import java.util.ArrayList;
import so.AbstractSO;

/**
 *
 * @author marij
 */
public class SOGetAllScena extends AbstractSO{
     private ArrayList<Scena> lista;

    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if (!(ado instanceof Scena)) {
            throw new Exception("Nevalidan objekat");
        }
    }

    @Override
    protected void execute(AbstractDomainObject ado) throws SQLException {

        ArrayList<AbstractDomainObject> scene = DBBroker.getInstance().selectBezUslova(ado);
        lista = (ArrayList<Scena>) (ArrayList<?>) scene;  

    }

    public ArrayList<Scena> getLista() {
        return lista;
    }
}

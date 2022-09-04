/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.predstava;

import db.DBBroker;
import domain.AbstractDomainObject;
import domain.Predstava;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import so.AbstractSO;

/**
 *
 * @author marij
 */
public class SOGetDatumiZaPredstava extends AbstractSO{
    private ArrayList<Date> lista;

    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if (!(ado instanceof Predstava)) {
            throw new Exception("Nevalidan objekat");
        }
    }

    @Override
    protected void execute(AbstractDomainObject ado) throws SQLException {

        ArrayList<Timestamp> datumi = DBBroker.getInstance().vratiDatumIVreme((Predstava) ado);
        lista = (ArrayList<Date>) (ArrayList<?>) datumi;  

    }

    public ArrayList<Date> getLista() {
        return lista;
    }
}

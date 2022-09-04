/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.karta;

import java.sql.SQLException;
import so.AbstractSO;
import db.DBBroker;
import domain.AbstractDomainObject;
import domain.Karta;
import java.sql.SQLException;
import so.AbstractSO;

/**
 *
 * @author marij
 */
public class SODeleteKarta extends AbstractSO{
    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if(!(ado instanceof Karta)){
            throw new Exception("Nevalidan objekat!");
        }
    }

    @Override
    protected void execute(AbstractDomainObject ado) throws SQLException {
        DBBroker.getInstance().delete(ado);
    }
}

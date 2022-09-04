/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.rezervacija;

import db.DBBroker;
import domain.AbstractDomainObject;
import domain.Rezervacija;
import java.sql.SQLException;
import so.AbstractSO;

/**
 *
 * @author marij
 */
public class SOUpdateRezervacija extends AbstractSO{
    
    boolean uspesno;
    
     @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if(!(ado instanceof Rezervacija)){
            throw new Exception("Nevalidan objekat!");
        }
    }

    @Override
    protected void execute(AbstractDomainObject ado) throws SQLException {
        boolean odgovor = DBBroker.getInstance().izmeniRezervaciju((Rezervacija) ado);
        uspesno = odgovor;
    }

    public boolean isUspesno() {
        return uspesno;
    }
    
    
}

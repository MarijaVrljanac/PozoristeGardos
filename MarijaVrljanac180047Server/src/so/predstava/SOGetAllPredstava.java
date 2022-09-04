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
import java.util.ArrayList;
import so.AbstractSO;

/**
 *
 * @author marij
 */
public class SOGetAllPredstava extends AbstractSO{
     private ArrayList<Predstava> lista;

    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if (!(ado instanceof Predstava)) {
            throw new Exception("Nevalidan objekat");
        }
    }

    @Override
    protected void execute(AbstractDomainObject ado) throws SQLException {

        ArrayList<AbstractDomainObject> predstave = DBBroker.getInstance().selectBezUslova(ado);
        lista = (ArrayList<Predstava>) (ArrayList<?>) predstave;  

    }

    public ArrayList<Predstava> getLista() {
        return lista;
    }
}

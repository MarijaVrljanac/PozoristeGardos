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
public class SOAddPredstava extends AbstractSO{
    private boolean uspesno;

    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if (!(ado instanceof Predstava)) {
            uspesno = false;
            throw new Exception("Nevalidan objekat!");
        }
        Predstava p = (Predstava) ado;

        ArrayList<AbstractDomainObject> predstave = DBBroker.getInstance().selectBezUslova(ado);

        ArrayList<Predstava> lista = (ArrayList<Predstava>) (ArrayList<?>) predstave;

        for (Predstava predstava : lista) {
            if (predstava.getNazivPredstave().equals(p.getNazivPredstave())) {
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

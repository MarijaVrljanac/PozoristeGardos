/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import communication.Request;
import communication.Response;
import communication.ResponseType;
import domain.Gledalac;
import domain.Nalog;
import domain.Predstava;
import domain.Scena;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import operations.Operations;
import communication.Communication;
import domain.Karta;
import domain.Racun;
import domain.Rezervacija;




/**
 *
 * @author marija
 */
public class ControllerClient {
 private static ControllerClient instance;

    public ControllerClient() {
    }

    public static ControllerClient getInstance() {
        if (instance == null) {
            instance = new ControllerClient();
        }
        return instance;
    }
    
     private Object sendRequest(int operation, Object data) throws Exception {
        Request req = new Request(operation, data);
        ObjectOutputStream out = new ObjectOutputStream(Communication.getInstance().getSocket().getOutputStream());
        out.writeObject(req);
        ObjectInputStream in = new ObjectInputStream(Communication.getInstance().getSocket().getInputStream());
        Response res = (Response) in.readObject();
        if (res.getResponseType().equals(ResponseType.ERROR)) {
            throw res.getException();
        } else {
            return res.getResult();
        }
    }
    

    public Nalog login(Nalog n) throws Exception {
        return (Nalog) sendRequest(Operations.LOGIN, n);
    }
    
    public boolean register(Nalog n) throws Exception{
        return (boolean) sendRequest(Operations.REGISTER, n);
    }
    
    public boolean loyalty(Gledalac g) throws Exception{
        return (boolean) sendRequest(Operations.LOYALTY_KLUB, g);
    }
    
    public int vratiGledalacID() throws Exception{
        return (int) sendRequest(Operations.VRATI_GLEDALAC_ID, null);
    }
    
    public boolean addPredstava(Predstava p) throws Exception{
        return (boolean) sendRequest(Operations.SACUVAJ_PREDSTAVU, p);
    }

    public boolean updateRezervacija(Rezervacija r) throws Exception{
        return (boolean) sendRequest(Operations.IZMENI_REZERVACIJU, r);
    }    
   
    public ArrayList<Gledalac> getAllGledalac() throws Exception {
        return (ArrayList<Gledalac>) sendRequest(Operations.VRATI_SVE_CLANOVE, null);
    }
    
    public ArrayList<Predstava> getAllPredstave() throws Exception {
        return (ArrayList<Predstava>) sendRequest(Operations.VRATI_SVE_PREDSTAVE, null);
    }

    public List<Scena> getAllScene() throws Exception {
        return (ArrayList<Scena>) sendRequest(Operations.VRATI_SCENE, null);
    }

    public List<Predstava> getPredstave(Scena scena) throws Exception {
        return (ArrayList<Predstava>) sendRequest(Operations.VRATI_PREDSTAVE, scena);
    }
    public List<Date> getAllDatumi(Predstava p) throws Exception {
        return (ArrayList<Date>) sendRequest(Operations.VRATI_DATUM_I_VREME, p);
    }
    
    public boolean sacuvajRezervacije(Predstava p) throws Exception {
        return (boolean) sendRequest(Operations.SACUVAJ_REZERVACIJE, p);
    }

    public void updateNalog(Nalog n) throws Exception {
        sendRequest(Operations.UPDATE_PODACI_NALOGA, n);
    }

    public void deleteNalog(Nalog n) throws Exception {
        sendRequest(Operations.BRISANJE_NALOGA, n);
    }

    public void updateGledalac(Gledalac g) throws Exception {
        sendRequest(Operations.UPDATE_PODACI_CLANA, g);
    }

    public void deleteGledalac(Gledalac g) throws Exception {
        sendRequest(Operations.BRISANJE_CLANSTVA, g);
    }

    public ArrayList<Nalog> getAllNalog() throws Exception {
        return (ArrayList<Nalog>) sendRequest(Operations.VRATI_SVE_NALOGE, null);
    }

    public List<Rezervacija> getAllRezervacije() throws Exception {
        return (ArrayList<Rezervacija>) sendRequest(Operations.VRATI_SVE_REZERVACIJE, null);
    }
    
    public boolean updateRezervacije(List<Rezervacija> rez) throws Exception {
        return (boolean) sendRequest(Operations.UPDATE_REZERVACIJE, null);
    }

    public boolean sacuvajRacun(Racun r) throws Exception {
        return (boolean) sendRequest(Operations.SACUVAJ_RACUN, r);
    }
    
    public int vratiRacunID() throws Exception{
        return (int) sendRequest(Operations.VRATI_RACUN_ID, null);
    }

    public boolean proveriDostupnostKarte(Karta k) throws Exception {
        return (boolean) sendRequest(Operations.PROVERI_DOSTUPNOST_KARTE, k);
    }

    public void sacuvajKartu(Karta k) throws Exception {
        sendRequest(Operations.SACUVAJ_KARTU, k);
    }
    
    public int vratiKartaID() throws Exception{
        return (int) sendRequest(Operations.VRATI_KARTA_ID, null);
    }
    
    
    public boolean updatePredstava(Predstava p) throws Exception{
        return (boolean) sendRequest(Operations.UPDATE_PREDSTAVA, p);
    }

    public boolean addRezervacija(Rezervacija rezervacija) throws Exception {
        return (boolean) sendRequest(Operations.UPDATE_REZERVACIJE, rezervacija);
    }

    public ArrayList<Karta> getAllKarta() throws Exception {
        return (ArrayList<Karta>) sendRequest(Operations.VRATI_REZERVISANE_KARTE, null);
    }

    public void deleteKarta(Karta k) throws Exception {
        sendRequest(Operations.DELETE_KARTA, k);
    }

    
}

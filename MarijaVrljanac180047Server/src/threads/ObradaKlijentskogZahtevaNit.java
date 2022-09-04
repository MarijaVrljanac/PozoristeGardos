/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threads;

import communication.Request;
import communication.Response;
import communication.ResponseType;
import controller.Controller;
import domain.Gledalac;
import domain.Karta;
import domain.Nalog;
import domain.Predstava;
import domain.Racun;
import domain.Rezervacija;
import domain.Scena;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Date;
import operations.Operations;




/**
 *
 * @author marij
 */
public class ObradaKlijentskogZahtevaNit extends Thread{

   private Socket socket;

    ObradaKlijentskogZahtevaNit(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            while (!isInterrupted()) {
                ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
                Request req = (Request) in.readObject();
                Response res = handleRequest(req);
                ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
                out.writeObject(res);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Response handleRequest(Request req) throws Exception {
        Response res = new Response(ResponseType.SUCCESS, null, null);

        try {
            switch (req.getOperation()) {

                case Operations.LOGIN:
                    Nalog n = (Nalog) req.getArgument();
                    ArrayList<Nalog> nalozi = Controller.getInstance().getAllNalog();
                    System.out.println(nalozi.get(0).getKorisnickoIme());
                    for (Nalog nalog : nalozi) {
                        if (nalog.getKorisnickoIme().equals(n.getKorisnickoIme())
                                && nalog.getSifra().equals(n.getSifra())) {
                            res.setResult(nalog);
                        }
                    }
                    if (res.getResult()== null) {
                        throw new Exception("Pogresno korisnicko ime ili lozinka!");
                    } else {
                        break;
                    }
                case Operations.REGISTER:
                    Nalog nal = (Nalog) req.getArgument();
                    boolean uspesno1 = Controller.getInstance().addNalog(nal);
                    res.setResult(uspesno1);
                    break;
                case Operations.VRATI_GLEDALAC_ID:
                    ArrayList<Gledalac> gled = Controller.getInstance().getAllGledalac();
                    if (gled.size() < 1) {
                        int sifra = 1;
                        res.setResult(sifra);
                        break;
                    } else {
                        int sifra = gled.get(0).getGledalacID();
                        for (Gledalac gledalac : gled) {
                            if (gledalac.getGledalacID()> sifra) {
                                sifra = gledalac.getGledalacID();
                            }
                        }
                        System.out.println(sifra);
                        res.setResult(++sifra);
                        break;
                    }
                case Operations.LOYALTY_KLUB:
                    Gledalac g = (Gledalac) req.getArgument();
                    boolean uspesno2 = Controller.getInstance().addGledalac(g);
                    res.setResult(uspesno2);
                    break;                
                case Operations.VRATI_SCENE:
                    ArrayList<Scena> scene = Controller.getInstance().getAllScena();
                    res.setResult(scene); 
                    break;
                case Operations.VRATI_PREDSTAVE:
                    Scena s = (Scena) req.getArgument();
                    ArrayList<Predstava> predstaveNaSceni = Controller.getInstance().getPredstava(s);
                    res.setResult(predstaveNaSceni); 
                    break;
                case Operations.VRATI_DATUM_I_VREME:
                    Predstava pred = (Predstava) req.getArgument();
                    ArrayList<Date> datumi = Controller.getInstance().getDatumi(pred);
                    res.setResult(datumi); 
                    break;
                case Operations.VRATI_SVE_PREDSTAVE:
                    ArrayList<Predstava> predstave = Controller.getInstance().getAllPredstava();
                    res.setResult(predstave); 
                    break;
                case Operations.VRATI_SVE_CLANOVE:
                    ArrayList<Gledalac> gledaoci = Controller.getInstance().getAllGledalac();
                    res.setResult(gledaoci);
                    break;               
                case Operations.IZMENI_REZERVACIJU:
                    Rezervacija r = (Rezervacija) req.getArgument();
                    boolean uspesno4 = Controller.getInstance().updateRezervacija(r);
                    res.setResult(uspesno4);
                    break;
                case Operations.SACUVAJ_PREDSTAVU:
                    Predstava p = (Predstava) req.getArgument();
                    boolean uspesno3 = Controller.getInstance().addPredstava(p);
                    res.setResult(uspesno3);
                    break;

                case Operations.UPDATE_PODACI_NALOGA:
                    Nalog nalog = (Nalog) req.getArgument();
                    Controller.getInstance().updateNalog(nalog);
                    break;
                case Operations.BRISANJE_NALOGA:
                    Nalog nalo=(Nalog) req.getArgument();
                    Controller.getInstance().deleteNalog(nalo);
                    break;
                case Operations.UPDATE_PODACI_CLANA:
                    Gledalac gle = (Gledalac) req.getArgument();
                    Controller.getInstance().updateGledalac(gle);
                    break;
                case Operations.BRISANJE_CLANSTVA:
                    Gledalac gl = (Gledalac) req.getArgument();
                    Controller.getInstance().deleteGledalac(gl);
                    break;
                case Operations.VRATI_SVE_NALOGE:
                    ArrayList<Nalog> nalogs = Controller.getInstance().getAllNalog();
                    res.setResult(nalogs);
                    break;
                case Operations.VRATI_SVE_REZERVACIJE:
                    ArrayList<Rezervacija> rezervacije = Controller.getInstance().getAllRezervacija();
                    res.setResult(rezervacije); 
                    break;
                case Operations.UPDATE_REZERVACIJE:         
                    Rezervacija rezerve = (Rezervacija) req.getArgument();
                    boolean rsrv = Controller.getInstance().addRezervacija(rezerve);
                    res.setResult(rsrv);
                    break;
                case Operations.UPDATE_PREDSTAVA:
                    Predstava pre = (Predstava) req.getArgument();
                    Controller.getInstance().updatePredstava(pre);
                    break;
                case Operations.SACUVAJ_RACUN:
                    Racun racun = (Racun) req.getArgument();
                    boolean uspesno7 = Controller.getInstance().addRacun(racun);
                    res.setResult(uspesno7);
                    break;               
                case Operations.VRATI_RACUN_ID:
                    ArrayList<Racun> racuni = Controller.getInstance().getAllRacun();
                    if (racuni.size() < 1) {
                        int sifra = 1;
                        res.setResult(sifra);
                        break;
                    } else {
                        int sifra = racuni.get(0).getRacunID();
                        for (Racun racun1 : racuni) {
                             if (racun1.getRacunID()> sifra) {
                                sifra = racun1.getRacunID();
                            }
                        }

                        System.out.println(sifra);
                        res.setResult(++sifra);
                        break;
                    }
                case Operations.SACUVAJ_KARTU:
                    Karta karta=(Karta) req.getArgument();
                    Controller.getInstance().addKarta(karta);
                    break;
                case Operations.VRATI_KARTA_ID:
                    ArrayList<Karta> karts = Controller.getInstance().getAllKarta();
                    if (karts.size() < 1) {
                        int sifra = 1;
                        res.setResult(sifra);
                        break;
                    } else {
                        int sifra = karts.get(0).getKartaID();
                        for (Karta kart : karts) {
                            if (kart.getKartaID()> sifra) {
                                sifra = kart.getKartaID();
                            }
                        }

                        System.out.println(sifra);
                        res.setResult(++sifra);
                        break;
                    }
                case Operations.PROVERI_DOSTUPNOST_KARTE:
                    Karta kar = (Karta) req.getArgument();
                    ArrayList<Karta> ka = Controller.getInstance().getAllKarta();
                    if (ka.size() < 1) {
                        boolean dostupno = true;
                        res.setResult(dostupno);
                        break;
                    } else {

                        for (Karta karta1 : ka) {
                            if(karta1.getKartaID() == kar.getKartaID()){
                                boolean dostupno = false;
                                res.setResult(dostupno);
                                break;
                            }
                        }
                        res.setResult(true);
                        break;
                    }
                case Operations.VRATI_REZERVISANE_KARTE:
                    ArrayList<Karta> karte = Controller.getInstance().getAllKarta();
                    res.setResult(karte); 
                    break;
                case Operations.DELETE_KARTA:
                    Karta krt =(Karta) req.getArgument();
                    Controller.getInstance().deleteKarta(krt);
                    break;
                default:
                    return null;
            }
        } catch (Exception e) {
            res.setException(e);
            res.setResponseType(ResponseType.ERROR);
        }
        return res;
    }
    
}

    
    


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;


import domain.Gledalac;
import domain.Karta;
import domain.Nalog;
import domain.Predstava;
import domain.Racun;
import domain.Rezervacija;
import domain.Scena;
import java.util.ArrayList;
import java.util.Date;
import so.AbstractSO;
import so.gledalac.SOAddGledalac;
import so.gledalac.SODeleteGledalac;
import so.gledalac.SOGetAllGledalac;
import so.gledalac.SOUpdateGledalac;
import so.karta.SOAddKarta;
import so.karta.SODeleteKarta;
import so.karta.SOGetAllKarta;
import so.nalog.SOAddNalog;
import so.nalog.SODeleteNalog;
import so.nalog.SOGetAllNalog;
import so.nalog.SOUpdateNalog;
import so.predstava.SOAddPredstava;
import so.predstava.SOGetAllPredstava;
import so.predstava.SOGetDatumiZaPredstava;
import so.predstava.SOGetPredstavaZaScena;
import so.predstava.SOUpdatePredstava;
import so.racun.SOAddRacun;
import so.racun.SOGetAllRacun;
import so.rezervacija.SOAddRezervacija;
import so.rezervacija.SOGetAllRezervacija;
import so.rezervacija.SOUpdateRezervacija;
import so.rezervacija.SOUpdateRezervacije;
import so.scena.SOGetAllScena;

/**
 *
 * @author marij
 */
public class Controller {
     private static Controller instance;

    public Controller() {
    }

    public static Controller getInstance() {
        if (instance == null) {
            instance = new Controller();
        }
        return instance;
    }

    public ArrayList<Nalog> getAllNalog() throws Exception {
        SOGetAllNalog so = new SOGetAllNalog();
        so.templateExecute(new Nalog());
        return so.getLista();
    }

    public boolean addNalog(Nalog n) throws Exception {
        SOAddNalog so = new SOAddNalog();
        so.templateExecute(n);
        return so.isUspesno();
    }

    public boolean addGledalac(Gledalac g) throws Exception {
        SOAddGledalac so = new SOAddGledalac();
        so.templateExecute(g);
        return so.isUspesno();
    }

    public ArrayList<Gledalac> getAllGledalac() throws Exception {
        SOGetAllGledalac so = new SOGetAllGledalac();
        so.templateExecute(new Gledalac());
        return so.getLista();
    }

    public boolean updateRezervacija(Rezervacija r) throws Exception {
        SOUpdateRezervacija so=new SOUpdateRezervacija();
        so.templateExecute(r);
        return so.isUspesno();
    }

    public boolean addPredstava(Predstava p) throws Exception {
        SOAddPredstava so = new SOAddPredstava();
        so.templateExecute(p);
        return so.isUspesno();
    }

    public ArrayList<Scena> getAllScena() throws Exception {
        SOGetAllScena so = new SOGetAllScena();
        so.templateExecute(new Scena());
        return so.getLista();
    }

    public ArrayList<Predstava> getPredstava(Scena s) throws Exception {
        SOGetPredstavaZaScena so = new SOGetPredstavaZaScena();
        so.templateExecute(s);
        return so.getLista();
    }

    public ArrayList<Date> getDatumi(Predstava pred) throws Exception {
        SOGetDatumiZaPredstava so = new SOGetDatumiZaPredstava();
        so.templateExecute(pred);
        return so.getLista();
    }

    public ArrayList<Predstava> getAllPredstava() throws Exception {
        SOGetAllPredstava so = new SOGetAllPredstava();
        so.templateExecute(new Predstava());
        return so.getLista();
    }

   

    public void updateNalog(Nalog n) throws Exception {
        AbstractSO so = new SOUpdateNalog();
        so.templateExecute(n);
    }

    public void deleteNalog(Nalog nalo) throws Exception {
        AbstractSO so = new SODeleteNalog();
        so.templateExecute(nalo);
    }


    public void updateGledalac(Gledalac gle) throws Exception {
        AbstractSO so = new SOUpdateGledalac();
        so.templateExecute(gle);
    }

    public void deleteGledalac(Gledalac gl) throws Exception {
        AbstractSO so = new SODeleteGledalac();
        so.templateExecute(gl);
    }

    public ArrayList<Rezervacija> getAllRezervacija() throws Exception {
        SOGetAllRezervacija so = new SOGetAllRezervacija();
        so.templateExecute(new Rezervacija());
        return so.getLista();
    }

//    public void updateRezervacije(ArrayList<Rezervacija> rez) throws Exception{
//        AbstractSO so = new SOUpdateRezervacije();
//        so.templateExecute(rez);
//
//    }

    public boolean addRacun(Racun racun) throws Exception {
        SOAddRacun so = new SOAddRacun();
        so.templateExecute(racun);
        return so.isUspesno();
    }

    public ArrayList<Racun> getAllRacun() throws Exception {
        SOGetAllRacun so = new SOGetAllRacun();
        so.templateExecute(new Racun());
        return so.getLista();
    }

    public void addKarta(Karta karta) throws Exception {
        SOAddKarta so = new SOAddKarta();
        so.templateExecute(karta);

    }

    public ArrayList<Karta> getAllKarta() throws Exception {
        SOGetAllKarta so = new SOGetAllKarta();
        so.templateExecute(new Karta());
        return so.getLista();
    }

    public void updatePredstava(Predstava predst) throws Exception {
        AbstractSO so = new SOUpdatePredstava();
        so.templateExecute(predst);
    }

    public boolean addRezervacija(Rezervacija rezerve) throws Exception {
        SOAddRezervacija so=new SOAddRezervacija();
        so.templateExecute(rezerve);
        return so.isUspesno();
    }

    public void deleteKarta(Karta krt) throws Exception {
        AbstractSO so=new SODeleteKarta();
        so.templateExecute(krt);
    }

   




    
    
    
}

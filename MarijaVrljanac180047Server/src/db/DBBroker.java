/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import domain.AbstractDomainObject;
import domain.Gledalac;
import domain.Nalog;
import domain.Predstava;
import domain.Rezervacija;
import domain.Scena;
import domain.StavkaIzvestaja;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.Date;
import java.util.ArrayList;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author marij
 */
public class DBBroker {
    private static DBBroker instance;
    private static Connection connection;

    public DBBroker() {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream("src\\config\\dbconfig.properties"));
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/marijavrljanac20180047baza", "root", "");
            connection.setAutoCommit(false);

        } catch (Exception ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public DBBroker(Connection connection) {
        this.connection = connection;

    }

    public Connection getConnection() {
        return connection;
    }

    public static DBBroker getInstance() {
        if (instance == null) {
            instance = new DBBroker();
        }
        return instance;
    }

    public ArrayList<AbstractDomainObject> select(AbstractDomainObject ado) throws SQLException {
        String upit = "SELECT * FROM " + ado.nazivTabele() + " " + ado.alijas()
                + " " + ado.spajanje() + " " + ado.id() + " ";
        System.out.println(upit);
        Statement s = connection.createStatement();
        ResultSet rs = s.executeQuery(upit);
        return ado.selectLista(rs);
    }

    public PreparedStatement insert(AbstractDomainObject ado) throws SQLException {
        String upit = "INSERT INTO " + ado.nazivTabele() + " "
                + ado.koloneZaInsert() + " VALUES(" + ado.vrednostiZaInsert() + ")";
        System.out.println(upit);
        PreparedStatement ps = connection.prepareStatement(upit, Statement.RETURN_GENERATED_KEYS);
        ps.executeUpdate();
        return ps;
    }
    
     public PreparedStatement insertReg(AbstractDomainObject ado) throws SQLException {
        String upit = "INSERT INTO " + ado.nazivTabele() + " "
                + ado.koloneZaInsert() + " VALUES(" + ado.vrednostiZaInsert() + ")";
        System.out.println(upit);
        PreparedStatement ps = connection.prepareStatement(upit);
        ps.executeUpdate();
        return ps;
    }

    public void update(AbstractDomainObject ado) throws SQLException {
        String upit = "UPDATE " + ado.nazivTabele() + " SET "
                + ado.vrednostiZaUpdate() + " WHERE " + ado.id();
        System.out.println(upit);
        Statement s = connection.createStatement();
        s.executeUpdate(upit);
    }

    public void delete(AbstractDomainObject ado) throws SQLException {
        String upit = "DELETE FROM " + ado.nazivTabele() + " WHERE " + ado.id();
        System.out.println(upit);
        Statement s = connection.createStatement();
        s.executeUpdate(upit);
    }

    public ArrayList<AbstractDomainObject> selectBezUslova(AbstractDomainObject ado) throws SQLException {
        String upit = "SELECT * FROM " + ado.nazivTabele() + " " + ado.alijas()
                + " " + ado.spajanje();
        System.out.println(upit);
        Statement s = connection.createStatement();
        ResultSet rs = s.executeQuery(upit);
        return ado.selectLista(rs);
    }
    
    
     public ArrayList<Predstava> vratiPredstave(Scena s) {
        String upit = "SELECT * FROM Predstava WHERE SCENAID = "+s.getScenaID();
        ArrayList<Predstava> lista = new ArrayList<>();
        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(upit);
            
            while(rs.next()){
                Predstava p = new Predstava(rs.getInt("PredstavaID"), rs.getString("NazivPredstave"), rs.getDate("DatumIzvodjenja"), rs.getString("Detalji"), s);
                lista.add(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return lista;
    }
    
    public ArrayList<Timestamp> vratiDatumIVreme(Predstava p) {
        String upit = "SELECT DatumIzvodjenja FROM Predstava WHERE PredstavaID = "+p.getPredstavaID();
        ArrayList<Timestamp> lista = new ArrayList<>();
        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(upit);           
            
            while(rs.next()){
                Timestamp d = rs.getTimestamp("DatumIzvodjenja");
                lista.add(d);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return lista;
    }
        
    
     public boolean izmeniRezervaciju(Rezervacija r) throws SQLException {
        String upit = "UPDATE Rezervacija "
                + "SET NalogID = ?, RezervacijaID = ?, ImePrezime = ?, DatumIVreme = ? "
                + "WHERE PredstavaID = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(upit);

            ps.setInt(1, r.getNalog().getNalogID());
            ps.setInt(2, r.getRezervacijaID());      
            ps.setString(3, r.getImePrezime());
            ps.setTimestamp(4, new Timestamp(r.getDatumIVreme().getTime()));
            ps.setInt(5, r.getPredstava().getPredstavaID());

            ps.executeUpdate();

            
            connection.commit();
            return true;
  

        } catch (SQLException ex) {
            connection.rollback();
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }
     
     
     
//     public boolean updatePredstavu(Predstava p) throws SQLException {
//        String upit = "UPDATE Predstava (NazivPredstave, DatumIzvodjenja, Detalji, ScenaID) VALUES (?,?,?,?)";
//        try {
//            PreparedStatement ps = connection.prepareStatement(upit, Statement.RETURN_GENERATED_KEYS);
//
//            ps.setString(1, p.getNazivPredstave());
//            ps.setDate(2, new java.sql.Date(p.getDatumIzvodjenja().getTime()));
//            ps.setString(3, p.getDetalji());
//            ps.setLong(4, p.getScena().getScenaID());
//
//            ps.executeUpdate();
//
//            ResultSet tableKeys = ps.getGeneratedKeys();
//            tableKeys.next();
//            int predstavaID = tableKeys.getInt(1);
//
//            p.setPredstavaID(predstavaID);
//
//            if (sacuvajRezervacije(p)) {
//                connection.commit();
//                return true;
//            } else {
//                connection.rollback();
//                return false;
//            }
//
//        } catch (SQLException ex) {
//            connection.rollback();
//            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
//        return false;
//    }

//    public boolean sacuvajRezervacije(Predstava p) throws SQLException {
//        String upit = "INSERT INTO Rezervacija VALUES (?,?,?,?,?,?)";
//        try {
//            PreparedStatement ps = connection.prepareStatement(upit);
//
//            for (Rezervacija r : p.getRezervacije()) {
//                ps.setInt(1, p.getPredstavaID());
//                ps.setInt(2, r.getNalog().getNalogID());
//                ps.setInt(3, r.getRezervacijaID());
//                ps.setString(4, r.getImePrezime());
//                ps.setDate(5, new java.sql.Date(r.getDatumIVreme().getTime()));
//                ps.setInt(6, r.getBrojKarata());
//
//                ps.addBatch();
//            }
//
//            ps.executeBatch();
//            connection.commit();
//
//            return true;
//
//        } catch (SQLException ex) {
//             connection.rollback();
//            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
//        return false;
//    }

        
}

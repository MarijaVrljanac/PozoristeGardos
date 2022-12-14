/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.form.rezervacija;


import view.form.rezervacija.IzmeniForm;
import view.form.rezervacija.DodajForm;
import controller.ControllerClient;
import domain.Nalog;
import domain.Predstava;
import domain.Rezervacija;
import domain.Scena;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import view.components.ModelTabelePredstava;
import view.components.ModelTabeleRezervacije;


/**
 *
 * @author marij
 */
public class RezBackUpForm extends javax.swing.JFrame {

    Nalog n;

    public Nalog getN() {
        return n;
    }
    
    
    
    /**
     * Creates new form MainFormClient
     */
    public RezBackUpForm(Nalog n) {
        initComponents();
        setLocationRelativeTo(null);
        this.n = n;

        try {
            popuniScene();
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error in view initialization: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        
        ModelTabeleRezervacije mtr = new ModelTabeleRezervacije();
        tblRezervacije.setModel(mtr);
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblRezervacije = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnDodaj = new javax.swing.JButton();
        btnObrisi = new javax.swing.JButton();
        btnSacuvaj = new javax.swing.JButton();
        btnIzmeni = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtNazivPredstave = new javax.swing.JTextField();
        txtDatumIzvodjenja = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtADetalji = new javax.swing.JTextArea();
        lblScena = new javax.swing.JLabel();
        cmbScena = new javax.swing.JComboBox();
        btnKupi = new javax.swing.JButton();
        btnNazad = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        lblPozoriste = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Pozori??te \"Gardo??\" - Rezervacije");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Unos predstave"));

        tblRezervacije.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblRezervacije);

        jLabel1.setText("Datum i vreme izvodjenja: ");

        jLabel2.setText("Detalji:");

        btnDodaj.setText("Dodaj rezervaciju");
        btnDodaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDodajActionPerformed(evt);
            }
        });

        btnObrisi.setText("Obrisi rezervaciju");
        btnObrisi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnObrisiActionPerformed(evt);
            }
        });

        btnSacuvaj.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btnSacuvaj.setText("Sacuvaj izmene");
        btnSacuvaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSacuvajActionPerformed(evt);
            }
        });

        btnIzmeni.setText("Izmeni rezervaciju");
        btnIzmeni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIzmeniActionPerformed(evt);
            }
        });

        jLabel3.setText("Naziv predstave:");

        txtNazivPredstave.setText("Nova predstava");

        txtDatumIzvodjenja.setText("20.12.2022. 20:00");

        txtADetalji.setColumns(20);
        txtADetalji.setRows(5);
        txtADetalji.setText("Neki opis...");
        jScrollPane2.setViewportView(txtADetalji);

        lblScena.setText("Scena:");

        cmbScena.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnKupi.setText("Kupi kartu");
        btnKupi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKupiActionPerformed(evt);
            }
        });

        btnNazad.setText("Nazad");
        btnNazad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNazadActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel1))
                        .addGap(21, 21, 21)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtDatumIzvodjenja)
                            .addComponent(txtNazivPredstave)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnDodaj)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnObrisi)
                        .addGap(13, 13, 13)
                        .addComponent(btnIzmeni)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnSacuvaj)
                        .addGap(56, 56, 56)
                        .addComponent(btnKupi)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnNazad))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(lblScena))
                        .addGap(135, 135, 135)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2)
                            .addComponent(cmbScena, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtNazivPredstave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(txtDatumIzvodjenja, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbScena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblScena))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDodaj)
                    .addComponent(btnObrisi)
                    .addComponent(btnIzmeni))
                .addGap(27, 27, 27)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSacuvaj)
                    .addComponent(btnKupi)
                    .addComponent(btnNazad))
                .addContainerGap())
        );

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/form/logo_pozoriste.png"))); // NOI18N

        lblPozoriste.setFont(new java.awt.Font("Tahoma", 3, 13)); // NOI18N
        lblPozoriste.setText("POZORI??TE \"GARDO??\"");

        jLabel6.setText("Sibinjanin Janka bb");

        jLabel5.setText("11080, Zemun");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(91, 91, 91)
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5)
                            .addComponent(lblPozoriste, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(lblPozoriste)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5)))
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDodajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDodajActionPerformed
        new DodajForm(this, true, null).setVisible(true);
    }//GEN-LAST:event_btnDodajActionPerformed

    private void btnObrisiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnObrisiActionPerformed
        int red = tblRezervacije.getSelectedRow();
        
        if(red != -1){
            ModelTabeleRezervacije mtr = (ModelTabeleRezervacije) tblRezervacije.getModel();
            mtr.obrisiRezervaciju(red);
        }
    }//GEN-LAST:event_btnObrisiActionPerformed

    private void btnIzmeniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIzmeniActionPerformed
        int red = tblRezervacije.getSelectedRow();
        
        if(red != -1){
            ModelTabeleRezervacije mtr = (ModelTabeleRezervacije) tblRezervacije.getModel();
            Rezervacija r = mtr.vratiRezervaciju(red);

            new IzmeniForm(this, true, r).setVisible(true);
        }
    }//GEN-LAST:event_btnIzmeniActionPerformed

    private void btnSacuvajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSacuvajActionPerformed
        try {
            if(txtNazivPredstave.getText().isEmpty() || txtDatumIzvodjenja.getText().isEmpty() || txtADetalji.getText().isEmpty()){
                JOptionPane.showMessageDialog(this, "Sva polja moraju biti popunjena!");
                return;
            }
            
            SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy. HH:mm");
            
            String nazivPredstave = txtNazivPredstave.getText();
            Date datumIzvodjenja = sdf.parse(txtDatumIzvodjenja.getText());
            String detalji = txtADetalji.getText();
            
            Scena scena = (Scena) cmbScena.getSelectedItem();
            
            ModelTabeleRezervacije mtr = (ModelTabeleRezervacije) tblRezervacije.getModel();
            
            Predstava p = new Predstava(-1, nazivPredstave, datumIzvodjenja, detalji, scena);
  

            boolean uspesno = (boolean) ControllerClient.getInstance().addPredstava(p);
            
            if(uspesno){
                JOptionPane.showMessageDialog(this, "Uspesno sacuvano!");
            }else{
                JOptionPane.showMessageDialog(this, "Nije uspesno sacuvano...");
            }   
            
        } catch (ParseException ex) {
            Logger.getLogger(RezBackUpForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(RezBackUpForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnSacuvajActionPerformed

    private void btnKupiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKupiActionPerformed
       int red = tblRezervacije.getSelectedRow();
        
        ModelTabelePredstava mtp = (ModelTabelePredstava) tblRezervacije.getModel();
        Predstava p = mtp.vratiPredstavu(red);
        
        
//        new KupiKartu(n, p).setVisible(true);
       this.dispose();
    }//GEN-LAST:event_btnKupiActionPerformed

    private void btnNazadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNazadActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnNazadActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDodaj;
    private javax.swing.JButton btnIzmeni;
    private javax.swing.JButton btnKupi;
    private javax.swing.JButton btnNazad;
    private javax.swing.JButton btnObrisi;
    private javax.swing.JButton btnSacuvaj;
    private javax.swing.JComboBox cmbScena;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblPozoriste;
    private javax.swing.JLabel lblScena;
    private javax.swing.JTable tblRezervacije;
    private javax.swing.JTextArea txtADetalji;
    private javax.swing.JTextField txtDatumIzvodjenja;
    private javax.swing.JTextField txtNazivPredstave;
    // End of variables declaration//GEN-END:variables

    void dodajRezervaciju(Rezervacija r) {
        ModelTabeleRezervacije mtr = (ModelTabeleRezervacije) tblRezervacije.getModel();
        mtr.dodajRezervaciju(r);
    }

    void izmeniRezervaciju(Rezervacija r) {
        ModelTabeleRezervacije mtr = (ModelTabeleRezervacije) tblRezervacije.getModel();
        int red = tblRezervacije.getSelectedRow();
        mtr.izmeniRezervaciju(red, r);
    }

    private void popuniScene() throws Exception {
        cmbScena.removeAllItems();
        
//              KlijentskiZahtev kz = new KlijentskiZahtev();
//            kz.setOperacija(Konstante.VRATI_SCENE);
//            
//            KomunikacijaSaServerom.getInstance().posaljiZahtev(kz);
//            ServerskiOdgovor so = KomunikacijaSaServerom.getInstance().primiOdgovor();
//            
//            ArrayList<Scena> scene = (ArrayList<Scena>) so.getOdgovor();

        List<Scena> scene = ControllerClient.getInstance().getAllScene();
            
            for (Scena scena : scene) {
            cmbScena.addItem(scena);
        }
    }
}

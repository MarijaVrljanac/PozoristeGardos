/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.form.nalog;

import controller.ControllerClient;
import domain.Nalog;
import java.net.SocketException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author marij
 */
public class NalogForm extends javax.swing.JDialog {
    
    Nalog n;
    /**
     * Creates new form NalogForm
     */
    public NalogForm(java.awt.Frame parent, boolean modal, Nalog n) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        this.n = n;
        txtNalogID.setText(String.valueOf(n.getNalogID()));
        txtEmailAdresa.setText(n.getEmailAdresa());
        txtKorisnickoIme.setText(n.getKorisnickoIme());
        pswLozinka.setText(n.getSifra());
        
        txtNalogID.setEditable(false);
        txtEmailAdresa.setEditable(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnOtkazi = new javax.swing.JButton();
        btnIzmeni = new javax.swing.JButton();
        btnObrisi = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        lblLozinka = new javax.swing.JLabel();
        lblKorisnickoIme = new javax.swing.JLabel();
        lblEmailAdresa = new javax.swing.JLabel();
        lblNalogID = new javax.swing.JLabel();
        txtNalogID = new javax.swing.JTextField();
        txtEmailAdresa = new javax.swing.JTextField();
        txtKorisnickoIme = new javax.swing.JFormattedTextField();
        pswLozinka = new javax.swing.JPasswordField();
        jLabel5 = new javax.swing.JLabel();
        lblPozoriste = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Pozori??te \"Gardo??\" - Nalog");

        btnOtkazi.setText("Nazad");
        btnOtkazi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOtkaziActionPerformed(evt);
            }
        });

        btnIzmeni.setText("Izmeni podatke");
        btnIzmeni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIzmeniActionPerformed(evt);
            }
        });

        btnObrisi.setText("Obri??i nalog");
        btnObrisi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnObrisiActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Podaci naloga"));

        lblLozinka.setText("Lozinka:");

        lblKorisnickoIme.setText("Korisni??ko ime:");

        lblEmailAdresa.setText("Email adresa:");

        lblNalogID.setText("NalogID:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblKorisnickoIme)
                    .addComponent(lblEmailAdresa)
                    .addComponent(lblNalogID)
                    .addComponent(lblLozinka))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtKorisnickoIme)
                    .addComponent(pswLozinka, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtNalogID)
                    .addComponent(txtEmailAdresa, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNalogID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNalogID))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEmailAdresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblEmailAdresa))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtKorisnickoIme, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblKorisnickoIme))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblLozinka)
                    .addComponent(pswLozinka, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/form/logo_pozoriste.png"))); // NOI18N

        lblPozoriste.setFont(new java.awt.Font("Tahoma", 3, 13)); // NOI18N
        lblPozoriste.setText("POZORI??TE \"GARDO??\"");

        jLabel6.setText("Sibinjanin Janka bb");

        jLabel7.setText("11080, Zemun");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(46, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(lblPozoriste, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jSeparator1)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnIzmeni)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnObrisi)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnOtkazi)
                        .addGap(157, 157, 157))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(lblPozoriste)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel7)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnIzmeni)
                    .addComponent(btnObrisi))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnOtkazi)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnOtkaziActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOtkaziActionPerformed

        this.dispose();
    }//GEN-LAST:event_btnOtkaziActionPerformed

    private void btnIzmeniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIzmeniActionPerformed

        try {

            if (String.valueOf(pswLozinka.getPassword()).isEmpty() || txtKorisnickoIme.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Korisni??ko ime i lozinka su obavezna polja!");
                return;
            }
            
            String staroUsername = n.getKorisnickoIme();
            String staraLozinka = n.getSifra();

            String korisnickoIme = txtKorisnickoIme.getText();
            String lozinka = String.valueOf(pswLozinka.getPassword());
            
            n.setKorisnickoIme(korisnickoIme);
            n.setSifra(lozinka);
            
            

            if (!n.getKorisnickoIme().equals(staroUsername) && !n.getSifra().equals(staraLozinka)) {
                try {                    
                    ControllerClient.getInstance().updateNalog(n);
                    JOptionPane.showMessageDialog(this, "Uspe??no izmenjeni podaci!");
                } catch (Exception ex) {
                    Logger.getLogger(NalogForm.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            PretragaNalogaForm pc = (PretragaNalogaForm) getParent();
            pc.osveziTabelu();
            this.dispose();
        } catch (Exception ex) {

            if (ex instanceof SocketException) {
                JOptionPane.showMessageDialog(rootPane, "Komunikacija izmedju servera je prekinuta");
                this.dispose();
                System.exit(0);
            }
            Logger.getLogger(NalogForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnIzmeniActionPerformed

    private void btnObrisiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnObrisiActionPerformed

        try {

            int result = JOptionPane.showConfirmDialog(this, "Da li ste sigurni da ??elite da obri??ete nalog?", "Konfirmacija", JOptionPane.YES_NO_OPTION);

            if (result == JOptionPane.YES_OPTION) {
                ControllerClient.getInstance().deleteNalog(n);
                JOptionPane.showMessageDialog(this, "Uspesno obrisan nalog!");
                PretragaNalogaForm pc = (PretragaNalogaForm) getParent();
                pc.osveziTabelu();
                this.dispose();
            }

        } catch (Exception ex) {

            if (ex instanceof SocketException) {
                JOptionPane.showMessageDialog(rootPane, "Komunikacija izmedju servera je prekinuta");
                this.dispose();
                System.exit(0);
            }

            Logger.getLogger(NalogForm.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btnObrisiActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIzmeni;
    private javax.swing.JButton btnObrisi;
    private javax.swing.JButton btnOtkazi;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblEmailAdresa;
    private javax.swing.JLabel lblKorisnickoIme;
    private javax.swing.JLabel lblLozinka;
    private javax.swing.JLabel lblNalogID;
    private javax.swing.JLabel lblPozoriste;
    private javax.swing.JPasswordField pswLozinka;
    private javax.swing.JTextField txtEmailAdresa;
    private javax.swing.JFormattedTextField txtKorisnickoIme;
    private javax.swing.JTextField txtNalogID;
    // End of variables declaration//GEN-END:variables


   

 


}

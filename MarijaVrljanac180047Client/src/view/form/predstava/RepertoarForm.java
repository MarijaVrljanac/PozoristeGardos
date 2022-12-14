/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.form.predstava;


import controller.ControllerClient;
import domain.Nalog;
import domain.Predstava;
import domain.Scena;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import view.components.ModelTabelePredstava;
import view.form.karta.KupiKartu;
import view.form.karta.KupovinaForm;
import view.form.rezervacija.RezervacijeForm;


/**
 *
 * @author marij
 */
public class RepertoarForm extends javax.swing.JFrame {

    Nalog n;
    
    /**
     * Creates new form RepertoarForm
     */
    public RepertoarForm(Nalog n) {
        initComponents();
        setLocationRelativeTo(null);
        this.n = n;

        ModelTabelePredstava mtp = new ModelTabelePredstava();
        tblPredstave.setModel(mtp);

        try {

            popuniRepertoar();
//            izvrsiUpit();
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error in view initialization: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        lblPozoriste = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPredstave = new javax.swing.JTable();
        btnRezervisi = new javax.swing.JButton();
        txtNazivPredstave = new javax.swing.JTextField();
        btnKupi = new javax.swing.JButton();
        btnNazad = new javax.swing.JButton();
        ckbNazivPredstave = new javax.swing.JCheckBox();
        btnDetalji = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Pozori??te \"Gardo??\" -  Repertoar");

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/form/logo_pozoriste.png"))); // NOI18N

        lblPozoriste.setFont(new java.awt.Font("Tahoma", 3, 13)); // NOI18N
        lblPozoriste.setText("POZORI??TE \"GARDO??\"");

        jLabel6.setText("Sibinjanin Janka bb");

        jLabel5.setText("11080, Zemun");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Repertoar pozori??ta"));

        tblPredstave.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblPredstave);

        btnRezervisi.setText("Rezervi??i kartu");
        btnRezervisi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRezervisiActionPerformed(evt);
            }
        });

        txtNazivPredstave.setText("Nova predstava");

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

        ckbNazivPredstave.setText("Naziv predstave:");
        ckbNazivPredstave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ckbNazivPredstaveActionPerformed(evt);
            }
        });

        btnDetalji.setFont(new java.awt.Font("Tahoma", 2, 13)); // NOI18N
        btnDetalji.setText("Detalji o predstavi");
        btnDetalji.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDetaljiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnDetalji)
                .addGap(164, 164, 164))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(ckbNazivPredstave)
                        .addGap(22, 22, 22)
                        .addComponent(txtNazivPredstave))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnRezervisi)
                        .addGap(82, 82, 82)
                        .addComponent(btnKupi)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnNazad)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNazivPredstave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ckbNazivPredstave))
                .addGap(28, 28, 28)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(btnDetalji)
                .addGap(26, 26, 26)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRezervisi)
                    .addComponent(btnKupi)
                    .addComponent(btnNazad))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

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
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRezervisiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRezervisiActionPerformed
       new RezervacijeForm(n).setVisible(true);
       this.dispose();
    }//GEN-LAST:event_btnRezervisiActionPerformed

    private void btnKupiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKupiActionPerformed
        int red = tblPredstave.getSelectedRow();
        
        ModelTabelePredstava mtp = (ModelTabelePredstava) tblPredstave.getModel();
        Predstava pred = mtp.vratiPredstavu(red);
        
        new KupiKartu(n, pred, null).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnKupiActionPerformed

    private void btnNazadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNazadActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnNazadActionPerformed

    private void btnDetaljiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDetaljiActionPerformed
        int red = tblPredstave.getSelectedRow();
        
        ModelTabelePredstava mtp = (ModelTabelePredstava) tblPredstave.getModel();
        Predstava pred = mtp.vratiPredstavu(red);
        
        JOptionPane.showMessageDialog(this, pred.info());
        
    }//GEN-LAST:event_btnDetaljiActionPerformed

    private void ckbNazivPredstaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ckbNazivPredstaveActionPerformed
        ModelTabelePredstava mtp = (ModelTabelePredstava) tblPredstave.getModel();
        String parametar = txtNazivPredstave.getText();
        mtp.setParametar(parametar);
    }//GEN-LAST:event_ckbNazivPredstaveActionPerformed

  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDetalji;
    private javax.swing.JButton btnKupi;
    private javax.swing.JButton btnNazad;
    private javax.swing.JButton btnRezervisi;
    private javax.swing.JCheckBox ckbNazivPredstave;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblPozoriste;
    private javax.swing.JTable tblPredstave;
    private javax.swing.JTextField txtNazivPredstave;
    // End of variables declaration//GEN-END:variables

    private void popuniRepertoar() throws Exception {

            List<Predstava> predstave = ControllerClient.getInstance().getAllPredstave();
            
            ModelTabelePredstava mtp = (ModelTabelePredstava) tblPredstave.getModel();
            
            mtp.dodajPredstave((ArrayList<Predstava>) predstave);
            
    }

    
    
//    private void izvrsiUpit() throws Exception{
//        ArrayList<Predstava> listaBaza = new ArrayList<>();
//        String dodatniUpit = "";
//        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy.");
//        ModelTabelePredstava mtp = (ModelTabelePredstava) tblPredstave.getModel();
//        
//        if(!ckbNazivPredstave.isSelected() && !ckbDatumIzvodjenja.isSelected()){
//            listaBaza = ControllerClient.getInstance().getAllPredstave();
//            mtp.vratiPredstave(listaBaza);
//        }
//        
//        
//        if(ckbNazivPredstave.isSelected()){
//            String parametar = txtNazivPredstave.getText();
//            mtp.setParametar(parametar);
//        }
//        
//        if(ckbDatumIzvodjenja.isSelected()){
//            String parametar = txtDatumIzvodjenja.getText();
//            mtp.setParametar(parametar);
//        }
//        
//        
//        
//    }
}

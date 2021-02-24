package Vista;

import Controlador.Controlador;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
/**
 * @author Victor Lavalle
 */
public class GUI extends javax.swing.JFrame {
    
    private Controlador ctrl;

    //Metodos Get  & Set
    public Controlador getCtrl() {return ctrl;}
    public JTextField getNodo1TXT() { return Nodo1TXT;}
    public JTextField getNodo2TXT() {return Nodo2TXT; }
    public JTextField getNodoTXT() {return NodoTXT; }
    public JTextPane getRecorrerListaTA() {return RecorrerListaTA;}
    public JTextPane getRecorrerMatrizTA1() {return RecorrerMatrizTA1;}
    public JRadioButton getProfundidadRB() { return ProfundidadRB;}
    public JButton getRecorrerBTN() { return RecorrerBTN;}
    public JRadioButton getAmplitudRB() { return AmplitudRB;} 
    public JTextPane getRecorrerTA() { return RecorrerListaTA; }
    public JTextArea getRepresentacionTA() {return RepresentacionTA;}


    public void setCtrl(Controlador ctrl) { this.ctrl = ctrl;}
    public void setNodo1TXT(JTextField Nodo1TXT) {this.Nodo1TXT = Nodo1TXT; }
    public void setNodo2TXT(JTextField Nodo2TXT) { this.Nodo2TXT = Nodo2TXT; }
    public void setNodoTXT(JTextField NodoTXT) {this.NodoTXT = NodoTXT;}
    public void setRecorrerListaTA(JTextPane RecorrerListaTA) { this.RecorrerListaTA = RecorrerListaTA; }
    public void setRecorrerMatrizTA1(JTextPane RecorrerMatrizTA1) { this.RecorrerMatrizTA1 = RecorrerMatrizTA1; }
    public void setProfundidadRB(JRadioButton ProfundidadRB) {this.ProfundidadRB = ProfundidadRB; }
    public void setRecorrerBTN(JButton RecorrerBTN) {  this.RecorrerBTN = RecorrerBTN; }
    public void setAmplitudRB(JRadioButton AmplitudRB) {  this.AmplitudRB = AmplitudRB;}
    public void setRecorrerTA(JTextPane RecorrerTA) {this.RecorrerListaTA = RecorrerTA; }
    public void setRepresentacionTA(JTextArea RepresentacionTA) {this.RepresentacionTA = RepresentacionTA;}
    
    //Constructor GUI
    public GUI() {
        initComponents();
        this.setLocation(60,80);
        this.AmplitudRB.setSelected(true);
        this.setResizable(false);
        this.setTitle(":::Proyecto Grafos:::");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        InsertarBTN = new javax.swing.JButton();
        BorrarBTN = new javax.swing.JButton();
        AdyacenteBTN = new javax.swing.JButton();
        BuscarBTN = new javax.swing.JButton();
        AmplitudRB = new javax.swing.JRadioButton();
        ProfundidadRB = new javax.swing.JRadioButton();
        RecorrerBTN = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        RepresentacionTA = new javax.swing.JTextArea();
        NodoTXT = new javax.swing.JTextField();
        ArcoBTN = new javax.swing.JButton();
        BorrarABTN = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        Nodo1TXT = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        BuscarTXT = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        RecorrerListaTA = new javax.swing.JTextPane();
        jScrollPane3 = new javax.swing.JScrollPane();
        RecorrerMatrizTA1 = new javax.swing.JTextPane();
        Nodo2TXT = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        InsertarBTN.setBackground(new java.awt.Color(74, 207, 172));
        InsertarBTN.setForeground(new java.awt.Color(255, 255, 255));
        InsertarBTN.setText("Insertar Vertice");
        InsertarBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InsertarBTNActionPerformed(evt);
            }
        });
        jPanel1.add(InsertarBTN, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 10, -1, -1));

        BorrarBTN.setBackground(new java.awt.Color(187, 134, 252));
        BorrarBTN.setForeground(new java.awt.Color(255, 255, 255));
        BorrarBTN.setText("Borrar Vertice");
        BorrarBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BorrarBTNActionPerformed(evt);
            }
        });
        jPanel1.add(BorrarBTN, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 50, 120, -1));

        AdyacenteBTN.setBackground(new java.awt.Color(255, 137, 59));
        AdyacenteBTN.setForeground(new java.awt.Color(255, 255, 255));
        AdyacenteBTN.setText("Adyacencia");
        AdyacenteBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AdyacenteBTNActionPerformed(evt);
            }
        });
        jPanel1.add(AdyacenteBTN, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 210, -1, -1));

        BuscarBTN.setBackground(new java.awt.Color(255, 137, 59));
        BuscarBTN.setForeground(new java.awt.Color(255, 255, 255));
        BuscarBTN.setText("Buscar");
        BuscarBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BuscarBTNActionPerformed(evt);
            }
        });
        jPanel1.add(BuscarBTN, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 380, -1, -1));

        AmplitudRB.setBackground(new java.awt.Color(187, 134, 252));
        buttonGroup1.add(AmplitudRB);
        AmplitudRB.setForeground(new java.awt.Color(255, 255, 255));
        AmplitudRB.setText("Amplitud");
        jPanel1.add(AmplitudRB, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 320, -1, -1));

        ProfundidadRB.setBackground(new java.awt.Color(187, 134, 252));
        buttonGroup1.add(ProfundidadRB);
        ProfundidadRB.setForeground(new java.awt.Color(255, 255, 255));
        ProfundidadRB.setText("Profundidad");
        ProfundidadRB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProfundidadRBActionPerformed(evt);
            }
        });
        jPanel1.add(ProfundidadRB, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 320, -1, -1));

        RecorrerBTN.setBackground(new java.awt.Color(255, 137, 59));
        RecorrerBTN.setForeground(new java.awt.Color(255, 255, 255));
        RecorrerBTN.setText("Recorrer Grafo ADT");
        RecorrerBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RecorrerBTNActionPerformed(evt);
            }
        });
        jPanel1.add(RecorrerBTN, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 490, -1, -1));

        RepresentacionTA.setEditable(false);
        RepresentacionTA.setColumns(20);
        RepresentacionTA.setRows(5);
        jScrollPane1.setViewportView(RepresentacionTA);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 10, 410, 350));
        jPanel1.add(NodoTXT, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 120, -1));

        ArcoBTN.setBackground(new java.awt.Color(74, 207, 172));
        ArcoBTN.setForeground(new java.awt.Color(255, 255, 255));
        ArcoBTN.setText("Crear Arco");
        ArcoBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ArcoBTNActionPerformed(evt);
            }
        });
        jPanel1.add(ArcoBTN, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 110, -1, -1));

        BorrarABTN.setBackground(new java.awt.Color(187, 134, 252));
        BorrarABTN.setForeground(new java.awt.Color(255, 255, 255));
        BorrarABTN.setText("Borrar Arco");
        BorrarABTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BorrarABTNActionPerformed(evt);
            }
        });
        jPanel1.add(BorrarABTN, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 160, -1, -1));

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Nombre del Vertice");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 420, -1, 20));
        jPanel1.add(Nodo1TXT, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 140, 110, -1));

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Vertice 2:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, -1, -1));

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Vertice 1:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, -1, -1));

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText(" Recorridos:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 280, -1, -1));
        jPanel1.add(BuscarTXT, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 390, 140, -1));

        RecorrerListaTA.setEditable(false);
        jScrollPane2.setViewportView(RecorrerListaTA);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 370, 210, 170));

        RecorrerMatrizTA1.setEditable(false);
        jScrollPane3.setViewportView(RecorrerMatrizTA1);

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 370, 210, 170));
        jPanel1.add(Nodo2TXT, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 190, 110, -1));

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Nombre del Vertice");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, -1, -1));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 260, 310, 10));
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 310, 10));

        jLabel7.setFont(new java.awt.Font("DialogInput", 3, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(102, 102, 102));
        jLabel7.setText("Victor Lavalle Estructura de Datos 4to Sem. UADY 2020");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 550, -1, -1));

        jLabel6.setBackground(new java.awt.Color(23, 31, 36));
        jLabel6.setOpaque(true);
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 730, 570));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 730, 570));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void InsertarBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InsertarBTNActionPerformed
       String nodo = this.NodoTXT.getText();
        if(!nodo.equals("")){
            this.ctrl.NuevoNodo(nodo);
        }
        else{
            JOptionPane.showMessageDialog(null, "Cadena nula no válida", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
         this.ctrl.escribir();
    }//GEN-LAST:event_InsertarBTNActionPerformed

    private void BorrarBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BorrarBTNActionPerformed
       
        String nodo = this.NodoTXT.getText();
        if(!nodo.equals("")){
          this.ctrl.BorrarNodo(nodo);
        }
        else{
   JOptionPane.showMessageDialog(null, "Cadena nula no válida", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
        this.ctrl.escribir();
    }//GEN-LAST:event_BorrarBTNActionPerformed

    private void ArcoBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ArcoBTNActionPerformed

        String nodo1=this.Nodo1TXT.getText();
        String nodo2=this.Nodo2TXT.getText();
        if(!nodo1.equals("")||!nodo2.equals("")){
          this.ctrl.NuevoArco(nodo1, nodo2);
        }
        else{
     JOptionPane.showMessageDialog(null, "Cadena nula no válida", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
        this.ctrl.escribir();
    }//GEN-LAST:event_ArcoBTNActionPerformed

    private void AdyacenteBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AdyacenteBTNActionPerformed
        String nodo1=this.Nodo1TXT.getText();
        String nodo2=this.Nodo2TXT.getText();
        if(!nodo1.equals("")||!nodo2.equals("")){
          this.ctrl.Adyacente(nodo1, nodo2);
        }
        else{
          JOptionPane.showMessageDialog(null, "Cadena nula no válida", "Advertencia", JOptionPane.WARNING_MESSAGE);
        } 
    }//GEN-LAST:event_AdyacenteBTNActionPerformed

    private void BorrarABTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BorrarABTNActionPerformed

        String nodo1=this.Nodo1TXT.getText();
        String nodo2=this.Nodo2TXT.getText();
        if(!nodo1.equals("")||!nodo2.equals("")){
            this.ctrl.BorrarArco(nodo1, nodo2);
        }
        else{
             JOptionPane.showMessageDialog(null, "Cadena nula no válida", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
        this.ctrl.escribir();
    }//GEN-LAST:event_BorrarABTNActionPerformed

    private void BuscarBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BuscarBTNActionPerformed
        String buscar = this.BuscarTXT.getText();
        if(!buscar.equals("")){
          this.ctrl.Buscar(buscar);
        }
        else{
   JOptionPane.showMessageDialog(null, "Cadena nula no válida", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }  
    }//GEN-LAST:event_BuscarBTNActionPerformed

    private void RecorrerBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RecorrerBTNActionPerformed
       this.ctrl.Recorrer();
    }//GEN-LAST:event_RecorrerBTNActionPerformed

    private void ProfundidadRBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ProfundidadRBActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ProfundidadRBActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AdyacenteBTN;
    private javax.swing.JRadioButton AmplitudRB;
    private javax.swing.JButton ArcoBTN;
    private javax.swing.JButton BorrarABTN;
    private javax.swing.JButton BorrarBTN;
    private javax.swing.JButton BuscarBTN;
    private javax.swing.JTextField BuscarTXT;
    private javax.swing.JButton InsertarBTN;
    private javax.swing.JTextField Nodo1TXT;
    private javax.swing.JTextField Nodo2TXT;
    private javax.swing.JTextField NodoTXT;
    private javax.swing.JRadioButton ProfundidadRB;
    private javax.swing.JButton RecorrerBTN;
    private javax.swing.JTextPane RecorrerListaTA;
    private javax.swing.JTextPane RecorrerMatrizTA1;
    private javax.swing.JTextArea RepresentacionTA;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    // End of variables declaration//GEN-END:variables
}

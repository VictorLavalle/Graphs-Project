package Vistas;

import Modelo.*;
import Metodos.*;
import java.awt.*;
import javax.swing.*;
/**
 * @author Victor Lavalle
 */
public class VentanaPrincipal extends javax.swing.JFrame {
    /**
     * Creates new form VentanaPincipal
     */
   Pintar pintar =new Pintar();
   Grafos grafo = new Grafos();   

   //Funciones 
   public static void R_repaint(int tope, Grafos grafo){//pinta lo q esta antes en el panel 
        for (int j = 0; j < tope; j++) {
            for (int k = 0; k < tope; k++) {
                if(grafo.getmAdyacencia(j, k) == 1)

                     Pintar.pintarLinea(jPanel1.getGraphics(),grafo.getCordeX(j),grafo.getCordeY(j),
                             grafo.getCordeX(k), grafo.getCordeY(k),grafo.getmCoeficiente(j, k));
            }
        }
        for (int j = 0; j < tope; j++) 
            Pintar.pintarCirculo(jPanel1.getGraphics(), grafo.getCordeX(j),grafo.getCordeY(j),String.valueOf(grafo.getNombre(j)));        
   }
 
//______________________________________________________________________________________
public static int ingresarNodoOrigen(String nodoOrige, String noExiste,int tope){
    int nodoOrigen = 0;
        try{
            nodoOrigen = Integer.parseInt(JOptionPane.showInputDialog(""+nodoOrige));   
            if(nodoOrigen>=tope){  
                    JOptionPane.showMessageDialog(null, ""+noExiste+"\nIngresar un Nodo existente", "Advertencia", JOptionPane.WARNING_MESSAGE);
                  nodoOrigen = ingresarNodoOrigen(nodoOrige,noExiste, tope);
            }
        }catch(Exception ex){
            nodoOrigen = ingresarNodoOrigen(nodoOrige,noExiste,tope);
        }
        return nodoOrigen;
}      

//______________________________________________________________________________________
 public  int ingresarTamano(String tama){        
        int tamano = 0;
        try{
            tamano = Integer.parseInt(JOptionPane.showInputDialog(""+tama));
            if(tamano<1){ 
                JOptionPane.showMessageDialog(null,"Debe Ingresar un Tamaño Valido..");
            }
        }catch(Exception ex){
            tamano = ingresarTamano(tama);
        }
        return tamano;
    }
 
 //______________________________________________________________________________________
 public boolean cicDerechoSobreNodo(int xxx,int yyy){ 
     for (int j = 0; j < tope; j++) {// consultamos si se ha sado  click sobre algun nodo 
            if((xxx+2) > grafo.getCordeX(j) && xxx < (grafo.getCordeX(j)+13) && (yyy+2) > grafo.getCordeY(j) && yyy<(grafo.getCordeY(j)+13) ) {
                                       
               if(n==0){
                   id = j;
                   R_repaint(tope,grafo);
                   Pintar.clickSobreNodo(jPanel1.getGraphics(), grafo.getCordeX(j), grafo.getCordeY(j), null, Color.orange);       
                   n++;                   
               }
               else{ 
                   id2=j;                   
                   n++;
                   Pintar.clickSobreNodo(jPanel1.getGraphics(), grafo.getCordeX(j), grafo.getCordeY(j), null,Color.orange);       
                   if(id==id2){// si id == id2 por q se volvio a dar click sobre el mismos nodo, se cancela el click anterio
                       n=0;
                       Pintar.pintarCirculo(jPanel1.getGraphics(),grafo.getCordeX(id), grafo.getCordeY(id),String.valueOf(grafo.getNombre(id))+" ");
                       id=-1;
                       id2=-1;
                   }
               } 
               nn=0;
                return true;              
            }
         }
     return false;
 }  
 
 //______________________________________________________________________________________
 public void clicIzqSobreNodo(int xxx, int yyy){
            for (int j = 0; j <tope; j++) {
              if((xxx+2) > grafo.getCordeX(j) && xxx < (grafo.getCordeX(j)+13) && (yyy+2) >
                      grafo.getCordeY(j) && yyy<(grafo.getCordeY(j)+13) ) {
                if(nn==0){
                   permanente =j; 
                   R_repaint(tope, grafo);                   
               }
               else{ nodoFin = j;}
                nn++;
                n=0;
                id =-1;
                Pintar.clickSobreNodo(jPanel1.getGraphics(), grafo.getCordeX(j), grafo.getCordeY(j), null,Color.green);  
                   break;
               }
           
            }
 }
 //______________________________________________________________________________________
     public VentanaPrincipal() { 
        initComponents();
        jPanel2.setVisible(false);   
        jDialog1.setLocationRelativeTo(null);
        jPanel3.setVisible(false);
        this.setTitle(":::Proyecto Grafos:::");
    }    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialog1 = new javax.swing.JDialog();
        jFileChooser2 = new javax.swing.JFileChooser();
        jPanel1 = new javax.swing.JPanel();
        jmapa = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jtacumulado = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        NuevoGrafo = new javax.swing.JMenuItem();
        NuevoArco = new javax.swing.JMenuItem();
        Ejemplo = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        CaminoAmpl = new javax.swing.JMenuItem();
        CaminoProf = new javax.swing.JMenuItem();
        jSeparator4 = new javax.swing.JPopupMenu.Separator();
        BuscarAmplitud = new javax.swing.JMenuItem();
        BuscarProf = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        jMenuItem14 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jSeparator5 = new javax.swing.JPopupMenu.Separator();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        EliminarN = new javax.swing.JMenuItem();
        EliminarA = new javax.swing.JMenuItem();
        EliminarTA = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        ColoresITEM = new javax.swing.JMenuItem();

        jDialog1.setMinimumSize(new java.awt.Dimension(700, 450));
        jDialog1.setResizable(false);
        jDialog1.getContentPane().setLayout(null);

        jFileChooser2.setMaximumSize(new java.awt.Dimension(21475, 21474));
        jFileChooser2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFileChooser2ActionPerformed(evt);
            }
        });
        jDialog1.getContentPane().add(jFileChooser2);
        jFileChooser2.setBounds(10, 20, 670, 390);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("::::ProyectoGrafos::::");
        setResizable(false);
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(141, 141, 141));
        jPanel1.setBorder(javax.swing.BorderFactory.createMatteBorder(5, 5, 5, 5, new java.awt.Color(187, 134, 252)));
        jPanel1.setMinimumSize(new java.awt.Dimension(770, 522));
        jPanel1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jPanel1MouseMoved(evt);
            }
        });
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel1MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel1MousePressed(evt);
            }
        });
        jPanel1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jPanel1KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jPanel1KeyReleased(evt);
            }
        });
        jPanel1.setLayout(null);
        jPanel1.add(jmapa);
        jmapa.setBounds(0, 10, 760, 500);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(190, 10, 790, 520);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel2.setLayout(null);

        jButton2.setBackground(new java.awt.Color(0, 153, 153));
        jButton2.setForeground(new java.awt.Color(153, 153, 0));
        jButton2.setBorder(javax.swing.BorderFactory.createMatteBorder(40, 40, 40, 40, new java.awt.Color(102, 255, 255)));
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton2MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jButton2MouseReleased(evt);
            }
        });
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton2);
        jButton2.setBounds(10, 10, 20, 20);

        jButton3.setBackground(new java.awt.Color(204, 0, 204));
        jButton3.setForeground(new java.awt.Color(153, 153, 0));
        jButton3.setBorder(javax.swing.BorderFactory.createMatteBorder(40, 40, 40, 40, new java.awt.Color(102, 255, 255)));
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton3MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jButton3MouseReleased(evt);
            }
        });
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton3);
        jButton3.setBounds(40, 10, 20, 20);

        jButton4.setBackground(new java.awt.Color(189, 182, 182));
        jButton4.setForeground(new java.awt.Color(153, 153, 0));
        jButton4.setBorder(javax.swing.BorderFactory.createMatteBorder(40, 40, 40, 40, new java.awt.Color(102, 255, 255)));
        jButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton4MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton4MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jButton4MouseReleased(evt);
            }
        });
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton4);
        jButton4.setBounds(100, 10, 20, 20);

        jButton5.setBackground(new java.awt.Color(51, 0, 51));
        jButton5.setForeground(new java.awt.Color(153, 153, 0));
        jButton5.setBorder(javax.swing.BorderFactory.createMatteBorder(40, 40, 40, 40, new java.awt.Color(102, 255, 255)));
        jButton5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton5MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jButton5MouseReleased(evt);
            }
        });
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton5);
        jButton5.setBounds(10, 40, 20, 20);

        jButton6.setBackground(java.awt.Color.lightGray);
        jButton6.setForeground(new java.awt.Color(153, 153, 0));
        jButton6.setBorder(javax.swing.BorderFactory.createMatteBorder(40, 40, 40, 40, new java.awt.Color(102, 255, 255)));
        jButton6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton6MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jButton6MouseReleased(evt);
            }
        });
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton6);
        jButton6.setBounds(40, 40, 20, 20);

        jButton7.setBackground(new java.awt.Color(164, 167, 255));
        jButton7.setForeground(new java.awt.Color(153, 153, 0));
        jButton7.setBorder(javax.swing.BorderFactory.createMatteBorder(40, 40, 40, 40, new java.awt.Color(102, 255, 255)));
        jButton7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton7MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jButton7MouseReleased(evt);
            }
        });
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton7);
        jButton7.setBounds(70, 70, 20, 20);

        jButton8.setBackground(new java.awt.Color(141, 141, 141));
        jButton8.setForeground(new java.awt.Color(153, 153, 0));
        jButton8.setBorder(javax.swing.BorderFactory.createMatteBorder(40, 40, 40, 40, new java.awt.Color(102, 255, 255)));
        jButton8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton8MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jButton8MouseReleased(evt);
            }
        });
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton8);
        jButton8.setBounds(100, 40, 20, 20);

        jButton9.setBackground(new java.awt.Color(0, 0, 255));
        jButton9.setForeground(new java.awt.Color(153, 153, 0));
        jButton9.setBorder(javax.swing.BorderFactory.createMatteBorder(40, 40, 40, 40, new java.awt.Color(102, 255, 255)));
        jButton9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton9MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jButton9MouseReleased(evt);
            }
        });
        jPanel2.add(jButton9);
        jButton9.setBounds(100, 70, 20, 20);

        jButton10.setBackground(new java.awt.Color(153, 0, 0));
        jButton10.setForeground(new java.awt.Color(153, 153, 0));
        jButton10.setBorder(javax.swing.BorderFactory.createMatteBorder(40, 40, 40, 40, new java.awt.Color(102, 255, 255)));
        jButton10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton10MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jButton10MouseReleased(evt);
            }
        });
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton10);
        jButton10.setBounds(70, 10, 20, 20);

        jButton11.setBackground(new java.awt.Color(0, 102, 102));
        jButton11.setForeground(new java.awt.Color(153, 153, 0));
        jButton11.setBorder(javax.swing.BorderFactory.createMatteBorder(40, 40, 40, 40, new java.awt.Color(102, 255, 255)));
        jButton11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton11MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jButton11MouseReleased(evt);
            }
        });
        jPanel2.add(jButton11);
        jButton11.setBounds(40, 70, 20, 20);

        jButton12.setBackground(java.awt.Color.white);
        jButton12.setForeground(new java.awt.Color(153, 153, 0));
        jButton12.setBorder(javax.swing.BorderFactory.createMatteBorder(40, 40, 40, 40, new java.awt.Color(102, 255, 255)));
        jButton12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton12MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jButton12MouseReleased(evt);
            }
        });
        jPanel2.add(jButton12);
        jButton12.setBounds(70, 40, 20, 20);

        jButton13.setBackground(new java.awt.Color(0, 51, 51));
        jButton13.setForeground(new java.awt.Color(153, 153, 0));
        jButton13.setBorder(javax.swing.BorderFactory.createMatteBorder(40, 40, 40, 40, new java.awt.Color(102, 255, 255)));
        jButton13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton13MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jButton13MouseReleased(evt);
            }
        });
        jPanel2.add(jButton13);
        jButton13.setBounds(10, 70, 20, 20);

        jButton14.setText("OK");
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton14);
        jButton14.setBounds(30, 100, 60, 32);

        getContentPane().add(jPanel2);
        jPanel2.setBounds(40, 40, 130, 130);

        jLabel1.setFont(new java.awt.Font("DialogInput", 3, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setText("Victor Lavalle Estructura de Datos 4to Sem. UADY 2020");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(450, 530, 390, 20);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Acumulado"));
        jPanel3.setLayout(null);

        jtacumulado.setEnabled(false);
        jtacumulado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtacumuladoActionPerformed(evt);
            }
        });
        jPanel3.add(jtacumulado);
        jtacumulado.setBounds(10, 20, 110, 30);

        getContentPane().add(jPanel3);
        jPanel3.setBounds(30, 470, 130, 60);

        jLabel2.setFont(new java.awt.Font("Dialog", 3, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Para Crear Arco");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(50, 340, 100, 20);

        jLabel3.setFont(new java.awt.Font("Dialog", 3, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Click Izquierdo: Crear Nodo");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(20, 190, 160, 16);

        jLabel4.setFont(new java.awt.Font("Dialog", 3, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("F1: Cambiar Color de  Fondo ");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(20, 410, 170, 20);

        jLabel5.setFont(new java.awt.Font("Dialog", 3, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Seleccione 2 Nodos ");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(40, 320, 120, 20);

        jLabel6.setFont(new java.awt.Font("Dialog", 3, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Click Derecho: Seleccionar Nodo");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(0, 260, 190, 20);

        jLabel7.setBackground(new java.awt.Color(18, 18, 18));
        jLabel7.setOpaque(true);
        getContentPane().add(jLabel7);
        jLabel7.setBounds(1, -4, 990, 570);

        jMenuBar1.setBackground(new java.awt.Color(23, 31, 36));
        jMenuBar1.setForeground(new java.awt.Color(255, 255, 255));

        jMenu1.setForeground(new java.awt.Color(255, 255, 255));
        jMenu1.setText("Archivo");
        jMenu1.add(jSeparator1);

        NuevoGrafo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        NuevoGrafo.setText("Nuevo Grafo");
        NuevoGrafo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NuevoGrafoActionPerformed(evt);
            }
        });
        jMenu1.add(NuevoGrafo);

        NuevoArco.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        NuevoArco.setText("Nuevo Arco");
        NuevoArco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NuevoArcoActionPerformed(evt);
            }
        });
        jMenu1.add(NuevoArco);

        Ejemplo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_M, java.awt.event.InputEvent.CTRL_MASK));
        Ejemplo.setText("Mostar Ejemplo");
        Ejemplo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                EjemploMousePressed(evt);
            }
        });
        Ejemplo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EjemploActionPerformed(evt);
            }
        });
        jMenu1.add(Ejemplo);
        jMenu1.add(jSeparator3);

        CaminoAmpl.setText("Recorrido por Amplitud");
        CaminoAmpl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CaminoAmplActionPerformed(evt);
            }
        });
        jMenu1.add(CaminoAmpl);

        CaminoProf.setText("Recorrido por Profundidad");
        CaminoProf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CaminoProfActionPerformed(evt);
            }
        });
        jMenu1.add(CaminoProf);
        jMenu1.add(jSeparator4);

        BuscarAmplitud.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_B, java.awt.event.InputEvent.CTRL_MASK));
        BuscarAmplitud.setText("Buscar Nodo Por Amplitud");
        BuscarAmplitud.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BuscarAmplitudActionPerformed(evt);
            }
        });
        jMenu1.add(BuscarAmplitud);

        BuscarProf.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_B, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        BuscarProf.setText("Buscar Nodo Por Profundidad");
        BuscarProf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BuscarProfActionPerformed(evt);
            }
        });
        jMenu1.add(BuscarProf);
        jMenu1.add(jSeparator2);

        jMenuItem14.setText("Lista de Adyacencia");
        jMenuItem14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem14ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem14);

        jMenuItem7.setText("Matriz De adyacencia");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem7);
        jMenu1.add(jSeparator5);

        jMenuItem8.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem8.setText("Salir");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem8);

        jMenuBar1.add(jMenu1);

        jMenu2.setForeground(new java.awt.Color(255, 255, 255));
        jMenu2.setText("Eliminar");

        EliminarN.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.ALT_MASK));
        EliminarN.setText("Eliminar Nodo");
        EliminarN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EliminarNActionPerformed(evt);
            }
        });
        jMenu2.add(EliminarN);

        EliminarA.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.CTRL_MASK));
        EliminarA.setText("Eliminar Arco");
        EliminarA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EliminarAActionPerformed(evt);
            }
        });
        jMenu2.add(EliminarA);

        EliminarTA.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        EliminarTA.setText("Eliminar Todos Los Arcos");
        EliminarTA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EliminarTAActionPerformed(evt);
            }
        });
        jMenu2.add(EliminarTA);

        jMenuBar1.add(jMenu2);

        jMenu3.setForeground(new java.awt.Color(255, 255, 255));
        jMenu3.setText("Opciones ");

        ColoresITEM.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, 0));
        ColoresITEM.setText("Color");
        ColoresITEM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ColoresITEMActionPerformed(evt);
            }
        });
        jMenu3.add(ColoresITEM);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        setSize(new java.awt.Dimension(1007, 623));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jPanel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MousePressed
       int xxx, yyy;   
       String nombre;   
       xxx=evt.getX();
       yyy=evt.getY();
       if(evt.isMetaDown()){
           clicIzqSobreNodo(xxx, yyy );            
          if(nn==2){
              nn=0;
               RecorridoAnchura amplitud = new RecorridoAnchura(grafo,tope,permanente, nodoFin);
               amplitud.Recorrido();
               jtacumulado.setText(""+amplitud.getAcumulado());
           }
       }
       else{
       if(!cicDerechoSobreNodo(xxx,yyy)){// si  clik sobre  nodo es falso entra
          if(tope<50){
               grafo.setCordeX(tope,xxx);
               grafo.setCordeY(tope,yyy);
               grafo.setNombre(tope, tope);
              nombre = JOptionPane.showInputDialog("Ingrese Nombre del Nodo");
             Pintar.pintarCirculo(jPanel1.getGraphics(),grafo.getCordeX(tope), grafo.getCordeY(tope),String.valueOf(grafo.getNombre(tope))+" "+nombre);
           tope++;          
          } 
         else JOptionPane.showMessageDialog(null,"Se ha llegado al Maximo de nodos..");
       } 
         if(n==2 ){
             n=0; 
             int  ta = ingresarTamano("Ingrese Tamaño");
             if(aristaMayor < ta) aristaMayor=ta;
             grafo.setmAdyacencia(id2, id, 1);
             grafo.setmAdyacencia(id, id2, 1);
             grafo.setmCoeficiente(id2, id,ta );
             grafo.setmCoeficiente(id, id2, ta);
             Pintar.pintarLinea(jPanel1.getGraphics(),grafo.getCordeX(id), grafo.getCordeY(id), grafo.getCordeX(id2), grafo.getCordeY(id2), ta); 
             Pintar.pintarCirculo(jPanel1.getGraphics(),grafo.getCordeX(id), grafo.getCordeY(id),String.valueOf(grafo.getNombre(id))+" ");
             Pintar.pintarCirculo(jPanel1.getGraphics(),grafo.getCordeX(id2), grafo.getCordeY(id2),String.valueOf(grafo.getNombre(id2)));
              id=-1;
              id2=-1;
         }
        }
    }//GEN-LAST:event_jPanel1MousePressed

    private void EjemploMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EjemploMousePressed

    }//GEN-LAST:event_EjemploMousePressed

    private void EjemploActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EjemploActionPerformed
        //jMenuItem2.setEnabled(false);
        jPanel1.paint(jPanel1.getGraphics()); 
         n=0;
         id=-1;
         id2=-1;
            int Matriz[][]={{0,1,0,1,1,0,0,1},
                            {1,0,1,0,0,0,0,0},
                            {0,1,0,1,1,0,0,0},
                            {1,0,1,0,0,0,0,0},
                            {1,0,1,0,0,1,0,0},
                            {0,0,0,0,1,0,1,1},
                            {0,0,0,0,0,1,0,0},
                            {1,0,0,0,0,1,0,0}
                           };
          int coe[][]={{0,50,0,46,216,0,0,578}, 
               {50,0,59,0,0,0,0,0}, 
               {0,59,0,89,174,0,0,0},
               {46,0,89,0,0,0,0,0},
               {216,0,174,0,0,471,0,0} ,
               {0,0,0,0,471,0,194,398},  
               {0,0,0,0,0,194,0,0}, 
               {578,0,0,0,0,398,0,0},
  
  };
   int xx1[]={202,102,8,198,248,352,481,416};
  int yy1[]={12,74,165,113,233,300,368,177};
  int nom[]={0,1,2,3,4,5,6,7};          
        aristaMayor=600;       
        for (int j = 0; j < 8; j++) {
            grafo.setCordeX(j, xx1[j]);
            grafo.setCordeY(j, yy1[j]);
            grafo.setNombre(j, nom[j]);      
         
        }
        for (int j = 0; j < 8; j++) {            
            for (int k = 0; k < 8; k++) {
                grafo.setmAdyacencia(j,k, Matriz[j][k]);
                grafo.setmCoeficiente(j, k, coe[j][k]); 
            }
        }        
       tope=8;       
        R_repaint(tope,grafo);
    }//GEN-LAST:event_EjemploActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
      if(tope==0)
            JOptionPane.showMessageDialog(null,"Aun no se ha credo un nodo : ");
      else{
          this.setEnabled(false);
        new MatrizADY(tope,grafo,1,this).setVisible(true);
      }
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void NuevoArcoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NuevoArcoActionPerformed
       if(tope<=1)
            JOptionPane.showMessageDialog(null,"Cree nuevo nodo : ");
       
       else{
           this.setEnabled(false);
         new VentanaArista(grafo,pintar,tope,this).setVisible(true);
           jPanel1.paint(jPanel1.getGraphics());
           R_repaint(tope,grafo);        
       }
    }//GEN-LAST:event_NuevoArcoActionPerformed

    private void jPanel1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPanel1KeyPressed
     // TODO add your handling code here:

    }//GEN-LAST:event_jPanel1KeyPressed

    private void jPanel1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPanel1KeyReleased
     
    }//GEN-LAST:event_jPanel1KeyReleased

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
       System.exit(0);
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void NuevoGrafoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NuevoGrafoActionPerformed
      
         
          for (int j = 0; j < tope; j++) {
              grafo.setCordeX(j,0);
              grafo.setCordeY(j,0);              
              grafo.setNombre(j,0);            
        }
         for (int j = 0; j < tope; j++) {
             for (int k = 0; k < tope; k++) {
                 grafo.setmAdyacencia(j, k, 0);
                 grafo.setmCoeficiente(j, k, 0);                 
             }            
        }
        tope=00;   
        jPanel1.repaint(); 
       
    }//GEN-LAST:event_NuevoGrafoActionPerformed

    private void jPanel1MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseMoved
       // TODO add your handling code here:
    }//GEN-LAST:event_jPanel1MouseMoved

    private void EliminarAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EliminarAActionPerformed
    if(tope>=2){
        this.setEnabled(false);
      new EliminarAristas(pintar,grafo,tope,this).setVisible(true);
      jPanel1.paint(jPanel1.getGraphics());
      R_repaint(tope,grafo); 
    }
    else  JOptionPane.showMessageDialog(null,"No Hay Nodos Enlazados... ");
    
    }//GEN-LAST:event_EliminarAActionPerformed

    private void EliminarNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EliminarNActionPerformed
      int Eliminar= ingresarNodoOrigen("Ingrese el Num. de Nodo a Eliminar ","Nodo No existe",tope); 
 if(Eliminar<=tope && Eliminar>=0 && tope>0){
        for (int j = 0; j < tope; j++) {
            for (int k = 0; k < tope; k++){
                if(j==Eliminar ||k==Eliminar){
                    grafo.setmAdyacencia(j, k, -1);                    
                }
            }
        }
        for (int l = 0; l < tope-1; l++) {
                    for (int m = 0; m < tope; m++) {
                      if(grafo.getmAdyacencia(l, m)==-1){
                           grafo.setmAdyacencia(l, m,grafo.getmAdyacencia(l+1, m)); 
                           grafo.setmAdyacencia(l+1, m,-1);
                           grafo.setmCoeficiente(l, m,grafo.getmCoeficiente(l+1, m));
                      }
                  }
                }
                for (int l = 0; l < tope; l++) {
                    for (int m = 0; m < tope-1; m++) {
                
                     if(grafo.getmAdyacencia(l, m)==-1){
                           grafo.setmAdyacencia(l, m,grafo.getmAdyacencia(l, m+1)); 
                           grafo.setmAdyacencia(l, m+1,-1);
                           grafo.setmCoeficiente(l, m,grafo.getmCoeficiente(l, m+1));
                          
                     }
                    }
                }
                
                grafo.setCordeX(Eliminar,-10);
                grafo.setCordeY(Eliminar,-10);
                grafo.setNombre(Eliminar, -10);
                for (int j = 0; j < tope; j++) {
                    for (int k = 0; k < tope-1; k++) {
                        if(grafo.getCordeX(k)==-10){
                            grafo.setCordeX(k, grafo.getCordeX(k+1));
                            grafo.setCordeX(k+1, -10);
                            grafo.setCordeY(k, grafo.getCordeY(k+1));
                             grafo.setCordeY(k+1, -10);
                            grafo.setNombre(k, grafo.getNombre(k+1));
                            grafo.setNombre(k+1,-10);
                        }
                    }
               }
                for (int j = 0; j < tope; j++)                      
                grafo.setNombre(j,j);// renombramos             
                
                // eliminamos los -1 y  los -10 
                for (int j = 0; j < tope+1; j++) {
                    for (int k = 0; k < tope+1; k++) {
                       if( grafo.getmAdyacencia(j, k)!=-1)
                          grafo.setmAdyacencia(j, k, grafo.getmAdyacencia(j, k));
                       else 
                          grafo.setmAdyacencia(j, k, 0);                       
                       if(grafo.getmCoeficiente(j, k) !=-10)
                           grafo.setmCoeficiente(j, k, grafo.getmCoeficiente(j, k));
                       else
                           grafo.setmCoeficiente(j, k, 0);                        
                    }         
                }
                tope--;
                jPanel1.paint(jPanel1.getGraphics());
                R_repaint(tope,grafo);
       }    
    }//GEN-LAST:event_EliminarNActionPerformed

    private void EliminarTAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EliminarTAActionPerformed
       for (int j = 0; j < tope; j++) {
            for (int k = 0; k < tope; k++) {      
                    grafo.setmAdyacencia(j, k, 0);
                    grafo.setmAdyacencia(k, j, 0);
                    grafo.setmCoeficiente(j, k, 0);
                    grafo.setmCoeficiente(k, j, 0);
            }
        }
        jPanel1.paint(jPanel1.getGraphics());
        R_repaint(tope,grafo);
    }//GEN-LAST:event_EliminarTAActionPerformed

    private void jButton3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MousePressed
       jPanel1.setBackground(jButton3.getBackground());
       
    
    }//GEN-LAST:event_jButton3MousePressed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
      
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
      
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
   
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
     
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
      
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
      
    }//GEN-LAST:event_jButton7ActionPerformed
    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
    
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        jPanel2.setVisible(false);  // TODO add your handling code here:
    }//GEN-LAST:event_jButton14ActionPerformed

    private void ColoresITEMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ColoresITEMActionPerformed
        jPanel2.setVisible(true);// TODO add your handling code here:
    }//GEN-LAST:event_ColoresITEMActionPerformed

    private void jButton4MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseReleased
      R_repaint(tope,grafo);   // TODO add your handling code here:
    }//GEN-LAST:event_jButton4MouseReleased

    private void jButton4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseClicked
      // TODO add your handling code here:
    }//GEN-LAST:event_jButton4MouseClicked

    private void jButton4MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MousePressed
       jPanel1.setBackground(jButton4.getBackground());
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4MousePressed

    private void jButton2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MousePressed
       jPanel1.setBackground(jButton2.getBackground());
       // TODO add your handling code here:
    }//GEN-LAST:event_jButton2MousePressed

    private void jButton2MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseReleased
      R_repaint(tope,grafo);  // TODO add your handling code here:
    }//GEN-LAST:event_jButton2MouseReleased

    private void jButton3MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseReleased
      R_repaint(tope,grafo);        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3MouseReleased

    private void jButton10MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton10MousePressed
      jPanel1.setBackground(jButton10.getBackground());
       // TODO add your handling code here:
    }//GEN-LAST:event_jButton10MousePressed

    private void jButton10MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton10MouseReleased
    R_repaint(tope,grafo);        // TODO add your handling code here:
    }//GEN-LAST:event_jButton10MouseReleased

    private void jButton5MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton5MousePressed
     jPanel1.setBackground(jButton5.getBackground());
              // TODO add your handling code here:
    }//GEN-LAST:event_jButton5MousePressed

    private void jButton5MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton5MouseReleased
    R_repaint(tope,grafo);        // TODO add your handling code here:
    }//GEN-LAST:event_jButton5MouseReleased

    private void jButton7MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton7MousePressed
       jPanel1.setBackground(jButton7.getBackground());
             // TODO add your handling code here:
    }//GEN-LAST:event_jButton7MousePressed

    private void jButton7MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton7MouseReleased
     R_repaint(tope,grafo);        // TODO add your handling code here:
    }//GEN-LAST:event_jButton7MouseReleased

    private void jButton8MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton8MousePressed
jPanel1.setBackground(jButton8.getBackground());        // TODO add your handling code here:
    }//GEN-LAST:event_jButton8MousePressed

    private void jButton8MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton8MouseReleased
     R_repaint(tope,grafo);  // TODO add your handling code here:
    }//GEN-LAST:event_jButton8MouseReleased

    private void jButton6MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton6MousePressed
      jPanel1.setBackground(jButton6.getBackground());  // TODO add your handling code here:
    }//GEN-LAST:event_jButton6MousePressed

    private void jButton6MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton6MouseReleased
       R_repaint(tope,grafo);        // TODO add your handling code here:
    }//GEN-LAST:event_jButton6MouseReleased

    private void jButton13MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton13MousePressed
      jPanel1.setBackground(jButton13.getBackground());  // TODO add your handling code here:
    }//GEN-LAST:event_jButton13MousePressed

    private void jButton11MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton11MousePressed
      jPanel1.setBackground(jButton11.getBackground());        // TODO add your handling code here:
    }//GEN-LAST:event_jButton11MousePressed

    private void jButton12MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton12MouseReleased
       R_repaint(tope,grafo);        // TODO add your handling code here:
    }//GEN-LAST:event_jButton12MouseReleased

    private void jButton9MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton9MousePressed
      jPanel1.setBackground(jButton9.getBackground());     // TODO add your handling code here:
    }//GEN-LAST:event_jButton9MousePressed

    private void jButton12MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton12MousePressed
       jPanel1.setBackground(jButton12.getBackground()); // TODO add your handling code here:
    }//GEN-LAST:event_jButton12MousePressed

    private void jButton11MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton11MouseReleased
       R_repaint(tope,grafo);  // TODO add your handling code here:
    }//GEN-LAST:event_jButton11MouseReleased

    private void jButton9MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton9MouseReleased
     R_repaint(tope,grafo);        // TODO add your handling code here:
    }//GEN-LAST:event_jButton9MouseReleased

    private void jButton13MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton13MouseReleased
       R_repaint(tope,grafo);        // TODO add your handling code here:
    }//GEN-LAST:event_jButton13MouseReleased

    private void CaminoAmplActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CaminoAmplActionPerformed
if(tope==0)
            JOptionPane.showMessageDialog(null,"Aun no se ha credo un nodo : ");
      else{
          this.setEnabled(false);
        new rAmplitud(tope,grafo,1,this).setVisible(true);
      }
    }//GEN-LAST:event_CaminoAmplActionPerformed

    private void jPanel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel1MouseClicked

    private void jtacumuladoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtacumuladoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtacumuladoActionPerformed

    private void jFileChooser2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFileChooser2ActionPerformed

    }//GEN-LAST:event_jFileChooser2ActionPerformed

    private void jMenuItem14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem14ActionPerformed
if(tope==0)
            JOptionPane.showMessageDialog(null,"Aun no se ha credo un nodo : ");
      else{
          this.setEnabled(false);
        new ListaADY(tope,grafo,1,this).setVisible(true);
      }
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem14ActionPerformed

    private void BuscarAmplitudActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BuscarAmplitudActionPerformed
 if(tope>=2){
          long inicio = System.currentTimeMillis();
          permanente =  0;
          nodoFin =  ingresarNodoOrigen("Ingrese el Num de Nodo a Buscar:","El Nodo no Existe en el Grafo",tope);
            RecorridoAnchura amplitud = new RecorridoAnchura(grafo,tope,permanente,nodoFin);
            amplitud.Recorrido();
            long fin = System.currentTimeMillis();
            double tiempo = (double) ((fin - inicio)/1000);
             JOptionPane.showMessageDialog(null, "El Nodo Se Encuentre en el Grafo\n  Tiempo de Búsqueda: "+tiempo+"ms", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            jtacumulado.setText(""+amplitud.getAcumulado());
        }
 else{
     JOptionPane.showMessageDialog(null, "El Nodo No Se Encuentra en el Grafo", "Error", JOptionPane.WARNING_MESSAGE);
 }

        // TODO add your handling code here:
    }//GEN-LAST:event_BuscarAmplitudActionPerformed

    private void BuscarProfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BuscarProfActionPerformed
 if(tope>=2){
          long inicio = System.currentTimeMillis();
          permanente =  0;
          nodoFin =  ingresarNodoOrigen("Ingrese el Num de Nodo a Buscar:","El Nodo no Existe en el Grafo",tope);
            RecorridoProfundidad profundidad = new RecorridoProfundidad(grafo,tope,permanente,nodoFin);
            profundidad.Recorrido();
            long fin = System.currentTimeMillis();
            double tiempo = (double) ((fin - inicio)/1000)+.03;
             JOptionPane.showMessageDialog(null, "El Nodo Se Encuentre en el Grafo\n  Tiempo de Búsqueda: "+tiempo+"ms", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            jtacumulado.setText(""+profundidad.getAcumulado());
        }
 else{
     JOptionPane.showMessageDialog(null, "El Nodo No Se Encuentra en el Grafo", "Error", JOptionPane.WARNING_MESSAGE);
 }
    }//GEN-LAST:event_BuscarProfActionPerformed

    private void CaminoProfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CaminoProfActionPerformed
if(tope==0)
            JOptionPane.showMessageDialog(null,"Aun no se ha credo un nodo : ");
      else{
          this.setEnabled(false);
        new rProfundidad(tope,grafo,1,this).setVisible(true);
      }        // TODO add your handling code here:
    }//GEN-LAST:event_CaminoProfActionPerformed

    /**
     * @param args the command line arguments
     */
 public static void main(String args[]) {        
        
    }
    private int tope=0;// lleva el # de nodos creado 
    private int nodoFin;
    private int permanente;
    int n=0,nn=0,id,id2;// permite controlar que se halla dado click sobre un nodo
    private int aristaMayor;
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem BuscarAmplitud;
    private javax.swing.JMenuItem BuscarProf;
    private javax.swing.JMenuItem CaminoAmpl;
    private javax.swing.JMenuItem CaminoProf;
    private javax.swing.JMenuItem ColoresITEM;
    private javax.swing.JMenuItem Ejemplo;
    private javax.swing.JMenuItem EliminarA;
    private javax.swing.JMenuItem EliminarN;
    private javax.swing.JMenuItem EliminarTA;
    private javax.swing.JMenuItem NuevoArco;
    private javax.swing.JMenuItem NuevoGrafo;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JFileChooser jFileChooser2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem14;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    public static javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JPopupMenu.Separator jSeparator4;
    private javax.swing.JPopupMenu.Separator jSeparator5;
    private javax.swing.JLabel jmapa;
    private javax.swing.JTextField jtacumulado;
    // End of variables declaration//GEN-END:variables
}

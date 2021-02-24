package Dibujo;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;
/**
 * @author Victor Lavalle
 */
public class Dibujo extends JFrame {
     public void Graficar(JPanel chartpanel){
        chartpanel.setPreferredSize(new  java.awt.Dimension(500,500));
        this.setSize(500, 607);
        this.setLocation(800,80);
        this.setContentPane(chartpanel);
        this.setVisible(true);
        this.setBackground(Color.GRAY);
        this.setTitle(":::Representación Gráfica:::");
    }
    
}

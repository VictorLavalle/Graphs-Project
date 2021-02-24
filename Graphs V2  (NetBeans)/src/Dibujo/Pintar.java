package Dibujo;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
/**
 * @author Victor Lavalle
 */
public class Pintar extends JPanel{

    private Grados grados;
    private final int targetline = 15;

    public void setGrados(Grados grados) {
        this.grados = grados;
        repaint();
    }
    
//_______________________________________________________
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        pintar(g, grados.coordenadas(grados.grados()));
    }
    
 //_______________________________________________________
    public void pintar(Graphics g, PintarNodo[] gradosNodo) {
        if (grados.numV==0) {
            JOptionPane.showMessageDialog(null, "No existen nodos", "Advertencia", JOptionPane.WARNING_MESSAGE);
        } else {
            for (PintarNodo gradosNodo1 : gradosNodo) {
                
                g.setColor(Color.BLUE);
                ((Graphics2D)g).setStroke(new BasicStroke(2));//leda el grosor al circulo  
                g.fillOval(gradosNodo1.getX(), gradosNodo1.getY(), grados.radio * 2, grados.radio * 2);
                
                g.setColor(Color.BLACK);
                g.drawOval(gradosNodo1.getX(), gradosNodo1.getY(), grados.radio * 2, grados.radio * 2);
                
                g.setColor(Color.ORANGE);
                Font fuente=new Font("Monospaced",Font.BOLD, 16);
                g.setFont(fuente);
                
                g.drawString(gradosNodo1.getName(), gradosNodo1.getX() + 10, gradosNodo1.getY() + 35);
            }
            for (int i = 0; i < grados.numV; i++) {
                for (int j = 0; j < grados.numV; j++) {
                    if (grados.adyacencia[i][j] == 1) {
                        int x1 = gradosNodo[i].getX()+grados.radio;
                        int x2 = gradosNodo[j].getX()+grados.radio;
                        int y1 = gradosNodo[i].getY()+grados.radio;
                        int y2 = gradosNodo[j].getY()+grados.radio;
                        double gradosPuntos = calcularDireccion(x1, y1, x2, y2);
                        int[] graph2 = point(gradosPuntos, x2, y2, grados.radio);
                        int[] puntos = points(gradosPuntos, graph2[0], graph2[1], 15);
                        g.setColor(Color.GREEN);
                        g.drawLine(puntos[0], puntos[1], graph2[0], graph2[1]);
                        g.drawLine(puntos[2], puntos[3], graph2[0], graph2[1]);
                        if(gradosPuntos>=180){
                            gradosPuntos -= 180;
                        }else{
                            gradosPuntos += 180;
                        }
                        int[] graph1 = point(gradosPuntos, x1, y1, grados.radio);
                        g.drawLine(graph1[0], graph1[1], graph2[0], graph2[1]);
                    }
                }
            }
        }
    }
    
//_______________________________________________________
    public double calcularDireccion(int x1, int y1, int x2, int y2) {
        double gradosPuntos;
        if(x1<=x2){
            if(y1<=y2){
                gradosPuntos = 180 - Math.toDegrees(Math.atan2((y2-y1),(x2-x1)));
            }else{
                gradosPuntos = 180 + Math.toDegrees(Math.atan2((y1-y2),(x2-x1)));
            }
        }else{
            if(y1<=y2){
                gradosPuntos = Math.toDegrees(Math.atan2((y2-y1),(x1-x2)));
            }else{
                gradosPuntos = 360-Math.toDegrees(Math.atan2((y1-y2),(x1-x2)));
            }
        }
        return gradosPuntos;
    }

//_______________________________________________________
    private int[] points(double gradosPunto, int Xorigen, int Yorigen, int apertura){
        int[] puntos = new int[4];
        puntos[0] = (int)grados.calcularX(gradosPunto-apertura, targetline, Xorigen);
        puntos[1] = (int)grados.calcularY(gradosPunto-apertura, targetline, Yorigen);
        puntos[2] = (int)grados.calcularX(gradosPunto+apertura, targetline, Xorigen);
        puntos[3] = (int)grados.calcularY(gradosPunto+apertura, targetline, Yorigen);
        return puntos;
    }
    
//_______________________________________________________
    private int[] point(double gradoPunto, int Xorigen, int Yorigen, int distancia){
        int[] punto = new int[2];
        punto[0] = (int)grados.calcularX(gradoPunto, distancia, Xorigen);
        punto[1] = (int)grados.calcularY(gradoPunto, distancia, Yorigen);
        return punto;
    }
}

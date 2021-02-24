package Metodos;

import java.awt.*;
import java.awt.geom.AffineTransform;
/**
 * @author fredy_000
 */

//Metodo para poder dibujar en el canvas
public class Pintar {   
    Color color;
      private final int RADIO = 40;
      private final int ARR_SIZE = 7;
     //Constructor de la buena suerte
    public Pintar(){      }
    
   public static void pintarCirculo(Graphics g,int x,int y,String n){
       ((Graphics2D)g).setColor(Color.blue);
        ((Graphics2D)g).setStroke(new BasicStroke(4));//leda el grosor al circulo        
        ((Graphics2D)g).fillOval(x, y, 15, 15);        
        ((Graphics2D)g).setColor(Color.BLACK);
        ((Graphics2D)g).drawOval(x, y, 15, 15);
        ((Graphics2D)g).setColor(Color.ORANGE);
        Font fuente=new Font("Monospaced",Font.BOLD, 16);
        g.setFont(fuente);
        ((Graphics2D)g).drawString(n, x, y);
    }    
 
   
  public static void pintarLinea(Graphics g, int x1,int y1,int x2,int y2,int tam){
        int xAux = 0; int yAux = 0; 
        ((Graphics2D)g).setRenderingHint(RenderingHints.KEY_ANTIALIASING,  RenderingHints.VALUE_ANTIALIAS_ON);
        BasicStroke stroke = new BasicStroke(2);
        ((Graphics2D)g).setStroke(stroke);         
       ((Graphics2D)g).drawLine(x1+10, y1+10, x2+10, y2+10);
       if(x1<=x2)
           xAux=((x2-x1)/2)+x1;       
        if(x1>x2)
           xAux=((x1-x2)/2)+x2;
        if(y1<y2)
           yAux=((y2-y1)/2)+y1;
        if(y1>=y2)
            yAux=((y1-y2)/2)+y2;        

        Font fuente=new Font("Monospaced",Font.PLAIN, 12);
        g.setFont(fuente);
      ((Graphics2D)g).drawString(String.valueOf(tam), xAux, yAux);
  }   
  
  
  public static void pintarCamino(Graphics g, int x1,int y1,int x2,int y2, Color color){
      ((Graphics2D)g).setRenderingHint(RenderingHints.KEY_ANTIALIASING,  RenderingHints.VALUE_ANTIALIAS_ON);
        BasicStroke stroke = new BasicStroke(2);
        ((Graphics2D)g).setStroke(stroke);
        g.setColor(color);
        g.drawLine(x1+10, y1+10, x2+10, y2+10);
  }
  
  
   public static void clickSobreNodo(Graphics g,int x,int y,String n,Color co){
       ((Graphics2D)g).setColor(co);
        ((Graphics2D)g).setStroke(new BasicStroke(4));//leda el grosor al circulo        
        ((Graphics2D)g).fillOval(x, y, 15, 15);        
        ((Graphics2D)g).setColor(Color.BLACK);
        ((Graphics2D)g).drawOval(x, y, 15, 15);
         
    }
   
    private void drawArrow(Graphics g1, int x1, int y1, int x2, int y2) {

        Graphics2D g = (Graphics2D) g1.create();
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        g.setColor(Color.GREEN);

        double dx = x2 - x1, dy = y2 - y1;

        double angle = Math.atan2(dy, dx);

        int y = (int) ((RADIO / 2 + 7) * Math.sin(angle));
        int x = (int) ((RADIO / 2 + 7) * Math.cos(angle));
        dx = x2 - (x + x1);
        dy = y2 - (y + y1);
        int len = (int) (Math.sqrt(dx * dx + dy * dy)) - (RADIO / 2 + 7);

        AffineTransform at = AffineTransform.getTranslateInstance(x + x1, y + y1);
        at.concatenate(AffineTransform.getRotateInstance(angle));
        g.transform(at);

        // Draw horizontal arrow starting in (0, 0)
        g.drawLine(0, 0, len, 0);
        g.fillPolygon(new int[]{len, len - ARR_SIZE, len - ARR_SIZE, len},
                new int[]{0, -ARR_SIZE, ARR_SIZE, 0}, 4);
    }
   
   
   
}

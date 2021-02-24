package Metodos;

import Modelo.Grafos;
import Modelo.Nodo;
import static Vistas.VentanaPrincipal.jPanel1;
import static Vistas.VentanaPrincipal.R_repaint;
import java.awt.Color;
import javax.swing.JOptionPane;

/**
 * @author Victor Lavalle
 */
public class RecorridoProfundidad {
   private final  Grafos grafo;
   private int subTope;
   private Nodo auxi=null;
   private int auxAumulado; // es un acumulado auxiliar
   private int subAcomulado;
   private final Nodo nodo[]; 
   private final int tope;
   private int permanente;     
   private final int nodoFin; 
   
   //Constructor
    public RecorridoProfundidad (Grafos grafo, int tope,int permanente, int nodoFin){
        this.grafo = grafo;        
        this.tope = tope;
        this.nodo= new Nodo[tope]; 
        this.permanente = permanente;
        this.nodoFin = nodoFin;
    }

    public int getAcumulado(){return nodo[nodoFin].getAcumulado(); }
        
    public void Recorrido(){ 
         for (int i = 0; i < tope; i++)  // creamos el vector nodo del tamaño de tope el cual tiene el numero de nodo pintados 
                    nodo[i]= new Nodo(); 
         
        if(permanente != nodoFin){
             jPanel1.paint(jPanel1.getGraphics());
             R_repaint(tope, grafo);   
             Pintar.clickSobreNodo(jPanel1.getGraphics(), grafo.getCordeX(permanente), grafo.getCordeY(permanente), null,Color.GREEN); // pinta de color GREEN los nodos
            nodo[permanente].setVisitado(true);        
            nodo[permanente].setNombre(permanente);       
            
            do{            
              subAcomulado=0;
              auxAumulado = 2000000000; // lo igualamos a esta cifra ya q el acomulado de los nodos, supuestamente  nunca sera mayor 
              nodo[permanente].setEtiqueta(true); 
              for (int j = 0; j < tope; j++) {
                  if(grafo.getmAdyacencia(j, permanente)==1){
                        subAcomulado= nodo[permanente].getAcumulado()+grafo.getmCoeficiente(j, permanente);                                 
                        if(subAcomulado <= nodo[j].getAcumulado() && nodo[j].isVisitado()==true && nodo[j].isEtiqueta()== false){
                            nodo[j].setAcumulado(subAcomulado);
                            nodo[j].setVisitado(true);
                            nodo[j].setNombre(j);
                            nodo[j].setPredecesor(nodo[permanente]);
                        }
                        else if( nodo[j].isVisitado()==false){
                            nodo[j].setAcumulado(subAcomulado);
                            nodo[j].setVisitado(true);
                            nodo[j].setNombre(j);
                            nodo[j].setPredecesor(nodo[permanente]); 
                       }
                 }
              }
              for (int i = 0; i <tope; i++) { // buscamos cual de los nodos visitado tiene el acomulado menor par escogerlo como permanente 
                if(nodo[i].isVisitado()== true && nodo[i].isEtiqueta()== false){
                   if(nodo[i].getAcumulado()<=auxAumulado){
                       permanente= nodo[i].getNombre();
                       auxAumulado= nodo[i].getAcumulado();
                   }
                }               
             }
            subTope++;                
          }while(subTope<tope+1);          
          auxi= nodo[nodoFin]; 
           if(auxi.getPredecesor() == null )
             JOptionPane.showMessageDialog(null,"No se Pudo LLegar Al Nodo "+nodoFin);          
          while(auxi.getPredecesor() != null){           
            //  Pintar.pintarCamino(jPanel1.getGraphics(), grafo.getCordeX(auxi.getNombre()), grafo.getCordeY(auxi.getNombre()), grafo.getCordeX(auxi.getPredecesor().getNombre()), grafo.getCordeY(auxi.getPredecesor().getNombre()),Color.GREEN);
              Pintar.clickSobreNodo(jPanel1.getGraphics(), grafo.getCordeX(auxi.getNombre()), grafo.getCordeY(auxi.getNombre()), null,Color.GREEN);
             auxi=auxi.getPredecesor();              
          }  
         Pintar.clickSobreNodo(jPanel1.getGraphics(), grafo.getCordeX(nodoFin), grafo.getCordeY(nodoFin), null,Color.GREEN);     
       }
       else Pintar.clickSobreNodo(jPanel1.getGraphics(), grafo.getCordeX(nodoFin), grafo.getCordeY(nodoFin), null,Color.GREEN);    
    }
  
    
 
}

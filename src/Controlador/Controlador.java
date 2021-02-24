package Controlador;

import Modelo.MatrizAdyacencia.*;
import Modelo.ListaAdyacencia.*;
import Dibujo.*;
import Excepciones.*;
import Vista.*;
import javax.swing.JOptionPane;
/**
 * @author Victor Lavalle
 */
public class Controlador {
    private GUI interfaz;
    private MatrizAd Matriz;
    private ListaAdyacencia Lista;
    private Dibujo dibujo;
    
    //Metodos Get & Set
    public Dibujo getDibujo() { return dibujo; }
    public GUI getInterfaz() { return interfaz;}
    public MatrizAd getMatriz() { return Matriz; }
    public ListaAdyacencia getLista() { return Lista;}  
   
    public void setDibujo(Dibujo dibujo) {this.dibujo = dibujo;}
    public void setInterfaz(GUI interfaz) { this.interfaz = interfaz;}
    public void setMatriz(MatrizAd Matriz) {this.Matriz = Matriz;  }
    public void setLista(ListaAdyacencia Lista) { this.Lista = Lista; }
 
//Funciones
//____________________________________________________________
    public void escribir(){
        String Representacion=this.Matriz.Matriz();
        Representacion+="\n";
        Representacion+=this.Lista.lista();
        this.interfaz.getRepresentacionTA().setText(Representacion);
    }
//____________________________________________________________  
    public void NuevoNodo(String nodo){
        try{
        this.Matriz.nuevo_vertice(nodo);
        this.Lista.nuevo_vertice(nodo);
        }
        catch(NodoExistente e){
      JOptionPane.showMessageDialog(null,e.getMessage(), "Advertencia", JOptionPane.WARNING_MESSAGE);  
        }
         Actualizar();
    }
    
//____________________________________________________________
    public void BorrarNodo(String nodo){
        try{
        this.Matriz.borra_vertice(nodo);
        this.Lista.borra_vertice(nodo);
         JOptionPane.showMessageDialog(null,"Vértice Eliminado Satisfactoriamente"); 
        }
        catch(NodoNoExistente e){     
   JOptionPane.showMessageDialog(null,e.getMessage(), "Advertencia", JOptionPane.WARNING_MESSAGE);     
        }
         Actualizar();
    }
    
//____________________________________________________________
    public void NuevoArco(String Nodo1,String Nodo2){
        try{  
        this.Matriz.union(Nodo1, Nodo2);
        this.Lista.union(Nodo1, Nodo2);
        }
        catch(NodoNoExistente e){      
  JOptionPane.showMessageDialog(null,e.getMessage(), "Advertencia", JOptionPane.WARNING_MESSAGE);   
        }
         Actualizar();
    }
    
//____________________________________________________________   
    public void BorrarArco(String Nodo1,String Nodo2){
        try{
        this.Matriz.Borrar_arco(Nodo1, Nodo2);
        this.Lista.Borrar_arco(Nodo1, Nodo2);
        JOptionPane.showMessageDialog(null,"Arco Eliminado Exitosamente"); 
        }
        catch(NodoNoExistente | ArcoNoExiste e){
         JOptionPane.showMessageDialog(null,e.getMessage(), "Advertencia", JOptionPane.WARNING_MESSAGE);   
        }
        Actualizar();
    }
    
//____________________________________________________________
    public void Adyacente(String Nodo1,String Nodo2){
        try{
         if( this.Matriz.Adyacente(Nodo1, Nodo2) && this.Lista.Adyacente(Nodo1, Nodo2)){
             System.out.println(this.Matriz.Adyacente(Nodo1, Nodo2) );
             System.out.println(this.Lista.Adyacente(Nodo1, Nodo2));
             JOptionPane.showMessageDialog(null,"Los Nodos Son Adyacentes"); 
         }
         else{
             JOptionPane.showMessageDialog(null,"Los Nodos No Son Adyacentes");
         }     
        }
        catch(NodoNoExistente e){
          JOptionPane.showMessageDialog(null,e.getMessage());    
        }
    }

//____________________________________________________________  
    public void Buscar(String buscar){
        if(this.interfaz.getAmplitudRB().isSelected()){
            if(this.Matriz.buscarAmplitud(buscar)&&this.Lista.buscarAmplitud(buscar)){
                JOptionPane.showMessageDialog(null, "El Elemento Esta en el Grafo");
             }
            else{
                JOptionPane.showMessageDialog(null, "El Elemento No Esta en el Grafo");   
            }
        }
        if(this.interfaz.getProfundidadRB().isSelected()){
             if(this.Matriz.buscarProfundidad(buscar)&& this.Lista.buscarProfundidad(buscar)){
                JOptionPane.showMessageDialog(null, "El Elemento Esta en el Grafo");
             }
             else{
                JOptionPane.showMessageDialog(null, "El Elemento No Esta en el Grafo");  
            }
        }
    }
    
//____________________________________________________________    
    public void Recorrer(){
        if(this.interfaz.getAmplitudRB().isSelected()){
        this.Matriz.recorrerAmplitud();
        this.interfaz.getRecorrerMatrizTA1().setText(this.Matriz.Recorrido);
        this.Lista.recorrerAmplitud();
        this.interfaz.getRecorrerListaTA().setText(this.Lista.Recorrido);
         }  
        
        if(this.interfaz.getProfundidadRB().isSelected()){
        this.Matriz.recorrerProfundidad();
        this.interfaz.getRecorrerMatrizTA1().setText(this.Matriz.Recorrido);
        this.Lista.recorrerProfundidad();
        this.interfaz.getRecorrerListaTA().setText(this.Lista.Recorrido);
        }
    }
    
//____________________________________________________________
      public void Actualizar(){
          Grados d = new Grados(this.Matriz.getVertices(),this.Matriz.getMatrizAd(),this.Matriz.getNumVer());
          Pintar p = new Pintar();
          p.setGrados(d);
//        JPanel panel = interfaz.getjPanel2();
//        panel.removeAll();
//        panel.add(p);
         this.dibujo.Graficar(p);
      }
}
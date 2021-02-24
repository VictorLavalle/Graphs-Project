package Modelo;
/**
 * @author Victor Lavalle
 */
public class Nodo {    
   private  int nombre ;
   private boolean visitado, etiqueta ;
   private int acumulado; // lleva el acoulado de cada nodo
   private Nodo Predecesor;

   //Constructor
   public Nodo(){
       this.nombre =-1;
       this.visitado = false;
       this.etiqueta = false;
       this.Predecesor  = null;
       this.acumulado =0;  
   }
   
//Metodos Get & Set
    public int getNombre() {return nombre;   }
    public boolean isVisitado() {return visitado; }
    public boolean isEtiqueta() { return etiqueta;}
    public int getAcumulado() { return acumulado;}
    public Nodo getPredecesor() {return Predecesor;}

    public void setNombre(int nombre) { this.nombre = nombre; }
    public void setVisitado(boolean visitado) { this.visitado = visitado;}
    public void setEtiqueta(boolean etiqueta) { this.etiqueta = etiqueta; }
    public void setAcumulado(int acomulado) {this.acumulado = acomulado;}
    public void setPredecesor(Nodo Predecesor) { this.Predecesor = Predecesor;}    
}

package Modelo;

import java.util.ArrayList;

/**
 * @author Victor Lavalle
 */
public class Grafos {
   private final int mCoeficiente[][] = new int [51][51];
   private final int mAdyacencia [][] = new int [51][51];
   public ArrayList<Nodo>Vertices;
   private final int cordeX [] = new int [51];
   private final int cordeY [] = new int [51];
   private final int nombre [] = new int [51];
   private int enArbol [];
   private int index;
   //Constructor de la buena suerte uwu
   public Grafos(){ }

   //Metodos Get & Set
    public int getmCoeficiente(int i, int j ) {return mCoeficiente[i][j]; }
    public int getmAdyacencia(int i,int j) {return mAdyacencia[i][j]; }
    public int getCordeX(int i) { return cordeX[i];}
    public int getCordeY(int i) {return cordeY[i]; }
    public int getNombre(int i) { return nombre[i];}
    public int getEnArbol(int i) { return enArbol[i]; }
    public ArrayList<Nodo> getVertices() { return Vertices; }
    public int getIndex() { return index; }
    
    
    public void setmCoeficiente(int i,int j ,int mCoeficiente) { this.mCoeficiente[i][j] = mCoeficiente;  }
    public void setmAdyacencia(int i,int j ,int mAdyacencia) { this.mAdyacencia[i][j] = mAdyacencia; }
    public void setCordeX(int i,int cordeX) { this.cordeX[i] = cordeX; }
    public void setCordeY(int i, int cordeY) { this.cordeY[i] = cordeY; }
    public void setNombre(int i,int nombre) { this.nombre[i] = nombre;}
    public void setEnArbol(int i,int enArbol) {this.enArbol[i] = enArbol;  }
    public void crearEnArbol(int i){enArbol = new int [i];  }  
    public void setVertices(ArrayList<Nodo> Vertices) { this.Vertices = Vertices;  }
    public void setIndex(int index) {  this.index = index; }

}

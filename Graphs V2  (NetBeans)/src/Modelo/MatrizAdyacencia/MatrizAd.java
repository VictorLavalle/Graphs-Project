package Modelo.MatrizAdyacencia;

import Excepciones.*;
import Modelo.Grafo;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
/**
 * @author Victor Lavalle
 */
public class MatrizAd implements Grafo {
    
    private NodoMA [] vertices;
    private int numVer;
    private int [][] matrizAd;
    private final int tam;
    static final int max= 15;  //Numero maximo de nodos permitidos
    public String Recorrido="";
    
    //Constructor
    public MatrizAd() {
        this.vertices = new NodoMA[max];
        this.matrizAd= new int [max][max];
        for(int i=0;i<max;i++){
             for(int j=0;j<max;j++){
                  this.matrizAd[i][j]=0;
                }
        }
        this.tam=max;
        this.numVer = 0; 
    }

    //Metodos Get & Set
    public NodoMA[] getVertices() { return vertices; }
    public int getNumVer() {return numVer; }
    public int[][] getMatrizAd() { return matrizAd; }
    
    public void setVertices(NodoMA[] vertices) {this.vertices = vertices;}
    public void setNumVer(int numVer) {this.numVer = numVer;}
    public void setMatrizAd(int[][] matrizAd) { this.matrizAd = matrizAd;}
 
//Funciones
//____________________________________________________________
    public boolean NodoExiste(NodoMA x){
        for (int i=0;i<this.numVer;i++){
             if (this.vertices[i].getDato().equals(x.getDato())){
                 x.setNum(this.vertices[i].getNum());
         return true;
        }
     }
       return false;
    }
    
//____________________________________________________________
    @Override
    public void Borrar_arco(Object x, Object y) throws NodoNoExistente,ArcoNoExiste {
    
     NodoMA nodo1 = new NodoMA(x);
     NodoMA nodo2 = new NodoMA(y);
       if (NodoExiste(nodo1)&& NodoExiste(nodo2)){
            if (Adyacente(x,y)){
                this.matrizAd[nodo1.getNum()][nodo2.getNum()]=0;
             }
            else{
               throw new ArcoNoExiste("El Arco No Existe"); 
            }
       }
       else{
        throw new NodoNoExistente("Nodo No Existe");
       } 
    }    
    
//____________________________________________________________
    @Override
    public boolean Adyacente(Object x, Object y) throws NodoNoExistente {
     NodoMA nodo1 = new NodoMA(x);
     NodoMA nodo2 = new NodoMA(y);
       if (NodoExiste(nodo1)&& NodoExiste(nodo2)){
           if(this.matrizAd[nodo1.getNum()][nodo2.getNum()]==1)
              return true; 
       }
       else{
        throw new NodoNoExistente("Nodo No Existe");
       } 
        return false;
    }
    
//____________________________________________________________
    @Override
    public void nuevo_vertice(Object x) throws NodoExistente{
        if(this.vertices.length==this.numVer){
            System.out.println("Vector Lleno");
            JOptionPane.showMessageDialog(null, "Ha Execedido el Maximo vertices");
           return;
        }
        NodoMA Nodo = new NodoMA(x);
        if (!NodoExiste(Nodo)){
          Nodo.setNum(numVer);
          this.vertices[numVer]=Nodo;
          this.numVer++;
        }
        else{
            throw new NodoExistente("Ya existe el Nodo");
        }
    }
    
//____________________________________________________________
    @Override
    public void borra_vertice(Object x) throws NodoNoExistente {
        if(this.numVer==0){
            System.out.println("Vector Vacio");
            JOptionPane.showMessageDialog(null, "No hay vertices");
           return;
        }
        NodoMA nodo = new NodoMA(x);
        if (NodoExiste(nodo)){
         int index=nodo.getNum(); 
          this.numVer--;   
         for(int i=0;i<this.numVer+1;i++){
            for(int j=index;j<this.numVer;j++){
             this.matrizAd[i][j]= this.matrizAd[i][j+1];
            }
         }
 
          for(int i=index;i<this.numVer;i++){
             System.arraycopy(this.matrizAd[i+1], 0, this.matrizAd[i], 0, this.numVer+1);
         }
          
         for(int i=index;i<this.numVer;++i){
             this.vertices[i]= this.vertices[i+1];
             this.vertices[i].setNum(i);
         }

         for(int i=this.numVer;i<this.vertices.length;i++){
            for(int j=0;j<this.vertices.length;j++){
                this.matrizAd[i][j]=0;
                this.matrizAd[j][i]=0;
            }
         }
        }
        else{   
            throw new NodoNoExistente("El nodo no existe");
        }
    }
    
//____________________________________________________________
    @Override
    public void union(Object x, Object y) throws NodoNoExistente {
       NodoMA nodo1 = new NodoMA(x);
       NodoMA nodo2 = new NodoMA(y);
       if (NodoExiste(nodo1)&& NodoExiste(nodo2)){
           if(!Adyacente(x,y)){
               this.matrizAd[nodo1.getNum()][nodo2.getNum()]=1;
           }
       }
       else{    
        throw new NodoNoExistente("Nodo No Existe"); 
       } 
    }
    
//____________________________________________________________
    public void imprimir(){
            System.out.println("Matriz de Adyacencia");
    for (int i = 0; i <this.numVer; i++){
        System.out.print("\t"+this.vertices[i]);
       }    
      System.out.println();     
    for (int i = 0; i < this.numVer; i++){
        System.out.print(vertices[i]+ "\t");
       for (int j = 0; j <numVer; j++){
         System.out.print(this.matrizAd[i][j]+ "\t");
           
       }
        System.out.println();  
    } 
 }
    
 //____________________________________________________________ 
    public String Matriz(){
        String Cadena="\tMatriz de Adyacencia\n";
        for (int i = 0; i <this.numVer; i++){
       Cadena+="\t"+this.vertices[i];
       }    
        
       Cadena+="\n"; 
        for (int i = 0; i < this.numVer; i++){
        Cadena+=vertices[i]+ "\t";
            for (int j = 0; j <numVer; j++){
             Cadena+=this.matrizAd[i][j]+ "\t";    
       }
      Cadena+="\n";  
    } 
       return Cadena; 
    }
    
 //____________________________________________________________   
    @Override
    public boolean buscarProfundidad(Object x) {
      ArrayList<NodoMA>visitados = new ArrayList<>();
        Stack<NodoMA> pila = new Stack<>();
        for(int i=0;i<this.numVer;i++){
            if(this.vertices[i].getDato().equals(x))return true;
           if(!pila.contains(this.vertices[i])){
                pila.push(this.vertices[i]);
           } 
           if(!visitados.contains(pila.peek())){
                visitados.add(pila.peek());  
           }
           NodoMA nodo = pila.peek();
            for(int j=0;j<this.numVer;j++){
                try {
                    if(!visitados.contains(this.vertices[j])&& Adyacente(nodo.getDato(),this.vertices[j].getDato())){
                        System.out.println(Adyacente(nodo.getDato(),this.vertices[j].getDato()));
                        if(this.vertices[j].getDato().equals(x))return true;
                        pila.push(this.vertices[j]);
                    }   } catch (NodoNoExistente ex) {
                    Logger.getLogger(MatrizAd.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            pila.remove(nodo);
            while(!pila.isEmpty()){
                NodoMA nodo1=pila.peek();
                for(int j=0;j<this.numVer;j++){
                try {
                    if(!visitados.contains(this.vertices[j])&& Adyacente(nodo1.getDato(),this.vertices[j].getDato())){
                        System.out.println(Adyacente(nodo1.getDato(),this.vertices[j].getDato()));
                        if(this.vertices[j].getDato().equals(x))return true;
                        pila.push(this.vertices[j]);
                    }   } catch (NodoNoExistente ex) {
                    Logger.getLogger(MatrizAd.class.getName()).log(Level.SEVERE, null, ex);
                }
                 }
                if(!visitados.contains(nodo1)){
                    visitados.add(nodo1);
                }
                pila.remove(nodo1);
            }
         if(visitados.size()==this.numVer){
             break;
         }  
        }        
    return false;
}
    
//____________________________________________________________
    @Override
    public boolean buscarAmplitud(Object x) {
     ArrayList<NodoMA> visitados= new ArrayList<>();
     LinkedList<NodoMA> nodos= new LinkedList<>(); 
        
     for(int j=0;j<this.numVer;j++){
            if(this.vertices[j].getDato().equals(x))return true;
              nodos.addFirst(this.vertices[j]);
               if(!visitados.contains(nodos.getFirst())){
           visitados.add(nodos.getFirst());
           }
               
            for(int i=0;i<this.numVer;i++){ 
               try {
                   if(Adyacente(nodos.getFirst().getDato(),this.vertices[i].getDato())){
                        if(this.vertices[i].getDato().equals(x))return true;
                       nodos.addLast(this.vertices[i]);
                   }
               } 
               catch (NodoNoExistente ex) {
                   Logger.getLogger(MatrizAd.class.getName()).log(Level.SEVERE, null, ex);
               }
           }
       nodos.removeFirst();
       while(!nodos.isEmpty()){
           for(int i=0;i<this.numVer;i++){
               try {
                   if(!visitados.contains(nodos.getFirst()) && 
                           Adyacente(nodos.getFirst().getDato(),this.vertices[i].getDato())){
                       if(this.vertices[i].getDato().equals(x))return true;
                       nodos.addLast(this.vertices[i]);
                       
                   }
               } catch (NodoNoExistente ex) {
                   Logger.getLogger(MatrizAd.class.getName()).log(Level.SEVERE, null, ex);
               }
           }
           if(!visitados.contains(nodos.getFirst())){
           visitados.add(nodos.getFirst());
           }
           nodos.removeFirst();
       }
        if(visitados.size()==this.numVer){
            break;
       }
    }
    return false;
    }
    
//____________________________________________________________
    @Override
    public void recorrerProfundidad() {
    Recorrido="Recorrido por Matriz"+"\n";
        ArrayList<NodoMA>visitados = new ArrayList<>();
        Stack<NodoMA> pila = new Stack<>();
        
        for(int i=0;i<this.numVer;i++){     
           if(!pila.contains(this.vertices[i])){
                pila.push(this.vertices[i]);
           } 
           if(!visitados.contains(pila.peek())){
                visitados.add(pila.peek());  
           }
           NodoMA nodo = pila.peek();
            for(int j=0;j<this.numVer;j++){
                try {
                    if(!pila.contains(this.vertices[j])&&!visitados.contains(this.vertices[j])&& Adyacente(nodo.getDato(),this.vertices[j].getDato())){
                        System.out.println(Adyacente(nodo.getDato(),this.vertices[j].getDato()));
                        pila.push(this.vertices[j]);
                    }   } catch (NodoNoExistente ex) {
                    Logger.getLogger(MatrizAd.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            pila.remove(nodo);
            while(!pila.isEmpty()){
                NodoMA nodo1=pila.peek();
                for(int j=0;j<this.numVer;j++){
                try {
                    if(!pila.contains(this.vertices[j])&&!visitados.contains(this.vertices[j])&& Adyacente(nodo1.getDato(),this.vertices[j].getDato())){
                        System.out.println(Adyacente(nodo1.getDato(),this.vertices[j].getDato()));
                        pila.push(this.vertices[j]);
                    }   } catch (NodoNoExistente ex) {
                    Logger.getLogger(MatrizAd.class.getName()).log(Level.SEVERE, null, ex);
                }
                 }
                if(!visitados.contains(nodo1)){
                    visitados.add(nodo1);
                }
                pila.remove(nodo1);
            }
         if(visitados.size()==this.numVer){
             break;
         }  
        }        
          System.out.println("Recorrido Por Lista");   
      for(int i=0;i<visitados.size();i++){
           Recorrido+=visitados.get(i).getDato()+"\n";
           System.out.println(visitados.get(i).getDato());
       }
    }
    
//____________________________________________________________
    @Override
    public void recorrerAmplitud() {
        Recorrido="Recorrido por Matriz\n";
        ArrayList<NodoMA> visitados= new ArrayList<>();
       LinkedList<NodoMA> nodos= new LinkedList<>(); 
       for(int j=0;j<this.numVer;j++){
           if(!nodos.contains(this.vertices[j])){
                nodos.addFirst(this.vertices[j]);
           }
         if(!visitados.contains(nodos.getFirst())){
           visitados.add(nodos.getFirst());
           }
       for(int i=0;i<this.numVer;i++){
               try {
                   if(!nodos.contains(this.vertices[i])&& Adyacente(nodos.getFirst().getDato(),this.vertices[i].getDato())){
                       nodos.addLast(this.vertices[i]);
                   }
               } catch (NodoNoExistente ex) {
                   Logger.getLogger(MatrizAd.class.getName()).log(Level.SEVERE, null, ex);
               }
           }
       nodos.removeFirst();
       while(!nodos.isEmpty()){
           for(int i=0;i<this.numVer;i++){
               try {
                   if(!visitados.contains(nodos.getFirst()) && !nodos.contains(this.vertices[i])&&
                           Adyacente(nodos.getFirst().getDato(),this.vertices[i].getDato())){
                       nodos.addLast(this.vertices[i]);   
                   }
               } catch (NodoNoExistente ex) {
                   Logger.getLogger(MatrizAd.class.getName()).log(Level.SEVERE, null, ex);
               }
           }
          if(!visitados.contains(nodos.getFirst())){
           visitados.add(nodos.getFirst());
           }
           nodos.removeFirst();
       }
       
        if(visitados.size()==this.numVer){
            break;
       }
    }
        System.out.println("Recorrido");   
      for(int i=0;i<visitados.size();i++){
           Recorrido+=visitados.get(i).getDato()+"\n";
           System.out.println(visitados.get(i).getDato());
       }
    }
}
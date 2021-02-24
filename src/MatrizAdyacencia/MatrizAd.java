package MatrizAdyacencia;

import Excepciones.*;
import Modelo.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 * @author Victor Lavalle
 */
public class MatrizAd extends Grafo {
    
    private NodoMA [] vertices;
    
    private int numVer;
    private int [][] matrizAd;
    private final int tam;
    static final int max= 10;  

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
    public NodoMA[] getVertices() {return vertices; }
    public int getNumVer() { return numVer; }
    public int[][] getMatrizAd() {return matrizAd;}
    
    public void setVertices(NodoMA[] vertices) { this.vertices = vertices; }
    public void setNumVer(int numVer) {this.numVer = numVer;}
    public void setMatrizAd(int[][] matrizAd) {this.matrizAd = matrizAd;}
    
//________________________________________________________________________________  
    public boolean NodoExiste(NodoMA x){
        for (int i=0;i<this.numVer;i++){    
        if (this.vertices[i].getData().equals(x.getData())){   
         x.setNum(this.vertices[i].getNum());
         return true;
        }
      }
       return false;
    }
    
 //________________________________________________________________________________  
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
   
 //________________________________________________________________________________
    @Override
    public boolean Adyacente(Object x, Object y) throws NodoNoExistente {
     NodoMA nodo1 = new NodoMA(x);
     NodoMA nodo2 = new NodoMA(y);
       if (NodoExiste(nodo1)&& NodoExiste(nodo2)){
           if(this.matrizAd[nodo1.getNum()][nodo2.getNum()]==1)
              return true; 
       }else{
        throw new NodoNoExistente("Nodo No Existe");
       } 
        return false;
    }
    
 //________________________________________________________________________________
    @Override
    public void nuevo_vertice(Object x) throws NodoExistente{
        if(this.vertices.length==this.numVer){
            System.out.println("Vector Lleno");
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
    
 //________________________________________________________________________________
    @Override
    public void borra_vertice(Object x) throws NodoNoExistente {
        if(this.numVer==0){
            System.out.println("Vector Vacio");
           return;
        }
        
        NodoMA nodo = new NodoMA(x);
        if (NodoExiste(nodo)){
         int index=nodo.getNum(); 
            System.out.println(index+"wey");  
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

 //________________________________________________________________________________
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
    
 //________________________________________________________________________________
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
    
 //________________________________________________________________________________
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
    
 //________________________________________________________________________________   
    @Override
    public boolean buscarProfundidad(Object x) {
    return false;
    }

 //________________________________________________________________________________
    @Override
    public boolean buscarAmplitud(Object x) {
        return false;
    }
    
 //________________________________________________________________________________
    @Override
    public void recorrerProfundidad() {
        ArrayList<NodoMA>Visitados = new ArrayList<>();
    }
    
 //________________________________________________________________________________
    @Override
    public void recorrerAmplitud() {
      ArrayList<NodoMA> visitados= new ArrayList<>();
       
       LinkedList<NodoMA> nodos= new LinkedList<>(); 
        
       nodos.addFirst(this.vertices[3]);
       visitados.add(nodos.getFirst());
       
       for(int i=0;i<this.numVer;i++){
               try {
                   if(Adyacente(nodos.getFirst().getData(),this.vertices[i].getData())){
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
                   if(!isProcesado(visitados,nodos.getFirst()) && 
                           Adyacente(nodos.getFirst().getData(),this.vertices[i].getData())){
                       nodos.addLast(this.vertices[i]);
                       
                   }
               } catch (NodoNoExistente ex) {
                   Logger.getLogger(MatrizAd.class.getName()).log(Level.SEVERE, null, ex);
               }
           }
         
           if(!isProcesado(visitados,nodos.getFirst())){
           visitados.add(nodos.getFirst());
           }
           nodos.removeFirst();  
       } 
        System.out.println("Recorrido");   
       for(int i=0;i<visitados.size();i++){  
           System.out.println(visitados.get(i).getData());  
       }  
    }
    
 //________________________________________________________________________________
   public boolean isProcesado(ArrayList<NodoMA> visitado,NodoMA nodo){
   for(int i=0;i<visitado.size();i++){
       if(visitado.get(i).getData().equals(nodo.getData())){
       return true;
       }
   }
   return false;
   }
}

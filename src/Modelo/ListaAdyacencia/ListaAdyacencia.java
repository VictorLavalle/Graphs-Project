package Modelo.ListaAdyacencia;

import Excepciones.*;
import Modelo.ListaLigada.NodoL;
import Modelo.Grafo;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;
import javax.swing.JOptionPane;
/**
 * @author Victor Lavalle
 */
public class ListaAdyacencia implements Grafo{

      static final int max= 15;  
      private ArrayList<NodoListaAdy>Vertices;
      private int index;
      public String  Recorrido="";
      
    //Constructor de la buena suerte
    public ListaAdyacencia() {
        this.Vertices = new ArrayList<>();
    }
    
    //Metodos Get & Set
    public ArrayList<NodoListaAdy> getVertices() {return Vertices;}
    public void setVertices(ArrayList<NodoListaAdy> Vertices) {this.Vertices = Vertices; }
      
    //Funciones
    public boolean Existe(NodoListaAdy x){
        for(int i=0;i<this.Vertices.size();i++){
            if(x.getDato().equals(this.Vertices.get(i).getDato())){
               index=i; 
            return true;
            }
        }
    return false;
    }
    
//__________________________________________________________________________
    @Override
    public void Borrar_arco(Object x, Object y) throws NodoNoExistente,ArcoNoExiste {
    
        NodoListaAdy nodo1= new NodoListaAdy(x);
        NodoListaAdy nodo2= new NodoListaAdy(y);
        
        if(Existe(nodo1)&& Existe(nodo2)){
            if(Adyacente(x,y)){
                Arco arco = new Arco(nodo1,nodo2);
                for(int i=0;i<this.Vertices.size();i++){
                    if(nodo1.getDato().equals(this.Vertices.get(i).getDato())){
                        this.Vertices.get(i).getAdy().eliminar(arco);
                        break;
                    }
                }
            }else{
                throw new ArcoNoExiste("Arco no existe");
            }
        }else{
            throw new NodoNoExistente("El nodo no existe");
        }
    }    
    
//__________________________________________________________________________
    @Override
    public boolean Adyacente(Object x, Object y) throws NodoNoExistente {
    
        boolean bandera=false;
        
        NodoListaAdy nodo1= new NodoListaAdy(x);
        NodoListaAdy nodo2= new NodoListaAdy(y);
        if(Existe(nodo1)&& Existe(nodo2)){
            for(int i=0;i<this.Vertices.size();i++){
                if(nodo1.getDato().equals(this.Vertices.get(i).getDato())){
                    Arco arco= new Arco(nodo1,nodo2);
                    return this.Vertices.get(i).getAdy().buscarLista(arco) != null;
                }
            }
        }
        else{
            throw new NodoNoExistente("El nodo no existe");
        }
        return bandera;
    }
    
//__________________________________________________________________________
    @Override
    public void nuevo_vertice(Object x) throws NodoExistente {
        if(this.Vertices.size()== max){
            JOptionPane.showMessageDialog(null, "Ha Execedido el Maximo vertices");
            return;
        }
        NodoListaAdy nodo= new NodoListaAdy(x);
        if(!Existe(nodo)){
            this.Vertices.add(nodo);
        }
        else{
            throw new NodoExistente("El nodo ya existe");
        }
    }
    
//__________________________________________________________________________
    @Override
    public void borra_vertice(Object x) throws NodoNoExistente {
        if(this.Vertices.isEmpty()){
            System.out.println("Lista Vacia");
            JOptionPane.showMessageDialog(null, "No hay vertices");
            return;
        }
        NodoListaAdy nodo= new NodoListaAdy(x);
        if(Existe(nodo)){
            nodo=this.getVertices().get(index);
            this.Vertices.remove(index);
            for(int i=0;i<this.Vertices.size();i++){
               NodoL n= this.Vertices.get(i).getAdy().getCabeza();   
                while(n!=null){
                if(n.getDato().getDestino().getDato().equals(nodo.getDato())){
                        this.Vertices.get(i).getAdy().eliminar(n.getDato());
                        break;
                }
                n=n.getLink();
                }  
            }
        }
        else{
            throw new NodoNoExistente("El nodo no existe");
        }
    }
    
//__________________________________________________________________________
    @Override
    public void union(Object x, Object y) throws NodoNoExistente {
        NodoListaAdy nodo1= new NodoListaAdy(x);
        NodoListaAdy nodo2= new NodoListaAdy(y);
        if(Existe(nodo1)&& Existe(nodo2)){
            if(!Adyacente(x,y)){
                Arco arco = new Arco(nodo1,nodo2);
                for(int i=0;i<this.Vertices.size();i++){
                    if(nodo1.getDato().equals(this.Vertices.get(i).getDato())){
                        this.Vertices.get(i).getAdy().insertarFinal(arco);
                        break;
                    }
                }
            }
        }
        else{
            throw new NodoNoExistente("El nodo no existe");
        }
    }
    
//__________________________________________________________________________
    @Override
    public boolean buscarProfundidad(Object x) {
         ArrayList<NodoListaAdy>visitados= new ArrayList();
         Stack<NodoListaAdy> pila = new Stack<>();
      for(int i=0;i<this.Vertices.size();i++){
          if(this.Vertices.get(i).getDato().equals(x))return true;
          if(!pila.contains(this.Vertices.get(i))){
           pila.push(this.Vertices.get(i));
          }
         if(!visitados.contains(pila.peek())){
             visitados.add(pila.peek());
         }

         while(!pila.isEmpty()){
             NodoL nodo=pila.peek().getAdy().getCabeza();
             NodoListaAdy aux=pila.peek();
             while(nodo!=null){
                 for(int j=0;j<this.Vertices.size();j++){
                     if(!pila.contains(this.Vertices.get(j)) &&nodo.getDato().getDestino().getDato().equals(this.Vertices.get(j).getDato())&&!visitados.contains(this.Vertices.get(j))){
                          if(this.Vertices.get(j).getDato().equals(x))return true;
                         pila.push(this.Vertices.get(j));
                     }
                 }
                nodo=nodo.getLink();
             }
             if(!visitados.contains(aux)){
             visitados.add(aux);
             }
             pila.remove(aux);
             }
                
         if(visitados.size()==this.Vertices.size()){
          break;
          }   
       }
    return false;
    }

//__________________________________________________________________________
    @Override
    public boolean buscarAmplitud(Object x) {    
        ArrayList<NodoListaAdy>visitados= new ArrayList();
         LinkedList<NodoListaAdy>vertices= new LinkedList(); 
    
      for(int i=0;i<this.Vertices.size();i++){
             vertices.add(this.Vertices.get(i));
         if(!visitados.contains(vertices.getFirst())){
             visitados.add(vertices.getFirst());
              if(x.equals(this.Vertices.get(i).getDato()))return true;
         }
         while(!vertices.isEmpty()){
             NodoL nodo=vertices.getFirst().getAdy().getCabeza();  
             while(nodo!=null){
                 for(int j=0;j<this.Vertices.size();j++){
                     if(nodo.getDato().getDestino().getDato().equals(this.Vertices.get(j).getDato())&&!visitados.contains(this.Vertices.get(j))){
                         if(x.equals(this.Vertices.get(j).getDato()))return true;
                         vertices.addLast(this.Vertices.get(j));
                     }
                 }
                nodo=nodo.getLink();
             }
             if(!visitados.contains(vertices.getFirst())){
             visitados.add(vertices.getFirst());
             }
             vertices.removeFirst();
             }  
         if(visitados.size()==this.Vertices.size()){ 
          break;
          }
         }
    return false;
    }
    
//__________________________________________________________________________
    @Override
    public void recorrerProfundidad() {
         Recorrido="Recorrido por Lista\n";
          ArrayList<NodoListaAdy>visitados= new ArrayList();
         Stack<NodoListaAdy> pila = new Stack<>();
      for(int i=0;i<this.Vertices.size();i++){    
          if(!pila.contains(this.Vertices.get(i))){
           pila.push(this.Vertices.get(i));
          }
         if(!visitados.contains(pila.peek())){
             visitados.add(pila.peek());
         }

         while(!pila.isEmpty()){
             NodoL nodo=pila.peek().getAdy().getCabeza();
             NodoListaAdy aux=pila.peek();
             while(nodo!=null){
                 for(int j=0;j<this.Vertices.size();j++){
                     if(!pila.contains(this.Vertices.get(j)) 
                             &&nodo.getDato().getDestino().getDato().equals(this.Vertices.get(j).getDato())
                             &&!visitados.contains(this.Vertices.get(j))){
                         pila.push(this.Vertices.get(j));
                     }
                 }
                nodo=nodo.getLink();
             }
             if(!visitados.contains(aux)){
             visitados.add(aux);
             }
             pila.remove(aux);
             }
         if(visitados.size()==this.Vertices.size()){    
          break;
          }
         }
         System.out.println(visitados.size());
         for(int i=0;i<visitados.size();i++){
             System.out.println(visitados.get(i).getDato());
             Recorrido+=visitados.get(i).getDato()+"\n";
         }
    }
//__________________________________________________________________________

    @Override
    public void recorrerAmplitud() {
         Recorrido="Recorrido por Lista\n";
          ArrayList<NodoListaAdy>visitados= new ArrayList();
         LinkedList<NodoListaAdy>vertices= new LinkedList(); 
          for(int i=0;i<this.Vertices.size();i++){
          if(!vertices.contains(this.Vertices.get(i))){
           vertices.add(this.Vertices.get(i));
          }

         if(!visitados.contains(vertices.getFirst())){
             visitados.add(vertices.getFirst());
         }
         
         while(!vertices.isEmpty()){
             NodoL nodo=vertices.getFirst().getAdy().getCabeza();
             while(nodo!=null){
                 for(int j=0;j<this.Vertices.size();j++){
                     if(!vertices.contains(this.Vertices.get(j)) 
                             &&nodo.getDato().getDestino().getDato().equals(this.Vertices.get(j).getDato())
                             &&!visitados.contains(this.Vertices.get(j))){
                         vertices.addLast(this.Vertices.get(j));
                     }
                 }
                nodo=nodo.getLink();
             }
             if(!visitados.contains(vertices.getFirst())){
             visitados.add(vertices.getFirst());
             }
             vertices.removeFirst();
             }
         if(visitados.size()==this.Vertices.size()){
          break;
          }
        }
         System.out.println(visitados.size());
         for(int i=0;i<visitados.size();i++){
             System.out.println(visitados.get(i).getDato());
             Recorrido+=visitados.get(i).getDato()+"\n";
         }  
      }
  
//__________________________________________________________________________    
     public void imprimir(){
        for(int i=0;i<this.Vertices.size();i++){
            System.out.println(this.Vertices.get(i));
            Recorrido+=this.Vertices.get(i).getDato()+"";
        }
    }
     
//__________________________________________________________________________
    public String lista(){
        String Cadena="\tLista de Adyacencia\n";
        for(int i=0;i<this.Vertices.size();i++){
          Cadena+=this.Vertices.get(i).toString()+"\n";
        }
        return Cadena;   
    }
 }  
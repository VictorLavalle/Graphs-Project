package ListaAdyacencia;

import Excepciones.*;
import ListaLigada.NodoL;
import Modelo.Arco;
import Modelo.Grafo;
import java.util.ArrayList;
/**
 * @author Victor Lavalle
 */
public class ListaAd extends Grafo{

      static final int max= 10;  
      private ArrayList<NodoLA>Vertices;
      private int index;

      //Constructor
    public ListaAd() {
        this.Vertices = new ArrayList<>();
    }
    
     //Get & Set
    public ArrayList<NodoLA> getVertices() { return Vertices;}
    public void setVertices(ArrayList<NodoLA> Vertices) { this.Vertices = Vertices;}
      
    //Funciones
    public boolean Existe(NodoLA x){
        for(int i=0;i<this.Vertices.size();i++){
            if(x.getData().equals(this.Vertices.get(i).getData())){
               index=i;
            return true;
            }
        }
    return false;
    }
    
//________________________________________________________________________________
    @Override
    public void Borrar_arco(Object x, Object y) throws NodoNoExistente,ArcoNoExiste {
    
        NodoLA nodo1= new NodoLA(x);
        NodoLA nodo2= new NodoLA(y);
        
        if(Existe(nodo1)&& Existe(nodo2)){
        
            if(Adyacente(x,y)){
                Arco arco = new Arco(nodo1,nodo2);
                for(int i=0;i<this.Vertices.size();i++){
                    if(nodo1.getData().equals(this.Vertices.get(i).getData())){
                        this.Vertices.get(i).getAdy().eliminar(arco);
                        break;
                    }
                }
            }
            else{
                throw new ArcoNoExiste("Arco no existe");
            }
        }else{
            throw new NodoNoExistente("El nodo no existe");
        
        }
    }   
    
//________________________________________________________________________________
    @Override
    public boolean Adyacente(Object x, Object y) throws NodoNoExistente {
    
        boolean status=false;  
        NodoLA nodo1= new NodoLA(x);
        NodoLA nodo2= new NodoLA(y);
        
        if(Existe(nodo1)&& Existe(nodo2)){
            for(int i=0;i<this.Vertices.size();i++){
                if(nodo1.getData().equals(this.Vertices.get(i).getData())){
                    Arco arco= new Arco(nodo1,nodo2);
                    return this.Vertices.get(i).getAdy().buscarLista(arco) != null;
                }
            }
        }else{
        throw new NodoNoExistente("El nodo no existe");
        }
        return status;
    }
    
//________________________________________________________________________________
    @Override
    public void nuevo_vertice(Object x) throws NodoExistente {
        if(this.Vertices.size()== max){
            System.out.println("Ha Execedido el Maximo de 20 vertices");
            return;
        }
        NodoLA nodo= new NodoLA(x);
        if(!Existe(nodo)){
            this.Vertices.add(nodo);
        }else{
             
        throw new NodoExistente("El nodo ya existe");
        }  
    }
    
//________________________________________________________________________________
    @Override
    public void borra_vertice(Object x) throws NodoNoExistente {
        
        if(this.Vertices.isEmpty()){
            System.out.println("Lista Vacia");
            return;
        }
        
        NodoLA nodo= new NodoLA(x);
        if(Existe(nodo)){  
            nodo=this.getVertices().get(index);
            this.Vertices.remove(index);
            for(int i=0;i<this.Vertices.size();i++){
               NodoL n= this.Vertices.get(i).getAdy().getTop();   
                while(n!=null){
                if(n.getData().getDestino().getData().equals(nodo.getData())){
                        this.Vertices.get(i).getAdy().eliminar(n.getData());
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
    
//________________________________________________________________________________
    @Override
    public void union(Object x, Object y) throws NodoNoExistente {
        NodoLA nodo1= new NodoLA(x);
        NodoLA nodo2= new NodoLA(y);
        
        if(Existe(nodo1)&& Existe(nodo2)){
        
            if(!Adyacente(x,y)){
                Arco arco = new Arco(nodo1,nodo2);
                for(int i=0;i<this.Vertices.size();i++){
                    if(nodo1.getData().equals(this.Vertices.get(i).getData())){
                        this.Vertices.get(i).getAdy().insertarTopLista(arco);
                      
                        break;
                    }
                }
            }
        }else{
            throw new NodoNoExistente("El nodo no existe");
        }
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
    }
    
//________________________________________________________________________________
    @Override
    public void recorrerAmplitud() {   
    }  
    
//________________________________________________________________________________
    public void imprimir(){
        for(int i=0;i<this.Vertices.size();i++){
            System.out.println(this.Vertices.get(i).toString());    
        }
    }
    
//________________________________________________________________________________
    public String lista(){
        String Cadena="\tLista de Adyacencia\n";
        for(int i=0;i<this.Vertices.size();i++){
          Cadena+=this.Vertices.get(i).toString()+"\n";
        }
        return Cadena;
    }   
}

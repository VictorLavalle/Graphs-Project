package Modelo.ListaLigada;

import Modelo.ListaAdyacencia.Arco;
/**
 * @author Victor Lavalle
 * Lista Generica Implementada
 */
public class Lista {
    
   private NodoL cabeza;
   
//Constructor
    public Lista() {this.cabeza=null;}
    
//Metodo Get
    public NodoL getCabeza() { return cabeza; }
    
//Metodos parael uso de la lista
    
    public void insertarCabezaLista (Arco arco){   
       NodoL nodo= new NodoL(arco); 
       nodo.setLink(this.cabeza);
       this.cabeza=nodo;
    }
    
//____________________________________________ 
    public void insertarFinal(Arco arco){
         NodoL nodo= new NodoL(arco); 
        if(this.cabeza==null){
            this.cabeza=nodo;
        }
        else{
            NodoL apuntador=this.cabeza;
            while(apuntador.getLink()!=null){
            apuntador=apuntador.getLink();
            }
            apuntador.setLink(nodo);
        }
    }
    
 //____________________________________________  
     public void eliminarInicio(){
       if(this.cabeza!=null){
             this.cabeza= this.cabeza.getLink();
       }
    }
     
//____________________________________________  
    public void eliminar(Arco o){
     if(this.cabeza!=null){   
       if(o.getDestino().getDato().equals(this.cabeza.getDato().getDestino().getDato())){  
           eliminarInicio();
       }
       else{  
           NodoL apuntador= cabeza;
                while(apuntador!=null){
                if(o.getDestino().getDato().equals
                (apuntador.getLink().getDato().getDestino().getDato())){
                    apuntador.setLink(apuntador.getLink().getLink());
                break;
                }
                apuntador=apuntador.getLink();
                }   
           }
       }
    } 
    
//____________________________________________ 
    public Arco buscarLista(Arco o){
     NodoL puntero= this.cabeza;
     while(puntero!=null){
         
     if(puntero.getDato().getDestino().getDato().
             equals(o.getDestino().getDato()))
     return puntero.getDato();
     
      puntero= puntero.getLink();
     }
     return null;
    }
    
//____________________________________________   
    public String mostrar(){
        String Mensaje=""; 
        if(this.cabeza!=null){ 
        NodoL apuntador= this.cabeza;
        while(apuntador!=null){
            
        if(apuntador.getLink()!=null){
          Mensaje+=apuntador.getDato().getDestino().getDato()+"-->";
           }
        else{
           Mensaje+=apuntador.getDato().getDestino().getDato();
        }
        apuntador=apuntador.getLink();
       }   
    }       
        return Mensaje;  
    }
  }

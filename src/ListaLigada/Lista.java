package ListaLigada;

import Modelo.Arco;
/**
 * @author Victor Lavalle
 */
public class Lista {
   private NodoL Top;
   
//Constructor
    public Lista() {
       this.Top=null;
    }
    
    public NodoL getTop() {return Top; }
    
 //________________________________________________________________________________
    public void insertarTopLista (Arco arco){   
       NodoL nodo= new NodoL(arco); 
       nodo.setLink(this.Top);
       this.Top=nodo; 
    }
    
//________________________________________________________________________________ 
     public void eliminarInicio(){
       if(this.Top!=null){
             this.Top= this.Top.getLink();
       }
    }
     
//________________________________________________________________________________   
    public void eliminar(Arco o){
     if(this.Top!=null){
       if(o.getDestino().getData().equals(this.Top.getData().getDestino().getData())){
           eliminarInicio();
       }
       else{
           NodoL apuntador= Top;
                while(apuntador!=null){
                if(o.getDestino().getData().equals(apuntador.getLink().getData().getDestino().getData())){  
                    apuntador.setLink(apuntador.getLink().getLink());
                break;
                }
                apuntador=apuntador.getLink();
                }
          }
       }
    } 
 
 //________________________________________________________________________________
    public Arco buscarLista(Arco o){
     NodoL puntero= this.Top;
     while(puntero!=null){
       if(puntero.getData().getDestino().getData().equals(o.getDestino().getData()))
        return puntero.getData();
    
      puntero= puntero.getLink();
     }
     return null;
    }

//________________________________________________________________________________
    public String mostrar(){
        String Mensaje=""; 
        if(this.Top!=null){ 
           NodoL apuntador= this.Top;
           while(apuntador!=null){
               if(apuntador.getLink()!=null){
                   Mensaje+=apuntador.getData().getDestino().getData()+"->";
               }
               else{
                   Mensaje+=apuntador.getData().getDestino().getData();
               }
               apuntador=apuntador.getLink();
           }    
        }       
        return Mensaje;
    }
}
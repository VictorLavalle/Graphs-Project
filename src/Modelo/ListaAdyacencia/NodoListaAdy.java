package Modelo.ListaAdyacencia;

import Modelo.ListaLigada.Lista;
import Modelo.Nodo;
/**
 * @author Victor Lavalle
 */
public class NodoListaAdy extends Nodo {
    
    private Lista ady;

    //Constructor
    public NodoListaAdy(Object Dato) {
        super(Dato);
        ady= new Lista();
    }
    
    //Metodos 
    public Lista getAdy() {return ady;}
    public void setAdy(Lista ady) { this.ady = ady;}

    @Override
    public String toString() {
        return super.toString()+":" + ady.mostrar()+"";
    }
}

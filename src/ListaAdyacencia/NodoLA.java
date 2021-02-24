package ListaAdyacencia;

import ListaLigada.Lista;
import Modelo._Nodo;
/**
 * @author Victor Lavalle
 */
public class NodoLA extends _Nodo {
    
    private Lista ady;

    public NodoLA(Object Dato) {
        super(Dato);
        ady= new Lista();    
    }
    
    public Lista getAdy() { return ady;}
    public void setAdy(Lista ady) {this.ady = ady; }

    @Override
    public String toString() {
        return super.toString()+":" + ady.mostrar()+"";
    }
}

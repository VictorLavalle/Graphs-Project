package Modelo.ListaLigada;

import Modelo.ListaAdyacencia.Arco;
/**
*@author Victor Lavalle
*/
public class NodoL {
    
    private Arco Dato;
    private NodoL Link;
   
    //Constructor
    public NodoL(Arco Dato) {
        this.Dato = Dato;
        this.Link = null;
    }    
    
   //Metodos Get & Set
    public Arco getDato() { return Dato;}
    public NodoL getLink() {return Link; }
    
    public void setDato(Arco Dato) { this.Dato = Dato; }
    public void setLink(NodoL Link) {this.Link = Link;} 
}

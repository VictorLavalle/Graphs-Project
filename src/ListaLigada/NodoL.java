package ListaLigada;

import Modelo.Arco;

public class NodoL {
    
    private Arco Data;
    private NodoL Link;
   
    public NodoL(Arco Data) {
        this.Data = Data;
        this.Link = null;
    }    

    public Arco getData() {return Data; }
    public NodoL getLink() {  return Link;}
    
    public void setData(Arco Data) { this.Data = Data;}
    public void setLink(NodoL Link) {
        this.Link = Link;
    }

    

    
    
}

package Modelo;
/**
 * @author Victor Lavalle
 */
public abstract class Nodo {
    
    private Object Dato;
  
    //Constructor
    public Nodo(Object Dato) {
        this.Dato = Dato;
    }

    //Metodos 
    public Object getDato() { return Dato; }
    public void setDato(Object Dato) { this.Dato = Dato;}

    @Override
    public String toString() {
        return  ""+Dato;
    } 
}

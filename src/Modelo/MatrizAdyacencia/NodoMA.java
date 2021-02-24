package Modelo.MatrizAdyacencia;

import Modelo.Nodo;
/**
 * @author Victor Lavalle
 */
public class NodoMA extends Nodo{
    
    private int Num;
    
  //Constructores
    public NodoMA(int Num,Object Dato) {
        super(Dato);
        this.Num = Num;
    }

    public NodoMA(Object Dato) {
        super(Dato);
        this.Num = -1;
    }
 
//Metodos Get & SEt
    public int getNum() { return Num;}
    public void setNum(int Num) { this.Num = Num;}    
}

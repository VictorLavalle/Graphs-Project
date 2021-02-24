package MatrizAdyacencia;

import Modelo._Nodo;
/**
 * @author Victor Lavalle
 */
public class NodoMA extends _Nodo{
    private int Num;

    public int getNum() {   return Num;}
    public void setNum(int Num) { this.Num = Num;}
    
    //Mega Constructor xd
    public NodoMA(int Num,Object Data) {
        super(Data);
        this.Num = Num;
    }
    
    //Constructor
    public NodoMA(Object Data) {
        super(Data);
        this.Num = -1;
    }

}

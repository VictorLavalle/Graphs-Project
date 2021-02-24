package Modelo;
/**
 * @author Victor Lavalle
 */
public class Arco {
    private _Nodo Inicio, Destino;
    private int Peso;
    
//Constructor
    public Arco(_Nodo Inicio, _Nodo Destino) {
        this.Inicio = Inicio;
        this.Destino = Destino;
        this.Peso = 1;
    }
//Metodos Get & Set
    public _Nodo getInicio() { return Inicio; }
    public _Nodo getDestino() {  return Destino; }
    public int getPeso() {return Peso;}
    
    public void setInicio(_Nodo Inicio) {  this.Inicio = Inicio;}
    public void setDestino(_Nodo Destino) {this.Destino = Destino;  }
    public void setPeso(int Peso) { this.Peso = Peso;}
    
    public boolean equals(Object n) {
    Arco a = (Arco)n;
    return Destino == a.Destino;
    }

    @Override
    public String toString() {
        return "g" + Destino;
    }

}

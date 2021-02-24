package Modelo.ListaAdyacencia;
/**
 * @author Victor Lavalle
 */
public class Arco {
    
    private NodoListaAdy Inicio;
    private NodoListaAdy Destino;
    private int Peso;

    //Constructor
    public Arco(NodoListaAdy Inicio, NodoListaAdy Destino) {
        this.Inicio = Inicio;
        this.Destino = Destino;
        this.Peso = 1;
    }
    
//Metodos Get & Set
    public NodoListaAdy getInicio() {return Inicio;}
    public NodoListaAdy getDestino() { return Destino; }
    public int getPeso() {return Peso;}
    
    public void setInicio(NodoListaAdy Inicio) {this.Inicio = Inicio;}
    public void setDestino(NodoListaAdy Destino) { this.Destino = Destino;}
    public void setPeso(int Peso) {this.Peso = Peso; }
    
//Funciones
    public boolean equals(Object n) {
    Arco a = (Arco)n;
    return Destino == a.Destino;
    }

    @Override
    public String toString() {
        return "g" + Destino;
    }
    
}

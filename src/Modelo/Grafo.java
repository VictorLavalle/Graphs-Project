package Modelo;

import Excepciones.*;
/**
 * @author Victor Lavalle
 */
public abstract class Grafo {
    
    public abstract void Borrar_arco(Object x, Object y)throws NodoNoExistente,ArcoNoExiste;
    
    public abstract  boolean Adyacente(Object x, Object y)throws NodoNoExistente ;
    
    public abstract void nuevo_vertice(Object x)throws NodoExistente;
    
    public abstract void borra_vertice(Object x)throws NodoNoExistente;
    
    public abstract void union(Object x, Object y)throws NodoNoExistente;
    
    public abstract  boolean buscarProfundidad(Object x);
    
    public abstract boolean buscarAmplitud(Object x);
    
    public abstract void recorrerProfundidad();
    
    public abstract void recorrerAmplitud();
    
}

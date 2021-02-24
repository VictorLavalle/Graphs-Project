package Launcher;

import Controlador.Controlador;
import Dibujo.Dibujo;
import Modelo.ListaAdyacencia.*;
import Modelo.MatrizAdyacencia.*;
import Vista.GUI;
/**
 * @author Victor Lavalle
 */
public class Main {

    public static GUI interfaz;
    public static ListaAdyacencia Lista;
    public static MatrizAd Matriz;
    public static Controlador ctrl;
    public static  Dibujo dibujo;
    
    public static void main(String[] args) {
       
        interfaz = new GUI();
        Lista= new ListaAdyacencia();
        Matriz= new MatrizAd();
        ctrl = new Controlador();
        dibujo= new Dibujo();
        
        ctrl.setDibujo(dibujo);
        ctrl.setInterfaz(interfaz);
        ctrl.setLista(Lista);
        ctrl.setMatriz(Matriz);
        
        interfaz.setCtrl(ctrl);   
       interfaz.setVisible(true);
    }
    
}

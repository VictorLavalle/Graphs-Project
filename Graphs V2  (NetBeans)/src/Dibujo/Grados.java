package Dibujo;

import Modelo.MatrizAdyacencia.NodoMA;
/**
 * @author Victor Lavalle
 */
public class Grados {
    NodoMA [] vertices;
    int numV;
    int [][] adyacencia;
    public int radio = 10;
    private static final int XO = 200;
    private static final int YO = 200;
    private final int d = 150;
    int index=0;

    //Constructor
    public Grados(NodoMA[] vertices, int[][] adyacencia,int numV) {
        this.vertices = vertices;
        this.adyacencia = adyacencia;
        this.numV= numV;
    }
    
  //________________________________________________________________
    public double[] grados() {
        double[] grados = new double[numV];
        for (int i = 0; i < numV; i++) {
            grados[i] = (360 /(numV))*i;
        }
        return grados;
    }
    
 //________________________________________________________________
    public PintarNodo[] coordenadas(double[] grados){
        PintarNodo[] nodos = new PintarNodo[numV];
        for(int i=0; i<grados.length; i++){
            double Y = calcularY(grados[i], d, YO);
            double X = calcularX(grados[i], d, XO);
            nodos[i] = new PintarNodo((int)X,(int)Y,vertices[i].getDato().toString());
        }
        return nodos;
    }
    
 //________________________________________________________________   
    public double calcularX(double grados, int distancia, int Xorigen){
        if(grados<=90){
            return Xorigen + Math.floor(Math.cos(Math.toRadians(grados))*distancia);
        }
        if(grados<=180){
            return Xorigen + Math.ceil(Math.cos(Math.toRadians(grados))*distancia);
        }
        if(grados<=270){
            return Xorigen + Math.ceil(Math.cos(Math.toRadians(grados))*distancia);
        }
        if(grados<=360){
            return Xorigen + Math.floor(Math.cos(Math.toRadians(grados))*distancia);
        }
        return 0;
    }
    
  //________________________________________________________________   
    public double calcularY(double grados, int distancia, int Yorigen){
        if(grados<=90){
            return Yorigen - Math.floor(Math.sin(Math.toRadians(grados))*distancia);
        }
        if(grados<=180){
            return Yorigen - Math.floor(Math.sin(Math.toRadians(grados))*distancia);
        }
        if(grados<=270){
            return Yorigen - Math.ceil(Math.sin(Math.toRadians(grados))*distancia);
        }
        if(grados<=360){
            return Yorigen - Math.ceil(Math.sin(Math.toRadians(grados))*distancia);
        }
        return 0;
    }
}

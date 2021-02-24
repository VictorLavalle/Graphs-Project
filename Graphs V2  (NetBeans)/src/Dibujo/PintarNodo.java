package Dibujo;
/**
 * @author Victor Lavalle
 */
public class PintarNodo {
    
    private int X,Y;
    private String Name;

    //Constructor
    public PintarNodo(int X, int Y, String Name) {
        this.X = X;
        this.Y = Y;
        this.Name = Name;
    }

    //Metodos Get & Set
    public int getX() {return X;}
    public int getY() { return Y;}
    public String getName() { return Name;}
    
    public void setX(int X) {this.X = X;  }
    public void setY(int Y) {this.Y = Y; }
    public void setName(String Name) { this.Name = Name; }
}

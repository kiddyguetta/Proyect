/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoestructuraarbol;

/**
 *
 * @author ARGUELLO CALLE
 */
public class Nodo {
    
    
    private Nodo Izquierda,Derecha;
    private int dato;
   
    public Nodo(int dato){
       this.dato = dato;
       Izquierda = null;
        Derecha = null;
    }

    public int getDato() {
        return dato;
    }

    public Nodo getIzquierda() {
        return Izquierda;
    }

    public Nodo getDerecha() {
        return Derecha;
    }

    public void setDato(int dato) {
        this.dato = dato;
    }

    public void setIzquierda(Nodo Izquierda) {
        this.Izquierda= Izquierda;
    }

    public void setDerecha(Nodo Derecha) {
        this.Derecha = Derecha;
    } 
    
    
}

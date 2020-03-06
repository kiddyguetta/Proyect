/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoestructuraarbol;

import java.util.LinkedList;

/**
 *
 * @author ARGUELLO CALLE
 */

public class ArbolBinario {
    private Nodo raiz;
    private int numerosdenodos;
    private int altura;

    public ArbolBinario() {
        raiz = null;
        numerosdenodos = 0;
        altura = 0;
    }
    //Con este metodo eliminino cualquiero numero en el Arbol
    public boolean Eliminar(int B) {
        if (!this.Existe(B)) {
            return false;
        }

        Nodo z = Eliminar(this.raiz, B);
        this.setRaiz(z);
        return true;

    }


    private Nodo Eliminar(Nodo r, int B) {
        if (r == null) {
            return null;//<--Dato no encontrado		
        }
        int compara = ((Comparable) r.getDato()).compareTo(B);
        if (compara > 0) {
            r.setIzquierda(Eliminar(r.getIzquierda(), B));
        } else if (compara < 0) {
            r.setDerecha(Eliminar(r.getDerecha(), B));
        } else {
            System.out.println("Encontro el dato:" + B);
            if (r.getIzquierda() != null && r.getDerecha() != null) {
                Nodo cambiar = BuscarMin(r.getDerecha());
                int aux = cambiar.getDato();
                cambiar.setDato(r.getDato());
                r.setDato(aux);
                r.setDerecha(Eliminar(r.getDerecha(), B));
                System.out.println("2 ramas");
            } else {
                r = (r.getIzquierda() != null) ? r.getIzquierda() : r.getDerecha();
                System.out.println("Entro cuando le faltan ramas ");
            }
        }
        return r;
    }
    
   private Nodo BuscarMin(Nodo r) {
        for (; r.getIzquierda() != null; r = r.getIzquierda());
        return (r);
    }
   
   public void SacarProm(){
       
   }
   public boolean Modificar(int dato, int datox) {
        Nodo aux = raiz;
        while (aux!=null) {
            if (dato==aux.getDato()){
                dato=datox;
                return true;
                
            }else{
                if (dato>aux.getDato()){
                    aux=aux.getDerecha();}
                else{
                    aux=aux.getIzquierda();}
        }
        
    }
        return false;
   }
   
    //Metodo para insertar un dato en el arbol...no acepta repetidos
    public void IngresarDato(int dato){
       if(Existe(dato))return;
       Nodo nuevo = new Nodo(dato);
          if (raiz == null)
              raiz = nuevo;
          else
          {
              Nodo anterior = null;
              Nodo tmp = raiz;
              while (tmp != null)
              {
                  anterior = tmp;
                  if (dato < tmp.getDato())
                      tmp = tmp.getIzquierda();
                  else
                      tmp = tmp.getDerecha();
              }
              if (dato < anterior.getDato())
                  anterior.setIzquierda(nuevo);
              else
                  anterior.setDerecha(nuevo);
          }
          numerosdenodos++;
    }

    public Nodo getRaiz() {
        return raiz;
    }

    public void setRaiz(Nodo raiz) {
        this.raiz = raiz;
    }

    public int getNumNodos() {
        return numerosdenodos;
    }
    
    //Recorrido preorden, recibe el nodo a empezar (raiz) y una linkedlist para ir guardando el recorrido
    public void Preorden(Nodo auxiliar,LinkedList recorrido){
          if (auxiliar != null)
          {
              recorrido.add(auxiliar.getDato());
              Preorden (auxiliar.getIzquierda(),recorrido);
              Preorden (auxiliar.getDerecha(),recorrido);
          }
    }
    //Recorrido inorden, recibe el nodo a empezar (raiz) y una linkedlist para ir guardando el recorrido
    public void Inorden(Nodo auxiliar,LinkedList recorrido){
          if (auxiliar != null)
          {
              Inorden (auxiliar.getIzquierda(),recorrido);
              recorrido.add(auxiliar.getDato());
              Inorden (auxiliar.getDerecha(),recorrido);
          }
    }
    //Recorrido postorden, recibe el nodo a empezar (raiz) y una linkedlist para ir guardando el recorrido
    public void postorden(Nodo auxiliar,LinkedList recorrido){
          if (auxiliar != null)
          {
              postorden (auxiliar.getIzquierda(),recorrido);
              postorden (auxiliar.getDerecha(),recorrido);
              recorrido.add(auxiliar.getDato());
          }
    }
    //Recorrido por nivel, recibe el nodo a empezar (raiz) y una linkedlist para ir guardando el recorrido
    public void Niveles(Nodo auxiliar,LinkedList recorrido){
        LinkedList<Nodo> cola = new LinkedList<Nodo>();
        cola.addLast(auxiliar);
        while(cola.size()> 0){
            Nodo tmp = cola.pollFirst();
            recorrido.add(tmp.getDato());
            if(tmp.getIzquierda()!=null){
                cola.addLast(tmp.getIzquierda());
            }
            if(tmp.getDerecha()!=null){
                cola.addLast(tmp.getDerecha());
            } 
        }
    }
    
    //Metodo para verificar si hay un nodo en el arbol
    public boolean Existe(int dato) {
        Nodo aux = raiz;
        while (aux!=null) {
            if (dato==aux.getDato())
                return true;
            else
                if (dato>aux.getDato())
                    aux=aux.getDerecha();
                else
                    aux=aux.getIzquierda();
        }
        return false;
    }
    
    
    private void Altura (Nodo aux,int nivel)  {
        if (aux != null) {    
            Altura(aux.getIzquierda(),nivel+1);
            altura = nivel;
            Altura(aux.getDerecha(),nivel+1);
        }
    }
    //Devuleve la altura del arbol
    public int getAltura(){
        Altura(raiz,1);
        return altura;
    }
     
}
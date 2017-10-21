import java.io.Serializable;
import java.util.Arrays;

class Nodo {

    private int[] puzzle;
    private int nivel;
    private Nodo nodoPadre;
    private int cantRepeticiones;
    private Nodo arriba = null;
    private Nodo derecha = null;
    private Nodo abajo = null;
    private Nodo izquierda = null;

    Nodo(int[] puzzle, int nivel, Nodo nodoPadre) {
        this.puzzle = puzzle;
        this.nivel = nivel;
        this.nodoPadre = nodoPadre;
    }

    int[] getPuzzle() {
        return puzzle;
    }

    public Nodo getNodoPadre() {
        return nodoPadre;
    }

    Nodo getIzquierda() {
        return izquierda;
    }

    void setIzquierda(Nodo izquierda) {
        this.izquierda = izquierda;
    }

    int getNivel() {
        return nivel;
    }

    Nodo getArriba() {
        return arriba;
    }

    void setArriba(Nodo arriba) {
        this.arriba = arriba;
    }

    Nodo getDerecha() {
        return derecha;
    }

    void setDerecha(Nodo derecha) {
        this.derecha = derecha;
    }

    Nodo getAbajo() {
        return abajo;
    }

    void setAbajo(Nodo abajo) {
        this.abajo = abajo;
    }

    int getCantRepeticiones() {
        return cantRepeticiones;
    }

    void agregarRepeticion() {
        cantRepeticiones++;
    }

    @Override
    public int hashCode() {
        return Hash.hashCode(getPuzzle());
    }

}

import java.util.ArrayList;
import java.util.Arrays;

class NodoEncontrado {

    private int cantNodosRecorridos;
    private Nodo nodoMeta;

    NodoEncontrado(int cantNodosRecorridos, Nodo nodoMeta) {
        this.cantNodosRecorridos = cantNodosRecorridos;
        this.nodoMeta = nodoMeta;
    }

    int getCantNodosRecorridos() {
        return cantNodosRecorridos;
    }

    Nodo getNodoMeta() {
        return nodoMeta;
    }

    @Override
    public String toString() {
        return "Nivel del nodo encontrado: " + nodoMeta.getNivel() + "\tCantidad de nodos recorridos: " + cantNodosRecorridos;
    }

    String caminoPuzzle() {
        String string = "";
        Nodo nodo = this.nodoMeta;
        while (nodo.getNodoPadre() != null) {
            string += Arrays.toString(nodo.getPuzzle()) + "\n";
            nodo = nodo.getNodoPadre();
        }
        return string;
    }

    String caminoPuzzle2() {
        String string = "Camino de solución del tablero:\n";
        ArrayList<Nodo> lista = new ArrayList<>();
        lista.add(nodoMeta);
        while (lista.get(0).getNodoPadre() != null) {
            lista.add(0, lista.get(0).getNodoPadre());
        }
        for (Nodo nodo : lista) {
            string += nodo.getPuzzle()[0] + " " + nodo.getPuzzle()[1] + " " + nodo.getPuzzle()[2] + "\t";
        }
        string += "\n";
        for (Nodo nodo : lista) {
            string += nodo.getPuzzle()[3] + " " + nodo.getPuzzle()[4] + " " + nodo.getPuzzle()[5] + "\t";
        }
        string += "\n";
        for (Nodo nodo : lista) {
            string += nodo.getPuzzle()[6] + " " + nodo.getPuzzle()[7] + " " + nodo.getPuzzle()[8] + "\t";
        }
        return string;
    }

}

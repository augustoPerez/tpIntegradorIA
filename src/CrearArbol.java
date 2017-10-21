import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

class CrearArbol {

    private static ArrayList<Nodo> listaNivel5 = new ArrayList<>();
    private static ArrayList<Nodo> listaNivel10 = new ArrayList<>();
    private static ArrayList<Nodo> listaNivel15 = new ArrayList<>();
    private static ArrayList<Nodo> listaNivel20 = new ArrayList<>();
    private static ArrayList<Nodo> listaNivel25 = new ArrayList<>();
    private static ArrayList<Nodo> listaNivel30 = new ArrayList<>();

    static Arbol enAmplitud(int[] tableroInicial) {

        Nodo raiz = new Nodo(tableroInicial, 0, null); //nodo que contiene el tablero inicial

        Arbol arbol = new Arbol(raiz); //arbol que contiene el nodo raíz (tablero inicial)
        ArrayList<Nodo> lista = new ArrayList<>(); //lista que recorre los nodos y los saca una vez recorridos
        HashMap<Integer, Nodo> hash = new HashMap<>(); //hash que contiene los tableros ya creados

        lista.add(raiz);
        hash.put(raiz.hashCode(), raiz);

        while (!lista.isEmpty()) {
            Nodo nodoRecorrido = lista.remove(0);

            if(nodoRecorrido.getNivel()==5) listaNivel5.add(nodoRecorrido);
            else if(nodoRecorrido.getNivel()==10) listaNivel10.add(nodoRecorrido);
            else if(nodoRecorrido.getNivel()==15) listaNivel15.add(nodoRecorrido);
            else if(nodoRecorrido.getNivel()==20) listaNivel20.add(nodoRecorrido);
            else if(nodoRecorrido.getNivel()==25) listaNivel25.add(nodoRecorrido);
            else if(nodoRecorrido.getNivel()==30) listaNivel30.add(nodoRecorrido);

            if (nodoRecorrido.getPuzzle() != null) {

                int[] arriba = MoverFicha.moverArriba(nodoRecorrido.getPuzzle());
                int[] derecha = MoverFicha.moverDerecha(nodoRecorrido.getPuzzle());
                int[] abajo = MoverFicha.moverAbajo(nodoRecorrido.getPuzzle());
                int[] izquierda = MoverFicha.moverIzquierda(nodoRecorrido.getPuzzle());

                if (arriba != null && !estaHash(arriba, hash)) {
                    nodoRecorrido.setArriba(new Nodo(MoverFicha.moverArriba(nodoRecorrido.getPuzzle()), nodoRecorrido.getNivel() + 1, nodoRecorrido));
                    lista.add(nodoRecorrido.getArriba());
                    hash.put(nodoRecorrido.getArriba().hashCode(), nodoRecorrido.getArriba());
                    arbol.sumarCantidad();
                }
                if (derecha != null && !estaHash(derecha, hash)) {
                    nodoRecorrido.setDerecha(new Nodo(MoverFicha.moverDerecha(nodoRecorrido.getPuzzle()), nodoRecorrido.getNivel() + 1, nodoRecorrido));
                    lista.add(nodoRecorrido.getDerecha());
                    hash.put(nodoRecorrido.getDerecha().hashCode(), nodoRecorrido.getDerecha());
                    arbol.sumarCantidad();
                }
                if (abajo != null && !estaHash(abajo, hash)) {
                    nodoRecorrido.setAbajo(new Nodo(MoverFicha.moverAbajo(nodoRecorrido.getPuzzle()), nodoRecorrido.getNivel() + 1, nodoRecorrido));
                    lista.add(nodoRecorrido.getAbajo());
                    hash.put(nodoRecorrido.getAbajo().hashCode(), nodoRecorrido.getAbajo());
                    arbol.sumarCantidad();
                }
                if (izquierda != null && !estaHash(izquierda, hash)) {
                    nodoRecorrido.setIzquierda(new Nodo(MoverFicha.moverIzquierda(nodoRecorrido.getPuzzle()), nodoRecorrido.getNivel() + 1, nodoRecorrido));
                    lista.add(nodoRecorrido.getIzquierda());
                    hash.put(nodoRecorrido.getIzquierda().hashCode(), nodoRecorrido.getIzquierda());
                    arbol.sumarCantidad();
                }

                if (nodoRecorrido.getNivel() > arbol.getMaxNivel())
                    arbol.setMaxNivel(nodoRecorrido.getNivel());

            }
        }

        return arbol;
    }

    private static boolean estaHash(int[] puzzle, HashMap<Integer, Nodo> hash) {
        return hash.containsKey(Hash.hashCode(puzzle));
    }

    public static ArrayList<Nodo> getListaNivel5() {
        return listaNivel5;
    }

    public static ArrayList<Nodo> getListaNivel10() {
        return listaNivel10;
    }

    public static ArrayList<Nodo> getListaNivel15() {
        return listaNivel15;
    }

    public static ArrayList<Nodo> getListaNivel20() {
        return listaNivel20;
    }

    public static ArrayList<Nodo> getListaNivel25() {
        return listaNivel25;
    }

    public static ArrayList<Nodo> getListaNivel30() {
        return listaNivel30;
    }

}

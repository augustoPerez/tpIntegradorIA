import java.util.ArrayList;
import java.util.Arrays;

class Busqueda {

    static NodoEncontrado busquedaAmplitud(Arbol arbol, int[] meta) {
        NodoEncontrado nodoEncontrado = null;
        ArrayList<Nodo> lista = new ArrayList<>();
        lista.add(arbol.getRaiz());
        int cantNodosRecorridos = 0;
        long t1 = System.currentTimeMillis();
        while (!lista.isEmpty()) {
            Nodo nodoRecorrido = lista.remove(0);
            cantNodosRecorridos++;
            if (Arrays.equals(nodoRecorrido.getPuzzle(), meta)) {
                long t2 = System.currentTimeMillis();
                nodoEncontrado = new NodoEncontrado(cantNodosRecorridos, nodoRecorrido, t2 - t1);
                break;
            } else {
                if (nodoRecorrido.getArriba() != null) lista.add(nodoRecorrido.getArriba());
                if (nodoRecorrido.getDerecha() != null) lista.add(nodoRecorrido.getDerecha());
                if (nodoRecorrido.getAbajo() != null) lista.add(nodoRecorrido.getAbajo());
                if (nodoRecorrido.getIzquierda() != null) lista.add(nodoRecorrido.getIzquierda());
            }
        }
        return nodoEncontrado;
    }

    static NodoEncontrado busquedaProfundidad(Arbol arbol, int[] meta) {
        NodoEncontrado nodoEncontrado = null;
        ArrayList<Nodo> lista = new ArrayList<>();
        lista.add(arbol.getRaiz());
        int cantNodosRecorridos = 0;
        long t1 = System.currentTimeMillis();
        while (!lista.isEmpty()) {
            Nodo nodoRecorrido = lista.remove(0);
            cantNodosRecorridos++;
            if (Arrays.equals(nodoRecorrido.getPuzzle(), meta)) {
                long t2 = System.currentTimeMillis();
                nodoEncontrado = new NodoEncontrado(cantNodosRecorridos, nodoRecorrido, t2 - t1);
                break;
            } else {
                if (nodoRecorrido.getIzquierda() != null) lista.add(0, nodoRecorrido.getIzquierda());
                if (nodoRecorrido.getAbajo() != null) lista.add(0, nodoRecorrido.getAbajo());
                if (nodoRecorrido.getDerecha() != null) lista.add(0, nodoRecorrido.getDerecha());
                if (nodoRecorrido.getArriba() != null) lista.add(0, nodoRecorrido.getArriba());
            }
        }
        return nodoEncontrado;
    }

    static NodoEncontrado busquedaPMFichas(Arbol arbol, int[] meta) {
        NodoEncontrado nodoEncontrado = null;
        ArrayList<Nodo> lista = new ArrayList<>();
        lista.add(arbol.getRaiz());
        int cantNodosRecorridos = 0;
        int[] posiciones = new int[10];
        long t1 = System.currentTimeMillis();
        while (!lista.isEmpty()) {
            Nodo nodoRecorrido = lista.remove(0);
            for (int i = 1; i < posiciones.length; i++) {
                if (posiciones[i] != 0) posiciones[i]--;
            }
            cantNodosRecorridos++;
            if (Arrays.equals(nodoRecorrido.getPuzzle(), meta)) {
                long t2 = System.currentTimeMillis();
                nodoEncontrado = new NodoEncontrado(cantNodosRecorridos, nodoRecorrido, t2 - t1);
                break;
            } else {
                if (nodoRecorrido.getIzquierda() != null) {
                    int pos = cantFichasDesacomodadas(nodoRecorrido.getIzquierda().getPuzzle(), meta);
                    lista.add(posiciones[pos], nodoRecorrido.getIzquierda());
                    for (int i = pos + 1; i < posiciones.length; i++) posiciones[i]++;
                }
                if (nodoRecorrido.getAbajo() != null) {
                    int pos = cantFichasDesacomodadas(nodoRecorrido.getAbajo().getPuzzle(), meta);
                    lista.add(posiciones[pos], nodoRecorrido.getAbajo());
                    for (int i = pos + 1; i < posiciones.length; i++) posiciones[i]++;
                }
                if (nodoRecorrido.getDerecha() != null) {
                    int pos = cantFichasDesacomodadas(nodoRecorrido.getDerecha().getPuzzle(), meta);
                    lista.add(posiciones[pos], nodoRecorrido.getDerecha());
                    for (int i = pos + 1; i < posiciones.length; i++) posiciones[i]++;
                }
                if (nodoRecorrido.getArriba() != null) {
                    int pos = cantFichasDesacomodadas(nodoRecorrido.getArriba().getPuzzle(), meta);
                    lista.add(posiciones[pos], nodoRecorrido.getArriba());
                    for (int i = pos + 1; i < posiciones.length; i++) posiciones[i]++;
                }
            }
        }
        return nodoEncontrado;
    }

    static NodoEncontrado busquedaPMManhattan(Arbol arbol, int[] meta) {
        NodoEncontrado nodoEncontrado = null;
        ArrayList<Nodo> lista = new ArrayList<>();
        lista.add(arbol.getRaiz());
        int cantNodosRecorridos = 0;
        int[] posiciones = new int[31];
        long t1 = System.currentTimeMillis();
        while (!lista.isEmpty()) {
            Nodo nodoRecorrido = lista.remove(0);
            for (int i = 1; i < posiciones.length; i++) {
                if (posiciones[i] != 0) posiciones[i]--;
            }
            cantNodosRecorridos++;
            if (Arrays.equals(nodoRecorrido.getPuzzle(), meta)) {
                long t2 = System.currentTimeMillis();
                nodoEncontrado = new NodoEncontrado(cantNodosRecorridos, nodoRecorrido, t2 - t1);
                break;
            } else {
                if (nodoRecorrido.getIzquierda() != null) {
                    int pos = distManhattan(nodoRecorrido.getIzquierda().getPuzzle(), meta);
                    lista.add(posiciones[pos], nodoRecorrido.getIzquierda());
                    for (int i = pos + 1; i < posiciones.length; i++) posiciones[i]++;
                }
                if (nodoRecorrido.getAbajo() != null) {
                    int pos = distManhattan(nodoRecorrido.getAbajo().getPuzzle(), meta);
                    lista.add(posiciones[pos], nodoRecorrido.getAbajo());
                    for (int i = pos + 1; i < posiciones.length; i++) posiciones[i]++;
                }
                if (nodoRecorrido.getDerecha() != null) {
                    int pos = distManhattan(nodoRecorrido.getDerecha().getPuzzle(), meta);
                    lista.add(posiciones[pos], nodoRecorrido.getDerecha());
                    for (int i = pos + 1; i < posiciones.length; i++) posiciones[i]++;
                }
                if (nodoRecorrido.getArriba() != null) {
                    int pos = distManhattan(nodoRecorrido.getArriba().getPuzzle(), meta);
                    lista.add(posiciones[pos], nodoRecorrido.getArriba());
                    for (int i = pos + 1; i < posiciones.length; i++) posiciones[i]++;
                }
            }
        }
        return nodoEncontrado;
    }

    static NodoEncontrado busquedaAFichas(Arbol arbol, int[] meta) {
        NodoEncontrado nodoEncontrado = null;
        ArrayList<Nodo> lista = new ArrayList<>();
        lista.add(arbol.getRaiz());
        int cantNodosRecorridos = 0;
        int[] posiciones = new int[arbol.getMaxNivel() + 10];
        long t1 = System.currentTimeMillis();
        while (!lista.isEmpty()) {
            Nodo nodoRecorrido = lista.remove(0);
            for (int i = 1; i < posiciones.length; i++) {
                if (posiciones[i] != 0) posiciones[i]--;
            }
            cantNodosRecorridos++;
            if (Arrays.equals(nodoRecorrido.getPuzzle(), meta)) {
                long t2 = System.currentTimeMillis();
                nodoEncontrado = new NodoEncontrado(cantNodosRecorridos, nodoRecorrido, t2 - t1);
                break;
            } else {
                if (nodoRecorrido.getIzquierda() != null) {
                    int pos = cantFichasDesacomodadas(nodoRecorrido.getIzquierda().getPuzzle(), meta) + nodoRecorrido.getIzquierda().getNivel();
                    lista.add(posiciones[pos], nodoRecorrido.getIzquierda());
                    for (int i = pos + 1; i < posiciones.length; i++) posiciones[i]++;
                }
                if (nodoRecorrido.getAbajo() != null) {
                    int pos = cantFichasDesacomodadas(nodoRecorrido.getAbajo().getPuzzle(), meta) + nodoRecorrido.getAbajo().getNivel();
                    lista.add(posiciones[pos], nodoRecorrido.getAbajo());
                    for (int i = pos + 1; i < posiciones.length; i++) posiciones[i]++;
                }
                if (nodoRecorrido.getDerecha() != null) {
                    int pos = cantFichasDesacomodadas(nodoRecorrido.getDerecha().getPuzzle(), meta) + nodoRecorrido.getDerecha().getNivel();
                    lista.add(posiciones[pos], nodoRecorrido.getDerecha());
                    for (int i = pos + 1; i < posiciones.length; i++) posiciones[i]++;
                }
                if (nodoRecorrido.getArriba() != null) {
                    int pos = cantFichasDesacomodadas(nodoRecorrido.getArriba().getPuzzle(), meta) + nodoRecorrido.getArriba().getNivel();
                    lista.add(posiciones[pos], nodoRecorrido.getArriba());
                    for (int i = pos + 1; i < posiciones.length; i++) posiciones[i]++;
                }
            }
        }
        return nodoEncontrado;
    }

    static NodoEncontrado busquedaAManhattan(Arbol arbol, int[] meta) {
        NodoEncontrado nodoEncontrado = null;
        ArrayList<Nodo> lista = new ArrayList<>();
        lista.add(arbol.getRaiz());
        int cantNodosRecorridos = 0;
        int[] posiciones = new int[arbol.getMaxNivel() + 31];
        long t1 = System.currentTimeMillis();
        while (!lista.isEmpty()) {
            Nodo nodoRecorrido = lista.remove(0);
            for (int i = 1; i < posiciones.length; i++) {
                if (posiciones[i] != 0) posiciones[i]--;
            }
            cantNodosRecorridos++;
            if (Arrays.equals(nodoRecorrido.getPuzzle(), meta)) {
                long t2 = System.currentTimeMillis();
                nodoEncontrado = new NodoEncontrado(cantNodosRecorridos, nodoRecorrido, t2 - t1);
                break;
            } else {
                if (nodoRecorrido.getIzquierda() != null) {
                    int pos = distManhattan(nodoRecorrido.getIzquierda().getPuzzle(), meta) + nodoRecorrido.getIzquierda().getNivel();
                    lista.add(posiciones[pos], nodoRecorrido.getIzquierda());
                    for (int i = pos + 1; i < posiciones.length; i++) posiciones[i]++;
                }
                if (nodoRecorrido.getAbajo() != null) {
                    int pos = distManhattan(nodoRecorrido.getAbajo().getPuzzle(), meta) + nodoRecorrido.getAbajo().getNivel();
                    lista.add(posiciones[pos], nodoRecorrido.getAbajo());
                    for (int i = pos + 1; i < posiciones.length; i++) posiciones[i]++;
                }
                if (nodoRecorrido.getDerecha() != null) {
                    int pos = distManhattan(nodoRecorrido.getDerecha().getPuzzle(), meta) + nodoRecorrido.getDerecha().getNivel();
                    lista.add(posiciones[pos], nodoRecorrido.getDerecha());
                    for (int i = pos + 1; i < posiciones.length; i++) posiciones[i]++;
                }
                if (nodoRecorrido.getArriba() != null) {
                    int pos = distManhattan(nodoRecorrido.getArriba().getPuzzle(), meta) + nodoRecorrido.getArriba().getNivel();
                    lista.add(posiciones[pos], nodoRecorrido.getArriba());
                    for (int i = pos + 1; i < posiciones.length; i++) posiciones[i]++;
                }
            }
        }
        return nodoEncontrado;
    }

    private static int cantFichasDesacomodadas(int[] inicial, int[] actual) {
        int cant = 0;
        for (int i = 0; i < inicial.length; i++) {
            if (inicial[i] != actual[i]) cant++;
        }
        return cant;
    }

    private static int distManhattan(int[] actual, int[] meta) {
        int cant = 0;
        for (int i = 0; i < actual.length; i++) {
            int pos = posicion(meta, actual[i]);
            cant += Math.abs(pos % 3 - i % 3);
            cant += Math.abs((int) (pos / 3) - (int) (i / 3));
        }
        return cant;
    }

    private static int posicion(int[] puzzle, int valor) {
        for (int i = 0; i < puzzle.length; i++) {
            if (puzzle[i] == valor) return i;
        }
        return 0;
    }


}

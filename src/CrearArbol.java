import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

class CrearArbol {

    static Arbol enAmplitud(int[] tableroInicial) {

        Nodo raiz = new Nodo(tableroInicial, 0, null); //nodo que contiene el tablero inicial

        Arbol arbol = new Arbol(raiz); //arbol que contiene el nodo raíz (tablero inicial)
        ArrayList<Nodo> lista = new ArrayList<>(); //lista que recorre los nodos y los saca una vez recorridos
        HashMap<Integer, Nodo> hash = new HashMap<>(); //hash que contiene los tableros ya creados

        lista.add(raiz);
        hash.put(raiz.hashCode(), raiz);

        while (!lista.isEmpty()) {
            Nodo nodoRecorrido = lista.remove(0);

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
                    if (arbol.size() != hash.size()) {
//                        System.out.println(arbol.size() + " " + hash.size());
                    }
                }
                if (derecha != null && !estaHash(derecha, hash)) {
                    nodoRecorrido.setDerecha(new Nodo(MoverFicha.moverDerecha(nodoRecorrido.getPuzzle()), nodoRecorrido.getNivel() + 1, nodoRecorrido));
                    lista.add(nodoRecorrido.getDerecha());
                    boolean esta = hash.containsKey(nodoRecorrido.getDerecha().hashCode());
                    Nodo n = hash.get(nodoRecorrido.getDerecha().hashCode());
                    int cant = hash.size();
                    boolean esta2 = estaHash(derecha, hash);
                    hash.put(nodoRecorrido.getDerecha().hashCode(), nodoRecorrido.getDerecha());
                    boolean esta1 = hash.containsKey(nodoRecorrido.getDerecha().hashCode());
                    boolean esta3 = estaHash(derecha, hash);
                    int cant1= hash.size();
                    arbol.sumarCantidad();
                    if (arbol.size() != hash.size()) {
                        int hash1 = Arrays.hashCode(derecha);
                        int hash2 = nodoRecorrido.getDerecha().hashCode();
                        Nodo nodo1 = nodoRecorrido.getDerecha();
                        Nodo nodo2 = hash.get(nodoRecorrido.getDerecha().hashCode());
//                        System.out.println(arbol.size() + " " + hash.size());
                    }
                }
                if (abajo != null && !estaHash(abajo, hash)) {
                    nodoRecorrido.setAbajo(new Nodo(MoverFicha.moverAbajo(nodoRecorrido.getPuzzle()), nodoRecorrido.getNivel() + 1, nodoRecorrido));
                    lista.add(nodoRecorrido.getAbajo());
                    hash.put(nodoRecorrido.getAbajo().hashCode(), nodoRecorrido.getAbajo());
                    arbol.sumarCantidad();
                    if (arbol.size() != hash.size()) {
//                        System.out.println(arbol.size() + " " + hash.size());
                    }
                }
                if (izquierda != null && !estaHash(izquierda, hash)) {
                    nodoRecorrido.setIzquierda(new Nodo(MoverFicha.moverIzquierda(nodoRecorrido.getPuzzle()), nodoRecorrido.getNivel() + 1, nodoRecorrido));
                    lista.add(nodoRecorrido.getIzquierda());
                    hash.put(nodoRecorrido.getIzquierda().hashCode(), nodoRecorrido.getIzquierda());
                    arbol.sumarCantidad();
                    if (arbol.size() != hash.size()) {
//                        System.out.println(arbol.size() + " " + hash.size());
                    }
                }

                if (arbol.size() != hash.size()) {
//                    System.out.println(arbol.size() + " " + hash.size());
                }

                if (nodoRecorrido.getNivel() > arbol.getMaxNivel())
                    arbol.setMaxNivel(nodoRecorrido.getNivel());

            }
        }

        return arbol;

    }

    static Arbol enProfundidad(int[] tableroInicial) {

        Nodo raiz = new Nodo(tableroInicial, 0, null); //nodo que contiene el tablero inicial

        Arbol arbol = new Arbol(raiz); //arbol que contiene el nodo raíz (tablero inicial)
        ArrayList<Nodo> lista = new ArrayList<>(); //lista que recorre los nodos y los saca una vez recorridos
        HashMap<Integer, Nodo> hash = new HashMap<>(); //hash que contiene los tableros ya creados

        lista.add(raiz);
        hash.put(raiz.hashCode(), raiz);

        while (!lista.isEmpty()) {
            Nodo nodoRecorrido = lista.remove(0);

            if (nodoRecorrido.getPuzzle() != null) {

                int[] arriba = MoverFicha.moverArriba(nodoRecorrido.getPuzzle());
                int[] derecha = MoverFicha.moverDerecha(nodoRecorrido.getPuzzle());
                int[] abajo = MoverFicha.moverAbajo(nodoRecorrido.getPuzzle());
                int[] izquierda = MoverFicha.moverIzquierda(nodoRecorrido.getPuzzle());

                if (izquierda != null && !estaHash(izquierda, hash)) {
                    nodoRecorrido.setIzquierda(new Nodo(MoverFicha.moverIzquierda(nodoRecorrido.getPuzzle()), nodoRecorrido.getNivel() + 1, nodoRecorrido));
                    lista.add(0, nodoRecorrido.getIzquierda());
                    hash.put(nodoRecorrido.getIzquierda().hashCode(), nodoRecorrido.getIzquierda());
                    arbol.sumarCantidad();
                }
                if (abajo != null && !estaHash(abajo, hash)) {
                    nodoRecorrido.setAbajo(new Nodo(MoverFicha.moverAbajo(nodoRecorrido.getPuzzle()), nodoRecorrido.getNivel() + 1, nodoRecorrido));
                    lista.add(0, nodoRecorrido.getAbajo());
                    hash.put(nodoRecorrido.getAbajo().hashCode(), nodoRecorrido.getAbajo());
                    arbol.sumarCantidad();
                }
                if (derecha != null && !estaHash(derecha, hash)) {
                    nodoRecorrido.setDerecha(new Nodo(MoverFicha.moverDerecha(nodoRecorrido.getPuzzle()), nodoRecorrido.getNivel() + 1, nodoRecorrido));
                    lista.add(0, nodoRecorrido.getDerecha());
                    hash.put(nodoRecorrido.getDerecha().hashCode(), nodoRecorrido.getDerecha());
                    arbol.sumarCantidad();
                }
                if (arriba != null && !estaHash(arriba, hash)) {
                    nodoRecorrido.setArriba(new Nodo(MoverFicha.moverArriba(nodoRecorrido.getPuzzle()), nodoRecorrido.getNivel() + 1, nodoRecorrido));
                    lista.add(0, nodoRecorrido.getArriba());
                    hash.put(nodoRecorrido.getArriba().hashCode(), nodoRecorrido.getArriba());
                    arbol.sumarCantidad();
                }

                if (nodoRecorrido.getNivel() > arbol.getMaxNivel())
                    arbol.setMaxNivel(nodoRecorrido.getNivel());

            }
        }
        System.out.println("hash: " + hash.size());
        return arbol;

    }

    static Arbol maxNivel(int[] tableroInicial, int maxNivel, int cantRepeticiones) {

        /*int nivel = 1;*/

        Nodo raiz = new Nodo(tableroInicial, 0, null); //nodo que contiene el tablero inicial

        Arbol arbol = new Arbol(raiz); //arbol que contiene el nodo raíz (tablero inicial)
        ArrayList<Nodo> lista = new ArrayList<>(); //lista que recorre los nodos y los saca una vez recorridos
        HashMap<Integer, Nodo> hash = new HashMap<>(); //hash que contiene los tableros ya creados

        lista.add(raiz);
        hash.put(raiz.hashCode(), raiz);

        while (!lista.isEmpty() && lista.get(0).getNivel() <= maxNivel) {
            Nodo nodoRecorrido = lista.remove(0);

            if (nodoRecorrido.getPuzzle() != null) {

                int[] arriba = MoverFicha.moverArriba(nodoRecorrido.getPuzzle());
                int[] derecha = MoverFicha.moverDerecha(nodoRecorrido.getPuzzle());
                int[] abajo = MoverFicha.moverAbajo(nodoRecorrido.getPuzzle());
                int[] izquierda = MoverFicha.moverIzquierda(nodoRecorrido.getPuzzle());

                if (arriba != null && agregarRepetido(arriba, hash, cantRepeticiones) &&
                        (nodoRecorrido.getNodoPadre() == null ||
                                (nodoRecorrido.getNodoPadre() != null && !Arrays.equals(arriba, nodoRecorrido.getNodoPadre().getPuzzle())))) {
                    nodoRecorrido.setArriba(new Nodo(MoverFicha.moverArriba(nodoRecorrido.getPuzzle()), nodoRecorrido.getNivel() + 1, nodoRecorrido));
                    lista.add(nodoRecorrido.getArriba());
                    arbol.sumarCantidad();
                    if (!estaHash(arriba, hash))
                        hash.put(nodoRecorrido.getArriba().hashCode(), nodoRecorrido.getArriba());
                }
                if (derecha != null && agregarRepetido(derecha, hash, cantRepeticiones) &&
                        (nodoRecorrido.getNodoPadre() == null ||
                                (nodoRecorrido.getNodoPadre() != null && !Arrays.equals(derecha, nodoRecorrido.getNodoPadre().getPuzzle())))) {
                    nodoRecorrido.setDerecha(new Nodo(MoverFicha.moverDerecha(nodoRecorrido.getPuzzle()), nodoRecorrido.getNivel() + 1, nodoRecorrido));
                    lista.add(nodoRecorrido.getDerecha());
                    arbol.sumarCantidad();
                    if (!estaHash(derecha, hash))
                        hash.put(nodoRecorrido.getDerecha().hashCode(), nodoRecorrido.getDerecha());

                }
                if (abajo != null && agregarRepetido(abajo, hash, cantRepeticiones) &&
                        (nodoRecorrido.getNodoPadre() == null ||
                                (nodoRecorrido.getNodoPadre() != null && !Arrays.equals(abajo, nodoRecorrido.getNodoPadre().getPuzzle())))) {
                    nodoRecorrido.setAbajo(new Nodo(MoverFicha.moverAbajo(nodoRecorrido.getPuzzle()), nodoRecorrido.getNivel() + 1, nodoRecorrido));
                    lista.add(nodoRecorrido.getAbajo());
                    arbol.sumarCantidad();
                    if (!estaHash(abajo, hash)) hash.put(nodoRecorrido.getAbajo().hashCode(), nodoRecorrido.getAbajo());
                }
                if (izquierda != null && agregarRepetido(izquierda, hash, cantRepeticiones) &&
                        (nodoRecorrido.getNodoPadre() == null ||
                                (nodoRecorrido.getNodoPadre() != null && !Arrays.equals(izquierda, nodoRecorrido.getNodoPadre().getPuzzle())))) {
                    nodoRecorrido.setIzquierda(new Nodo(MoverFicha.moverIzquierda(nodoRecorrido.getPuzzle()), nodoRecorrido.getNivel() + 1, nodoRecorrido));
                    lista.add(nodoRecorrido.getIzquierda());
                    arbol.sumarCantidad();
                    if (!estaHash(izquierda, hash))
                        hash.put(nodoRecorrido.getIzquierda().hashCode(), nodoRecorrido.getIzquierda());
                }

                if (nodoRecorrido.getNivel() > arbol.getMaxNivel())
                    arbol.setMaxNivel(nodoRecorrido.getNivel());

                /*if (nodoRecorrido.getNivel() == nivel) {
                    nivel++;
                    System.out.println("Nivel: " + nodoRecorrido.getNivel() + ", \tNodos: " + arbol.size() + ", \tDiferentes: " + hash.size());
                }*/
            }
        }

        System.out.println("hash: " + hash.size());

        return arbol;
    }

    private static boolean estaHash(int[] puzzle, HashMap<Integer, Nodo> hash) {
        if (!hash.containsKey(Arrays.hashCode(puzzle))) return false;
        if (hash.containsKey(Arrays.hashCode(puzzle)) && !Arrays.equals(hash.get(Arrays.hashCode(puzzle)).getPuzzle(), puzzle)) {
            return false;
        }
        return true;
    }

    private static boolean agregarRepetido(int[] puzzle, HashMap<Integer, Nodo> hash, int cantRepeticiones) {
        boolean agregar = false;
        if (hash.get(Arrays.hashCode(puzzle)) == null)
            agregar = true;
        if (hash.get(Arrays.hashCode(puzzle)) != null &&
                !Arrays.equals(hash.get(Arrays.hashCode(puzzle)).getPuzzle(), puzzle))
            agregar = true;
        if (hash.get(Arrays.hashCode(puzzle)) != null &&
                Arrays.equals(hash.get(Arrays.hashCode(puzzle)).getPuzzle(), puzzle) &&
                hash.get(Arrays.hashCode(puzzle)).getCantRepeticiones() < cantRepeticiones) {
            hash.get(Arrays.hashCode(puzzle)).agregarRepeticion();
            agregar = true;
        }
        return agregar;
    }

}

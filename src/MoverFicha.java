class MoverFicha {

    static int[] moverArriba(int[] puzzle) {
        if (puedeArriba(puzzle)){
            int[] nuevo = puzzle.clone();
            int posCero = cero(puzzle);
            nuevo[posCero] = puzzle[posCero-3];
            nuevo[posCero-3] = puzzle[posCero];
            return nuevo;
        }
        return null;
    }

    static int[] moverDerecha(int[] puzzle) {
        if (puedeDerecha(puzzle)){
            int[] nuevo = puzzle.clone();
            int posCero = cero(puzzle);
            nuevo[posCero] = puzzle[posCero+1];
            nuevo[posCero+1] = puzzle[posCero];
            return nuevo;
        }
        return null;
    }

    static int[] moverAbajo(int[] puzzle) {
        if (puedeAbajo(puzzle)){
            int[] nuevo = puzzle.clone();
            int posCero = cero(puzzle);
            nuevo[posCero] = puzzle[posCero+3];
            nuevo[posCero+3] = puzzle[posCero];
            return nuevo;
        }
        return null;
    }

    static int[] moverIzquierda(int[] puzzle) {
        if (puedeIzquierda(puzzle)){
            int[] nuevo = puzzle.clone();
            int posCero = cero(puzzle);
            nuevo[posCero] = puzzle[posCero-1];
            nuevo[posCero-1] = puzzle[posCero];
            return nuevo;
        }
        return null;
    }

    private static int cero(int[] puzzle) {
        for (int i = 0; i < puzzle.length; i++) {
            if (puzzle[i] == 0) return i;
        }
        return 0;
    }

    private static boolean puedeArriba(int[] puzzle){
        return cero(puzzle) > 2;
    }

    private static boolean puedeDerecha(int[] puzzle){
        return cero(puzzle) % 3 != 2;
    }

    private static boolean puedeAbajo(int[] puzzle){
        return cero(puzzle) < 6;
    }

    private static boolean puedeIzquierda(int[] puzzle){
        return cero(puzzle) % 3 != 0;
    }

}

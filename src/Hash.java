class Hash {

    static int hashCode(int[] tablero) {
        int cant = 0;
        for (int i = 0; i < tablero.length; i++) {
            cant += (tablero[i] * Math.pow(10,(8 - i)));
        }
        return cant;
    }

}

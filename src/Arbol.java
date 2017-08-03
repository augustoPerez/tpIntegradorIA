class Arbol {

    private Nodo raiz;
    private int cantidad;
    private int maxNivel;

    Arbol(Nodo raiz) {
        this.raiz = raiz;
        this.cantidad = 1;
    }

    Nodo getRaiz() {
        return raiz;
    }

    int size()
    {
        return cantidad;
    }

    void sumarCantidad(){
        cantidad++;
    }

    int getMaxNivel() {
        return maxNivel;
    }

    void setMaxNivel(int maxNivel) {
        this.maxNivel = maxNivel;
    }
}

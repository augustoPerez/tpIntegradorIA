class NodoEncontrado {

    private int cantNodosRecorridos;
    private Nodo nodoMeta;

    public NodoEncontrado(int cantNodosRecorridos, Nodo nodoMeta) {
        this.cantNodosRecorridos = cantNodosRecorridos;
        this.nodoMeta = nodoMeta;
    }

    public int getCantNodosRecorridos() {
        return cantNodosRecorridos;
    }

    public Nodo getNodoMeta() {
        return nodoMeta;
    }

    @Override
    public String toString() {
        return "Nivel del nodo encontrado: " + nodoMeta.getNivel()+  "\tCantidad de nodos recorridos: " + cantNodosRecorridos ;
    }
}

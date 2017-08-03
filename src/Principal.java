import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Principal {

    public static void main(String[] args) {

        int[] tableroInicial = {1, 2, 3, 4, 0, 5, 6, 7, 8}; //tablero inicial

        Arbol arbol = CrearArbol.maxNivel(tableroInicial, 30, 3);
//        Arbol arbol = CrearArbol.enAmplitud(tableroInicial);
//        Arbol arbol = CrearArbol.enProfundidad(tableroInicial);

//        int[] asd = {1, 5, 7, 6, 0, 4, 8, 3, 2};  Una disposición de tablero no encontrada
        int[] asd = {1, 5, 7, 6, 0, 4, 8, 2, 3};
//        int[] asd = {1, 3, 5, 4, 7, 2, 6, 0, 8};

        System.out.println("Tamaño del árbol: " + arbol.size());
        System.out.println("Máximo nivel del árbol: " + arbol.getMaxNivel());
        System.out.println("Busqueda en amplitud: " + Busqueda.busquedaAmplitud(arbol, asd));
        System.out.println("Busqueda en profundidad: " + Busqueda.busquedaProfundidad(arbol, asd));
        System.out.println("Busqueda en primero el mejor - Fichas Desacomodadas: " + Busqueda.busquedaPMFichas(arbol, asd));
        System.out.println("Busqueda en primero el mejor - Manhattan: " + Busqueda.busquedaPMManhattan(arbol, asd));
        System.out.println("Busqueda en A* - Fichas Desacomodadas: " + Busqueda.busquedaAFichas(arbol, asd));
        System.out.println("Busqueda en A* - Manhattan: " + Busqueda.busquedaAManhattan(arbol, asd));


    }

}

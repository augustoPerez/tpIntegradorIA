import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {

//        int[] tableroInicial = {1, 2, 3, 4, 0, 5, 6, 7, 8}; //tablero inicial
//        int[] asd = {1, 5, 7, 6, 0, 4, 8, 3, 2};  Disposición de tablero NO encontrada
//        int[] asd = {1, 5, 7, 6, 0, 4, 8, 2, 3}; Disposición de tablero encontrada

        Scanner scanner = new Scanner(System.in);

        int[] tableroIni = new int[9];
        int[] tableroFin = new int[9];

        int repetir;

        do {

            System.out.println("Ingrese el tablero inicial: ");
            System.out.print("Posición 1,1 : ");
            tableroIni[0] = scanner.nextInt();
            System.out.print("Posición 1,2 : ");
            tableroIni[1] = scanner.nextInt();
            System.out.print("Posición 1,3 : ");
            tableroIni[2] = scanner.nextInt();
            System.out.print("Posición 2,1 : ");
            tableroIni[3] = scanner.nextInt();
            System.out.print("Posición 2,2 : ");
            tableroIni[4] = scanner.nextInt();
            System.out.print("Posición 2,3 : ");
            tableroIni[5] = scanner.nextInt();
            System.out.print("Posición 3,1 : ");
            tableroIni[6] = scanner.nextInt();
            System.out.print("Posición 3,2 : ");
            tableroIni[7] = scanner.nextInt();
            System.out.print("Posición 3,3 : ");
            tableroIni[8] = scanner.nextInt();

            System.out.println("\nIngrese el tablero final: ");
            System.out.print("Posición 1,1 : ");
            tableroFin[0] = scanner.nextInt();
            System.out.print("Posición 1,2 : ");
            tableroFin[1] = scanner.nextInt();
            System.out.print("Posición 1,3 : ");
            tableroFin[2] = scanner.nextInt();
            System.out.print("Posición 2,1 : ");
            tableroFin[3] = scanner.nextInt();
            System.out.print("Posición 2,2 : ");
            tableroFin[4] = scanner.nextInt();
            System.out.print("Posición 2,3 : ");
            tableroFin[5] = scanner.nextInt();
            System.out.print("Posición 3,1 : ");
            tableroFin[6] = scanner.nextInt();
            System.out.print("Posición 3,2 : ");
            tableroFin[7] = scanner.nextInt();
            System.out.print("Posición 3,3 : ");
            tableroFin[8] = scanner.nextInt();

            System.out.println("\nTablero Inicial:");
            System.out.println(tableroIni[0] + " " + tableroIni[1] + " " + tableroIni[2] + " ");
            System.out.println(tableroIni[3] + " " + tableroIni[4] + " " + tableroIni[5] + " ");
            System.out.println(tableroIni[6] + " " + tableroIni[7] + " " + tableroIni[8] + " ");

            System.out.println("\nTablero Final:");
            System.out.println(tableroFin[0] + " " + tableroFin[1] + " " + tableroFin[2] + " ");
            System.out.println(tableroFin[3] + " " + tableroFin[4] + " " + tableroFin[5] + " ");
            System.out.println(tableroFin[6] + " " + tableroFin[7] + " " + tableroFin[8] + " ");


            Arbol arbol = CrearArbol.enAmplitud(tableroIni);

            System.out.println("\nTamaño del árbol: " + arbol.size());
            System.out.println("Máximo nivel del árbol: " + arbol.getMaxNivel());
            System.out.println("\n-----Busqueda en amplitud: \n" + (Busqueda.busquedaAmplitud(arbol, tableroFin) != null ? Busqueda.busquedaAmplitud(arbol, tableroFin).toString() : "Tablero no encontrado"));
            System.out.println("\n-----Busqueda en profundidad: \n" + (Busqueda.busquedaProfundidad(arbol, tableroFin) != null ? Busqueda.busquedaProfundidad(arbol, tableroFin).toString() : "Tablero no encontrado"));
            System.out.println("\n-----Busqueda en primero el mejor - Fichas Desacomodadas: \n" + (Busqueda.busquedaPMFichas(arbol, tableroFin) != null ? Busqueda.busquedaPMFichas(arbol, tableroFin).toString() : "Tablero no encontrado"));
            System.out.println("\n-----Busqueda en primero el mejor - Manhattan: \n" + (Busqueda.busquedaPMManhattan(arbol, tableroFin) != null ? Busqueda.busquedaPMManhattan(arbol, tableroFin).toString() : "Tablero no encontrado"));
            System.out.println("\n-----Busqueda en A* - Fichas Desacomodadas: \n" + (Busqueda.busquedaAFichas(arbol, tableroFin) != null ? Busqueda.busquedaAFichas(arbol, tableroFin).toString() : "Tablero no encontrado"));
            System.out.println("\n-----Busqueda en A* - Manhattan: \n" + (Busqueda.busquedaAManhattan(arbol, tableroFin) != null ? Busqueda.busquedaAManhattan(arbol, tableroFin).toString() : "Tablero no encontrado"));

            System.out.println("\n" + (Busqueda.busquedaAmplitud(arbol, tableroFin) != null ? Busqueda.busquedaAmplitud(arbol, tableroFin).caminoPuzzle2() : "Tablero no encontrado"));

            System.out.println("\n\n¿Generar nuevos tableros?: (0: No - 1: Si)");
            repetir = scanner.nextInt();

        } while (repetir != 0);

    }

}

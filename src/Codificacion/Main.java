package Codificacion;

import static Codificacion.BitUtils.*;

/**
 * Actividad 2. Codificación Gray para comunicaciones
 *
 * Genera:
 * - Contador binario (INCREMENTO) y su costo (flips) de 0 a 31.
 * - Contador Gray (INCREMENTO_GRAY) y su costo (flips) de 0 a 31.
 * Imprime una tabla y los totales.
 *
 * Compilar:
 *   javac -d out src/gray/*.java
 * Ejecutar:
 *   java -cp out gray.Main
 *   
 @author Isai Emmanuel Castro Hernandez
 @version 1.0
 @since 11-11-2025
 */
public class Main {

    public static void main(String[] args) {
        final int N = 5;         // 5 bits (0..31)
        final int MAX = 31;

        // --- Inicialización de contadores ---
        int[] bin = toBits(0, N);            // estado binario inicial (00000)
        int[] gray = Counters.grayOf(0, N);  // estado Gray inicial (00000)

        int totalBin = 0;
        int totalGray = 0;

        // Encabezado de tabla
        System.out.println("Contadores 0..31 (N=5)");
        System.out.println("Idx |  Binario   | Costo |    Gray    | Costo");
        System.out.println("----+------------+-------+------------+------");

        // Fila 0 (sin costo, estado inicial)
        System.out.printf("%3d | %s | %5s | %s | %5s%n",
                0, toBinaryString(bin), "-", toBinaryString(gray), "-");

        // Recorremos 1..31 (31 incrementos)
        for (int k = 0; k < MAX; k++) {
            // BINARIO: incrementar de k -> k+1
            int[] prevBin = copy(bin);
            int cBin = Counters.incrementBinary(bin);
            totalBin += cBin;

            // GRAY: incrementar de Gray(k) -> Gray(k+1)
            int[] prevGray = copy(gray);
            int cGray = Counters.incrementGray(gray, k);
            totalGray += cGray;

            // (Chequeo opcional de costos: distancia Hamming)
            // assert cGray == BitUtils.hammingDistance(prevGray, gray);

            System.out.printf("%3d | %s | %5d | %s | %5d%n",
                    k + 1,
                    toBinaryString(bin), cBin,
                    toBinaryString(gray), cGray);
        }

        System.out.println("----+------------+-------+------------+------");
        System.out.printf("Tot |            | %5d |            | %5d%n", totalBin, totalGray);

        // Comentario teórico:
        // - Binario 0..31: total flips = 31 + 15 + 7 + 3 + 1 = 57
        // - Gray 0..31: total flips = 31 (siempre 1 por incremento)
    }
}
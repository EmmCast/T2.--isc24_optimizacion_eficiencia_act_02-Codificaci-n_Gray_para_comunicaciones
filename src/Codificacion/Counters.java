package Codificacion;

/**
 * Implementa:
 * - INCREMENTO para contador binario (arreglo de bits, LSB en n-1),
 * - INCREMENTO_GRAY para contador Gray ascendente (BRGC),
 * y utilidades asociadas.
 *
 * Notas:
 * - El costo de una operación es el número de bits que cambian (0→1 o 1→0).
 * - Para Gray ascendente estándar (Binary Reflected Gray Code, BRGC),
 *   de 0 a 2^n - 1, cada incremento cambia exactamente 1 bit.
 *   
 @author Isai Emmanuel Castro Hernandez
 @version 1.0
 @since 11-11-2025
 */
public class Counters {

    private Counters() {}

    /**
     * INCREMENTO (contador binario clásico).
     * Suma +1 in-place sobre el arreglo de bits (LSB en n-1).
     * Devuelve el costo (número de bits que cambiaron).
     *
     * @param bits arreglo de bits (0/1), LSB en n-1
     * @return costo (flips) del incremento
     */
    public static int incrementBinary(int[] bits) {
        int n = bits.length;
        int flips = 0;
        int i = n - 1;
        // Propaga acarreo: 1 -> 0 (flips por cada trailing 1)
        while (i >= 0 && bits[i] == 1) {
            bits[i] = 0;
            flips++;
            i--;
        }
        // Si no desbordó, pone 1 en la primera posición 0 (otro flip)
        if (i >= 0) {
            bits[i] = 1;
            flips++;
        }
        // Si i < 0, hubo overflow; para esta actividad no llegamos a overflow (0..31).
        return flips;
    }

    /**
     * Convierte valor entero k a su Gray Code (BRGC): g = k ^ (k >> 1).
     * Se devuelve arreglo de bits (LSB en n-1).
     */
    public static int[] grayOf(int k, int n) {
        int g = k ^ (k >> 1);
        return BitUtils.toBits(g, n);
    }

    /**
     * INCREMENTO_GRAY (contador Gray ascendente BRGC) usando regla formal:
     * el siguiente código Gray es Gray(k+1) = (k+1) ^ ((k+1)>>1).
     * Aquí mantenemos un "contador" k y producimos bits Gray de k.
     *
     * @param grayBits arreglo actual en Gray (LSB en n-1)
     * @param k        índice actual (valor natural)
     * @return costo (flips) para pasar de Gray(k) a Gray(k+1)
     */
    public static int incrementGray(int[] grayBits, int k) {
        int n = grayBits.length;
        int[] next = grayOf(k + 1, n);
        int flips = BitUtils.hammingDistance(grayBits, next);
        // copiar next -> grayBits
        System.arraycopy(next, 0, grayBits, 0, n);
        return flips;
    }
}

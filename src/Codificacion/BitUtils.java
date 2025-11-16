package Codificacion;

/**
 * Utilidades para manejar arreglos de bits y operaciones de costo (flips).
 * Se asume arreglo de bits de longitud n, con LSB en el índice n-1 (derecha).
 */
public class BitUtils {

    private BitUtils() {}

    /**
     * Convierte un entero no negativo a un arreglo de bits de longitud fija n.
     * LSB en posición n-1.
     *
     * @param value valor entero (>=0)
     * @param n     número de bits
     * @return arreglo de bits (0/1), LSB en n-1
 	   
	 @author Isai Emmanuel Castro Hernandez
	 @version 1.0
	 @since 11-11-2025
	 */
    public static int[] toBits(int value, int n) {
        int[] bits = new int[n];
        for (int i = 0; i < n; i++) {
            bits[n - 1 - i] = (value >>> i) & 1;
        }
        return bits;
    }

    /**
     * Convierte arreglo de bits (LSB en n-1) a cadena binaria msb..lsb.
     */
    public static String toBinaryString(int[] bits) {
        StringBuilder sb = new StringBuilder(bits.length + (bits.length / 4));
        for (int i = 0; i < bits.length; i++) {
            sb.append(bits[i]);
            if (i % 4 == 3 && i != bits.length - 1) sb.append('_'); // separador opcional
        }
        return sb.toString();
    }

    /**
     * Calcula la distancia de Hamming (número de posiciones distintas)
     * entre dos arreglos de bits de igual longitud.
     */
    public static int hammingDistance(int[] a, int[] b) {
        if (a.length != b.length) throw new IllegalArgumentException("Longitudes distintas");
        int d = 0;
        for (int i = 0; i < a.length; i++) if (a[i] != b[i]) d++;
        return d;
    }

    /**
     * Copia profunda de un arreglo de bits.
     */
    public static int[] copy(int[] src) {
        int[] dst = new int[src.length];
        System.arraycopy(src, 0, dst, 0, src.length);
        return dst;
    }
}
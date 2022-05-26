//		Ejercicio 3.
//		Implemente un algoritmo recursivo que convierta un número en notación decimal a su
//		equivalente en notación binaria.

package ProgramacionIII.tp2;

public class Ejercicio3 {

	public static double decimalToBinary(int i) {
		int negativo = 1;
		if (i < 0) {
			negativo = -1;
			i *= -1;
		}
		
		if (i < 2)
			return i;
		
		int resto = i % 2;
		return (negativo * (resto + 10 * decimalToBinary(i/2)));
	}

	public static String decimalToBinaryStr(int i) {
		String negativo = "";
		if (i < 0) {
			negativo = "-";
			i *= -1;
		}
		
		if (i < 2)
			return String.valueOf(i);
		
		int resto = i % 2;
		return (negativo + decimalToBinaryStr(i/2) + resto);
	}

	public static void main(String stats[]) {
//		for (int n = 1; n < 100; n = n + 3) {
//			System.out.println(decimalToBinary(n));
//			System.out.println(decimalToBinaryStr(n));
//		}
		
		int n = (int)(Math.random() * Math.random() * 10000000);
		System.out.println(n + ": " + decimalToBinary(n));
		System.out.println(n + ": " + decimalToBinaryStr(n));
		System.out.println(n + ": " + Long.toBinaryString(n));
	}

}

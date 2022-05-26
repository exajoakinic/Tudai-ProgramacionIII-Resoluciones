package ProgramacionIII.tp2;

//	 Ejercicio 1.
//	 Implemente un algoritmo recursivo que determine si un arreglo de tamaño N está ordenado.
//	 1. ¿Qué complejidad O tiene? (La complejidad en el peor caso)
// 	 es O(n)
//
//	 2. ¿Trae algún problema hacerlo recursivo? ¿Cuál?
//   el único problema es el uso de la pila de ejecución
//
//	 3. ¿Qué cambiaría si la estructura fuera una lista en lugar de un arreglo?
//	 si es recursivo la complejidad aumenta muchísimo xq tengo q utilizar el get... q no es O(1)	


public class Ejercicio1 {
	
	public static boolean arregloOrdenado(int arr[]) {
		return arregloOrdenadoDesde(arr, 0);
	}
	
	private static boolean arregloOrdenadoDesde(int arr[], int inicio) {
		if (inicio  == arr.length - 1) 
			return true;
		if (arr[inicio] < arr[inicio+1]) 
				return arregloOrdenadoDesde(arr, inicio + 1);
		else
			return false;
	}
	
	public static void main(String stats[]) {
		int arreglo[] = new int[4];
		arreglo[0] = 1;
		arreglo[1] = 4;
		arreglo[2] = 7;
		arreglo[3] = 6;
		System.out.println(arregloOrdenado(arreglo));
		
	}
}

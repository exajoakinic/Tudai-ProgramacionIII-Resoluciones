//		Ejercicio 2.
//		Implemente un algoritmo recursivo para buscar un elemento en una lista simple.
//		Implemente, además, un algoritmo recursivo para buscar un elemento en un arreglo ordenado
//		ascendentemente [1 2 3 …].
//		
//		1. ¿Qué complejidad O tienen estos algoritmos?
//		En la lista va a tener un O(n^2) porque el get(i) es es O(n), y lo tengo que ejecutar n veces 
//		En el arreglo, al estar ordenado puedo hacer búsqueda binaria, con lo que la complejidad vigo es O(log2(n))
//		
//		2. ¿En qué afecta la estructura a estos algoritmos?
//		No es una estructura en la que sea óptimo utlizar recursión.
//      Jústamente por eso le habíamos implementado el Iterator
//		
//		3. ¿Cambia algo que la estructura esté ordenada?
//		Sería un poco más eficiente el algoritmo si le programamos un corte
//      devolviendo -1 di el elemento a buscar ya es menor que el elemento de 
//      la lista donde estoy posicionado.
//		Aún así en notación vigo sigue siendo comlejidad O(n^2), dado que en el peor de los casos 
//		igual deberá recorrer todo el listado. 

package ProgramacionIII.tp2;

import ProgramacionIII.tp1.MySimpleLinkedList;

public class Ejercicio2 {
	public static Integer buscarElemento(Integer e, MySimpleLinkedList<Integer> l) {
		return buscarElementoDesde(e, l, 0);
	}

	private static int buscarElementoDesde(Integer e, MySimpleLinkedList<Integer> l, int posicion) {
		if (l == null)
			return -1;
		if (posicion >= l.size()) {
			return -1;
		} else {
			if (e == l.get(posicion))
				return posicion;
			else
				return buscarElementoDesde(e, l, posicion + 1);
		}
	}
}

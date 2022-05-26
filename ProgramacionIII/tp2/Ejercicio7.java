//	Ejercicio 7.
//	Implemente la estructura de Árbol Binario para búsquedas.
//	Métodos:
//	 -	Integer getRoot(),  O(1)
//	 - 	boolean hasElem(Integer), O(N) en el peor de los casos,O(log2(n)) si está balanceado 
//	 - 	boolean isEmpty(), 
//	 - 	void insert(Integer),
//	 - 	boolean delete(Integer), 
//	 - 	int getHeight(), 
//	 - 	void printPosOrder(), 
//	 - 	void printPreOrder(), 
//	 - 	void printInOrder(), 
//	 - 	List getLongestBranch(), 
//	 - 	List getFrontera(), 
//	 -	Integer getMaxElem(), List	getElemAtLevel(int)
//	1. ¿Cuál es la complejidad de cada uno de estos métodos?
		
		
package ProgramacionIII.tp2;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

public class Ejercicio7 {
    private static Scanner s = new Scanner(System.in);

	public static void main(String args[]) {
		Tree t = new Tree(null);
		List<Integer> aux = new ArrayList<Integer>();
		final int TOPE = 12;
		Integer valor = 0;
		for (int i = 0; i<TOPE; i++) {
			aux.add(i+1);
		}
		
		List<Integer> l = new ArrayList<Integer>();
		for (int i = 0; i<TOPE; i++) {
			int indice = (int)(Math.random() * aux.size());
			valor = aux.get(indice);
			aux.remove(indice);
			l.add(valor);
			t.add(valor);
		}
		
		mostrarEnConsola(l, t);
		
		System.out.println("Prueba iterator del arbol:");
		for (Integer i:t)
			System.out.print(i + " ");
		System.out.println();
		
//		valor = Integer.valueOf(System.console().readLine());

		while (l.size() > 0 && !valor.equals(-1) || valor.equals(-2)) {
			System.out.print("Ingrese elvalor a borrar | -1 para finalizar | -2 para balancear | -3 para completar");
			valor = leerNumeroDesdeConsola();
			if (valor.equals(-3)) {
				t.completar();
				mostrarEnConsola(l,t);
			}
			else if (valor.equals(-2)) {
				t.balancear();
				mostrarEnConsola(l,t);
			} else if (valor != -1) {
				remover(l, t, valor);
				mostrarEnConsola(l, t);
				}
			}
		}
		
//		while (l.size() > 0) {
//			int indice = (int)(Math.random() * l.size());
//			valor = l.get(indice);
//			l.remove(indice);
//			t.delete(valor);
//			System.out.println("SE ELIMINÓ " + valor);
//			mostrarEnConsola(l, t);
//		}

	private static void remover(List<Integer> l, Tree t, Integer valor) {
		int indice = l.indexOf(valor);
		if (indice >= 0)
			l.remove(indice);
		t.delete(valor);
	}
	private static void mostrarEnConsola(List<Integer> l, Tree t) {
		System.out.println(l);
		System.out.print("Preorder: ");
		t.printPreOrder();
//		System.out.println("Postorder: ");
//		t.printPosOrder();
		System.out.print("InOrder: ");
		t.printInOrder();
	}
	
	private static Integer leerNumeroDesdeConsola() {
	    Integer res = Integer.parseInt(s.nextLine());
	    return  res;
	}
}
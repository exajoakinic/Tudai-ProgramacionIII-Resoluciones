package ProgramacionIII.tp1;

import java.util.Iterator;

public class Ejercicio6 {
	public static void main(String[] args) {
		
	}

	//EJERCICIO 6A
	public static MySimpleLinkedList<String> listaDesordenadaEnComun(MySimpleLinkedList<String> l1, MySimpleLinkedList<String> l2) {
		MySimpleLinkedList<String> listaEnComun = new MySimpleLinkedList<String>(); 
		for (String e1: l1) {
//			// EL SIGUIENTE FOR DEBERÍA IMPLEMENTAR UN BUSCAR EN LA LISTA!!!!!
//			for (String e2: l2) {
//				if (e1.equals(e2)) 
//					//
//					listaEnComun.insertarOrdenado(e1);
//			}
			if (l2.buscar(e1) != null) {
				listaEnComun.insertarOrdenado(e1);
			}
		}
		return listaEnComun;
	}
	
	//EJERCICIO 6B
	public static MySimpleLinkedList<String> listaOrdenadaEnComun(MySimpleLinkedList<String> l1, MySimpleLinkedList<String> l2) {
		MySimpleLinkedList<String> listaEnComun = new MySimpleLinkedList<String>(); 

		Iterator<String> i1 = l1.iterator();
		Iterator<String> i2 = l2.iterator();
		
		String s1 = null, s2 = null;
		
		while (i1.hasNext() && i2.hasNext()) {
			//Para la primera pasada:
			if (s1==null || s2==null) {
				s1 = i1.next();
				s2 = i2.next();
			}
			
			int comp = s1.compareTo(s2);
			if (comp == 0 ) {
				listaEnComun.insertarOrdenado(s1);
				s1 = i1.next();
				s2 = i2.next();
			}
			else {
				if (comp < 0)
					s1 = i1.next();
				else //(comp > 0)
					s2= i2.next();
			}
		}
		
		return listaEnComun;
	}
	
	
}

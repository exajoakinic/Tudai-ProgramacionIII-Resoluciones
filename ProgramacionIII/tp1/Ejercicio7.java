package ProgramacionIII.tp1;

public class Ejercicio7 {

	public static void main(String[] args) {
		MySimpleLinkedList<Object> l1 = new MySimpleLinkedList<Object>();
		MySimpleLinkedList<Object> l2 = new MySimpleLinkedList<Object>();
		
		l1.insertarOrdenado("A");
		l1.insertarOrdenado("B");
		l1.insertarOrdenado("C");
		l1.insertarOrdenado("D");

		l2.insertarOrdenado("B");
		l2.insertarOrdenado("C");

		MySimpleLinkedList<Object> l3 = null;
		l3= listaPositivaSinElementosNegativa(l1, l2);
		System.out.println(l3);
		
		l1.insertarOrdenado("algo");
		l1.insertarOrdenado("otro");
		l2.extractFront();
		l2.insertarOrdenado("otro");
		
		System.out.println(listaPositivaSinElementosNegativa(l1, l2));
	}
	
//	Retorna una nueva lista con elementos de listaPositiva que NO ESTÉN en listaNegativa
	public static MySimpleLinkedList<Object> listaPositivaSinElementosNegativa(MySimpleLinkedList<Object> listaPositiva, MySimpleLinkedList<Object> listaNegativa) {
		
		MySimpleLinkedList<Object> resultado = new MySimpleLinkedList<Object>();
		
		for (Object elemento:listaPositiva) {
			if (listaNegativa.buscar(elemento) == null)
				resultado.insertarOrdenado(elemento);
		}
		return resultado;
	}
}

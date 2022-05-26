package ProgramacionIII.tp1;

import java.util.Iterator;

public class IteratorLinkedList<T> implements Iterator<T> {
	
	private Node<T> nodo;
	
	IteratorLinkedList(Node<T> nodo) {
		this.nodo = nodo;
	}
	
	
	@Override
	public boolean hasNext() {
		return (nodo != null); 
	}

	@Override
	public T next() {
		T valor = nodo.getInfo();
		nodo = nodo.getNext();
		return valor;
	}
	
	public T valor() {
		return nodo.getInfo();
	}
	
}

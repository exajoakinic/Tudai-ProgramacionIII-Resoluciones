package ProgramacionIII.tp1;

import java.util.Iterator;

public class MySimpleLinkedList<T> implements Iterable<T> {

	private Node<T> first;
	private int size;

	public MySimpleLinkedList() {
		this.first = null;
		this.size = 0;
	}

	public void insertFront(T info) {
		// Node<T> tmp = new Node<T>(info, null);
		// tmp.setNext(this.first);
		if (info != null) {
			Node<T> tmp = new Node<T>(info, this.first);
			this.first = tmp;
			size++;
		}
	}

	public T extractFront() {
		Node<T> tmp = first;
		if (tmp != null) {
			first = tmp.getNext();
			size--;
		}
		return tmp.getInfo();
	}

	public boolean isEmpty() {
		return (this.first == null);
	}

	public T get(int index) {
		if ((0 <= index) && (index < size)) {
			Node<T> tmp = first;
			for (int i = 0; i < index; i++) {
				tmp = tmp.getNext();
			}
			return tmp.getInfo();
		}
		return null;
	}

	public int size() {
		return size;
	}

	@Override
	public String toString() {
		String s = "";
		Node<T> tmp = first;
		while (tmp != null) {
			s += tmp.getInfo() + " | ";
			tmp = tmp.getNext();
		}
		return s;
	}

	public int indexOf(T info) {
		Node<T> tmp = first;
		int index = 0;
		while (tmp != null) {
			if (info.equals(tmp.getInfo()))
				return index;
			index++;
		}
		return -1;
	}

	@Override
	public Iterator<T> iterator() {
		return new IteratorLinkedList<T>(this.first);
	}

	public T buscar(T valor) {
		Node<T> tmp = first;
		while (tmp!=null) {
			if (tmp.getInfo().equals(valor))
				return tmp.getInfo();
			tmp = tmp.getNext();
		}
		return null;
	}
	
	public void insertarOrdenado(T valor) {
		Node<T> nodo = first;

		if (nodo == null) {
			this.insertFront(valor);
			return;
		}

		boolean insertado = false;

		while (!insertado) {
			T info = nodo.getInfo();
			@SuppressWarnings("unchecked")
			Comparable<T> comparable = ((Comparable<T>)info);
			
			int comp = (comparable.compareTo(valor));

			if (comp == 0) {
				Node<T> nuevoNodo = new Node<T>(valor, nodo.getNext());
				nodo.setNext(nuevoNodo);
				insertado = true;
			} else if (comp > 0) {
				T valorActual = nodo.getInfo();
				nodo.setInfo(valor);
				Node<T> nuevoNodo = new Node<T>(valorActual, nodo.getNext());
				nodo.setNext(nuevoNodo);
				insertado = true;
			} else { // comp < 0
				if (nodo.getNext() == null) {
					nodo.setNext(new Node<T>(valor, null));
					insertado = true;
				} else
					nodo = nodo.getNext();
			}
		}
	}
}

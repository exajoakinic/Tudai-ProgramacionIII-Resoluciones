package ProgramacionIII.tp1;

public class Pila<T> {
	private MySimpleLinkedList<T> lista;
	
	Pila() {
		lista = new MySimpleLinkedList<T>();
	}
	
	public void push(T o) {
		lista.insertFront(o);
	}
	
	public T pop() {
		return lista.extractFront();
	}
	
	public T top() {
		return lista.get(0);
	}
	
	public void reverse() {
		MySimpleLinkedList<T> tmp = new MySimpleLinkedList<>();
		while (!lista.isEmpty()) {
			tmp.insertFront(lista.extractFront());
		}
		
		lista = tmp;
	}
	
	@Override
	public String toString() {
		return lista.toString();
	}
}

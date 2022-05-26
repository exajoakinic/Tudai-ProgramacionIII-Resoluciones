package ProgramacionIII.tp2;

import java.util.Iterator;

public class IteratorTreeInOrder implements Iterator<Integer> {
	private Iterator<Integer> izq;
	private Iterator<Integer> der;
	private Integer valor;
	private boolean hasPassedValor;
	
	IteratorTreeInOrder(Tree t) {
		if (t == null) {
			izq = null;
			der = null;
			valor = null;
			hasPassedValor = true;
		} else {
			izq = t.IteratorLeft();
			der = t.IteratorRight();
			valor = t.getRoot();
			hasPassedValor = false;
		}
	}
	
	@Override
	public boolean hasNext() {
		if (izq != null)
			if (izq.hasNext())
				return true;
		if (!hasPassedValor)
			return true;
		if (der != null)
			if (der.hasNext())
				return true;
		return false;
	}

	@Override
	public Integer next() {
		if (izq != null)
			if (izq.hasNext())
				return izq.next();
		if (!hasPassedValor) {
			hasPassedValor = true;
			return valor;
		}
		if (der != null)
			if (der.hasNext())
				return der.next();
		return null;
	}

}

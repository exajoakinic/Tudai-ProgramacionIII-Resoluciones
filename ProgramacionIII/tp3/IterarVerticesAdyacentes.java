package ProgramacionIII.tp3;

import java.util.HashSet;
import java.util.Iterator;

public class IterarVerticesAdyacentes<T> implements Iterator<Integer> {
	private Iterator<   Arco<T>   > arcos;
	
	IterarVerticesAdyacentes(HashSet< Arco<T> > arcos) {
		this.arcos = arcos.iterator();
	}

	@Override
	public boolean hasNext() {
		return arcos.hasNext();
	}

	@Override
	public Integer next() {
		return arcos.next().getVerticeDestino();
	}

}

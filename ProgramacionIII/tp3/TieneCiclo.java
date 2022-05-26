//Ejercicio 3.
//Implemente un algoritmo que determine si un grafo dirigido tiene algún ciclo.



package ProgramacionIII.tp3;

import java.util.HashMap;
import java.util.Iterator;

public class TieneCiclo<T> {
	private HashMap<Integer, String> color;
	GrafoDirigido<T> grafo;
	
	TieneCiclo(GrafoDirigido<T> grafo) {
		color = new HashMap<>();
		this.grafo = grafo;
	}

	public boolean tieneCiclo() {
		Iterator<Integer> iterVert;
		iterVert = grafo.obtenerVertices();
		while ( iterVert.hasNext() ) {
			Integer v =  iterVert.next();
			color.put(v, "BLANCO");
		}
		
		iterVert = grafo.obtenerVertices();
		while ( iterVert.hasNext() ) {
			Integer v =  iterVert.next();
			if (color.get(v).equals("BLANCO")) 
				if (visitarBuscandoCiclo(v)) {
					return true;
				}
		}
		
		return false;
	}
	
	private boolean visitarBuscandoCiclo(Integer v) {
		color.put(v, "AMARILLO");

		Iterator<Integer> iterVert = grafo.obtenerAdyacentes(v);
		while ( iterVert.hasNext() ) {
			Integer v2 = iterVert.next();
			if (color.get(v2).equals("BLANCO")) 
				visitarBuscandoCiclo(v2);
			else if (color.get(v2).equals("AMARILLO")) {
				return true;
			}
		}
		color.put(v, "NEGRO");
		return false;
	}
	
}
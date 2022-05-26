//Ejercicio 2.
//Implemente los recorridos Depth-First-Search y Breadth-First-Search.


package ProgramacionIII.tp3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class RecorridoDFS<T> {
	private HashMap<Integer, String> color;
	private ArrayList<Integer> recorrido;
	GrafoDirigido<T> grafo;
	
	RecorridoDFS(GrafoDirigido<T> grafo) {
		color = new HashMap<>();
		recorrido = new ArrayList<>();
		this.grafo = grafo;
	}

	public ArrayList<Integer> depthFirstSearch_recorrido() {
		Iterator<Integer> iterVert;
		recorrido = new ArrayList<>();
		
		iterVert = grafo.obtenerVertices();
		while ( iterVert.hasNext() ) {
			Integer v =  iterVert.next();
			color.put(v, "BLANCO");
		}
		
		iterVert = grafo.obtenerVertices();
		while ( iterVert.hasNext() ) {
			Integer v =  iterVert.next();
			if (color.get(v).equals("BLANCO")) 
				depthFirstSearch_Visitar(v);
		}
		
		return recorrido;
	}
	
	private void depthFirstSearch_Visitar(Integer v) {

		color.put(v, "AMARILLO");
		recorrido.add(v);
		Iterator<Integer> iterVert = grafo.obtenerAdyacentes(v);
		while ( iterVert.hasNext() ) {
			Integer v2 = iterVert.next();
			if (color.get(v2).equals("BLANCO")) 
				depthFirstSearch_Visitar(v2);
		}
		color.put(v, "NEGRO");
	}
	
}
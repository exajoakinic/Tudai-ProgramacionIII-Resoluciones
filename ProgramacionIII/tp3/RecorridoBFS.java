//Ejercicio 2.
//Implemente los recorridos Depth-First-Search y Breadth-First-Search.


package ProgramacionIII.tp3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class RecorridoBFS<T> {
	private HashMap<Integer, String> color;
	private ArrayList<Integer> recorrido;
	GrafoDirigido<T> grafo;
	
	RecorridoBFS(GrafoDirigido<T> grafo) {
		color = new HashMap<>();
		recorrido = new ArrayList<>();
		this.grafo = grafo;
	}
	
	public ArrayList<Integer> breadthFirstSearch_recorrido() {
		recorrido = new ArrayList<>();
		
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
				breathFirstSearch_Visitar(v);
		}
		
		return recorrido;
	}
	
	private void breathFirstSearch_Visitar(Integer v) {
		Iterator<Integer> iterVert;
		iterVert = grafo.obtenerAdyacentes(v);
		color.put(v, "AMARILLO");
		while ( iterVert.hasNext() ) {
			Integer v2 =  iterVert.next();
			if (color.get(v2).equals("BLANCO")) 
				recorrido.add(v2);
		}
	}
}

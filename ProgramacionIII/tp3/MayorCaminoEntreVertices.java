//Ejercicio 4.
//Escribir un algoritmo que, dado un grafo dirigido y dos v�rtices i, j de este grafo, devuelva el
//camino simple (sin ciclos) de mayor longitud del v�rtice i al v�rtice j. Puede suponerse que
//el grafo de entrada es ac�clico.
//public List<Integer> mayorRecorridoEntreVertices(int v1, int v2)

//Ejercicio 5.
//Escriba un algoritmo que dado un grafo G y un v�rtice v de dicho grafo, devuelva una lista
//con todos los v�rtices a partir de los cuales exista un camino en G que termine en v.

package ProgramacionIII.tp3;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class MayorCaminoEntreVertices<T> {
	private HashMap<Integer, String> color;
	GrafoDirigido<T> grafo;
	
	MayorCaminoEntreVertices(GrafoDirigido<T> grafo) {
		color = new HashMap<>();
		this.grafo = grafo;
	}

	public List<Integer> mayorRecorridoEntreVertices(int v1, int v2) {
		
		if (!grafo.contieneVertice(v1) || !grafo.contieneVertice(v2))
			return new LinkedList<Integer>(); //retorna un camino vac�o porque los v�rtices no existen
		
		Iterator<Integer> iterVert;
		iterVert = grafo.obtenerVertices();
		while ( iterVert.hasNext() ) {
			Integer v =  iterVert.next();
			color.put(v, "BLANCO");
		}
		return obtenerMayorRecorrido(v1, v2);

	}
	
	private List<Integer> obtenerMayorRecorrido(Integer vInicio, Integer vFin) {
		if (vInicio == vFin) {
			LinkedList<Integer> lista = new LinkedList<Integer>();
			lista.add(vInicio);
			return lista;
		}
		
		color.put(vInicio, "AMARILLO");

		Iterator<Integer> iterVert = grafo.obtenerAdyacentes(vInicio);
		boolean llegaADestino = false;
		
		List<Integer> recorridoMejor = new LinkedList<>();
		while ( iterVert.hasNext() ) {
			Integer v = iterVert.next();
			List<Integer> recorridoIteracion;
			if (color.get(v).equals("BLANCO")) {
				
				recorridoIteracion = obtenerMayorRecorrido(v, vFin);
				if (recorridoIteracion.size() != 0) { //no lleg� a vFin, devolvi� el recorrido Vac�o
					llegaADestino = true;
					if (recorridoMejor.size() < recorridoIteracion.size())
						recorridoMejor = recorridoIteracion;
				}
			}
		}
		if (llegaADestino)
			color.put(vInicio, "BLANCO");
		else
			color.put(vInicio, "NEGRO"); //NO QUIERO QUE SE VUELVA A RECORRER ESTE V�RTICE
		
		recorridoMejor.add(0, vInicio); //Esto no es eficiente, xq es O(n)
		
		return recorridoMejor;
	}

	public List<Integer> verticesLleganHasta(int vFin) {

		LinkedList<Integer> vertices = new LinkedList<Integer>();
		
		if (!grafo.contieneVertice(vFin))
			return new LinkedList<Integer>(); //retorna un camino vac�o porque los v�rtices no existen
		
		Iterator<Integer> iterVert;
		iterVert = grafo.obtenerVertices();
		while ( iterVert.hasNext() ) {
			Integer v =  iterVert.next();
			if (vFin != v)
				color.put(v, "BLANCO");

		}
		
		iterVert = grafo.obtenerVertices();
		while ( iterVert.hasNext() ) {
			Integer v =  iterVert.next();
			agregarVerticesLleganDesdeHasta(v, vFin, vertices);
		}
		
		return (List<Integer>)vertices;

	}

	private void agregarVerticesLleganDesdeHasta(int vInicio, int vFin, LinkedList<Integer> vertices) {
		if (vInicio == vFin) {
			color.put(vInicio, "VERDE");
			vertices.add(vInicio);
			return;
		}
		
	}
}
package ProgramacionIII.tp3;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class GrafoDirigido<T> implements Grafo<T> {
	protected HashMap<Integer, HashSet<Arco<T>>> data;
	
	public GrafoDirigido() {
		data = new HashMap<>();
	}
	

	@Override
	public void agregarVertice(int verticeId) {
		if (data.get(verticeId) != null) 
			data.put(verticeId, new HashSet<>());
	}

	@Override
	public void borrarVertice(int verticeId) {
		data.remove(verticeId);		
		//BORRAR LOS ARCOS CON DESTINO verticeId
		for (int id:data.keySet()) {
			Arco<T> arcoToDelete = new Arco<T>(id, verticeId, null);
			data.get(id).remove(arcoToDelete);
		}
	}

	@Override
	public void agregarArco(int verticeId1, int verticeId2, T etiqueta) {
		HashSet<Arco<T>> arcosDesdeV1 = data.get(verticeId1);
	//VERIFICAR DESTINO
		if (arcosDesdeV1 != null) {
			Arco<T> arcoAgregar = new Arco<T>(verticeId1, verticeId2, etiqueta);
			arcosDesdeV1.add(arcoAgregar);
		}
	}

	@Override
	public void borrarArco(int verticeId1, int verticeId2) {
		HashSet<Arco<T>> arcosDesdeV1 = data.get(verticeId1);

		if (arcosDesdeV1 != null) {
			Arco<T> arcoBorrar = new Arco<T>(verticeId1, verticeId2, null);
			arcosDesdeV1.remove(arcoBorrar);
		}
	}

	@Override
	public boolean contieneVertice(int verticeId) {
		return data.containsKey(verticeId);		
	}

	@Override
	public boolean existeArco(int verticeId1, int verticeId2) {
		HashSet<Arco<T>> arcosDesdeV1 = data.get(verticeId1);

		if (arcosDesdeV1 == null)
			return false;
		Arco<T> arcoBuscar = new Arco<T>(verticeId1, verticeId2, null);
		return arcosDesdeV1.contains(arcoBuscar);
	}

	@Override
	public Arco<T> obtenerArco(int verticeId1, int verticeId2) {
		HashSet<Arco<T>> arcosDesdeV1 = data.get(verticeId1);

		if (arcosDesdeV1 == null)
			return null;
		for (Arco<T> arco:arcosDesdeV1) {
			if (arco.getVerticeDestino() == verticeId2)
				return arco;
		}
		return null;
	}

	@Override
	public int cantidadVertices() {
		return data.size();
	}

	@Override
	//VER PODRÍA MANTENER LA CANTIDAD DE ARCOS EN UN VALOR PRIVADO E IR ACTUALIZÁNDOLO
	//PERO ESTO REQUIERE MAYOR PROGRAMACIÓN DANDO POSIBILIDAD A ERRORES
	public int cantidadArcos() {
		int cant = 0;
		for (HashSet<Arco<T>> arcos:data.values()) {
			cant += arcos.size();
		}
		return cant;
	}

	@Override
	public Iterator<Integer> obtenerVertices() {
		return data.keySet().iterator();
	}

	//Se puede hacer O(1) con una Clase IteratorArcos
//	@Override
//	public Iterator<Integer> obtenerAdyacentes(int verticeId) {
//		HashSet<Integer> destinos = new HashSet<>();
//		
//		for (Arco<T> arco:data.get(verticeId)) {
//			destinos.add(arco.getVerticeDestino());
//		}
//		return destinos.iterator();
//	}

	@Override
	public Iterator<Integer> obtenerAdyacentes(int verticeId) {
		return new IterarVerticesAdyacentes<T>(data.get(verticeId));
	}

	@Override
	public Iterator<Arco<T>> obtenerArcos() {
		HashSet<Arco<T>> arcosTodos = new HashSet<>();

		for (int id:data.keySet())
			arcosTodos.addAll(data.get(id));
		
		return arcosTodos.iterator();
	}

	@Override
	public Iterator<Arco<T>> obtenerArcos(int verticeId) {
		HashSet<Arco<T>> arcosDesdeId = new HashSet<>();
		arcosDesdeId.addAll(data.get(verticeId));
		return arcosDesdeId.iterator();
	}
}
	

package ProgramacionIII.tp3;

import java.util.Objects;

/*
 * La clase arco representa un arco del grafo. Contiene un vertice origen, un vertice destino y una etiqueta.
 * Nota: Para poder exponer los arcos fuera del grafo y que nadie los modifique se hizo esta clase inmutable
 * (Inmutable: una vez creado el arco no es posible cambiarle los valores).
 */
public class Arco<T> {

	private int verticeOrigen;
	private int verticeDestino;
	private T etiqueta;

	public Arco(int verticeOrigen, int verticeDestino, T etiqueta) {
		this.verticeOrigen = verticeOrigen;
		this.verticeDestino = verticeDestino;
		this.etiqueta = etiqueta;
	}

	public int getVerticeOrigen() {
		return verticeOrigen;
	}

	public int getVerticeDestino() {
		return verticeDestino;
	}

	public T getEtiqueta() {
		return etiqueta;
	}


//	@Override
//	public boolean equals(Object obj) {
//		try {
//			Arco e = (Arco) obj;
//			return (this.verticeOrigen == e.getVerticeOrigen() && this.verticeDestino == e.getVerticeDestino());
//		} catch (Exception e) {
//			return false;
//		}
//	}

	@Override
	public int hashCode() {
		return Objects.hash(verticeDestino, verticeOrigen);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Arco other = (Arco) obj;
		return verticeDestino == other.verticeDestino && verticeOrigen == other.verticeOrigen;
	}

}

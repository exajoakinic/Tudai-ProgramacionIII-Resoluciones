//	 +	Integer getRoot(), 
//	 + 	boolean hasElem(Integer), 
//	 + 	boolean isEmpty(), 
//	 + 	void insert(Integer),
//	 + 	boolean delete(Integer), 
//	 + 	int getHeight(), 
//	 + 	void printPosOrder(), 
//	 + 	void printPreOrder(), 
//	 + 	void printInOrder(), 
//	 + 	List getLongestBranch(), 
//	 + 	List getFrontera(), 
//	 +	Integer getMaxElem(), (agregué getMinElem()) 
//	 +	List	getElemAtLevel(int)


//PREGUNTAR... 
//ESTOY LLAMANDO A left.value o right.value
//¿estoy rompiendo el encapsulamiento? Java lo permite, pero debería no hacerlo?
//
//VER deleteMe()
//

package ProgramacionIII.tp2;

import java.util.LinkedList;
import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

public class Tree implements Iterable<Integer>{

	private Integer value;
	private Tree left;
	private Tree right;
	
	private final String SEPARADOR = "|"; //Separador para imprimir el árbol 


	public Tree(Integer value) {
		this.value = value;
		this.left = null;
		this.right = null;
	}

	public List<Integer> getFrontera() {
		List<Integer> lista = new ArrayList<Integer>();
		if (this.left != null) 
			lista.addAll(this.left.getFrontera());
		
		if (this.right != null)
			lista.addAll(this.right.getFrontera());
		else 
			if (this.left == null)
				lista.add(this.value);

		return lista;
	}
	
	//PREGUNTA, ¿SI AMBOS LADOS SON IGUAL DE LARGOS?
	//ME VOY A QUEDAR CON EL IZQUIERDO, XQ SÍ
	public List<Integer> getLongestBranch() {
		List<Integer> lista = new ArrayList<Integer>();
		if (this.isEmpty())
			return lista;
		
		lista.add(this.value);
		
		List<Integer> listaLeft = new LinkedList<Integer>();
		List<Integer> listaRight = new LinkedList<Integer>();
		
		if (this.left != null)
			listaLeft = this.left.getLongestBranch();
		if (this.right != null)
			listaRight = this.left.getLongestBranch();
		
		if (listaLeft.size() >= listaRight.size())
			lista.addAll(listaLeft);
		else
			lista.addAll(listaRight);
		
		return lista;

//		LA HABÍA RE COMPLICADO:
//		if (this.left == null) {
//			if (this.right == null) {
//				return lista;
//			} else {
//				lista.addAll(this.right.getLongestBranch());
//				return lista;
//			}
//		} else { //left != null
//			if (this.right == null) {
//				lista.addAll(this.left.getLongestBranch());
//				return lista;
//			} else { //debo ver cuál de los dos caminos es más largo
//				if (this.left.getHeight() < this.right.getHeight())
//					lista.addAll(this.right.getLongestBranch());
//				else //(this.left.getHeight() >= this.right.getHeight())
//					lista.addAll(this.left.getLongestBranch());
//				return lista;
//			}
//				
//		}

	}
	
	public List<Integer> getElemAtLevel(int lvl) {
		if (lvl < 0)
			return new ArrayList<Integer>();
		if (lvl == 0)
			return new ArrayList<Integer>(value);
		else { // (lvl > 0)
			List<Integer> res = new ArrayList<Integer>();
			if (this.left != null)
				res.addAll(this.left.getElemAtLevel(lvl - 1));
			if (this.right != null)
				res.addAll(this.right.getElemAtLevel(lvl - 1));
			return res;
		}
	}

	public Integer getMaxElem() {
		if (this.isEmpty())
			return null;
		if (this.right == null)
			return this.value;
		else
			return this.right.getMaxElem();
	}
	
	public Integer getMinElem() {
		if (this.isEmpty())
			return null;
		if (this.left == null)
			return this.value;
		else
			return this.left.getMinElem();
	}
	
	public void printPosOrder() {
		System.out.println(this.getPosOrder());
	}
	//protected o private..? DUDA
	private String getPosOrder() {
		if (this.isEmpty())
			return "-" + SEPARADOR;
		String res = "";
		
		if (this.left == null)
			res += "-" + SEPARADOR;
		else
			res += this.left.getPosOrder();
		
		if (this.right == null)
			res += "-" + SEPARADOR;
		else
			res += this.right.getPosOrder();

		res += this.value + SEPARADOR;
		
		return res;
	}
	
	public void printPreOrder() {
		System.out.println(this.getPreOrder());
	}
	//protected o private..? DUDA
	private String getPreOrder() {
		if (this.isEmpty())
			return "-" + SEPARADOR;
		String res = "";
		
		res += this.value + SEPARADOR;

		if (this.left == null)
			res += "-" + SEPARADOR;
		else
			res += this.left.getPreOrder();
		
		if (this.right == null)
			res += "-" + SEPARADOR;
		else
			res += this.right.getPreOrder();
		
		return res;
	}	
	public void printInOrder() {
		System.out.println(this.getInOrder());
	}
	//protected o private..? DUDA
	private String getInOrder() {
		if (this.isEmpty())
//			return "-" + SEPARADOR;
			return "-";
		String res = "";
		
		if (this.left == null)
			res += "-" + "<";
		else
			res += "(" + this.left.getInOrder() +")<";

		res += this.value;
		
		if (this.right == null)
			res += ">-";
		else
			res += ">(" + this.right.getInOrder() + ")";

		
		return res;
	}
	

	
	public int getHeight() {
		
		if (this.left == null) 
			if (this.right == null)
				return 0;
			else
				return 1 + this.right.getHeight();
		else
			if (this.right == null)
				return 1 + this.left.getHeight();
			else {
				int leftHeight = this.left.getHeight();
				int rightHeight = this.right.getHeight();
				if (leftHeight < rightHeight)
					return 1 + rightHeight;
				else
					return 1 + leftHeight;
			}
		
	}
	
	public boolean delete(Integer value) {
		if (value == null)
			return true;
		if (this.isEmpty())
			return false;
		if (this.value.equals(value)) {
			this.deleteMe();
			return true;
		} else {
			if (value < this.value ) { // borro por izquierda
				if (this.left == null)
					return false;
				if (this.left.delete(value)) {
					if (this.left.isEmpty())
						this.left = null;
					return true;
				} else 
					return false;
			} else { //this.value < value / borro por derecha
				if (this.right == null)
					return false;
				if (this.right.delete(value)) {
					if (this.right.isEmpty())
						this.right = null;
					return true;
				} else 
					return false;
			}
		}
		
	}
	
	private void deleteMe() {
		
		//AGREGADO PARA QUE QUEDE MEJOR EL ARBOL:
		//BUSCO EXTRAER EL ELEMENTO DEL LADO MÁS ALTO
		//EL ARBOL VA A QUEDAR MEJOR, PERO TENGO QUE HACER UN CÁLCULO MÁS
		//PREGUNTAR HASTA QUÉ PUNTO PUEDE SER BUENA IDEA
		int priorizar = 0;
		if (this.left != null && this.right != null)
			priorizar = this.right.getHeight() - this.left.getHeight();
		
		
		if (this.left != null || priorizar < 0) {
			Integer newValue = this.left.extractMaxElem();
			if (this.left.value == null)
				this.left = null;
			this.value = newValue;
		} else {
			if (this.right != null) {
				Integer newValue = this.right.extractMinElem();
				if (this.right.value == null)
					this.right = null;
				this.value = newValue;
			} else { //soy una hoja, no hay nuevo valor para reemplazar
				this.value = null;
			}
		}
	}
	
	private Integer extractMaxElem() {
		Integer newValue = null;
		if (this.right != null) {
			newValue = this.right.extractMaxElem();
			if (this.right.value == null)
				this.right = null;
			return newValue;
		} else { //soy yo el que debe borrarse, ya soy el más derecho
			newValue = this.value;
			deleteMe();
			return newValue;
		}
	}
	
	private Integer extractMinElem() {
		Integer newValue = null;
		if (this.left != null) {
			newValue = this.left.extractMaxElem();
			if (this.left.value == null)
				this.left = null;
			return newValue;
		} else { //soy yo el que debe borrarse, ya soy el más izquierdo
			newValue = this.value;
			deleteMe();
			return newValue;
		}
	}
	
	public void insert(Integer value) {
		if (this.isEmpty())
			this.value = value;
//		Tree ladoAInsertar = null;
		if (value < this.value)
//			ladoAInsertar = this.left;
//		else
//			ladoAInsertar = this.right;
//
			if (this.left == null)
				this.left = new Tree(value);
			else
				this.left.insert(value);
		else
			if (this.right == null)
				this.right = new Tree(value);
			else
				this.right.insert(value);
	}
	
	public boolean isEmpty() {
		return (this.value == null);
	}

	
	public Integer getRoot() {
		return value;
	}
	
	public boolean hasElem(Integer value) {
		if (this.value == value)
			return true;
		
		if (this.value < value) // busco por derecha
			if (this.right == null)
				return false;
			else
				return this.right.hasElem(value);
		else //(value < this.value) busco por izquierda
			if (this.left == null)
				return false;
			else
				return this.left.hasElem(value);
	}
	
	public void add(Integer newValue) {
		if (this.value == null)
			this.value = newValue;
		else {
			if (newValue < this.value) {
				if (this.left == null)
					this.left = new Tree(newValue);
				else
					this.left.add(newValue);
			} else if (this.value < newValue) {
				if (this.right == null)
					this.right = new Tree(newValue);
				else
					this.right.add(newValue);
			}
		}
	}

	@Override
	public Iterator<Integer> iterator() {
		return new IteratorTreeInOrder(this);
	}
//	
//	LO QUE SIGUE ESTÁ IMPLEMENTADO PARA PODER HACER FUNCIONAR EL ITERATOR
//	DE ALGUNA FORMA NO ESTÁ BUENO, PORQUE REVELO QUIÉN ES MI LEFT Y QUIÉN MI RIGHT
//	Y PODRÍAN ROMPERME EL ARBOL BINARIO ORDENADO... DEBO MEJORAR ESTO
//	ENTIENDO QUE ESTE PROBLEMA NO LO HABRÍA TENIDO DESARROLLANDO TreeNode, ya que el 
//	IteratorTreeNode podría recorrer sin problemas los nodos.
//
//	protected Tree getLeft() {
//		return this.left;
//	}
//	protected Tree getRight() {
//		return this.right;
//	}
//	
//	Ahora se me ocurre que en vez de hacer un getLeft() o getRight() sería mejor hacer un
//	getIteratorLeft() y getIteratorRight(), ahí ya estaría quedando mejor el encapsulamiento.
//	Que como son funciones raras que sólo van a ser utilizadas por el iterador, 
//	van pretected en vez de public.
	
	protected Iterator<Integer> IteratorLeft() {
		return new IteratorTreeInOrder(this.left);
	}
	protected Iterator<Integer> IteratorRight() {
		return new IteratorTreeInOrder(this.right);
	}
	
//	public boolean isBalanced() {
//		
//		Integer leftHeight = -1;
//		Integer rightHeight = -1;
//		
//		if (this.left != null) {
//			this.left.balancear();
//			leftHeight = this.left.getHeight();
//		}
//		if (this.right != null) {
//			this.right.balancear();
//			rightHeight = this.right.getHeight();
//		}
//	}
	public void balancear() {
		Integer leftHeight = 0;
		Integer rightHeight = 0;
		
		if (this.left != null) {
			this.left.balancear();
			leftHeight = this.left.getHeight() + 1;
		}
		if (this.right != null) {
			this.right.balancear();
			rightHeight = this.right.getHeight() + 1;
		}
		
		if (Math.abs(leftHeight - rightHeight) > 1) {
			if (leftHeight > rightHeight) {
				Integer actualValue = this.getRoot();
				this.value = this.left.extractMaxElem();
				this.add(actualValue);
				this.balancear();
			} else if (leftHeight < rightHeight) {
				Integer actualValue = this.getRoot();
				this.value = this.right.extractMinElem();
				this.add(actualValue);
				this.balancear();
			}
		}
	}
	
	
	// EL ALGORITMO QUE PENSÉ SEGURAMENTE NO SEA EFICIENTO, LO QUE HAGO ES CONTAR CUÁNTOS
	// ELEMENTOS TENGO POR IZQUIERDA Y POR DERECHA. SI LA DIFERENCIA ENTRE AMBOS ES > 1
	// SACO EL MENOR O MAYOR ELEMENTO AL QUE TIENE MÁS, ME ASIGNO ESE VALOR, Y AGREGO EL 
	// VALOR QUE YO TENÍA, REPITIÉNDOLO MIENTRAS LA DIFERENCIA ENTRE AMBOS > 1.
	// LUEGO MANDO A COMPLETAR LEFT Y RIGHT
	public void completar() {
		int countLeft = 0;
		int countRight = 0;
		if (this.left != null)
			countLeft = this.left.count();
		if (this.right != null)
			countRight = this.right.count();
		while (countLeft - countRight > 1) {
			Integer aux = this.value;
			this.value = this.left.extractMaxElem();
			countLeft--; 
			this.add(aux);
			countRight++;
		}
		while (countRight - countLeft > 1) {
			Integer aux = this.value;
			this.value = this.right.extractMinElem();
			countRight--; 
			this.add(aux);
			countLeft++;
		}
		if (this.left != null)
			this.left.completar();
		if (this.right != null)
			this.right.completar();
	}
	
	public int count() {
		if (this.isEmpty())
			return 0;
		
		int tot = 1;
		if (this.left != null)
			tot += this.left.count();
		if (this.right != null)
			tot += this.right.count();
		
		return tot;
	}
}

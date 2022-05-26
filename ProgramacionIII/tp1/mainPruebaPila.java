package ProgramacionIII.tp1;

public class mainPruebaPila {

	public static void main(String[] args) {
		Pila<String> p = new Pila<String>();
		p.push("A");
		p.push("B");
		p.push("C");
		p.push("D");
		p.push("E");
		System.out.println(p);
		p.reverse();
		System.out.println(p);
		//p.reverse();
		//System.out.println(p);
	}

}

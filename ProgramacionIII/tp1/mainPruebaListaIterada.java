package ProgramacionIII.tp1;

public class mainPruebaListaIterada {

	public static void main(String[] args) {
		MySimpleLinkedList<String> l = new MySimpleLinkedList<>();
		l.insertFront("A");
		l.insertFront("B");
		l.insertFront("C");
		l.insertFront("D");
		
		
		
		for (String s:l) {
			System.out.println(s);
		}
			

	}

}

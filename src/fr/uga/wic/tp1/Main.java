package fr.uga.wic.tp1;

public class Main {

	public static void main(String[] args) {
		Huffman huff = new Huffman("abracadabra-baccara");
		
		huff.printDico();
		
		try {
			String coded = huff.code("abracadabra-baccara");
			System.out.println(coded);
			System.out.println(huff.decode(coded));
		} catch (CaractereInconnuException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FinDeTexteInattendueException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
